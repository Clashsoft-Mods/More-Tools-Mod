package clashsoft.mods.moretools;

import clashsoft.cslib.minecraft.update.CSUpdate;
import clashsoft.mods.moretools.addons.MTMAchievements;
import clashsoft.mods.moretools.addons.MTMArmor;
import clashsoft.mods.moretools.addons.MTMTools;
import clashsoft.mods.moretools.addons.MTMWorld;
import clashsoft.mods.moretools.common.MTMCommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

@Mod(modid = "MoreToolsMod", name = "More Tools Mod", version = MoreToolsMod.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MoreToolsMod
{
	public static final int			REVISION		= 5;
	public static final String		VERSION			= CSUpdate.CURRENT_VERSION + "-" + REVISION;
	
	@Instance("MoreToolsMod")
	public static MoreToolsMod		instance;
	
	@SidedProxy(clientSide = "clashsoft.mods.moretools.client.MTMClientProxy", serverSide = "clashsoft.mods.moretools.common.MTMCommonProxy")
	public static MTMCommonProxy	proxy;
	
	public static int				toolsID			= 17000;
	public static int				armorID			= 17500;
	public static int				itemsID			= 18000;
	
	public static int				spaceBlockID	= 1300;
	public static int				spaceOreID		= 1301;
	public static int				glowingBlockID	= 1302;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		toolsID = config.getItem("Tool Items Start ID", 17000).getInt();
		armorID = config.getItem("Armor Item Start ID", 17500).getInt();
		itemsID = config.getItem("Item Start ID", 18000).getInt();
		
		spaceBlockID = config.getBlock("Space Block ID", 1300).getInt();
		spaceOreID = config.getBlock("Space Ore ID", 1301).getInt();
		glowingBlockID = config.getBlock("Glowing Block ID", 1302).getInt();
		
		config.save();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderers();
		GameRegistry.registerWorldGenerator(new MTMWorld());
		
		MTMTools.instance.load(event);
		MTMArmor.instance.load(event);
		MTMAchievements.instance.load();
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@ForgeSubscribe
	public void playerJoined(EntityJoinWorldEvent event)
	{
		if (event.entity instanceof EntityPlayer)
			CSUpdate.doClashsoftUpdateCheck((EntityPlayer) event.entity, "More Tools Mod", "mtm", VERSION);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		System.out.println("[MoreToolsMod] Succesfully loaded More Tools Mod v" + VERSION);
		System.out.println("[MoreToolsMod] ID Settings: ");
		System.out.println("[MoreToolsMod]   Tools:      " + toolsID);
		System.out.println("[MoreToolsMod]   Armory:     " + armorID);
		System.out.println("[MoreToolsMod]   Misc Items: " + itemsID);
	}
}