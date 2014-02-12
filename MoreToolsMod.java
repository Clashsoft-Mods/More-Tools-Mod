package clashsoft.mods.moretools;

import clashsoft.cslib.minecraft.item.CSStacks;
import clashsoft.mods.moretools.addons.MTMArmor;
import clashsoft.mods.moretools.addons.MTMTools;
import clashsoft.mods.moretools.addons.MTMWorld;
import clashsoft.mods.moretools.common.MTMCommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

@Mod(modid = MTMVersion.MODID, name = MTMVersion.NAME, version = MTMVersion.VERSION)
public class MoreToolsMod
{
	@Instance(MTMVersion.MODID)
	public static MoreToolsMod		instance;
	
	@SidedProxy(clientSide = "clashsoft.mods.moretools.client.MTMClientProxy", serverSide = "clashsoft.mods.moretools.common.MTMCommonProxy")
	public static MTMCommonProxy	proxy;
	
	public static ArmorMaterial[]	armorMaterials	= new ArmorMaterial[] {
			MTMArmor.OBSIDIAN,
			MTMArmor.REDSTONE,
			MTMArmor.COAL,
			MTMArmor.LAPIS,
			MTMArmor.END,
			MTMArmor.BONE,
			MTMArmor.REED,
			MTMArmor.BLAZEROD,
			MTMArmor.DIRT,
			MTMArmor.GLASS,
			MTMArmor.SANDSTONE,
			MTMArmor.BRICK,
			MTMArmor.ENDSTONE,
			MTMArmor.EMERALD,
			MTMArmor.NETHERSTAR,
			MTMArmor.POTATO,
			MTMArmor.CARROT,
			MTMArmor.FISH,
			MTMArmor.BACON,
			MTMArmor.SLIME							};
	
	public static String[]			armorTypes		= new String[] {
			"helmet",
			"chestplate",
			"leggings",
			"boots"								};
	
	public static ToolMaterial[]	toolMaterials	= new ToolMaterial[] {
			MTMTools.OBSIDIAN,
			MTMTools.REDSTONE,
			MTMTools.COAL,
			MTMTools.LAPIS,
			MTMTools.END,
			MTMTools.BONE,
			MTMTools.REED,
			MTMTools.BLAZEROD,
			MTMTools.DIRT,
			MTMTools.GLASS,
			MTMTools.SANDSTONE,
			MTMTools.BRICK,
			MTMTools.ENDSTONE,
			MTMTools.EMERALD,
			MTMTools.NETHERSTAR,
			MTMTools.POTATO,
			MTMTools.CARROT,
			MTMTools.FISH,
			MTMTools.BACON,
			MTMTools.SLIME							};
	
	public static String[]			toolTypes		= new String[] {
			"sword",
			"shovel",
			"pickaxe",
			"axe",
			"hoe"									};
	
	public static String[]			materialNames	= new String[] {
			"obsidian",
			"redstone",
			"coal",
			"lapis",
			"ender",
			"bone",
			"sugarcane",
			"blaze",
			"dirt",
			"glass",
			"sandstone",
			"brick",
			"endstone",
			"emerald",
			"netherstar",
			"potato",
			"carrot",
			"fish",
			"bacon",
			"slime"								};
	
	public static ItemStack[]		stacks			= new ItemStack[] {
			CSStacks.obsidian,
			CSStacks.redstone_block,
			CSStacks.coal,
			CSStacks.lapis_block,
			CSStacks.ender_pearl,
			CSStacks.bone,
			CSStacks.reeds,
			CSStacks.blaze_rod,
			CSStacks.dirt,
			CSStacks.glass,
			CSStacks.sandstone,
			CSStacks.brick,
			CSStacks.end_stone,
			CSStacks.emerald,
			CSStacks.nether_star,
			CSStacks.potato,
			CSStacks.carrot,
			CSStacks.fish,
			CSStacks.porkchop,
			CSStacks.glowstone,
			CSStacks.slimeball						};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MTMTools.instance.load(event);
		MTMArmor.instance.load(event);
		MTMVersion.write(event.getModMetadata());
		
		// Free up some memory
		
		armorMaterials = null;
		armorTypes = null;
		toolMaterials = null;
		toolTypes = null;
		materialNames = null;
		stacks = null;
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(this);
		GameRegistry.registerWorldGenerator(new MTMWorld(), 1);
		proxy.registerRenderers();
	}
	
	@SubscribeEvent
	public void playerJoined(EntityJoinWorldEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			MTMVersion.updateCheck((EntityPlayer) event.entity);
		}
	}
}