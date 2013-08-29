package clashsoft.mods.moretools;

import clashsoft.clashsoftapi.CustomEnchantment;
import clashsoft.clashsoftapi.util.CSBlocks;
import clashsoft.clashsoftapi.util.CSCrafting;
import clashsoft.clashsoftapi.util.CSItems;
import clashsoft.mods.moretools.block.BlockGlowing;
import clashsoft.mods.moretools.block.BlockSpaceblock;
import clashsoft.mods.moretools.item.ItemAxeMoreTools;
import clashsoft.mods.moretools.item.ItemBowMoreTools;
import clashsoft.mods.moretools.item.ItemDyeableAxeMoreTools;
import clashsoft.mods.moretools.item.ItemDyeableHoeMoreTools;
import clashsoft.mods.moretools.item.ItemDyeablePickaxeMoreTools;
import clashsoft.mods.moretools.item.ItemDyeableSpadeMoreTools;
import clashsoft.mods.moretools.item.ItemDyeableSwordMoreTools;
import clashsoft.mods.moretools.item.ItemFlintAndSteelMoreTools;
import clashsoft.mods.moretools.item.ItemGoldBucket;
import clashsoft.mods.moretools.item.ItemHoeMoreTools;
import clashsoft.mods.moretools.item.ItemLightsaberMoreTools;
import clashsoft.mods.moretools.item.ItemLightsaberShaftMoreTools;
import clashsoft.mods.moretools.item.ItemMoreTools;
import clashsoft.mods.moretools.item.ItemMultiBlock;
import clashsoft.mods.moretools.item.ItemMultitoolMoreTools;
import clashsoft.mods.moretools.item.ItemPickaxeMoreTools;
import clashsoft.mods.moretools.item.ItemShearsMoreTools;
import clashsoft.mods.moretools.item.ItemSpadeMoreTools;
import clashsoft.mods.moretools.item.ItemSwordMoreTools;
import clashsoft.mods.moretools.lib.RecipesToolDyes;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

public class MoreToolsMod_Tools
{
	
	public static MoreToolsMod_Tools	instance			= new MoreToolsMod_Tools();
	
	// Tool Materials.
	
	public static EnumToolMaterial		OBSIDIAN			= CSItems.addToolMaterial("OBSIDIAN", 3, 4096, 25F, 10, 10, 0x1e182b, new ItemStack(Block.obsidian), null);
	public static EnumToolMaterial		REDSTONE			= EnumHelper.addToolMaterial("REDSTONE", 2, 64, 6F, 2.5F, 15);
	public static EnumToolMaterial		COAL				= EnumHelper.addToolMaterial("COAL", 1, 128, 3F, 2.1F, 15);
	public static EnumToolMaterial		LAPIS				= EnumHelper.addToolMaterial("LAPIS", 2, 256, 3F, 2F, 15);
	public static EnumToolMaterial		END					= EnumHelper.addToolMaterial("END", 2, 512, 5F, 2.8F, 15);
	public static EnumToolMaterial		SPACE1				= EnumHelper.addToolMaterial("SPACESTRONG", 3, 8196, 50F, 13F, 20);
	public static EnumToolMaterial		SPACE2				= EnumHelper.addToolMaterial("SPACEWEAK", 3, 6144, 40F, 10F, 18);
	public static EnumToolMaterial		BONE				= EnumHelper.addToolMaterial("BONE", 1, 32, 1.5F, 1.2F, 15);
	public static EnumToolMaterial		REED				= EnumHelper.addToolMaterial("REED", 0, 16, 0.5F, 0.2F, 15);
	public static EnumToolMaterial		BLAZEROD			= EnumHelper.addToolMaterial("BLAZEROD", 2, 512, 6F, 1.9F, 15);
	public static EnumToolMaterial		DIRT				= EnumHelper.addToolMaterial("DIRT", 0, 16, 0.8F, -0.1F, 15);
	public static EnumToolMaterial		GLASS				= EnumHelper.addToolMaterial("GLASS", 0, 16, 0.5F, 1.3F, 15);
	public static EnumToolMaterial		SANDSTONE			= EnumHelper.addToolMaterial("SANDSTONE", 1, 128, 3F, 1.8F, 15);
	public static EnumToolMaterial		BRICK				= EnumHelper.addToolMaterial("BRICK", 1, 128, 2.5F, 1.75F, 15);
	public static EnumToolMaterial		ENDSTONE			= EnumHelper.addToolMaterial("ENDSTONE", 2, 256, 3.5F, 2.9F, 15);
	public static EnumToolMaterial		EXCALIBUR			= EnumHelper.addToolMaterial("EXCALIBUR", 3, 16392, 10F, 20F, 1);
	public static EnumToolMaterial		GOD					= EnumHelper.addToolMaterial("GOD", 3, 2048, 5F, 15F, 10);
	public static EnumToolMaterial		LUZIFER				= EnumHelper.addToolMaterial("LUZIFER", 3, 2048, 5F, 15F, 10);
	public static EnumToolMaterial		LASER				= EnumHelper.addToolMaterial("LASER", 3, -1, 1F, 25F, 1);
	public static EnumToolMaterial		EMERALD2			= EnumHelper.addToolMaterial("EMERALD2", 3, 1536, 8F, 2.95F, 17);
	public static EnumToolMaterial		NETHERSTAR			= EnumHelper.addToolMaterial("NETHERSTAR", 3, 2048, 12F, 4F, 20);
	public static EnumToolMaterial		POTATO				= EnumHelper.addToolMaterial("POTATO", 1, 64, 3F, 0.6F, 15);
	public static EnumToolMaterial		CARROT				= EnumHelper.addToolMaterial("CARROT", 1, 64, 3F, 0.6F, 15);
	public static EnumToolMaterial		FISH				= EnumHelper.addToolMaterial("FISH", 1, 64, 2.5F, 0.7F, 15);
	public static EnumToolMaterial		BACON				= EnumHelper.addToolMaterial("BACON", 1, 64, 2.5F, 0.7F, 15);
	public static EnumToolMaterial		LEATHER				= EnumToolMaterial.WOOD;
	public static EnumToolMaterial		GLOWSTONE			= EnumHelper.addToolMaterial("GLOWSTONE", 2, 64, 1F, 1F, 16);
	public static EnumToolMaterial		SLIME				= EnumHelper.addToolMaterial("SLIME", 1, 80, 1.2F, 0.85F, 15);
	
	public static Enchantment			quickDraw			= new CustomEnchantment(7, 1, 3, EnumEnchantmentType.bow, "quickdraw");
	
	// Rarities.
	
	public static int					EPIC				= 0;
	public static int					RARE				= 1;
	public static int					UNCOMMON			= 2;
	public static int					COMMON				= 3;
	
	// Integers.
	
	int									l1					= 0;																																				// Swords.
	int									l2					= 16;																																				// Shovels.
	int									l3					= 32;																																				// Picks.
	int									l4					= 48;																																				// Axes.
	int									l5					= 64;																																				// Hoes.
	int									l6					= 80;																																				// Swords.
	int									l7					= 96;																																				// ...
	int									l8					= 112;																																				// ...
	int									l9					= 128;																																				// ...
	int									l10					= 144;																																				//
	int									l11					= 160;																																				//
	int									l12					= 176;																																				//
	int									l13					= 192;																																				//
	int									l14					= 208;																																				//
	int									l15					= 224;																																				//
	int									l16					= 240;																																				// Misc
																																																				
	int									c1					= 0;																																				// Obsidian
	// Epic
	int									c2					= 1;																																				// Redstone
	// Lightsabers
	int									c3					= 2;																																				// Coal
	// Emerald
	int									c4					= 3;																																				// Lapis
	// Netherstar
	int									c5					= 4;																																				// End
	// Potatoe
	int									c6					= 5;																																				// Bone
	// Carrot
	int									c7					= 6;																																				// Sugarcanes
	// Fish
	int									c8					= 7;																																				// Blazerods
	// Bacon
	int									c9					= 8;																																				// Dirt
	// Glowstone
	int									c10					= 9;																																				// Glass
	int									c11					= 10;																																				// Sandstone
	int									c12					= 11;																																				// Bricks
	int									c13					= 12;																																				// Endstone
	int									c14					= 13;																																				// Space
	int									c15					= 14;																																				// Hallowed
	int									c16					= 15;																																				// Goddawn
																																																				
	// Items.
	
	public static final Item			spacePick			= (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 26, SPACE1)).setUnlocalizedName("spacePickaxe");
	public static final Item			spaceShovel			= (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 27, SPACE1)).setUnlocalizedName("spaceShovel");
	public static final Item			spaceAxe			= (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 28, SPACE1)).setUnlocalizedName("spaceAxe");
	public static final Item			spaceHoe			= (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 29, SPACE1)).setUnlocalizedName("spaceHoe");
	public static final Item			spaceSwordStrong	= (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 30, SPACE1, EPIC)).setUnlocalizedName("spaceSwordStrong");
	
	public static final Item			spaceMultitool		= (new ItemMultitoolMoreTools(MoreToolsMod.MISCITEMS_ID, SPACE1)).setUnlocalizedName("spacemulti");
	public static final Item			spaceArrow			= (new ItemMoreTools(MoreToolsMod.MISCITEMS_ID + 2, CreativeTabs.tabCombat)).setUnlocalizedName("spacearrow");
	public static final Item			spaceBow			= (new ItemBowMoreTools(MoreToolsMod.MISCITEMS_ID + 1, spaceArrow, false)).setUnlocalizedName("spacebow");
	public static final Item			spaceIngot			= (new ItemMoreTools(MoreToolsMod.MISCITEMS_ID + 3, CreativeTabs.tabMaterials)).setUnlocalizedName("spaceingot");
	public static final Item			spaceSwordWeak		= (new ItemSwordMoreTools(MoreToolsMod.MISCITEMS_ID + 4, SPACE2, RARE)).setUnlocalizedName("spaceSwordWeak");
	
	public static final Item			lightsaberShaft		= (new ItemLightsaberShaftMoreTools(MoreToolsMod.MISCITEMS_ID + 05)).setUnlocalizedName("lsshaft");
	public static final Item			lightsaberBlue		= (new ItemLightsaberMoreTools(MoreToolsMod.TOOLS_ID + 86, LASER)).setUnlocalizedName("lightSaber1");
	public static final Item			lightsaberGreen		= (new ItemLightsaberMoreTools(MoreToolsMod.TOOLS_ID + 87, LASER)).setUnlocalizedName("lightSaber2");
	public static final Item			lightsaberPurple	= (new ItemLightsaberMoreTools(MoreToolsMod.TOOLS_ID + 88, LASER)).setUnlocalizedName("lightSaber3");
	public static final Item			lightsaberRed		= (new ItemLightsaberMoreTools(MoreToolsMod.TOOLS_ID + 89, LASER)).setUnlocalizedName("lightSaber4");
	public static final Item			lightsaberWhite		= (new ItemLightsaberMoreTools(MoreToolsMod.TOOLS_ID + 90, LASER)).setUnlocalizedName("lightSaber5");
	
	public static final Item			glowstonePick		= (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 46, GLOWSTONE)).setUnlocalizedName("glowstonePickaxe");
	public static final Item			glowstoneShovel		= (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 47, GLOWSTONE)).setUnlocalizedName("glowstoneShovel");
	public static final Item			glowstoneAxe		= (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 48, GLOWSTONE)).setUnlocalizedName("glowstoneAxe");
	public static final Item			glowstoneHoe		= (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 49, GLOWSTONE)).setUnlocalizedName("glowstoneHoe");
	public static final Item			glowstoneSword		= (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 100 + 50, GLOWSTONE, COMMON)).setUnlocalizedName("glowstoneSword");
	
	public static final Item			slimePick			= (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 51, SLIME)).setUnlocalizedName("slimePickaxe");
	public static final Item			slimeShovel			= (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 52, SLIME)).setUnlocalizedName("slimeShovel");
	public static final Item			slimeAxe			= (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 53, SLIME)).setUnlocalizedName("slimeAxe");
	public static final Item			slimeHoe			= (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 54, SLIME)).setUnlocalizedName("slimeHoe");
	public static final Item			slimeSword			= (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 100 + 55, SLIME, COMMON)).setUnlocalizedName("slimeSword");
	
	public static final Item			goldBucket			= (new ItemGoldBucket(MoreToolsMod.TOOLS_ID + 200 + 8, 0)).setUnlocalizedName("bucketgold");
	public static final Item			goldBucketWater		= (new ItemGoldBucket(MoreToolsMod.TOOLS_ID + 200 + 9, Block.waterStill.blockID)).setUnlocalizedName("bucketgoldWater");
	public static final Item			goldBucketLava		= (new ItemGoldBucket(MoreToolsMod.TOOLS_ID + 200 + 10, Block.lavaStill.blockID)).setUnlocalizedName("bucketgoldLava");
	public static final Item			goldBucketMilk		= (new ItemBucketMilk(MoreToolsMod.TOOLS_ID + 200 + 11)).setUnlocalizedName("bucketgoldMilk").setCreativeTab(null);
	
	public static final Block			spaceBlock			= (new BlockSpaceblock(250)).setHardness(3F).setLightValue(15 / 16).setUnlocalizedName("spaceblock");
	public static final Block			spaceOre			= new Block(251, Material.rock).setHardness(2.5F).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("spaceore").func_111022_d("spaceore");
	public static final Block			glowing				= (new BlockGlowing(252)).setHardness(0F).setLightValue(1F).setUnlocalizedName("glowing");
	
	public void load(FMLInitializationEvent event)
	{
		load2();
		
		// Obsidian tools.
		
		Item obsidianPick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 01, OBSIDIAN)).setUnlocalizedName("obsidianPickaxe");
		Item obsidianShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 02, OBSIDIAN)).setUnlocalizedName("obsidianShovel");
		Item obsidianAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 03, OBSIDIAN)).setUnlocalizedName("obsidianAxe");
		Item obsidianHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 04, OBSIDIAN)).setUnlocalizedName("obsidianHoe");
		Item obsidianSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 05, OBSIDIAN, UNCOMMON)).setUnlocalizedName("obsidianSword");
		ModLoader.addName(obsidianPick, "Obsidian Pickaxe");
		ModLoader.addName(obsidianShovel, "Obsidian Shovel");
		ModLoader.addName(obsidianAxe, "Obsidian Axe");
		ModLoader.addName(obsidianHoe, "Obsidian Hoe");
		ModLoader.addName(obsidianSword, "Obsidian Sword");
		ModLoader.addRecipe(new ItemStack(obsidianPick, 1), new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Block.obsidian, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(obsidianShovel, 1), new Object[] { "X", "|", "|", Character.valueOf('X'), Block.obsidian, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(obsidianAxe, 1), new Object[] { "XX", "X|", " |", Character.valueOf('X'), Block.obsidian, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(obsidianHoe, 1), new Object[] { "XX", " |", " |", Character.valueOf('X'), Block.obsidian, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(obsidianSword, 1), new Object[] { "X", "X", "|", Character.valueOf('X'), Block.obsidian, Character.valueOf('|'), Item.stick });
		
		// Redstone tools.
		
		Item redstonePick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 06, REDSTONE)).setUnlocalizedName("redstonePickaxe");
		Item redstoneShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 07, REDSTONE)).setUnlocalizedName("redstoneShovel");
		Item redstoneAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 8, REDSTONE)).setUnlocalizedName("redstoneAxe");
		Item redstoneHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 9, REDSTONE)).setUnlocalizedName("redstoneHoe");
		Item redstoneSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 10, REDSTONE, UNCOMMON)).setUnlocalizedName("redstoneSword");
		CSItems.addItemWithRecipe(redstonePick, "Redstone Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Block.blockRedstone, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(redstoneShovel, "Redstone Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), Block.blockRedstone, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(redstoneAxe, "Redstone Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), Block.blockRedstone, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(redstoneHoe, "Redstone Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), Block.blockRedstone, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(redstoneSword, "Redstone Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), Block.blockRedstone, Character.valueOf('|'), Item.stick });
		
		// Coal tools.
		
		Item coalPick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 11, COAL)).setUnlocalizedName("coalPickaxe");
		Item coalShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 12, COAL)).setUnlocalizedName("coalShovel");
		Item coalAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 13, COAL)).setUnlocalizedName("coalAxe");
		Item coalHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 14, COAL)).setUnlocalizedName("coalHoe");
		Item coalSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 15, COAL, COMMON)).setUnlocalizedName("coalSword");
		ModLoader.addName(coalPick, "Coal Pickaxe");
		ModLoader.addName(coalShovel, "Coal Shovel");
		ModLoader.addName(coalAxe, "Coal Axe");
		ModLoader.addName(coalHoe, "Coal Hoe");
		ModLoader.addName(coalSword, "Coal Sword");
		ModLoader.addRecipe(new ItemStack(coalPick, 1), new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Item.coal, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(coalShovel, 1), new Object[] { "X", "|", "|", Character.valueOf('X'), Item.coal, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(coalAxe, 1), new Object[] { "XX", "X|", " |", Character.valueOf('X'), Item.coal, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(coalHoe, 1), new Object[] { "XX", " |", " |", Character.valueOf('X'), Item.coal, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(coalSword, 1), new Object[] { "X", "X", "|", Character.valueOf('X'), Item.coal, Character.valueOf('|'), Item.stick });
		
		// Lapislazuli tools.
		
		Item lapisPick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 16, LAPIS)).setUnlocalizedName("lapisPickaxe");
		Item lapisShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 17, LAPIS)).setUnlocalizedName("lapisShovel");
		Item lapisAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 18, LAPIS)).setUnlocalizedName("lapisAxe");
		Item lapisHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 19, LAPIS)).setUnlocalizedName("lapisHoe");
		Item lapisSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 20, LAPIS, COMMON)).setUnlocalizedName("lapisSword");
		ModLoader.addName(lapisPick, "Lapislazuli Pickaxe");
		ModLoader.addName(lapisShovel, "Lapislazuli Shovel");
		ModLoader.addName(lapisAxe, "Lapislazuli Axe");
		ModLoader.addName(lapisHoe, "Lapislazuli Hoe");
		ModLoader.addName(lapisSword, "Lapislazuli Sword");
		ModLoader.addRecipe(new ItemStack(lapisPick, 1), new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Block.blockLapis, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(lapisShovel, 1), new Object[] { "X", "|", "|", Character.valueOf('X'), Block.blockLapis, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(lapisAxe, 1), new Object[] { "XX", "X|", " |", Character.valueOf('X'), Block.blockLapis, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(lapisHoe, 1), new Object[] { "XX", " |", " |", Character.valueOf('X'), Block.blockLapis, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(lapisSword, 1), new Object[] { "X", "X", "|", Character.valueOf('X'), Block.blockLapis, Character.valueOf('|'), Item.stick });
		
		// Endertools.
		
		Item enderPick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 21, END)).setUnlocalizedName("enderPickaxe");
		Item enderShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 22, END)).setUnlocalizedName("enderShovel");
		Item enderAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 23, END)).setUnlocalizedName("enderAxe");
		Item enderHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 24, END)).setUnlocalizedName("enderHoe");
		Item enderSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 25, END, RARE)).setUnlocalizedName("enderSword");
		ModLoader.addName(enderPick, "Ender Pickaxe");
		ModLoader.addName(enderShovel, "Ender Shovel");
		ModLoader.addName(enderAxe, "Ender Axe");
		ModLoader.addName(enderHoe, "Ender Hoe");
		ModLoader.addName(enderSword, "Ender Sword");
		ModLoader.addRecipe(new ItemStack(enderPick, 1), new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Item.enderPearl, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(enderShovel, 1), new Object[] { "X", "|", "|", Character.valueOf('X'), Item.enderPearl, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(enderAxe, 1), new Object[] { "XX", "X|", " |", Character.valueOf('X'), Item.enderPearl, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(enderHoe, 1), new Object[] { "XX", " |", " |", Character.valueOf('X'), Item.enderPearl, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(enderSword, 1), new Object[] { "X", "X", "|", Character.valueOf('X'), Item.enderPearl, Character.valueOf('|'), Item.stick });
		
		// Space Tools.
		
		ModLoader.addName(spacePick, "Spacepickaxe");
		ModLoader.addName(spaceShovel, "Spaceshovel");
		ModLoader.addName(spaceAxe, "Spaceaxe");
		ModLoader.addName(spaceHoe, "Spacehoe");
		ModLoader.addName(spaceSwordStrong, "Epic Spacesword");
		ModLoader.addName(spaceSwordWeak, "Normal Spacesword");
		ModLoader.addRecipe(new ItemStack(spacePick, 1), new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), spaceIngot, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(spaceShovel, 1), new Object[] { "X", "|", "|", Character.valueOf('X'), spaceIngot, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(spaceAxe, 1), new Object[] { "XX", "X|", " |", Character.valueOf('X'), spaceIngot, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(spaceHoe, 1), new Object[] { "XX", " |", " |", Character.valueOf('X'), spaceIngot, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(spaceSwordStrong, 1), new Object[] { "X", "X", "|", Character.valueOf('X'), spaceBlock, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(spaceSwordWeak, 1), new Object[] { "X", "X", "|", Character.valueOf('X'), spaceIngot, Character.valueOf('|'), Item.stick });
		
		// Bone tools.
		
		Item bonePick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 31, BONE)).setUnlocalizedName("bonePickaxe");
		Item boneShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 32, BONE)).setUnlocalizedName("boneShovel");
		Item boneAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 33, BONE)).setUnlocalizedName("boneAxe");
		Item boneHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 34, BONE)).setUnlocalizedName("boneHoe");
		Item boneSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 35, BONE, COMMON)).setUnlocalizedName("boneSword");
		ModLoader.addName(bonePick, "Bone Pickaxe");
		ModLoader.addName(boneShovel, "Bone Shovel");
		ModLoader.addName(boneAxe, "Bone Axe");
		ModLoader.addName(boneHoe, "Bone Hoe");
		ModLoader.addName(boneSword, "Bone Sword");
		ModLoader.addRecipe(new ItemStack(bonePick, 1), new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Item.bone, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(boneShovel, 1), new Object[] { "X", "|", "|", Character.valueOf('X'), Item.bone, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(boneAxe, 1), new Object[] { "XX", "X|", " |", Character.valueOf('X'), Item.bone, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(boneHoe, 1), new Object[] { "XX", " |", " |", Character.valueOf('X'), Item.bone, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(boneSword, 1), new Object[] { "X", "X", "|", Character.valueOf('X'), Item.bone, Character.valueOf('|'), Item.stick });
		
		// Sugarcane Tools.
		
		Item sugarcanePick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 36, REED)).setUnlocalizedName("sugarcanePickaxe");
		Item sugarcaneShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 37, REED)).setUnlocalizedName("sugarcaneShovel");
		Item sugarcaneAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 38, REED)).setUnlocalizedName("sugarcaneAxe");
		Item sugarcaneHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 39, REED)).setUnlocalizedName("sugarcaneHoe");
		Item sugarcaneSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 40, REED, COMMON)).setUnlocalizedName("sugarcaneSword");
		ModLoader.addName(sugarcanePick, "Sugarcane Pickaxe");
		ModLoader.addName(sugarcaneShovel, "Sugarcane Shovel");
		ModLoader.addName(sugarcaneAxe, "Sugarcane Axe");
		ModLoader.addName(sugarcaneHoe, "Sugarcane Hoe");
		ModLoader.addName(sugarcaneSword, "Senseis Sword");
		ModLoader.addRecipe(new ItemStack(sugarcanePick, 1), new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Item.reed, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(sugarcaneShovel, 1), new Object[] { "X", "|", "|", Character.valueOf('X'), Item.reed, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(sugarcaneAxe, 1), new Object[] { "XX", "X|", " |", Character.valueOf('X'), Item.reed, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(sugarcaneHoe, 1), new Object[] { "XX", " |", " |", Character.valueOf('X'), Item.reed, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(sugarcaneSword, 1), new Object[] { "X", "X", "|", Character.valueOf('X'), Item.reed, Character.valueOf('|'), Item.stick });
		
		// Blazerod Tools.
		
		Item blazerodPick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 41, BLAZEROD)).setUnlocalizedName("blazePickaxe");
		Item blazerodShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 42, BLAZEROD)).setUnlocalizedName("blazeShovel");
		Item blazerodAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 43, BLAZEROD)).setUnlocalizedName("blazeAxe");
		Item blazerodHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 44, BLAZEROD)).setUnlocalizedName("blazeHoe");
		Item blazerodSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 45, BLAZEROD, UNCOMMON)).setUnlocalizedName("blazeSword");
		ModLoader.addName(blazerodPick, "Blaze Pickaxe");
		ModLoader.addName(blazerodShovel, "Blaze Shovel");
		ModLoader.addName(blazerodAxe, "Blaze Axe");
		ModLoader.addName(blazerodHoe, "Blaze Hoe");
		ModLoader.addName(blazerodSword, "Blaze Sword");
		ModLoader.addRecipe(new ItemStack(blazerodPick, 1), new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Item.blazeRod, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(blazerodShovel, 1), new Object[] { "X", "|", "|", Character.valueOf('X'), Item.blazeRod, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(blazerodAxe, 1), new Object[] { "XX", "X|", " |", Character.valueOf('X'), Item.blazeRod, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(blazerodHoe, 1), new Object[] { "XX", " |", " |", Character.valueOf('X'), Item.blazeRod, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(blazerodSword, 1), new Object[] { "X", "X", "|", Character.valueOf('X'), Item.blazeRod, Character.valueOf('|'), Item.stick });
		
		// Dirt Tools.
		
		Item dirtPick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 46, DIRT)).setUnlocalizedName("dirtPickaxe");
		Item dirtShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 47, DIRT)).setUnlocalizedName("dirtShovel");
		Item dirtAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 48, DIRT)).setUnlocalizedName("dirtAxe");
		Item dirtHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 49, DIRT)).setUnlocalizedName("dirtHoe");
		Item dirtSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 50, DIRT, COMMON)).setUnlocalizedName("dirtSword");
		ModLoader.addName(dirtPick, "Dirt Pickaxe");
		ModLoader.addName(dirtShovel, "Dirt Shovel");
		ModLoader.addName(dirtAxe, "Dirt Axe");
		ModLoader.addName(dirtHoe, "Dirt Hoe");
		ModLoader.addName(dirtSword, "Dirt Sword");
		ModLoader.addRecipe(new ItemStack(dirtPick, 1), new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Block.dirt, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(dirtShovel, 1), new Object[] { "X", "|", "|", Character.valueOf('X'), Block.dirt, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(dirtAxe, 1), new Object[] { "XX", "X|", " |", Character.valueOf('X'), Block.dirt, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(dirtHoe, 1), new Object[] { "XX", " |", " |", Character.valueOf('X'), Block.dirt, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(dirtSword, 1), new Object[] { "X", "X", "|", Character.valueOf('X'), Block.dirt, Character.valueOf('|'), Item.stick });
		
		// Glass Tools.
		
		Item glassPick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 51, GLASS)).setUnlocalizedName("glassPickaxe");
		Item glassShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 52, GLASS)).setUnlocalizedName("glassShovel");
		Item glassAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 53, GLASS)).setUnlocalizedName("glassAxe");
		Item glassHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 54, GLASS)).setUnlocalizedName("glassHoe");
		Item glassSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 55, GLASS, COMMON)).setUnlocalizedName("glassSword");
		ModLoader.addName(glassPick, "Glass Pickaxe");
		ModLoader.addName(glassShovel, "Glass Shovel");
		ModLoader.addName(glassAxe, "Glass Axe");
		ModLoader.addName(glassHoe, "Glass Hoe");
		ModLoader.addName(glassSword, "Glass Sword");
		ModLoader.addRecipe(new ItemStack(glassPick, 1), new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Block.glass, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(glassShovel, 1), new Object[] { "X", "|", "|", Character.valueOf('X'), Block.glass, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(glassAxe, 1), new Object[] { "XX", "X|", " |", Character.valueOf('X'), Block.glass, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(glassHoe, 1), new Object[] { "XX", " |", " |", Character.valueOf('X'), Block.glass, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(glassSword, 1), new Object[] { "X", "X", "|", Character.valueOf('X'), Block.glass, Character.valueOf('|'), Item.stick });
		
		// Sandstone Tools.
		
		Item sandstonePick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 56, SANDSTONE)).setUnlocalizedName("sandstonePickaxe");
		Item sandstoneShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 57, SANDSTONE)).setUnlocalizedName("sandstoneShovel");
		Item sandstoneAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 58, SANDSTONE)).setUnlocalizedName("sandstoneAxe");
		Item sandstoneHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 59, SANDSTONE)).setUnlocalizedName("sandstoneHoe");
		Item sandstoneSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 60, SANDSTONE, COMMON)).setUnlocalizedName("sandstoneSword");
		ModLoader.addName(sandstonePick, "Sandstone Pickaxe");
		ModLoader.addName(sandstoneShovel, "Sandstone Shovel");
		ModLoader.addName(sandstoneAxe, "Sandstone Axe");
		ModLoader.addName(sandstoneHoe, "Sandstone Hoe");
		ModLoader.addName(sandstoneSword, "Sandstone Sword");
		ModLoader.addRecipe(new ItemStack(sandstonePick, 1), new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Block.sandStone, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(sandstoneShovel, 1), new Object[] { "X", "|", "|", Character.valueOf('X'), Block.sandStone, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(sandstoneAxe, 1), new Object[] { "XX", "X|", " |", Character.valueOf('X'), Block.sandStone, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(sandstoneHoe, 1), new Object[] { "XX", " |", " |", Character.valueOf('X'), Block.sandStone, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(sandstoneSword, 1), new Object[] { "X", "X", "|", Character.valueOf('X'), Block.sandStone, Character.valueOf('|'), Item.stick });
		
		// Brick Tools.
		
		Item brickPick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 61, BRICK)).setUnlocalizedName("brickPickaxe");
		Item brickShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 62, BRICK)).setUnlocalizedName("brickShovel");
		Item brickAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 63, BRICK)).setUnlocalizedName("brickAxe");
		Item brickHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 64, BRICK)).setUnlocalizedName("brickHoe");
		Item brickSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 65, BRICK, COMMON)).setUnlocalizedName("brickSword");
		ModLoader.addName(brickPick, "Brick Pickaxe");
		ModLoader.addName(brickShovel, "Brick Shovel");
		ModLoader.addName(brickAxe, "Brick Axe");
		ModLoader.addName(brickHoe, "Brick Hoe");
		ModLoader.addName(brickSword, "Brick Sword");
		ModLoader.addRecipe(new ItemStack(brickPick, 1), new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Item.brick, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(brickShovel, 1), new Object[] { "X", "|", "|", Character.valueOf('X'), Item.brick, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(brickAxe, 1), new Object[] { "XX", "X|", " |", Character.valueOf('X'), Item.brick, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(brickHoe, 1), new Object[] { "XX", " |", " |", Character.valueOf('X'), Item.brick, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(brickSword, 1), new Object[] { "X", "X", "|", Character.valueOf('X'), Item.brick, Character.valueOf('|'), Item.stick });
		
		// Endstone Tools.
		
		Item endstonePick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 66, ENDSTONE)).setUnlocalizedName("endstonePickaxe");
		Item endstoneShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 67, ENDSTONE)).setUnlocalizedName("endstoneShovel");
		Item endstoneAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 68, ENDSTONE)).setUnlocalizedName("endstoneAxe");
		Item endstoneHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 69, ENDSTONE)).setUnlocalizedName("endstoneHoe");
		Item endstoneSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 70, ENDSTONE, UNCOMMON)).setUnlocalizedName("endstoneSword");
		ModLoader.addName(endstonePick, "Endstone Pickaxe");
		ModLoader.addName(endstoneShovel, "Endstone Shovel");
		ModLoader.addName(endstoneAxe, "Endstone Axe");
		ModLoader.addName(endstoneHoe, "Endstone Hoe");
		ModLoader.addName(endstoneSword, "Endstone Sword");
		ModLoader.addRecipe(new ItemStack(endstonePick, 1), new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Block.whiteStone, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(endstoneShovel, 1), new Object[] { "X", "|", "|", Character.valueOf('X'), Block.whiteStone, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(endstoneAxe, 1), new Object[] { "XX", "X|", " |", Character.valueOf('X'), Block.whiteStone, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(endstoneHoe, 1), new Object[] { "XX", " |", " |", Character.valueOf('X'), Block.whiteStone, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(endstoneSword, 1), new Object[] { "X", "X", "|", Character.valueOf('X'), Block.whiteStone, Character.valueOf('|'), Item.stick });
		
		// Excalibur.
		
		Item excaliburSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 75, EXCALIBUR, EPIC)).setUnlocalizedName("epicSword");
		ModLoader.addName(excaliburSword, "Excalibur");
		ModLoader.addRecipe(new ItemStack(excaliburSword, 1), new Object[] { "gNg", "hDh", "d|d", Character.valueOf('g'), Item.ghastTear, Character.valueOf('N'), Item.netherStar, Character.valueOf('D'), Block.dragonEgg, 'h', new ItemStack(Item.skull, 1, 1), Character.valueOf('|'), Item.blazeRod, 'd', Item.diamond });
		
		// Hallowed Tools.
		
		Item godPick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 76, GOD)).setUnlocalizedName("godPickaxe");
		Item godShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 77, GOD)).setUnlocalizedName("godShovel");
		Item godAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 78, GOD)).setUnlocalizedName("godAxe");
		Item godHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 79, GOD)).setUnlocalizedName("godHoe");
		Item godSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 80, GOD, EPIC)).setUnlocalizedName("godSword");
		ModLoader.addName(godPick, "God's Pickaxe");
		ModLoader.addName(godShovel, "God's Shovel");
		ModLoader.addName(godAxe, "God's Axe");
		ModLoader.addName(godHoe, "God's Hoe");
		ModLoader.addName(godSword, "God's Sword");
		ModLoader.addRecipe(new ItemStack(godPick, 1), new Object[] { "GGG", "g|g", " | ", Character.valueOf('g'), Item.glowstone, Character.valueOf('G'), Block.blockGold, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(godShovel, 1), new Object[] { "gGg", " | ", " | ", Character.valueOf('g'), Item.glowstone, Character.valueOf('G'), Block.blockGold, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(godAxe, 1), new Object[] { "GGg", "G|g", " | ", Character.valueOf('g'), Item.glowstone, Character.valueOf('G'), Block.blockGold, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(godHoe, 1), new Object[] { "GGg", "g| ", " | ", Character.valueOf('g'), Item.glowstone, Character.valueOf('G'), Block.blockGold, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(godSword, 1), new Object[] { "gGg", "gGg", " | ", Character.valueOf('g'), Item.glowstone, Character.valueOf('G'), Block.blockGold, Character.valueOf('|'), Item.stick });
		
		// Goddawn Tools.
		
		Item luziferPick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 81, LUZIFER)).setUnlocalizedName("luziferPickaxe");
		Item luziferShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 82, LUZIFER)).setUnlocalizedName("luziferShovel");
		Item luziferAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 83, LUZIFER)).setUnlocalizedName("luziferAxe");
		Item luziferHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 84, LUZIFER)).setUnlocalizedName("luziferHoe");
		Item luziferSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 85, LUZIFER, EPIC)).setUnlocalizedName("luziferSword");
		ModLoader.addName(luziferPick, "Luzifer's Pickaxe");
		ModLoader.addName(luziferShovel, "Luzifer's Shovel");
		ModLoader.addName(luziferAxe, "Luzifer's Axe");
		ModLoader.addName(luziferHoe, "Luzifer's Hoe");
		ModLoader.addName(luziferSword, "Luzifer's Sword");
		ModLoader.addRecipe(new ItemStack(luziferPick, 1), new Object[] { "NNN", "r|r", " | ", Character.valueOf('r'), Item.redstone, Character.valueOf('N'), Block.netherrack, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(luziferShovel, 1), new Object[] { "rNr", " | ", " | ", Character.valueOf('r'), Item.redstone, Character.valueOf('N'), Block.netherrack, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(luziferAxe, 1), new Object[] { "NNr", "N|r", " | ", Character.valueOf('r'), Item.redstone, Character.valueOf('N'), Block.netherrack, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(luziferHoe, 1), new Object[] { "NNr", "r| ", " | ", Character.valueOf('r'), Item.redstone, Character.valueOf('N'), Block.netherrack, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(luziferSword, 1), new Object[] { "rNr", "rNr", " | ", Character.valueOf('r'), Item.redstone, Character.valueOf('N'), Block.netherrack, Character.valueOf('|'), Item.stick });
		
		// Lightsabers.
		
		ModLoader.addName(lightsaberShaft, "Lightsaber Shaft");
		ModLoader.addName(lightsaberBlue, "Blue Lightsaber");
		ModLoader.addName(lightsaberGreen, "Green Lightsaber");
		ModLoader.addName(lightsaberPurple, "Purple Lightsaber");
		ModLoader.addName(lightsaberRed, "Red Lightsaber");
		ModLoader.addName(lightsaberWhite, "White Lightsaber");
		ModLoader.addRecipe(new ItemStack(lightsaberShaft, 1), new Object[] { "idi", "rGi", "iii", Character.valueOf('i'), Item.ingotIron, Character.valueOf('r'), Item.diamond, Character.valueOf('r'), Item.redstone, Character.valueOf('G'), Block.glowStone });
		
		// Emerald Tools.
		
		Item emeraldPick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 91, EMERALD2)).setUnlocalizedName("emeraldPickaxe");
		Item emeraldShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 92, EMERALD2)).setUnlocalizedName("emeraldShovel");
		Item emeraldAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 93, EMERALD2)).setUnlocalizedName("emeraldAxe");
		Item emeraldHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 94, EMERALD2)).setUnlocalizedName("emeraldHoe");
		Item emeraldSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 95, EMERALD2, EPIC)).setUnlocalizedName("emeraldSword");
		ModLoader.addName(emeraldPick, "Emerald Pickaxe");
		ModLoader.addName(emeraldShovel, "Emerald Shovel");
		ModLoader.addName(emeraldAxe, "Emerald Axe");
		ModLoader.addName(emeraldHoe, "Emerald Hoe");
		ModLoader.addName(emeraldSword, "Emerald Sword");
		ModLoader.addRecipe(new ItemStack(emeraldPick, 1), new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Item.emerald, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(emeraldShovel, 1), new Object[] { "X", "|", "|", Character.valueOf('X'), Item.emerald, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(emeraldAxe, 1), new Object[] { "XX", "X|", " |", Character.valueOf('X'), Item.emerald, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(emeraldHoe, 1), new Object[] { "XX", " |", " |", Character.valueOf('X'), Item.emerald, Character.valueOf('|'), Item.stick });
		ModLoader.addRecipe(new ItemStack(emeraldSword, 1), new Object[] { "X", "X", "|", Character.valueOf('X'), Item.emerald, Character.valueOf('|'), Item.stick });
		
		// Netherstar tools
		
		Item netherstarPick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 96, NETHERSTAR)).setUnlocalizedName("netherstarPickaxe");
		Item netherstarShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 97, NETHERSTAR)).setUnlocalizedName("netherstarShovel");
		Item netherstarAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 98, NETHERSTAR)).setUnlocalizedName("netherstarAxe");
		Item netherstarHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 99, NETHERSTAR)).setUnlocalizedName("netherstarHoe");
		Item netherstarSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 100 + 20, NETHERSTAR, EPIC)).setUnlocalizedName("netherstarSword");
		CSItems.addItemWithRecipe(netherstarPick, "Nether Star Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Item.netherStar, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(netherstarShovel, "Nether Star Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), Item.netherStar, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(netherstarAxe, "Nether Star Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), Item.netherStar, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(netherstarHoe, "Nether Star Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), Item.netherStar, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(netherstarSword, "Nether Star Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), Item.netherStar, Character.valueOf('|'), Item.stick });
		
		// Potato tools
		
		Item potatoPick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 21, POTATO)).setUnlocalizedName("potatoPickaxe");
		Item potatoShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 22, POTATO)).setUnlocalizedName("potatoShovel");
		Item potatoAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 23, POTATO)).setUnlocalizedName("potatoAxe");
		Item potatoHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 24, POTATO)).setUnlocalizedName("potatoHoe");
		Item potatoSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 100 + 25, POTATO, COMMON)).setUnlocalizedName("potatoSword");
		CSItems.addItemWithRecipe(potatoPick, "Potato Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Item.potato, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(potatoShovel, "Potato Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), Item.potato, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(potatoAxe, "Potato Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), Item.potato, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(potatoHoe, "Potato Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), Item.potato, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(potatoSword, "Potato Sword", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), Item.potato, Character.valueOf('|'), Item.stick });
		
		// Carrot tools
		
		Item carrotPick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 26, CARROT)).setUnlocalizedName("carrotPickaxe");
		Item carrotShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 27, CARROT)).setUnlocalizedName("carrotShovel");
		Item carrotAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 28, CARROT)).setUnlocalizedName("carrotAxe");
		Item carrotHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 29, CARROT)).setUnlocalizedName("carrotHoe");
		Item carrotSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 100 + 30, CARROT, COMMON)).setUnlocalizedName("carrotSword");
		CSItems.addItemWithRecipe(carrotPick, "Carrot Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Item.carrot, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(carrotShovel, "Carrot Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), Item.carrot, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(carrotAxe, "Carrot Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), Item.carrot, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(carrotHoe, "Carrot Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), Item.carrot, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(carrotSword, "Carrot Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), Item.carrot, Character.valueOf('|'), Item.stick });
		
		// Fish tools
		
		Item fishPick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 31, FISH)).setUnlocalizedName("fishPickaxe");
		Item fishShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 32, FISH)).setUnlocalizedName("fishShovel");
		Item fishAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 33, FISH)).setUnlocalizedName("fishAxe");
		Item fishHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 34, FISH)).setUnlocalizedName("fishHoe");
		Item fishSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 100 + 35, FISH, COMMON)).setUnlocalizedName("fishSword");
		CSItems.addItemWithRecipe(fishPick, "Fish Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Item.fishRaw, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(fishShovel, "Fish Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), Item.fishRaw, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(fishAxe, "Fish Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), Item.fishRaw, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(fishHoe, "Fish Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), Item.fishRaw, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(fishSword, "Fish Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), Item.fishRaw, Character.valueOf('|'), Item.stick });
		
		// Bacon tools.
		
		Item baconPick = (new ItemPickaxeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 36, BACON)).setUnlocalizedName("baconPickaxe");
		Item baconShovel = (new ItemSpadeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 37, BACON)).setUnlocalizedName("baconShovel");
		Item baconAxe = (new ItemAxeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 38, BACON)).setUnlocalizedName("baconAxe");
		Item baconHoe = (new ItemHoeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 39, BACON)).setUnlocalizedName("baconHoe");
		Item baconSword = (new ItemSwordMoreTools(MoreToolsMod.TOOLS_ID + 100 + 40, BACON, COMMON)).setUnlocalizedName("baconSword");
		CSItems.addItemWithRecipe(baconPick, "Bacon Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Item.porkRaw, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(baconShovel, "Bacon Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), Item.porkRaw, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(baconAxe, "Bacon Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), Item.porkRaw, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(baconHoe, "Bacon Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), Item.porkRaw, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(baconSword, "Bacon Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), Item.porkRaw, Character.valueOf('|'), Item.stick });
		
		// Dyeable tools.
		
		Item leatherPick = (new ItemDyeablePickaxeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 41, LEATHER)).setUnlocalizedName("leatherPickaxe");
		Item leatherShovel = (new ItemDyeableSpadeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 42, LEATHER)).setUnlocalizedName("leatherShovel");
		Item leatherAxe = (new ItemDyeableAxeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 43, LEATHER)).setUnlocalizedName("leatherAxe");
		Item leatherHoe = (new ItemDyeableHoeMoreTools(MoreToolsMod.TOOLS_ID + 100 + 44, LEATHER)).setUnlocalizedName("leatherHoe");
		Item leatherSword = (new ItemDyeableSwordMoreTools(MoreToolsMod.TOOLS_ID + 100 + 45, LEATHER)).setUnlocalizedName("leatherSword");
		CSItems.addItemWithRecipe(leatherPick, "Leather Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Item.leather, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(leatherShovel, "Leather Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), Item.leather, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(leatherAxe, "Leather Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), Item.leather, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(leatherHoe, "Leather Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), Item.leather, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(leatherSword, "Leather Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), Item.leather, Character.valueOf('|'), Item.stick });
		
		// Glowstone Tools
		
		CSItems.addItemWithRecipe(glowstonePick, "Glowstone Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Block.glowStone, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(glowstoneShovel, "Glowstone Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), Block.glowStone, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(glowstoneAxe, "Glowstone Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), Block.glowStone, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(glowstoneHoe, "Glowstone Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), Block.glowStone, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(glowstoneSword, "Glowstone Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), Block.glowStone, Character.valueOf('|'), Item.stick });
		
		// Slimeball Tools
		
		CSItems.addItemWithRecipe(slimePick, "Slime Pickaxe", 1, new Object[] { "XXX", " | ", " | ", Character.valueOf('X'), Item.slimeBall, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(slimeShovel, "Slime Shovel", 1, new Object[] { "X", "|", "|", Character.valueOf('X'), Item.slimeBall, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(slimeAxe, "Slime Axe", 1, new Object[] { "XX", "X|", " |", Character.valueOf('X'), Item.slimeBall, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(slimeHoe, "Slime Hoe", 1, new Object[] { "XX", " |", " |", Character.valueOf('X'), Item.slimeBall, Character.valueOf('|'), Item.stick });
		CSItems.addItemWithRecipe(slimeSword, "Slime Sword", 1, new Object[] { "X", "X", "|", Character.valueOf('X'), Item.slimeBall, Character.valueOf('|'), Item.stick });
		
		// Space things.
		
		// Space Ore.
		GameRegistry.registerBlock(spaceBlock, ItemMultiBlock.class, "SpaceBlock");
		ModLoader.addName(spaceBlock, "Space Block");
		GameRegistry.registerBlock(spaceOre, ItemBlock.class, "SpaceOre");
		ModLoader.addName(spaceOre, "Space Ore");
		
		ModLoader.addRecipe(new ItemStack(spaceBlock, 1, 1), new Object[] { "sss", "sss", "sss", Character.valueOf('s'), spaceIngot });
		// Space Multitool.
		CSItems.addItemWithShapelessRecipe(spaceMultitool, "Space Multitool", 1, new Object[] { spacePick, spaceShovel, spaceAxe, spaceHoe, spaceSwordStrong });
		// Space Bow.
		CSItems.addItemWithRecipe(spaceBow, "Space Bow", 1, new Object[] { "sS ", "s S", "sS ", 'S', spaceIngot, 's', Item.silk });
		// Space Arrow
		CSItems.addItemWithRecipe(spaceArrow, "Space Arrow", 4, new Object[] { "s", "|", "f", Character.valueOf('s'), spaceIngot, Character.valueOf('|'), Item.stick, Character.valueOf('f'), Item.feather });
		// Space Ingot.
		CSItems.addItemWithRecipe(spaceIngot, "Space Ingot", 9, new Object[] { "s", 's', new ItemStack(spaceBlock, 1, 1) });
		
		CSCrafting.addSmelting(new ItemStack(spaceOre, 1, 0), new ItemStack(spaceIngot, 1), 0.5F);
		CSCrafting.addSmelting(new ItemStack(spaceBlock, 1, 0), new ItemStack(spaceIngot, 1), 0.5F);
		
		// Other items.
		
		// Blazerod and Steel.
		Item blazerodAndSteel = (new ItemFlintAndSteelMoreTools(MoreToolsMod.TOOLS_ID + 200 + 04, 128)).setUnlocalizedName("blazeandsteel");
		CSItems.addItemWithRecipe(blazerodAndSteel, "Blazerod and Steel", 1, new Object[] { "i ", " b", Character.valueOf('i'), Item.ingotIron, Character.valueOf('b'), Item.blazeRod });
		
		Item goldShears = (new ItemShearsMoreTools(MoreToolsMod.TOOLS_ID + 200 + 05, 32, 2)).setUnlocalizedName("shearsgold");
		CSItems.addItemWithRecipe(goldShears, "Gold Shears", 1, new Object[] { "X ", " X", Character.valueOf('X'), Item.ingotGold });
		Item diamondShears = (new ItemShearsMoreTools(MoreToolsMod.TOOLS_ID + 200 + 06, 1024, 5)).setUnlocalizedName("shearsdiamond");
		CSItems.addItemWithRecipe(diamondShears, "Diamond Shears", 1, new Object[] { "X ", " X", Character.valueOf('X'), Item.diamond });
		// Item skeletonBow = (new ItemBowMoreTools(MoreToolsMod.TOOLS_ID + 200
		// + 07, Item.arrow, true)).setUnlocalizedName("skeletonBow");
		
		// Glowing Block used by Glowstone Tools
		
		CSBlocks.addBlock(glowing, "Glowing Block");
	}
	
	public void load2()
	{
		MinecraftForge.setBlockHarvestLevel(spaceOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(spaceBlock, "pickaxe", 2);
		CraftingManager.getInstance().getRecipeList().add(new RecipesToolDyes());
		LanguageRegistry.instance().addStringLocalization("enchantment.quickdraw", "Quick Draw");
	}
	
	public void addName(Object o, String name)
	{
		
		LanguageRegistry.instance().addNameForObject(o, "en_US", name);
	}
}
