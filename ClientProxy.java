package clashsoft.mods.moretools;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
	/** Armor files **/
	public static int obsidian;
	public static int redstone;
	public static int coal;
	public static int lapis;
	public static int ender;
	public static int space;
	public static int bone;
	public static int sugarcane;
	public static int blazerod;
	public static int dirt;
	public static int glass;
	public static int sandstone;
	public static int brick;
	public static int endstone;
	public static int hallowed;
	public static int goddawn;
	public static int invisibility;
	public static int emerald;
	public static int netherstar;
	public static int potato;
	public static int carrot;
	public static int fish;
	public static int bacon;
	public static int glowstone;
	public static int slime;
	
	public static String items = "/mod_moreTools/gui/items.png";
	public static String tools1 = "/mod_moreTools/gui/tools.png";
	public static String armor1 = "/mod_moreTools/gui/armor.png";
	public static String terrain = "/mod_moreTools/terrain.png";
	
	public void registerRenderers()
	{
		MinecraftForgeClient.preloadTexture(items);
		MinecraftForgeClient.preloadTexture(tools1);
		MinecraftForgeClient.preloadTexture(armor1);
		MinecraftForgeClient.preloadTexture(terrain);
		
		obsidian = RenderingRegistry.addNewArmourRendererPrefix("obsidian");
		redstone = RenderingRegistry.addNewArmourRendererPrefix("redstone");
		coal = RenderingRegistry.addNewArmourRendererPrefix("coal");
		lapis = RenderingRegistry.addNewArmourRendererPrefix("lapis");
		ender = RenderingRegistry.addNewArmourRendererPrefix("ender");
		space = RenderingRegistry.addNewArmourRendererPrefix("space");
		bone = RenderingRegistry.addNewArmourRendererPrefix("bone");
		sugarcane = RenderingRegistry.addNewArmourRendererPrefix("sugarcane");
		blazerod = RenderingRegistry.addNewArmourRendererPrefix("blazerod");
		dirt = RenderingRegistry.addNewArmourRendererPrefix("dirt");
		glass = RenderingRegistry.addNewArmourRendererPrefix("glass");
		sandstone = RenderingRegistry.addNewArmourRendererPrefix("sandstone");
		brick = RenderingRegistry.addNewArmourRendererPrefix("brick");
		endstone = RenderingRegistry.addNewArmourRendererPrefix("endstone");
		hallowed = RenderingRegistry.addNewArmourRendererPrefix("hallowed");
		goddawn = RenderingRegistry.addNewArmourRendererPrefix("goddawn");
		invisibility = RenderingRegistry.addNewArmourRendererPrefix("invisibility");
		emerald = RenderingRegistry.addNewArmourRendererPrefix("emerald");
		netherstar = RenderingRegistry.addNewArmourRendererPrefix("netherstar");
		potato = RenderingRegistry.addNewArmourRendererPrefix("potato");
		carrot = RenderingRegistry.addNewArmourRendererPrefix("carrot");
		fish = RenderingRegistry.addNewArmourRendererPrefix("fish");
		bacon = RenderingRegistry.addNewArmourRendererPrefix("bacon");
		glowstone = RenderingRegistry.addNewArmourRendererPrefix("glowstone");
		slime = RenderingRegistry.addNewArmourRendererPrefix("slime");
	}
}
