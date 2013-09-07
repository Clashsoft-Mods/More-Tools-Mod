package clashsoft.mods.moretools;

import clashsoft.clashsoftapi.util.CSUtil;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraftforge.common.Configuration;

@Mod(modid = "MoreToolsMod", name = "More Tools Mod", version = CSUtil.CURRENT_VERION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MoreToolsMod
{
	@Instance("MoreToolsModMainID")
	public static MoreToolsMod	instance;
	
	@SidedProxy(clientSide = "clashsoft.mods.moretools.ClientProxy", serverSide = "clashsoft.mods.moretools.CommonProxy")
	public static CommonProxy	proxy;
	
	public static int			TOOLS_ID		= 1900;
	public static int			ARMORY_ID		= 2500;
	public static int			MISCITEMS_ID	= 2400;
	
	public int					linesOfCode		= 803 // Tools
														+ 436 // Armor
														+ 68 // Achievements
														+ 46 // WorldGen
														+ 69 // ClientProxy
														+ 23 // CommonProxy
														+ 56 // this
												;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		TOOLS_ID = config.get("IDs", "ToolItems", 1900).getInt();
		ARMORY_ID = config.get("IDs", "ArmorItems", 2500).getInt();
		MISCITEMS_ID = config.get("IDs", "MiscItems", 2400).getInt();
		
		config.save();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderers();
		GameRegistry.registerWorldGenerator(new MoreToolsMod_WorldGen());
		
		MoreToolsMod_Tools.instance.load(event);
		MoreToolsMod_Armor.instance.load(event);
		MoreToolsMod_Achievements.instance.load();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		System.out.println("[MoreToolsMod] Succesfully loaded More Tools Mod");
		System.out.println("[MoreToolsMod] Thanks for using!");
		System.out.println("[MoreToolsMod] Made by Clashsoft.");
		System.out.println("[MoreToolsMod] Setting IDs: ");
		System.out.println("[MoreToolsMod]   Tools: 	 " + TOOLS_ID);
		System.out.println("[MoreToolsMod]   Armory:	 " + ARMORY_ID);
		System.out.println("[MoreToolsMod]   Misc Items: " + MISCITEMS_ID);
	}
}