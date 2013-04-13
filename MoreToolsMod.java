package clashsoft.mods.moretools;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "More Tools Mod", name="More Tools Mod", version="1.5.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MoreToolsMod
{
	@Instance("MoreToolsModMainID")
	public static MoreToolsMod instance;
	
	@SidedProxy(clientSide = "clashsoft.mods.moretools.ClientProxy", serverSide = "clashsoft.mods.moretools.CommonProxy")
	public static CommonProxy proxy;
	
	public int linesOfCode =
			  803	//Tools
			+ 436	//Armor
			//+ 68	//Achievements
			+ 46	//WorldGen
			+ 69	//ClientProxy
			+ 23	//CommonProxy
			+ 56	//this
			;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.registerRenderers();
		GameRegistry.registerWorldGenerator(new MoreToolsMod_WorldGen());
	}
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		MoreToolsMod_Tools.instance.load(event);
		MoreToolsMod_Armor.instance.load(event);
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
		System.out.println("[MoreToolsMod] Succesfully loaded More Tools Mod v1.5.1");
		System.out.println("[MoreToolsMod] Thanks for using!");
		System.out.println("[MoreToolsMod] Made by Clashsoft.");
	}
}