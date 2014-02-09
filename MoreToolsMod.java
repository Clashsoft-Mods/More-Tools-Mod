package clashsoft.mods.moretools;

import clashsoft.cslib.minecraft.update.CSUpdate;
import clashsoft.mods.moretools.addons.MTMArmor;
import clashsoft.mods.moretools.addons.MTMTools;
import clashsoft.mods.moretools.addons.MTMWorld;
import clashsoft.mods.moretools.common.MTMCommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

@Mod(modid = "MoreToolsMod", name = "More Tools Mod", version = MoreToolsMod.VERSION)
public class MoreToolsMod
{
	public static final String		MODID		= "moretools";
	public static final String		NAME		= "More Tools Mod";
	public static final int			REVISION	= 0;
	public static final String		VERSION		= CSUpdate.CURRENT_VERSION + "-" + REVISION;
	
	@Instance(MODID)
	public static MoreToolsMod		instance;
	
	@SidedProxy(clientSide = "clashsoft.mods.moretools.client.MTMClientProxy", serverSide = "clashsoft.mods.moretools.common.MTMCommonProxy")
	public static MTMCommonProxy	proxy;
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderers();
		GameRegistry.registerWorldGenerator(new MTMWorld(), 10);
		
		MTMTools.instance.load(event);
		MTMArmor.instance.load(event);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void playerJoined(EntityJoinWorldEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			CSUpdate.doClashsoftUpdateCheck((EntityPlayer) event.entity, "More Tools Mod", "mtm", VERSION);
		}
	}
}