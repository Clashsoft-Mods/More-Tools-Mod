package clashsoft.mods.moretools.addons;

import clashsoft.cslib.addon.Addon;
import clashsoft.cslib.minecraft.CustomBlock;
import clashsoft.cslib.minecraft.CustomEnchantment;
import clashsoft.cslib.minecraft.ItemCustomBlock;
import clashsoft.cslib.minecraft.util.CSBlocks;
import clashsoft.cslib.minecraft.util.CSCrafting;
import clashsoft.cslib.minecraft.util.CSItems;
import clashsoft.mods.moretools.MoreToolsMod;
import clashsoft.mods.moretools.block.BlockGlowing;
import clashsoft.mods.moretools.block.BlockSpaceblock;
import clashsoft.mods.moretools.crafting.RecipesToolDyes;
import clashsoft.mods.moretools.item.ItemMTM;
import clashsoft.mods.moretools.item.buckets.ItemGoldBucket;
import clashsoft.mods.moretools.item.dyeable.*;
import clashsoft.mods.moretools.item.lightsabers.ItemLightsaber;
import clashsoft.mods.moretools.item.lightsabers.ItemLightsaberShaft;
import clashsoft.mods.moretools.item.tools.*;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

@Addon(modName = "MoreToolsMod", addonName = "Tools")
public class MTMTools
{
	
	public static MTMTools			instance			= new MTMTools();
	
	// Tool Materials
	
	public static EnumToolMaterial	OBSIDIAN			= CSItems.addToolMaterial("OBSIDIAN", 3, 4096, 25F, 10, 10, 0x1e182b, new ItemStack(Block.obsidian), null);
	public static EnumToolMaterial	REDSTONE			= EnumHelper.addToolMaterial("REDSTONE", 2, 64, 6F, 2.5F, 15);
	public static EnumToolMaterial	COAL				= EnumHelper.addToolMaterial("COAL", 1, 128, 3F, 2.1F, 15);
	public static EnumToolMaterial	LAPIS				= EnumHelper.addToolMaterial("LAPIS", 2, 256, 3F, 2F, 15);
	public static EnumToolMaterial	END					= EnumHelper.addToolMaterial("END", 2, 512, 5F, 2.8F, 15);
	public static EnumToolMaterial	SPACE1				= EnumHelper.addToolMaterial("SPACESTRONG", 3, 8196, 50F, 13F, 20);
	public static EnumToolMaterial	SPACE2				= EnumHelper.addToolMaterial("SPACEWEAK", 3, 6144, 40F, 10F, 18);
	public static EnumToolMaterial	BONE				= EnumHelper.addToolMaterial("BONE", 1, 32, 1.5F, 1.2F, 15);
	public static EnumToolMaterial	REED				= EnumHelper.addToolMaterial("REED", 0, 16, 0.5F, 0.2F, 15);
	public static EnumToolMaterial	BLAZEROD			= EnumHelper.addToolMaterial("BLAZEROD", 2, 512, 6F, 1.9F, 15);
	public static EnumToolMaterial	DIRT				= EnumHelper.addToolMaterial("DIRT", 0, 16, 0.8F, -0.1F, 15);
	public static EnumToolMaterial	GLASS				= EnumHelper.addToolMaterial("GLASS", 0, 16, 0.5F, 1.3F, 15);
	public static EnumToolMaterial	SANDSTONE			= EnumHelper.addToolMaterial("SANDSTONE", 1, 128, 3F, 1.8F, 15);
	public static EnumToolMaterial	BRICK				= EnumHelper.addToolMaterial("BRICK", 1, 128, 2.5F, 1.75F, 15);
	public static EnumToolMaterial	ENDSTONE			= EnumHelper.addToolMaterial("ENDSTONE", 2, 256, 3.5F, 2.9F, 15);
	public static EnumToolMaterial	EXCALIBUR			= EnumHelper.addToolMaterial("EXCALIBUR", 3, 16392, 10F, 20F, 1);
	public static EnumToolMaterial	GOD					= EnumHelper.addToolMaterial("GOD", 3, 2048, 5F, 15F, 10);
	public static EnumToolMaterial	LUZIFER				= EnumHelper.addToolMaterial("LUZIFER", 3, 2048, 5F, 15F, 10);
	public static EnumToolMaterial	LASER				= EnumHelper.addToolMaterial("LASER", 3, -1, 1F, 25F, 1);
	public static EnumToolMaterial	EMERALD2			= EnumHelper.addToolMaterial("EMERALD2", 3, 1536, 8F, 2.95F, 17);
	public static EnumToolMaterial	NETHERSTAR			= EnumHelper.addToolMaterial("NETHERSTAR", 3, 2048, 12F, 4F, 20);
	public static EnumToolMaterial	POTATO				= EnumHelper.addToolMaterial("POTATO", 1, 64, 3F, 0.6F, 15);
	public static EnumToolMaterial	CARROT				= EnumHelper.addToolMaterial("CARROT", 1, 64, 3F, 0.6F, 15);
	public static EnumToolMaterial	FISH				= EnumHelper.addToolMaterial("FISH", 1, 64, 2.5F, 0.7F, 15);
	public static EnumToolMaterial	BACON				= EnumHelper.addToolMaterial("BACON", 1, 64, 2.5F, 0.7F, 15);
	public static EnumToolMaterial	LEATHER				= EnumToolMaterial.WOOD;
	public static EnumToolMaterial	GLOWSTONE			= EnumHelper.addToolMaterial("GLOWSTONE", 2, 64, 1F, 1F, 16);
	public static EnumToolMaterial	SLIME				= EnumHelper.addToolMaterial("SLIME", 1, 80, 1.2F, 0.85F, 15);
	
	// Enchantments
	
	public static Enchantment		quickDraw			= new CustomEnchantment(7, 1, 3, EnumEnchantmentType.bow, "quickdraw");
	
	// Rarities
	
	public static int				EPIC				= 0;
	public static int				RARE				= 1;
	public static int				UNCOMMON			= 2;
	public static int				COMMON				= 3;																																								// Goddawn
																																																								
	// Blocks
	
	public static CustomBlock		spaceBlock			= (CustomBlock) (new BlockSpaceblock(MoreToolsMod.spaceBlockID)).setHardness(3F).setLightValue(15 / 16).setUnlocalizedName("spaceblock");
	public static Block				spaceOre			= new Block(MoreToolsMod.spaceOreID, Material.rock).setHardness(2.5F).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("spaceore").setTextureName("spaceore");
	public static BlockGlowing		glowingBlock		= (BlockGlowing) (new BlockGlowing(MoreToolsMod.glowingBlockID)).setHardness(0F).setLightValue(1F).setUnlocalizedName("glowing");
	
	// Items
	
	public static Item				obsidianPick		= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 1, OBSIDIAN)).setUnlocalizedName("obsidianPickaxe");
	public static Item				obsidianShovel		= (new ItemSpadeMTM(MoreToolsMod.toolsID + 2, OBSIDIAN)).setUnlocalizedName("obsidianShovel");
	public static Item				obsidianAxe			= (new ItemAxeMTM(MoreToolsMod.toolsID + 3, OBSIDIAN)).setUnlocalizedName("obsidianAxe");
	public static Item				obsidianHoe			= (new ItemHoeMTM(MoreToolsMod.toolsID + 4, OBSIDIAN)).setUnlocalizedName("obsidianHoe");
	public static Item				obsidianSword		= (new ItemSwordMTM(MoreToolsMod.toolsID + 5, OBSIDIAN, UNCOMMON)).setUnlocalizedName("obsidianSword");
	
	public static Item				redstonePick		= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 6, REDSTONE)).setUnlocalizedName("redstonePickaxe");
	public static Item				redstoneShovel		= (new ItemSpadeMTM(MoreToolsMod.toolsID + 7, REDSTONE)).setUnlocalizedName("redstoneShovel");
	public static Item				redstoneAxe			= (new ItemAxeMTM(MoreToolsMod.toolsID + 8, REDSTONE)).setUnlocalizedName("redstoneAxe");
	public static Item				redstoneHoe			= (new ItemHoeMTM(MoreToolsMod.toolsID + 9, REDSTONE)).setUnlocalizedName("redstoneHoe");
	public static Item				redstoneSword		= (new ItemSwordMTM(MoreToolsMod.toolsID + 10, REDSTONE, UNCOMMON)).setUnlocalizedName("redstoneSword");
	
	public static Item				coalPick			= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 11, COAL)).setUnlocalizedName("coalPickaxe");
	public static Item				coalShovel			= (new ItemSpadeMTM(MoreToolsMod.toolsID + 12, COAL)).setUnlocalizedName("coalShovel");
	public static Item				coalAxe				= (new ItemAxeMTM(MoreToolsMod.toolsID + 13, COAL)).setUnlocalizedName("coalAxe");
	public static Item				coalHoe				= (new ItemHoeMTM(MoreToolsMod.toolsID + 14, COAL)).setUnlocalizedName("coalHoe");
	public static Item				coalSword			= (new ItemSwordMTM(MoreToolsMod.toolsID + 15, COAL, COMMON)).setUnlocalizedName("coalSword");
	
	public static Item				lapisPick			= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 16, LAPIS)).setUnlocalizedName("lapisPickaxe");
	public static Item				lapisShovel			= (new ItemSpadeMTM(MoreToolsMod.toolsID + 17, LAPIS)).setUnlocalizedName("lapisShovel");
	public static Item				lapisAxe			= (new ItemAxeMTM(MoreToolsMod.toolsID + 18, LAPIS)).setUnlocalizedName("lapisAxe");
	public static Item				lapisHoe			= (new ItemHoeMTM(MoreToolsMod.toolsID + 19, LAPIS)).setUnlocalizedName("lapisHoe");
	public static Item				lapisSword			= (new ItemSwordMTM(MoreToolsMod.toolsID + 20, LAPIS, COMMON)).setUnlocalizedName("lapisSword");
	
	public static Item				enderPick			= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 21, END)).setUnlocalizedName("enderPickaxe");
	public static Item				enderShovel			= (new ItemSpadeMTM(MoreToolsMod.toolsID + 22, END)).setUnlocalizedName("enderShovel");
	public static Item				enderAxe			= (new ItemAxeMTM(MoreToolsMod.toolsID + 23, END)).setUnlocalizedName("enderAxe");
	public static Item				enderHoe			= (new ItemHoeMTM(MoreToolsMod.toolsID + 24, END)).setUnlocalizedName("enderHoe");
	public static Item				enderSword			= (new ItemSwordMTM(MoreToolsMod.toolsID + 25, END, RARE)).setUnlocalizedName("enderSword");
	
	public static Item				spacePick			= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 26, SPACE1)).setUnlocalizedName("spacePickaxe");
	public static Item				spaceShovel			= (new ItemSpadeMTM(MoreToolsMod.toolsID + 27, SPACE1)).setUnlocalizedName("spaceShovel");
	public static Item				spaceAxe			= (new ItemAxeMTM(MoreToolsMod.toolsID + 28, SPACE1)).setUnlocalizedName("spaceAxe");
	public static Item				spaceHoe			= (new ItemHoeMTM(MoreToolsMod.toolsID + 29, SPACE1)).setUnlocalizedName("spaceHoe");
	public static Item				spaceSwordAdvanced	= (new ItemSwordMTM(MoreToolsMod.toolsID + 30, SPACE1, EPIC)).setUnlocalizedName("spaceSwordStrong");
	
	public static Item				bonePick			= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 31, BONE)).setUnlocalizedName("bonePickaxe");
	public static Item				boneShovel			= (new ItemSpadeMTM(MoreToolsMod.toolsID + 32, BONE)).setUnlocalizedName("boneShovel");
	public static Item				boneAxe				= (new ItemAxeMTM(MoreToolsMod.toolsID + 33, BONE)).setUnlocalizedName("boneAxe");
	public static Item				boneHoe				= (new ItemHoeMTM(MoreToolsMod.toolsID + 34, BONE)).setUnlocalizedName("boneHoe");
	public static Item				boneSword			= (new ItemSwordMTM(MoreToolsMod.toolsID + 35, BONE, COMMON)).setUnlocalizedName("boneSword");
	
	public static Item				sugarcanePick		= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 36, REED)).setUnlocalizedName("sugarcanePickaxe");
	public static Item				sugarcaneShovel		= (new ItemSpadeMTM(MoreToolsMod.toolsID + 37, REED)).setUnlocalizedName("sugarcaneShovel");
	public static Item				sugarcaneAxe		= (new ItemAxeMTM(MoreToolsMod.toolsID + 38, REED)).setUnlocalizedName("sugarcaneAxe");
	public static Item				sugarcaneHoe		= (new ItemHoeMTM(MoreToolsMod.toolsID + 39, REED)).setUnlocalizedName("sugarcaneHoe");
	public static Item				sugarcaneSword		= (new ItemSwordMTM(MoreToolsMod.toolsID + 40, REED, COMMON)).setUnlocalizedName("sugarcaneSword");
	
	public static Item				blazerodPick		= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 41, BLAZEROD)).setUnlocalizedName("blazePickaxe");
	public static Item				blazerodShovel		= (new ItemSpadeMTM(MoreToolsMod.toolsID + 42, BLAZEROD)).setUnlocalizedName("blazeShovel");
	public static Item				blazerodAxe			= (new ItemAxeMTM(MoreToolsMod.toolsID + 43, BLAZEROD)).setUnlocalizedName("blazeAxe");
	public static Item				blazerodHoe			= (new ItemHoeMTM(MoreToolsMod.toolsID + 44, BLAZEROD)).setUnlocalizedName("blazeHoe");
	public static Item				blazerodSword		= (new ItemSwordMTM(MoreToolsMod.toolsID + 45, BLAZEROD, UNCOMMON)).setUnlocalizedName("blazeSword");
	
	public static Item				dirtPick			= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 46, DIRT)).setUnlocalizedName("dirtPickaxe");
	public static Item				dirtShovel			= (new ItemSpadeMTM(MoreToolsMod.toolsID + 47, DIRT)).setUnlocalizedName("dirtShovel");
	public static Item				dirtAxe				= (new ItemAxeMTM(MoreToolsMod.toolsID + 48, DIRT)).setUnlocalizedName("dirtAxe");
	public static Item				dirtHoe				= (new ItemHoeMTM(MoreToolsMod.toolsID + 49, DIRT)).setUnlocalizedName("dirtHoe");
	public static Item				dirtSword			= (new ItemSwordMTM(MoreToolsMod.toolsID + 50, DIRT, COMMON)).setUnlocalizedName("dirtSword");
	
	public static Item				glassPick			= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 51, GLASS)).setUnlocalizedName("glassPickaxe");
	public static Item				glassShovel			= (new ItemSpadeMTM(MoreToolsMod.toolsID + 52, GLASS)).setUnlocalizedName("glassShovel");
	public static Item				glassAxe			= (new ItemAxeMTM(MoreToolsMod.toolsID + 53, GLASS)).setUnlocalizedName("glassAxe");
	public static Item				glassHoe			= (new ItemHoeMTM(MoreToolsMod.toolsID + 54, GLASS)).setUnlocalizedName("glassHoe");
	public static Item				glassSword			= (new ItemSwordMTM(MoreToolsMod.toolsID + 55, GLASS, COMMON)).setUnlocalizedName("glassSword");
	
	public static Item				sandstonePick		= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 56, SANDSTONE)).setUnlocalizedName("sandstonePickaxe");
	public static Item				sandstoneShovel		= (new ItemSpadeMTM(MoreToolsMod.toolsID + 57, SANDSTONE)).setUnlocalizedName("sandstoneShovel");
	public static Item				sandstoneAxe		= (new ItemAxeMTM(MoreToolsMod.toolsID + 58, SANDSTONE)).setUnlocalizedName("sandstoneAxe");
	public static Item				sandstoneHoe		= (new ItemHoeMTM(MoreToolsMod.toolsID + 59, SANDSTONE)).setUnlocalizedName("sandstoneHoe");
	public static Item				sandstoneSword		= (new ItemSwordMTM(MoreToolsMod.toolsID + 60, SANDSTONE, COMMON)).setUnlocalizedName("sandstoneSword");
	
	public static Item				brickPick			= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 61, BRICK)).setUnlocalizedName("brickPickaxe");
	public static Item				brickShovel			= (new ItemSpadeMTM(MoreToolsMod.toolsID + 62, BRICK)).setUnlocalizedName("brickShovel");
	public static Item				brickAxe			= (new ItemAxeMTM(MoreToolsMod.toolsID + 63, BRICK)).setUnlocalizedName("brickAxe");
	public static Item				brickHoe			= (new ItemHoeMTM(MoreToolsMod.toolsID + 64, BRICK)).setUnlocalizedName("brickHoe");
	public static Item				brickSword			= (new ItemSwordMTM(MoreToolsMod.toolsID + 65, BRICK, COMMON)).setUnlocalizedName("brickSword");
	
	public static Item				endstonePick		= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 66, ENDSTONE)).setUnlocalizedName("endstonePickaxe");
	public static Item				endstoneShovel		= (new ItemSpadeMTM(MoreToolsMod.toolsID + 67, ENDSTONE)).setUnlocalizedName("endstoneShovel");
	public static Item				endstoneAxe			= (new ItemAxeMTM(MoreToolsMod.toolsID + 68, ENDSTONE)).setUnlocalizedName("endstoneAxe");
	public static Item				endstoneHoe			= (new ItemHoeMTM(MoreToolsMod.toolsID + 69, ENDSTONE)).setUnlocalizedName("endstoneHoe");
	public static Item				endstoneSword		= (new ItemSwordMTM(MoreToolsMod.toolsID + 70, ENDSTONE, UNCOMMON)).setUnlocalizedName("endstoneSword");
	
	public static Item				excaliburSword		= (new ItemSwordMTM(MoreToolsMod.toolsID + 75, EXCALIBUR, EPIC)).setUnlocalizedName("epicSword");
	
	public static Item				godPick				= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 76, GOD)).setUnlocalizedName("godPickaxe");
	public static Item				godShovel			= (new ItemSpadeMTM(MoreToolsMod.toolsID + 77, GOD)).setUnlocalizedName("godShovel");
	public static Item				godAxe				= (new ItemAxeMTM(MoreToolsMod.toolsID + 78, GOD)).setUnlocalizedName("godAxe");
	public static Item				godHoe				= (new ItemHoeMTM(MoreToolsMod.toolsID + 79, GOD)).setUnlocalizedName("godHoe");
	public static Item				godSword			= (new ItemSwordMTM(MoreToolsMod.toolsID + 80, GOD, EPIC)).setUnlocalizedName("godSword");
	
	public static Item				luziferPick			= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 81, LUZIFER)).setUnlocalizedName("luziferPickaxe");
	public static Item				luziferShovel		= (new ItemSpadeMTM(MoreToolsMod.toolsID + 82, LUZIFER)).setUnlocalizedName("luziferShovel");
	public static Item				luziferAxe			= (new ItemAxeMTM(MoreToolsMod.toolsID + 83, LUZIFER)).setUnlocalizedName("luziferAxe");
	public static Item				luziferHoe			= (new ItemHoeMTM(MoreToolsMod.toolsID + 84, LUZIFER)).setUnlocalizedName("luziferHoe");
	public static Item				luziferSword		= (new ItemSwordMTM(MoreToolsMod.toolsID + 85, LUZIFER, EPIC)).setUnlocalizedName("luziferSword");
	
	public static Item				lightsaberShaft		= (new ItemLightsaberShaft(MoreToolsMod.itemsID + 05)).setUnlocalizedName("lsshaft");
	public static Item				lightsaberBlue		= (new ItemLightsaber(MoreToolsMod.toolsID + 86, LASER)).setUnlocalizedName("lightSaber1");
	public static Item				lightsaberGreen		= (new ItemLightsaber(MoreToolsMod.toolsID + 87, LASER)).setUnlocalizedName("lightSaber2");
	public static Item				lightsaberPurple	= (new ItemLightsaber(MoreToolsMod.toolsID + 88, LASER)).setUnlocalizedName("lightSaber3");
	public static Item				lightsaberRed		= (new ItemLightsaber(MoreToolsMod.toolsID + 89, LASER)).setUnlocalizedName("lightSaber4");
	public static Item				lightsaberWhite		= (new ItemLightsaber(MoreToolsMod.toolsID + 90, LASER)).setUnlocalizedName("lightSaber5");
	
	public static Item				emeraldPick			= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 91, EMERALD2)).setUnlocalizedName("emeraldPickaxe");
	public static Item				emeraldShovel		= (new ItemSpadeMTM(MoreToolsMod.toolsID + 92, EMERALD2)).setUnlocalizedName("emeraldShovel");
	public static Item				emeraldAxe			= (new ItemAxeMTM(MoreToolsMod.toolsID + 93, EMERALD2)).setUnlocalizedName("emeraldAxe");
	public static Item				emeraldHoe			= (new ItemHoeMTM(MoreToolsMod.toolsID + 94, EMERALD2)).setUnlocalizedName("emeraldHoe");
	public static Item				emeraldSword		= (new ItemSwordMTM(MoreToolsMod.toolsID + 95, EMERALD2, EPIC)).setUnlocalizedName("emeraldSword");
	
	public static Item				netherstarPick		= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 96, NETHERSTAR)).setUnlocalizedName("netherstarPickaxe");
	public static Item				netherstarShovel	= (new ItemSpadeMTM(MoreToolsMod.toolsID + 97, NETHERSTAR)).setUnlocalizedName("netherstarShovel");
	public static Item				netherstarAxe		= (new ItemAxeMTM(MoreToolsMod.toolsID + 98, NETHERSTAR)).setUnlocalizedName("netherstarAxe");
	public static Item				netherstarHoe		= (new ItemHoeMTM(MoreToolsMod.toolsID + 99, NETHERSTAR)).setUnlocalizedName("netherstarHoe");
	public static Item				netherstarSword		= (new ItemSwordMTM(MoreToolsMod.toolsID + 120, NETHERSTAR, EPIC)).setUnlocalizedName("netherstarSword");
	
	public static Item				potatoPick			= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 121, POTATO)).setUnlocalizedName("potatoPickaxe");
	public static Item				potatoShovel		= (new ItemSpadeMTM(MoreToolsMod.toolsID + 122, POTATO)).setUnlocalizedName("potatoShovel");
	public static Item				potatoAxe			= (new ItemAxeMTM(MoreToolsMod.toolsID + 123, POTATO)).setUnlocalizedName("potatoAxe");
	public static Item				potatoHoe			= (new ItemHoeMTM(MoreToolsMod.toolsID + 124, POTATO)).setUnlocalizedName("potatoHoe");
	public static Item				potatoSword			= (new ItemSwordMTM(MoreToolsMod.toolsID + 125, POTATO, COMMON)).setUnlocalizedName("potatoSword");
	
	public static Item				carrotPick			= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 126, CARROT)).setUnlocalizedName("carrotPickaxe");
	public static Item				carrotShovel		= (new ItemSpadeMTM(MoreToolsMod.toolsID + 127, CARROT)).setUnlocalizedName("carrotShovel");
	public static Item				carrotAxe			= (new ItemAxeMTM(MoreToolsMod.toolsID + 128, CARROT)).setUnlocalizedName("carrotAxe");
	public static Item				carrotHoe			= (new ItemHoeMTM(MoreToolsMod.toolsID + 129, CARROT)).setUnlocalizedName("carrotHoe");
	public static Item				carrotSword			= (new ItemSwordMTM(MoreToolsMod.toolsID + 130, CARROT, COMMON)).setUnlocalizedName("carrotSword");
	
	public static Item				fishPick			= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 131, FISH)).setUnlocalizedName("fishPickaxe");
	public static Item				fishShovel			= (new ItemSpadeMTM(MoreToolsMod.toolsID + 132, FISH)).setUnlocalizedName("fishShovel");
	public static Item				fishAxe				= (new ItemAxeMTM(MoreToolsMod.toolsID + 133, FISH)).setUnlocalizedName("fishAxe");
	public static Item				fishHoe				= (new ItemHoeMTM(MoreToolsMod.toolsID + 134, FISH)).setUnlocalizedName("fishHoe");
	public static Item				fishSword			= (new ItemSwordMTM(MoreToolsMod.toolsID + 135, FISH, COMMON)).setUnlocalizedName("fishSword");
	
	public static Item				baconPick			= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 100 + 36, BACON)).setUnlocalizedName("baconPickaxe");
	public static Item				baconShovel			= (new ItemSpadeMTM(MoreToolsMod.toolsID + 100 + 37, BACON)).setUnlocalizedName("baconShovel");
	public static Item				baconAxe			= (new ItemAxeMTM(MoreToolsMod.toolsID + 100 + 38, BACON)).setUnlocalizedName("baconAxe");
	public static Item				baconHoe			= (new ItemHoeMTM(MoreToolsMod.toolsID + 100 + 39, BACON)).setUnlocalizedName("baconHoe");
	public static Item				baconSword			= (new ItemSwordMTM(MoreToolsMod.toolsID + 100 + 40, BACON, COMMON)).setUnlocalizedName("baconSword");
	
	public static Item				leatherPick			= (new ItemDyeablePickaxe(MoreToolsMod.toolsID + 100 + 41, LEATHER)).setUnlocalizedName("leatherPickaxe");
	public static Item				leatherShovel		= (new ItemDyeableShovel(MoreToolsMod.toolsID + 100 + 42, LEATHER)).setUnlocalizedName("leatherShovel");
	public static Item				leatherAxe			= (new ItemDyeableAxe(MoreToolsMod.toolsID + 100 + 43, LEATHER)).setUnlocalizedName("leatherAxe");
	public static Item				leatherHoe			= (new ItemDyeableHoe(MoreToolsMod.toolsID + 100 + 44, LEATHER)).setUnlocalizedName("leatherHoe");
	public static Item				leatherSword		= (new ItemDyeableSword(MoreToolsMod.toolsID + 100 + 45, LEATHER)).setUnlocalizedName("leatherSword");
	
	public static Item				glowstonePick		= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 100 + 46, GLOWSTONE)).setUnlocalizedName("glowstonePickaxe");
	public static Item				glowstoneShovel		= (new ItemSpadeMTM(MoreToolsMod.toolsID + 100 + 47, GLOWSTONE)).setUnlocalizedName("glowstoneShovel");
	public static Item				glowstoneAxe		= (new ItemAxeMTM(MoreToolsMod.toolsID + 100 + 48, GLOWSTONE)).setUnlocalizedName("glowstoneAxe");
	public static Item				glowstoneHoe		= (new ItemHoeMTM(MoreToolsMod.toolsID + 100 + 49, GLOWSTONE)).setUnlocalizedName("glowstoneHoe");
	public static Item				glowstoneSword		= (new ItemSwordMTM(MoreToolsMod.toolsID + 100 + 50, GLOWSTONE, COMMON)).setUnlocalizedName("glowstoneSword");
	
	public static Item				slimePick			= (new ItemPickaxeMTM(MoreToolsMod.toolsID + 100 + 51, SLIME)).setUnlocalizedName("slimePickaxe");
	public static Item				slimeShovel			= (new ItemSpadeMTM(MoreToolsMod.toolsID + 100 + 52, SLIME)).setUnlocalizedName("slimeShovel");
	public static Item				slimeAxe			= (new ItemAxeMTM(MoreToolsMod.toolsID + 100 + 53, SLIME)).setUnlocalizedName("slimeAxe");
	public static Item				slimeHoe			= (new ItemHoeMTM(MoreToolsMod.toolsID + 100 + 54, SLIME)).setUnlocalizedName("slimeHoe");
	public static Item				slimeSword			= (new ItemSwordMTM(MoreToolsMod.toolsID + 100 + 55, SLIME, COMMON)).setUnlocalizedName("slimeSword");
	
	public static Item				spaceMultitool		= (new ItemMultitool(MoreToolsMod.itemsID, SPACE1)).setUnlocalizedName("spacemulti");
	public static Item				spaceArrow			= (new ItemMTM(MoreToolsMod.itemsID + 2, CreativeTabs.tabCombat)).setUnlocalizedName("spacearrow");
	public static Item				spaceBow			= (new ItemBowMTM(MoreToolsMod.itemsID + 1, spaceArrow, false)).setUnlocalizedName("spacebow");
	public static Item				spaceIngot			= (new ItemMTM(MoreToolsMod.itemsID + 3, CreativeTabs.tabMaterials)).setUnlocalizedName("spaceingot");
	public static Item				spaceSword			= (new ItemSwordMTM(MoreToolsMod.itemsID + 4, SPACE2, RARE)).setUnlocalizedName("spaceSwordWeak");
	
	public static Item				blazerodAndSteel	= (new ItemFlintAndSteelMTM(MoreToolsMod.toolsID + 204, 128)).setUnlocalizedName("blazeandsteel");
	
	public static Item				goldShears			= (new ItemShearsMTM(MoreToolsMod.toolsID + 205, 32, 2)).setUnlocalizedName("shearsgold");
	public static Item				diamondShears		= (new ItemShearsMTM(MoreToolsMod.toolsID + 206, 1024, 5)).setUnlocalizedName("shearsdiamond");
	
	public static Item				goldBucket			= (new ItemGoldBucket(MoreToolsMod.toolsID + 208, 0)).setUnlocalizedName("bucketgold");
	public static Item				goldBucketWater		= (new ItemGoldBucket(MoreToolsMod.toolsID + 209, Block.waterStill.blockID)).setUnlocalizedName("bucketgoldWater");
	public static Item				goldBucketLava		= (new ItemGoldBucket(MoreToolsMod.toolsID + 210, Block.lavaStill.blockID)).setUnlocalizedName("bucketgoldLava");
	public static Item				goldBucketMilk		= (new ItemBucketMilk(MoreToolsMod.toolsID + 211)).setUnlocalizedName("bucketgoldMilk").setCreativeTab(null);
	
	public static ItemStack			obsidian			= new ItemStack(Block.obsidian);
	public static ItemStack			redstone			= new ItemStack(Block.blockRedstone);
	public static ItemStack			coal				= new ItemStack(Item.coal);
	public static ItemStack			lapis				= new ItemStack(Block.blockLapis);
	public static ItemStack			enderPearl			= new ItemStack(Item.enderPearl);
	public static ItemStack			space				= new ItemStack(spaceIngot);
	public static ItemStack			spaceAdvanced		= new ItemStack(spaceBlock);
	public static ItemStack			bone				= new ItemStack(Item.bone);
	public static ItemStack			sugarcane			= new ItemStack(Item.reed);
	public static ItemStack			blazerod			= new ItemStack(Item.blazeRod);
	public static ItemStack			dirt				= new ItemStack(Block.dirt);
	public static ItemStack			glass				= new ItemStack(Block.glass);
	public static ItemStack			sandstone			= new ItemStack(Block.sandStone);
	public static ItemStack			brick				= new ItemStack(Block.brick);
	public static ItemStack			endstone			= new ItemStack(Block.whiteStone);
	public static ItemStack			emerald				= new ItemStack(Item.emerald);
	public static ItemStack			netherstar			= new ItemStack(Item.netherStar);
	public static ItemStack			potato				= new ItemStack(Item.potato);
	public static ItemStack			carrot				= new ItemStack(Item.carrot);
	public static ItemStack			fish				= new ItemStack(Item.fishRaw);
	public static ItemStack			bacon				= new ItemStack(Item.porkRaw);
	public static ItemStack			leather				= new ItemStack(Item.leather);
	public static ItemStack			glowstone			= new ItemStack(Item.glowstone);
	public static ItemStack			slime				= new ItemStack(Item.slimeBall);
	
	public void load(FMLInitializationEvent event)
	{
		LanguageRegistry.instance().addStringLocalization("enchantment.quickdraw", "Quick Draw");
		
		addItems();
		addBlocks();
		addRecipes();
	}
	
	public void addRecipes()
	{
		CSCrafting.addCrafting(new ItemStack(spaceBlock, 1, 1), new Object[] { "sss", "sss", "sss", Character.valueOf('s'), spaceIngot });
		
		CSCrafting.addSmelting(new ItemStack(spaceOre, 1, 0), new ItemStack(spaceIngot, 1), 0.5F);
		CSCrafting.addSmelting(new ItemStack(spaceBlock, 1, 0), new ItemStack(spaceIngot, 1), 0.5F);
		
		CraftingManager.getInstance().getRecipeList().add(new RecipesToolDyes());
	}
	
	public void addItems()
	{
		CSItems.addTool(MTMTools.obsidianSword, "Obsidian Sword", obsidian, 0);
		CSItems.addTool(MTMTools.obsidianShovel, "Obsidian Shovel", obsidian, 1);
		CSItems.addTool(MTMTools.obsidianPick, "Obsidian Pickaxe", obsidian, 2);
		CSItems.addTool(MTMTools.obsidianAxe, "Obsidian Axe", obsidian, 3);
		CSItems.addTool(MTMTools.obsidianHoe, "Obsidian Hoe", obsidian, 4);
		
		CSItems.addTool(MTMTools.redstoneSword, "Redstone Sword", redstone, 0);
		CSItems.addTool(MTMTools.redstoneShovel, "Redstone Shovel", redstone, 1);
		CSItems.addTool(MTMTools.redstonePick, "Redstone Pickaxe", redstone, 2);
		CSItems.addTool(MTMTools.redstoneAxe, "Redstone Axe", redstone, 3);
		CSItems.addTool(MTMTools.redstoneHoe, "Redstone Hoe", redstone, 4);
		
		CSItems.addTool(MTMTools.coalSword, "Coal Sword", coal, 0);
		CSItems.addTool(MTMTools.coalShovel, "Coal Shovel", coal, 1);
		CSItems.addTool(MTMTools.coalPick, "Coal Pickaxe", coal, 2);
		CSItems.addTool(MTMTools.coalAxe, "Coal Axe", coal, 3);
		CSItems.addTool(MTMTools.coalHoe, "Coal Hoe", coal, 4);
		
		CSItems.addTool(MTMTools.lapisSword, "Lapislazuli Sword", lapis, 0);
		CSItems.addTool(MTMTools.lapisShovel, "Lapislazuli Shovel", lapis, 1);
		CSItems.addTool(MTMTools.lapisPick, "Lapislazuli Pickaxe", lapis, 2);
		CSItems.addTool(MTMTools.lapisAxe, "Lapislazuli Axe", lapis, 3);
		CSItems.addTool(MTMTools.lapisHoe, "Lapislazuli Hoe", lapis, 4);
		
		CSItems.addTool(MTMTools.enderSword, "Ender Sword", enderPearl, 0);
		CSItems.addTool(MTMTools.enderShovel, "Ender Shovel", enderPearl, 1);
		CSItems.addTool(MTMTools.enderPick, "Ender Pickaxe", enderPearl, 2);
		CSItems.addTool(MTMTools.enderAxe, "Ender Axe", enderPearl, 3);
		CSItems.addTool(MTMTools.enderHoe, "Ender Hoe", enderPearl, 4);
		
		CSItems.addTool(spaceSword, "Normal Spacesword", space, 0);
		CSItems.addTool(MTMTools.spaceSwordAdvanced, "Advanced Spacesword", spaceAdvanced, 0);
		CSItems.addTool(MTMTools.spaceShovel, "Space Shovel", space, 1);
		CSItems.addTool(MTMTools.spacePick, "Space Pickaxe", space, 2);
		CSItems.addTool(MTMTools.spaceAxe, "Space Axe", space, 3);
		CSItems.addTool(MTMTools.spaceHoe, "Space Hoe", space, 4);
		
		CSItems.addTool(MTMTools.boneSword, "Bone Sword", bone, 0);
		CSItems.addTool(MTMTools.boneShovel, "Bone Shovel", bone, 1);
		CSItems.addTool(MTMTools.bonePick, "Bone Pickaxe", bone, 2);
		CSItems.addTool(MTMTools.boneAxe, "Bone Axe", bone, 3);
		CSItems.addTool(MTMTools.boneHoe, "Bone Hoe", bone, 4);
		
		CSItems.addTool(MTMTools.sugarcaneSword, "Senseis Sword", sugarcane, 0);
		CSItems.addTool(MTMTools.sugarcaneShovel, "Sugarcane Shovel", sugarcane, 1);
		CSItems.addTool(MTMTools.sugarcanePick, "Sugarcane Pickaxe", sugarcane, 2);
		CSItems.addTool(MTMTools.sugarcaneAxe, "Sugarcane Axe", sugarcane, 3);
		CSItems.addTool(MTMTools.sugarcaneHoe, "Sugarcane Hoe", sugarcane, 4);
		
		CSItems.addTool(MTMTools.blazerodSword, "Blazerod Sword", blazerod, 0);
		CSItems.addTool(MTMTools.blazerodShovel, "Blazerod Shovel", blazerod, 1);
		CSItems.addTool(MTMTools.blazerodPick, "Blazerod Pickaxe", blazerod, 2);
		CSItems.addTool(MTMTools.blazerodAxe, "Blazerod Axe", blazerod, 3);
		CSItems.addTool(MTMTools.blazerodHoe, "Blazerod Hoe", blazerod, 4);
		
		CSItems.addTool(MTMTools.dirtSword, "Dirt Sword", dirt, 0);
		CSItems.addTool(MTMTools.dirtShovel, "Dirt Shovel", dirt, 1);
		CSItems.addTool(MTMTools.dirtPick, "Dirt Pickaxe", dirt, 2);
		CSItems.addTool(MTMTools.dirtAxe, "Dirt Axe", dirt, 3);
		CSItems.addTool(MTMTools.dirtHoe, "Dirt Hoe", dirt, 4);
		
		CSItems.addTool(MTMTools.glassSword, "Glass Sword", glass, 0);
		CSItems.addTool(MTMTools.glassShovel, "Glass Shovel", glass, 1);
		CSItems.addTool(MTMTools.glassPick, "Glass Pickaxe", glass, 2);
		CSItems.addTool(MTMTools.glassAxe, "Glass Axe", glass, 3);
		CSItems.addTool(MTMTools.glassHoe, "Glass Hoe", glass, 4);
		
		CSItems.addTool(MTMTools.sandstoneSword, "Sandstone Sword", sandstone, 0);
		CSItems.addTool(MTMTools.sandstoneShovel, "Sandstone Shovel", sandstone, 1);
		CSItems.addTool(MTMTools.sandstonePick, "Sandstone Pickaxe", sandstone, 2);
		CSItems.addTool(MTMTools.sandstoneAxe, "Sandstone Axe", sandstone, 3);
		CSItems.addTool(MTMTools.sandstoneHoe, "Sandstone Hoe", sandstone, 4);
		
		CSItems.addTool(MTMTools.brickSword, "Brick Sword", brick, 0);
		CSItems.addTool(MTMTools.brickShovel, "Brick Shovel", brick, 1);
		CSItems.addTool(MTMTools.brickPick, "Brick Pickaxe", brick, 2);
		CSItems.addTool(MTMTools.brickAxe, "Brick Axe", brick, 3);
		CSItems.addTool(MTMTools.brickHoe, "Brick Hoe", brick, 4);
		
		CSItems.addTool(MTMTools.endstoneSword, "Endstone Sword", endstone, 0);
		CSItems.addTool(MTMTools.endstoneShovel, "Endstone Shovel", endstone, 1);
		CSItems.addTool(MTMTools.endstonePick, "Endstone Pickaxe", endstone, 2);
		CSItems.addTool(MTMTools.endstoneAxe, "Endstone Axe", endstone, 3);
		CSItems.addTool(MTMTools.endstoneHoe, "Endstone Hoe", endstone, 4);
		
		CSItems.addItemWithRecipe(MTMTools.excaliburSword, "Excalibur", 1, new Object[] { "gNg", "hDh", "d|d", Character.valueOf('g'), Item.ghastTear, Character.valueOf('N'), Item.netherStar, Character.valueOf('D'), Block.dragonEgg, 'h', new ItemStack(Item.skull, 1, 1), Character.valueOf('|'), Item.blazeRod, 'd', Item.diamond });
		
		CSItems.addItemWithRecipe(MTMTools.godSword, "God's Sword", 1, new Object[] { "gGg", "gGg", " b ", 'g', Item.glowstone, 'G', Block.blockGold, 'b', Item.stick });
		CSItems.addItemWithRecipe(MTMTools.godShovel, "God's Shovel", 1, new Object[] { "gGg", " b ", " b ", 'g', Item.glowstone, 'G', Block.blockGold, 'b', Item.stick });
		CSItems.addItemWithRecipe(MTMTools.godPick, "God's Pickaxe", 1, new Object[] { "GGG", "gbg", " b ", 'g', Item.glowstone, 'G', Block.blockGold, 'b', Item.stick });
		CSItems.addItemWithRecipe(MTMTools.godAxe, "God's Axe", 1, new Object[] { "GGg", "Gb ", "gb ", 'g', Item.glowstone, 'G', Block.blockGold, 'b', Item.stick });
		CSItems.addItemWithRecipe(MTMTools.godHoe, "God's Hoe", 1, new Object[] { "GGg", "gb ", " b ", 'g', Item.glowstone, 'G', Block.blockGold, 'b', Item.stick });
		
		CSItems.addItemWithRecipe(MTMTools.luziferSword, "Luzifers's Sword", 1, new Object[] { "rRr", "rRr", " b ", 'r', Item.redstone, 'R', Block.netherBrick, 'b', Item.blazeRod });
		CSItems.addItemWithRecipe(MTMTools.luziferShovel, "Luzifers's Shovel", 1, new Object[] { "rRr", " b ", " b ", 'r', Item.redstone, 'R', Block.netherBrick, 'b', Item.blazeRod });
		CSItems.addItemWithRecipe(MTMTools.luziferPick, "Luzifers's Pickaxe", 1, new Object[] { "RRR", "rbr", " b ", 'r', Item.redstone, 'R', Block.netherBrick, 'b', Item.blazeRod });
		CSItems.addItemWithRecipe(MTMTools.luziferAxe, "Luzifers's Axe", 1, new Object[] { "RRg", "Rb ", "rb ", 'r', Item.redstone, 'R', Block.netherBrick, 'b', Item.blazeRod });
		CSItems.addItemWithRecipe(MTMTools.luziferHoe, "Luzifers's Hoe", 1, new Object[] { "RRg", "rb ", " b ", 'r', Item.redstone, 'R', Block.netherBrick, 'b', Item.blazeRod });
		
		CSItems.addItemWithRecipe(MTMTools.lightsaberShaft, "Lightsaber Shaft", 1, new Object[] { "idi", "rGi", "iii", Character.valueOf('i'), Item.ingotIron, 'r', Item.diamond, 'r', Item.redstone, 'G', Block.glowStone });
		CSItems.addItem(MTMTools.lightsaberBlue, "Blue Lightsaber");
		CSItems.addItem(MTMTools.lightsaberGreen, "Green Lightsaber");
		CSItems.addItem(MTMTools.lightsaberPurple, "Purple Lightsaber");
		CSItems.addItem(MTMTools.lightsaberRed, "Red Lightsaber");
		CSItems.addItem(MTMTools.lightsaberWhite, "White Lightsaber");
		
		CSItems.addTool(MTMTools.emeraldSword, "Emerald Sword", emerald, 0);
		CSItems.addTool(MTMTools.emeraldShovel, "Emerald Shovel", emerald, 1);
		CSItems.addTool(MTMTools.emeraldPick, "Emerald Pickaxe", emerald, 2);
		CSItems.addTool(MTMTools.emeraldAxe, "Emerald Axe", emerald, 3);
		CSItems.addTool(MTMTools.emeraldHoe, "Emerald Hoe", emerald, 4);
		
		CSItems.addTool(MTMTools.netherstarSword, "Nether Star Sword", netherstar, 0);
		CSItems.addTool(MTMTools.netherstarShovel, "Nether Star Shovel", netherstar, 1);
		CSItems.addTool(MTMTools.netherstarPick, "Nether Star Pickaxe", netherstar, 2);
		CSItems.addTool(MTMTools.netherstarAxe, "Nether Star Axe", netherstar, 3);
		CSItems.addTool(MTMTools.netherstarHoe, "Nether Star Hoe", netherstar, 4);
		
		CSItems.addTool(MTMTools.potatoSword, "Potato Sword", potato, 0);
		CSItems.addTool(MTMTools.potatoShovel, "Potato Shovel", potato, 1);
		CSItems.addTool(MTMTools.potatoPick, "Potato Pickaxe", potato, 2);
		CSItems.addTool(MTMTools.potatoAxe, "Potato Axe", potato, 3);
		CSItems.addTool(MTMTools.potatoHoe, "Potato Hoe", potato, 4);
		
		CSItems.addTool(MTMTools.carrotSword, "Carrot Sword", carrot, 0);
		CSItems.addTool(MTMTools.carrotShovel, "Carrot Shovel", carrot, 1);
		CSItems.addTool(MTMTools.carrotPick, "Carrot Pickaxe", carrot, 2);
		CSItems.addTool(MTMTools.carrotAxe, "Carrot Axe", carrot, 3);
		CSItems.addTool(MTMTools.carrotHoe, "Carrot Hoe", carrot, 4);
		
		CSItems.addTool(MTMTools.fishSword, "Fish Sword", fish, 0);
		CSItems.addTool(MTMTools.fishShovel, "Fish Shovel", fish, 1);
		CSItems.addTool(MTMTools.fishPick, "Fish Pickaxe", fish, 2);
		CSItems.addTool(MTMTools.fishAxe, "Fish Axe", fish, 3);
		CSItems.addTool(MTMTools.fishHoe, "Fish Hoe", fish, 4);
		
		CSItems.addTool(MTMTools.baconSword, "Bacon Sword", bacon, 0);
		CSItems.addTool(MTMTools.baconShovel, "Bacon Shovel", bacon, 1);
		CSItems.addTool(MTMTools.baconPick, "Bacon Pickaxe", bacon, 2);
		CSItems.addTool(MTMTools.baconAxe, "Bacon Axe", bacon, 3);
		CSItems.addTool(MTMTools.baconHoe, "Bacon Hoe", bacon, 4);
		
		CSItems.addTool(MTMTools.leatherPick, "Leather Pickaxe", leather, 0);
		CSItems.addTool(MTMTools.leatherShovel, "Leather Shovel", leather, 1);
		CSItems.addTool(MTMTools.leatherAxe, "Leather Axe", leather, 2);
		CSItems.addTool(MTMTools.leatherHoe, "Leather Hoe", leather, 3);
		CSItems.addTool(MTMTools.leatherSword, "Leather Sword", leather, 4);
		
		CSItems.addTool(MTMTools.glowstonePick, "Glowstone Pickaxe", glowstone, 0);
		CSItems.addTool(MTMTools.glowstoneShovel, "Glowstone Shovel", glowstone, 1);
		CSItems.addTool(MTMTools.glowstoneAxe, "Glowstone Axe", glowstone, 2);
		CSItems.addTool(MTMTools.glowstoneHoe, "Glowstone Hoe", glowstone, 3);
		CSItems.addTool(MTMTools.glowstoneSword, "Glowstone Sword", glowstone, 4);
		
		CSItems.addTool(MTMTools.slimePick, "Slime Pickaxe", slime, 0);
		CSItems.addTool(MTMTools.slimeShovel, "Slime Shovel", slime, 1);
		CSItems.addTool(MTMTools.slimeAxe, "Slime Axe", slime, 2);
		CSItems.addTool(MTMTools.slimeHoe, "Slime Hoe", slime, 3);
		CSItems.addTool(MTMTools.slimeSword, "Slime Sword", slime, 4);
		
		CSItems.addItemWithShapelessRecipe(spaceMultitool, "Space Multitool", 1, new Object[] { MTMTools.spacePick, MTMTools.spaceShovel, MTMTools.spaceAxe, MTMTools.spaceHoe, MTMTools.spaceSwordAdvanced });
		CSItems.addItemWithRecipe(spaceBow, "Space Bow", 1, new Object[] { "sS ", "s S", "sS ", 'S', spaceIngot, 's', Item.silk });
		CSItems.addItemWithRecipe(spaceArrow, "Space Arrow", 4, new Object[] { "s", "|", "f", Character.valueOf('s'), spaceIngot, Character.valueOf('|'), Item.stick, Character.valueOf('f'), Item.feather });
		CSItems.addItemWithRecipe(spaceIngot, "Space Ingot", 9, new Object[] { "s", 's', new ItemStack(spaceBlock, 1, 1) });
		
		CSItems.addItemWithRecipe(blazerodAndSteel, "Blazerod and Steel", 1, new Object[] { "i ", " b", Character.valueOf('i'), Item.ingotIron, Character.valueOf('b'), Item.blazeRod });
		
		CSItems.addItemWithRecipe(goldShears, "Gold Shears", 1, new Object[] { "X ", " X", Character.valueOf('X'), Item.ingotGold });
		CSItems.addItemWithRecipe(diamondShears, "Diamond Shears", 1, new Object[] { "X ", " X", Character.valueOf('X'), Item.diamond });
	}
	
	public void addBlocks()
	{
		CSBlocks.addBlock(spaceBlock, ItemCustomBlock.class, "Space Block");
		CSBlocks.addBlock(spaceOre, ItemBlock.class, "Space Ore");
		CSBlocks.addBlock(glowingBlock, ItemBlock.class, "Glowing Block");
		
		spaceBlock.addNames();
		
		MinecraftForge.setBlockHarvestLevel(spaceOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(spaceBlock, "pickaxe", 2);
	}
}
