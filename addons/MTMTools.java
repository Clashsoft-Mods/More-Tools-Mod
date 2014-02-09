package clashsoft.mods.moretools.addons;

import static net.minecraft.item.EnumRarity.common;
import static net.minecraft.item.EnumRarity.epic;
import static net.minecraft.item.EnumRarity.rare;
import static net.minecraft.item.EnumRarity.uncommon;
import clashsoft.cslib.minecraft.addon.Addon;
import clashsoft.cslib.minecraft.block.CSBlocks;
import clashsoft.cslib.minecraft.block.CustomBlock;
import clashsoft.cslib.minecraft.crafting.CSCrafting;
import clashsoft.cslib.minecraft.enchantment.CustomEnchantment;
import clashsoft.cslib.minecraft.item.CSItems;
import clashsoft.cslib.minecraft.item.block.ItemCustomBlock;
import clashsoft.cslib.minecraft.lang.CSLang;
import clashsoft.mods.moretools.block.BlockGlowing;
import clashsoft.mods.moretools.block.BlockSpaceblock;
import clashsoft.mods.moretools.crafting.RecipesToolDyes;
import clashsoft.mods.moretools.item.dyeable.*;
import clashsoft.mods.moretools.item.lightsabers.ItemLightsaber;
import clashsoft.mods.moretools.item.lightsabers.ItemLightsaberShaft;
import clashsoft.mods.moretools.item.tools.*;
import cpw.mods.fml.common.event.FMLInitializationEvent;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.util.EnumHelper;

@Addon(modName = "MoreToolsMod", addonName = "Tools")
public class MTMTools
{
	public static MTMTools		instance			= new MTMTools();
	
	public static ToolMaterial	OBSIDIAN			= EnumHelper.addToolMaterial("OBSIDIAN", 3, 4096, 25F, 10, 10);
	public static ToolMaterial	REDSTONE			= EnumHelper.addToolMaterial("REDSTONE", 2, 64, 6F, 2.5F, 15);
	public static ToolMaterial	COAL				= EnumHelper.addToolMaterial("COAL", 1, 128, 3F, 2.1F, 15);
	public static ToolMaterial	LAPIS				= EnumHelper.addToolMaterial("LAPIS", 2, 256, 3F, 2F, 15);
	public static ToolMaterial	END					= EnumHelper.addToolMaterial("END", 2, 512, 5F, 2.8F, 15);
	public static ToolMaterial	SPACE1				= EnumHelper.addToolMaterial("SPACESTRONG", 3, 8196, 50F, 13F, 20);
	public static ToolMaterial	SPACE2				= EnumHelper.addToolMaterial("SPACEWEAK", 3, 6144, 40F, 10F, 18);
	public static ToolMaterial	BONE				= EnumHelper.addToolMaterial("BONE", 1, 32, 1.5F, 1.2F, 15);
	public static ToolMaterial	REED				= EnumHelper.addToolMaterial("REED", 0, 16, 0.5F, 0.2F, 15);
	public static ToolMaterial	BLAZEROD			= EnumHelper.addToolMaterial("BLAZEROD", 2, 512, 6F, 1.9F, 15);
	public static ToolMaterial	DIRT				= EnumHelper.addToolMaterial("DIRT", 0, 16, 0.8F, -0.1F, 15);
	public static ToolMaterial	GLASS				= EnumHelper.addToolMaterial("GLASS", 0, 16, 0.5F, 1.3F, 15);
	public static ToolMaterial	SANDSTONE			= EnumHelper.addToolMaterial("SANDSTONE", 1, 128, 3F, 1.8F, 15);
	public static ToolMaterial	BRICK				= EnumHelper.addToolMaterial("BRICK", 1, 128, 2.5F, 1.75F, 15);
	public static ToolMaterial	ENDSTONE			= EnumHelper.addToolMaterial("ENDSTONE", 2, 256, 3.5F, 2.9F, 15);
	public static ToolMaterial	EXCALIBUR			= EnumHelper.addToolMaterial("EXCALIBUR", 3, 16392, 10F, 20F, 1);
	public static ToolMaterial	GOD					= EnumHelper.addToolMaterial("GOD", 3, 2048, 5F, 15F, 10);
	public static ToolMaterial	LUZIFER				= EnumHelper.addToolMaterial("LUZIFER", 3, 2048, 5F, 15F, 10);
	public static ToolMaterial	LASER				= EnumHelper.addToolMaterial("LASER", 3, -1, 1F, 25F, 1);
	public static ToolMaterial	EMERALD2			= EnumHelper.addToolMaterial("EMERALD2", 3, 1536, 8F, 2.95F, 17);
	public static ToolMaterial	NETHERSTAR			= EnumHelper.addToolMaterial("NETHERSTAR", 3, 2048, 12F, 4F, 20);
	public static ToolMaterial	POTATO				= EnumHelper.addToolMaterial("POTATO", 1, 64, 3F, 0.6F, 15);
	public static ToolMaterial	CARROT				= EnumHelper.addToolMaterial("CARROT", 1, 64, 3F, 0.6F, 15);
	public static ToolMaterial	FISH				= EnumHelper.addToolMaterial("FISH", 1, 64, 2.5F, 0.7F, 15);
	public static ToolMaterial	BACON				= EnumHelper.addToolMaterial("BACON", 1, 64, 2.5F, 0.7F, 15);
	public static ToolMaterial	LEATHER				= ToolMaterial.WOOD;
	public static ToolMaterial	GLOWSTONE			= EnumHelper.addToolMaterial("GLOWSTONE", 2, 64, 1F, 1F, 16);
	public static ToolMaterial	SLIME				= EnumHelper.addToolMaterial("SLIME", 1, 80, 1.2F, 0.85F, 15);
	
	public static Enchantment	quickDraw			= new CustomEnchantment(7, 1, 3, EnumEnchantmentType.bow, "quickdraw");
	
	public static CustomBlock	spaceBlock			= (CustomBlock) (new BlockSpaceblock()).setBlockName("spaceblock").setHardness(3F);
	public static BlockGlowing	glowingBlock		= (BlockGlowing) (new BlockGlowing()).setBlockName("glowing");
	
	public static Item			obsidianPick		= (new ItemPickaxeMTM(OBSIDIAN)).setUnlocalizedName("obsidianPickaxe");
	public static Item			obsidianShovel		= (new ItemSpadeMTM(OBSIDIAN)).setUnlocalizedName("obsidianShovel");
	public static Item			obsidianAxe			= (new ItemAxeMTM(OBSIDIAN)).setUnlocalizedName("obsidianAxe");
	public static Item			obsidianHoe			= (new ItemHoeMTM(OBSIDIAN)).setUnlocalizedName("obsidianHoe");
	public static Item			obsidianSword		= (new ItemSwordMTM(OBSIDIAN, uncommon)).setUnlocalizedName("obsidianSword");
	
	public static Item			redstonePick		= (new ItemPickaxeMTM(REDSTONE)).setUnlocalizedName("redstonePickaxe");
	public static Item			redstoneShovel		= (new ItemSpadeMTM(REDSTONE)).setUnlocalizedName("redstoneShovel");
	public static Item			redstoneAxe			= (new ItemAxeMTM(REDSTONE)).setUnlocalizedName("redstoneAxe");
	public static Item			redstoneHoe			= (new ItemHoeMTM(REDSTONE)).setUnlocalizedName("redstoneHoe");
	public static Item			redstoneSword		= (new ItemSwordMTM(REDSTONE, uncommon)).setUnlocalizedName("redstoneSword");
	
	public static Item			coalPick			= (new ItemPickaxeMTM(COAL)).setUnlocalizedName("coalPickaxe");
	public static Item			coalShovel			= (new ItemSpadeMTM(COAL)).setUnlocalizedName("coalShovel");
	public static Item			coalAxe				= (new ItemAxeMTM(COAL)).setUnlocalizedName("coalAxe");
	public static Item			coalHoe				= (new ItemHoeMTM(COAL)).setUnlocalizedName("coalHoe");
	public static Item			coalSword			= (new ItemSwordMTM(COAL, common)).setUnlocalizedName("coalSword");
	
	public static Item			lapisPick			= (new ItemPickaxeMTM(LAPIS)).setUnlocalizedName("lapisPickaxe");
	public static Item			lapisShovel			= (new ItemSpadeMTM(LAPIS)).setUnlocalizedName("lapisShovel");
	public static Item			lapisAxe			= (new ItemAxeMTM(LAPIS)).setUnlocalizedName("lapisAxe");
	public static Item			lapisHoe			= (new ItemHoeMTM(LAPIS)).setUnlocalizedName("lapisHoe");
	public static Item			lapisSword			= (new ItemSwordMTM(LAPIS, common)).setUnlocalizedName("lapisSword");
	
	public static Item			enderPick			= (new ItemPickaxeMTM(END)).setUnlocalizedName("enderPickaxe");
	public static Item			enderShovel			= (new ItemSpadeMTM(END)).setUnlocalizedName("enderShovel");
	public static Item			enderAxe			= (new ItemAxeMTM(END)).setUnlocalizedName("enderAxe");
	public static Item			enderHoe			= (new ItemHoeMTM(END)).setUnlocalizedName("enderHoe");
	public static Item			enderSword			= (new ItemSwordMTM(END, rare)).setUnlocalizedName("enderSword");
	
	public static Item			spacePick			= (new ItemPickaxeMTM(SPACE1)).setUnlocalizedName("spacePickaxe");
	public static Item			spaceShovel			= (new ItemSpadeMTM(SPACE1)).setUnlocalizedName("spaceShovel");
	public static Item			spaceAxe			= (new ItemAxeMTM(SPACE1)).setUnlocalizedName("spaceAxe");
	public static Item			spaceHoe			= (new ItemHoeMTM(SPACE1)).setUnlocalizedName("spaceHoe");
	public static Item			spaceSwordAdvanced	= (new ItemSwordMTM(SPACE1, epic)).setUnlocalizedName("spaceSwordStrong");
	
	public static Item			bonePick			= (new ItemPickaxeMTM(BONE)).setUnlocalizedName("bonePickaxe");
	public static Item			boneShovel			= (new ItemSpadeMTM(BONE)).setUnlocalizedName("boneShovel");
	public static Item			boneAxe				= (new ItemAxeMTM(BONE)).setUnlocalizedName("boneAxe");
	public static Item			boneHoe				= (new ItemHoeMTM(BONE)).setUnlocalizedName("boneHoe");
	public static Item			boneSword			= (new ItemSwordMTM(BONE, common)).setUnlocalizedName("boneSword");
	
	public static Item			sugarcanePick		= (new ItemPickaxeMTM(REED)).setUnlocalizedName("sugarcanePickaxe");
	public static Item			sugarcaneShovel		= (new ItemSpadeMTM(REED)).setUnlocalizedName("sugarcaneShovel");
	public static Item			sugarcaneAxe		= (new ItemAxeMTM(REED)).setUnlocalizedName("sugarcaneAxe");
	public static Item			sugarcaneHoe		= (new ItemHoeMTM(REED)).setUnlocalizedName("sugarcaneHoe");
	public static Item			sugarcaneSword		= (new ItemSwordMTM(REED, common)).setUnlocalizedName("sugarcaneSword");
	
	public static Item			blazerodPick		= (new ItemPickaxeMTM(BLAZEROD)).setUnlocalizedName("blazePickaxe");
	public static Item			blazerodShovel		= (new ItemSpadeMTM(BLAZEROD)).setUnlocalizedName("blazeShovel");
	public static Item			blazerodAxe			= (new ItemAxeMTM(BLAZEROD)).setUnlocalizedName("blazeAxe");
	public static Item			blazerodHoe			= (new ItemHoeMTM(BLAZEROD)).setUnlocalizedName("blazeHoe");
	public static Item			blazerodSword		= (new ItemSwordMTM(BLAZEROD, uncommon)).setUnlocalizedName("blazeSword");
	
	public static Item			dirtPick			= (new ItemPickaxeMTM(DIRT)).setUnlocalizedName("dirtPickaxe");
	public static Item			dirtShovel			= (new ItemSpadeMTM(DIRT)).setUnlocalizedName("dirtShovel");
	public static Item			dirtAxe				= (new ItemAxeMTM(DIRT)).setUnlocalizedName("dirtAxe");
	public static Item			dirtHoe				= (new ItemHoeMTM(DIRT)).setUnlocalizedName("dirtHoe");
	public static Item			dirtSword			= (new ItemSwordMTM(DIRT, common)).setUnlocalizedName("dirtSword");
	
	public static Item			glassPick			= (new ItemPickaxeMTM(GLASS)).setUnlocalizedName("glassPickaxe");
	public static Item			glassShovel			= (new ItemSpadeMTM(GLASS)).setUnlocalizedName("glassShovel");
	public static Item			glassAxe			= (new ItemAxeMTM(GLASS)).setUnlocalizedName("glassAxe");
	public static Item			glassHoe			= (new ItemHoeMTM(GLASS)).setUnlocalizedName("glassHoe");
	public static Item			glassSword			= (new ItemSwordMTM(GLASS, common)).setUnlocalizedName("glassSword");
	
	public static Item			sandstonePick		= (new ItemPickaxeMTM(SANDSTONE)).setUnlocalizedName("sandstonePickaxe");
	public static Item			sandstoneShovel		= (new ItemSpadeMTM(SANDSTONE)).setUnlocalizedName("sandstoneShovel");
	public static Item			sandstoneAxe		= (new ItemAxeMTM(SANDSTONE)).setUnlocalizedName("sandstoneAxe");
	public static Item			sandstoneHoe		= (new ItemHoeMTM(SANDSTONE)).setUnlocalizedName("sandstoneHoe");
	public static Item			sandstoneSword		= (new ItemSwordMTM(SANDSTONE, common)).setUnlocalizedName("sandstoneSword");
	
	public static Item			brickPick			= (new ItemPickaxeMTM(BRICK)).setUnlocalizedName("brickPickaxe");
	public static Item			brickShovel			= (new ItemSpadeMTM(BRICK)).setUnlocalizedName("brickShovel");
	public static Item			brickAxe			= (new ItemAxeMTM(BRICK)).setUnlocalizedName("brickAxe");
	public static Item			brickHoe			= (new ItemHoeMTM(BRICK)).setUnlocalizedName("brickHoe");
	public static Item			brickSword			= (new ItemSwordMTM(BRICK, common)).setUnlocalizedName("brickSword");
	
	public static Item			endstonePick		= (new ItemPickaxeMTM(ENDSTONE)).setUnlocalizedName("endstonePickaxe");
	public static Item			endstoneShovel		= (new ItemSpadeMTM(ENDSTONE)).setUnlocalizedName("endstoneShovel");
	public static Item			endstoneAxe			= (new ItemAxeMTM(ENDSTONE)).setUnlocalizedName("endstoneAxe");
	public static Item			endstoneHoe			= (new ItemHoeMTM(ENDSTONE)).setUnlocalizedName("endstoneHoe");
	public static Item			endstoneSword		= (new ItemSwordMTM(ENDSTONE, uncommon)).setUnlocalizedName("endstoneSword");
	
	public static Item			excaliburSword		= (new ItemSwordMTM(EXCALIBUR, epic)).setUnlocalizedName("epicSword");
	
	public static Item			godPick				= (new ItemPickaxeMTM(GOD)).setUnlocalizedName("godPickaxe");
	public static Item			godShovel			= (new ItemSpadeMTM(GOD)).setUnlocalizedName("godShovel");
	public static Item			godAxe				= (new ItemAxeMTM(GOD)).setUnlocalizedName("godAxe");
	public static Item			godHoe				= (new ItemHoeMTM(GOD)).setUnlocalizedName("godHoe");
	public static Item			godSword			= (new ItemSwordMTM(GOD, epic)).setUnlocalizedName("godSword");
	
	public static Item			luziferPick			= (new ItemPickaxeMTM(LUZIFER)).setUnlocalizedName("luziferPickaxe");
	public static Item			luziferShovel		= (new ItemSpadeMTM(LUZIFER)).setUnlocalizedName("luziferShovel");
	public static Item			luziferAxe			= (new ItemAxeMTM(LUZIFER)).setUnlocalizedName("luziferAxe");
	public static Item			luziferHoe			= (new ItemHoeMTM(LUZIFER)).setUnlocalizedName("luziferHoe");
	public static Item			luziferSword		= (new ItemSwordMTM(LUZIFER, epic)).setUnlocalizedName("luziferSword");
	
	public static Item			lightsaberShaft		= (new ItemLightsaberShaft()).setUnlocalizedName("lsshaft");
	public static Item			lightsaberBlue		= (new ItemLightsaber(LASER)).setUnlocalizedName("lightSaber1");
	public static Item			lightsaberGreen		= (new ItemLightsaber(LASER)).setUnlocalizedName("lightSaber2");
	public static Item			lightsaberPurple	= (new ItemLightsaber(LASER)).setUnlocalizedName("lightSaber3");
	public static Item			lightsaberRed		= (new ItemLightsaber(LASER)).setUnlocalizedName("lightSaber4");
	public static Item			lightsaberWhite		= (new ItemLightsaber(LASER)).setUnlocalizedName("lightSaber5");
	
	public static Item			emeraldPick			= (new ItemPickaxeMTM(EMERALD2)).setUnlocalizedName("emeraldPickaxe");
	public static Item			emeraldShovel		= (new ItemSpadeMTM(EMERALD2)).setUnlocalizedName("emeraldShovel");
	public static Item			emeraldAxe			= (new ItemAxeMTM(EMERALD2)).setUnlocalizedName("emeraldAxe");
	public static Item			emeraldHoe			= (new ItemHoeMTM(EMERALD2)).setUnlocalizedName("emeraldHoe");
	public static Item			emeraldSword		= (new ItemSwordMTM(EMERALD2, epic)).setUnlocalizedName("emeraldSword");
	
	public static Item			netherstarPick		= (new ItemPickaxeMTM(NETHERSTAR)).setUnlocalizedName("netherstarPickaxe");
	public static Item			netherstarShovel	= (new ItemSpadeMTM(NETHERSTAR)).setUnlocalizedName("netherstarShovel");
	public static Item			netherstarAxe		= (new ItemAxeMTM(NETHERSTAR)).setUnlocalizedName("netherstarAxe");
	public static Item			netherstarHoe		= (new ItemHoeMTM(NETHERSTAR)).setUnlocalizedName("netherstarHoe");
	public static Item			netherstarSword		= (new ItemSwordMTM(NETHERSTAR, epic)).setUnlocalizedName("netherstarSword");
	
	public static Item			potatoPick			= (new ItemPickaxeMTM(POTATO)).setUnlocalizedName("potatoPickaxe");
	public static Item			potatoShovel		= (new ItemSpadeMTM(POTATO)).setUnlocalizedName("potatoShovel");
	public static Item			potatoAxe			= (new ItemAxeMTM(POTATO)).setUnlocalizedName("potatoAxe");
	public static Item			potatoHoe			= (new ItemHoeMTM(POTATO)).setUnlocalizedName("potatoHoe");
	public static Item			potatoSword			= (new ItemSwordMTM(POTATO, common)).setUnlocalizedName("potatoSword");
	
	public static Item			carrotPick			= (new ItemPickaxeMTM(CARROT)).setUnlocalizedName("carrotPickaxe");
	public static Item			carrotShovel		= (new ItemSpadeMTM(CARROT)).setUnlocalizedName("carrotShovel");
	public static Item			carrotAxe			= (new ItemAxeMTM(CARROT)).setUnlocalizedName("carrotAxe");
	public static Item			carrotHoe			= (new ItemHoeMTM(CARROT)).setUnlocalizedName("carrotHoe");
	public static Item			carrotSword			= (new ItemSwordMTM(CARROT, common)).setUnlocalizedName("carrotSword");
	
	public static Item			fishPick			= (new ItemPickaxeMTM(FISH)).setUnlocalizedName("fishPickaxe");
	public static Item			fishShovel			= (new ItemSpadeMTM(FISH)).setUnlocalizedName("fishShovel");
	public static Item			fishAxe				= (new ItemAxeMTM(FISH)).setUnlocalizedName("fishAxe");
	public static Item			fishHoe				= (new ItemHoeMTM(FISH)).setUnlocalizedName("fishHoe");
	public static Item			fishSword			= (new ItemSwordMTM(FISH, common)).setUnlocalizedName("fishSword");
	
	public static Item			baconPick			= (new ItemPickaxeMTM(BACON)).setUnlocalizedName("baconPickaxe");
	public static Item			baconShovel			= (new ItemSpadeMTM(BACON)).setUnlocalizedName("baconShovel");
	public static Item			baconAxe			= (new ItemAxeMTM(BACON)).setUnlocalizedName("baconAxe");
	public static Item			baconHoe			= (new ItemHoeMTM(BACON)).setUnlocalizedName("baconHoe");
	public static Item			baconSword			= (new ItemSwordMTM(BACON, common)).setUnlocalizedName("baconSword");
	
	public static Item			leatherPick			= (new ItemDyeablePickaxe(LEATHER)).setUnlocalizedName("leatherPickaxe");
	public static Item			leatherShovel		= (new ItemDyeableSpade(LEATHER)).setUnlocalizedName("leatherShovel");
	public static Item			leatherAxe			= (new ItemDyeableAxe(LEATHER)).setUnlocalizedName("leatherAxe");
	public static Item			leatherHoe			= (new ItemDyeableHoe(LEATHER)).setUnlocalizedName("leatherHoe");
	public static Item			leatherSword		= (new ItemDyeableSword(LEATHER)).setUnlocalizedName("leatherSword");
	
	public static Item			glowstonePick		= (new ItemPickaxeMTM(GLOWSTONE)).setUnlocalizedName("glowstonePickaxe");
	public static Item			glowstoneShovel		= (new ItemSpadeMTM(GLOWSTONE)).setUnlocalizedName("glowstoneShovel");
	public static Item			glowstoneAxe		= (new ItemAxeMTM(GLOWSTONE)).setUnlocalizedName("glowstoneAxe");
	public static Item			glowstoneHoe		= (new ItemHoeMTM(GLOWSTONE)).setUnlocalizedName("glowstoneHoe");
	public static Item			glowstoneSword		= (new ItemSwordMTM(GLOWSTONE, common)).setUnlocalizedName("glowstoneSword");
	
	public static Item			slimePick			= (new ItemPickaxeMTM(SLIME)).setUnlocalizedName("slimePickaxe");
	public static Item			slimeShovel			= (new ItemSpadeMTM(SLIME)).setUnlocalizedName("slimeShovel");
	public static Item			slimeAxe			= (new ItemAxeMTM(SLIME)).setUnlocalizedName("slimeAxe");
	public static Item			slimeHoe			= (new ItemHoeMTM(SLIME)).setUnlocalizedName("slimeHoe");
	public static Item			slimeSword			= (new ItemSwordMTM(SLIME, common)).setUnlocalizedName("slimeSword");
	
	public static Item			spaceMultitool		= new ItemMultitool(SPACE1).setUnlocalizedName("spacemulti");
	public static Item			spaceArrow			= new Item().setUnlocalizedName("spacearrow").setCreativeTab(CreativeTabs.tabCombat);
	public static Item			spaceBow			= new ItemBowMTM(spaceArrow).setUnlocalizedName("spacebow");
	public static Item			spaceIngot			= new Item().setUnlocalizedName("spaceingot").setCreativeTab(CreativeTabs.tabMaterials);
	public static Item			spaceSword			= new ItemSwordMTM(SPACE2, rare).setUnlocalizedName("spaceSwordWeak");
	
	public static Item			blazerodAndSteel	= (new ItemFlintAndSteelMTM(128)).setUnlocalizedName("blazeandsteel");
	
	public static Item			goldShears			= (new ItemShearsMTM(32, 2)).setUnlocalizedName("shearsgold");
	public static Item			diamondShears		= (new ItemShearsMTM(1024, 5)).setUnlocalizedName("shearsdiamond");
	
	public static ItemStack		obsidian			= new ItemStack(Blocks.obsidian);
	public static ItemStack		redstone_block		= new ItemStack(Blocks.redstone_block);
	public static ItemStack		coal				= new ItemStack(Items.coal);
	public static ItemStack		lapis_block			= new ItemStack(Blocks.lapis_block);
	public static ItemStack		ender_pearl			= new ItemStack(Items.ender_pearl);
	public static ItemStack		space				= new ItemStack(spaceIngot);
	public static ItemStack		space_2				= new ItemStack(spaceBlock, 1, 1);
	public static ItemStack		bone				= new ItemStack(Items.bone);
	public static ItemStack		reeds				= new ItemStack(Items.reeds);
	public static ItemStack		blaze_rod			= new ItemStack(Items.blaze_rod);
	public static ItemStack		dirt				= new ItemStack(Blocks.dirt);
	public static ItemStack		glass				= new ItemStack(Blocks.glass);
	public static ItemStack		sandstone			= new ItemStack(Blocks.sandstone);
	public static ItemStack		brick				= new ItemStack(Blocks.brick_block);
	public static ItemStack		end_stone			= new ItemStack(Blocks.end_stone);
	public static ItemStack		emerald				= new ItemStack(Items.emerald);
	public static ItemStack		nether_star			= new ItemStack(Items.nether_star);
	public static ItemStack		potato				= new ItemStack(Items.potato);
	public static ItemStack		carrot				= new ItemStack(Items.carrot);
	public static ItemStack		fish				= new ItemStack(Items.fish);
	public static ItemStack		porkchop			= new ItemStack(Items.porkchop);
	public static ItemStack		leather				= new ItemStack(Items.leather);
	public static ItemStack		glowstone			= new ItemStack(Blocks.glowstone);
	public static ItemStack		slime				= new ItemStack(Items.slime_ball);
	
	public static ItemStack		glowstone_dust		= new ItemStack(Items.glowstone_dust);
	
	public void load(FMLInitializationEvent event)
	{
		CSLang.addLocalizationUS("enchantment.quickdraw", "Quick Draw");
		
		this.addItems();
		this.addBlocks();
		this.addRecipes();
	}
	
	public void addRecipes()
	{
		CSCrafting.addCrafting(new ItemStack(spaceBlock, 1, 1), "sss", "sss", "sss", 's', spaceIngot);
		
		CSCrafting.addSmelting(new ItemStack(spaceBlock, 1, 0), new ItemStack(spaceIngot, 1), 0.5F);
		
		CraftingManager.getInstance().getRecipeList().add(new RecipesToolDyes());
	}
	
	public void addItems()
	{
		CSItems.addTool(obsidianSword, "Obsidian Sword", obsidian, 0);
		CSItems.addTool(obsidianShovel, "Obsidian Shovel", obsidian, 1);
		CSItems.addTool(obsidianPick, "Obsidian Pickaxe", obsidian, 2);
		CSItems.addTool(obsidianAxe, "Obsidian Axe", obsidian, 3);
		CSItems.addTool(obsidianHoe, "Obsidian Hoe", obsidian, 4);
		
		CSItems.addTool(redstoneSword, "Redstone Sword", redstone_block, 0);
		CSItems.addTool(redstoneShovel, "Redstone Shovel", redstone_block, 1);
		CSItems.addTool(redstonePick, "Redstone Pickaxe", redstone_block, 2);
		CSItems.addTool(redstoneAxe, "Redstone Axe", redstone_block, 3);
		CSItems.addTool(redstoneHoe, "Redstone Hoe", redstone_block, 4);
		
		CSItems.addTool(coalSword, "Coal Sword", coal, 0);
		CSItems.addTool(coalShovel, "Coal Shovel", coal, 1);
		CSItems.addTool(coalPick, "Coal Pickaxe", coal, 2);
		CSItems.addTool(coalAxe, "Coal Axe", coal, 3);
		CSItems.addTool(coalHoe, "Coal Hoe", coal, 4);
		
		CSItems.addTool(lapisSword, "Lapislazuli Sword", lapis_block, 0);
		CSItems.addTool(lapisShovel, "Lapislazuli Shovel", lapis_block, 1);
		CSItems.addTool(lapisPick, "Lapislazuli Pickaxe", lapis_block, 2);
		CSItems.addTool(lapisAxe, "Lapislazuli Axe", lapis_block, 3);
		CSItems.addTool(lapisHoe, "Lapislazuli Hoe", lapis_block, 4);
		
		CSItems.addTool(enderSword, "Ender Sword", ender_pearl, 0);
		CSItems.addTool(enderShovel, "Ender Shovel", ender_pearl, 1);
		CSItems.addTool(enderPick, "Ender Pickaxe", ender_pearl, 2);
		CSItems.addTool(enderAxe, "Ender Axe", ender_pearl, 3);
		CSItems.addTool(enderHoe, "Ender Hoe", ender_pearl, 4);
		
		CSItems.addTool(spaceSword, "Normal Spacesword", space, 0);
		CSItems.addTool(spaceSwordAdvanced, "Advanced Spacesword", space_2, 0);
		CSItems.addTool(spaceShovel, "Space Shovel", space, 1);
		CSItems.addTool(spacePick, "Space Pickaxe", space, 2);
		CSItems.addTool(spaceAxe, "Space Axe", space, 3);
		CSItems.addTool(spaceHoe, "Space Hoe", space, 4);
		
		CSItems.addTool(boneSword, "Bone Sword", bone, 0);
		CSItems.addTool(boneShovel, "Bone Shovel", bone, 1);
		CSItems.addTool(bonePick, "Bone Pickaxe", bone, 2);
		CSItems.addTool(boneAxe, "Bone Axe", bone, 3);
		CSItems.addTool(boneHoe, "Bone Hoe", bone, 4);
		
		CSItems.addTool(sugarcaneSword, "Senseis Sword", reeds, 0);
		CSItems.addTool(sugarcaneShovel, "Sugarcane Shovel", reeds, 1);
		CSItems.addTool(sugarcanePick, "Sugarcane Pickaxe", reeds, 2);
		CSItems.addTool(sugarcaneAxe, "Sugarcane Axe", reeds, 3);
		CSItems.addTool(sugarcaneHoe, "Sugarcane Hoe", reeds, 4);
		
		CSItems.addTool(blazerodSword, "Blazerod Sword", blaze_rod, 0);
		CSItems.addTool(blazerodShovel, "Blazerod Shovel", blaze_rod, 1);
		CSItems.addTool(blazerodPick, "Blazerod Pickaxe", blaze_rod, 2);
		CSItems.addTool(blazerodAxe, "Blazerod Axe", blaze_rod, 3);
		CSItems.addTool(blazerodHoe, "Blazerod Hoe", blaze_rod, 4);
		
		CSItems.addTool(dirtSword, "Dirt Sword", dirt, 0);
		CSItems.addTool(dirtShovel, "Dirt Shovel", dirt, 1);
		CSItems.addTool(dirtPick, "Dirt Pickaxe", dirt, 2);
		CSItems.addTool(dirtAxe, "Dirt Axe", dirt, 3);
		CSItems.addTool(dirtHoe, "Dirt Hoe", dirt, 4);
		
		CSItems.addTool(glassSword, "Glass Sword", glass, 0);
		CSItems.addTool(glassShovel, "Glass Shovel", glass, 1);
		CSItems.addTool(glassPick, "Glass Pickaxe", glass, 2);
		CSItems.addTool(glassAxe, "Glass Axe", glass, 3);
		CSItems.addTool(glassHoe, "Glass Hoe", glass, 4);
		
		CSItems.addTool(sandstoneSword, "Sandstone Sword", sandstone, 0);
		CSItems.addTool(sandstoneShovel, "Sandstone Shovel", sandstone, 1);
		CSItems.addTool(sandstonePick, "Sandstone Pickaxe", sandstone, 2);
		CSItems.addTool(sandstoneAxe, "Sandstone Axe", sandstone, 3);
		CSItems.addTool(sandstoneHoe, "Sandstone Hoe", sandstone, 4);
		
		CSItems.addTool(brickSword, "Brick Sword", brick, 0);
		CSItems.addTool(brickShovel, "Brick Shovel", brick, 1);
		CSItems.addTool(brickPick, "Brick Pickaxe", brick, 2);
		CSItems.addTool(brickAxe, "Brick Axe", brick, 3);
		CSItems.addTool(brickHoe, "Brick Hoe", brick, 4);
		
		CSItems.addTool(endstoneSword, "Endstone Sword", end_stone, 0);
		CSItems.addTool(endstoneShovel, "Endstone Shovel", end_stone, 1);
		CSItems.addTool(endstonePick, "Endstone Pickaxe", end_stone, 2);
		CSItems.addTool(endstoneAxe, "Endstone Axe", end_stone, 3);
		CSItems.addTool(endstoneHoe, "Endstone Hoe", end_stone, 4);
		
		CSItems.addItemWithRecipe(excaliburSword, "Excalibur", 1, new Object[] {
				"gNg",
				"hDh",
				"d|d",
				'g',
				Items.ghast_tear,
				'N',
				Items.nether_star,
				'D',
				Blocks.dragon_egg,
				'h',
				new ItemStack(Items.skull, 1, 1),
				'|',
				Items.blaze_rod,
				'd',
				Items.diamond });
		
		CSItems.addItemWithRecipe(godSword, "God's Sword", 1, new Object[] {
				"gGg",
				"gGg",
				" b ",
				'g',
				Items.glowstone_dust,
				'G',
				Blocks.gold_block,
				'b',
				Items.stick });
		CSItems.addItemWithRecipe(godShovel, "God's Shovel", 1, new Object[] {
				"gGg",
				" b ",
				" b ",
				'g',
				Items.glowstone_dust,
				'G',
				Blocks.gold_block,
				'b',
				Items.stick });
		CSItems.addItemWithRecipe(godPick, "God's Pickaxe", 1, new Object[] {
				"GGG",
				"gbg",
				" b ",
				'g',
				Items.glowstone_dust,
				'G',
				Blocks.gold_block,
				'b',
				Items.stick });
		CSItems.addItemWithRecipe(godAxe, "God's Axe", 1, new Object[] {
				"GGg",
				"Gb ",
				"gb ",
				'g',
				Items.glowstone_dust,
				'G',
				Blocks.gold_block,
				'b',
				Items.stick });
		CSItems.addItemWithRecipe(godHoe, "God's Hoe", 1, new Object[] {
				"GGg",
				"gb ",
				" b ",
				'g',
				Items.glowstone_dust,
				'G',
				Blocks.gold_block,
				'b',
				Items.stick });
		
		CSItems.addItemWithRecipe(luziferSword, "Luzifers's Sword", 1, new Object[] {
				"rRr",
				"rRr",
				" b ",
				'r',
				Items.redstone,
				'R',
				Blocks.nether_brick,
				'b',
				Items.blaze_rod });
		CSItems.addItemWithRecipe(luziferShovel, "Luzifers's Shovel", 1, new Object[] {
				"rRr",
				" b ",
				" b ",
				'r',
				Items.redstone,
				'R',
				Blocks.nether_brick,
				'b',
				Items.blaze_rod });
		CSItems.addItemWithRecipe(luziferPick, "Luzifers's Pickaxe", 1, new Object[] {
				"RRR",
				"rbr",
				" b ",
				'r',
				Items.redstone,
				'R',
				Blocks.nether_brick,
				'b',
				Items.blaze_rod });
		CSItems.addItemWithRecipe(luziferAxe, "Luzifers's Axe", 1, new Object[] {
				"RRg",
				"Rb ",
				"rb ",
				'r',
				Items.redstone,
				'R',
				Blocks.nether_brick,
				'b',
				Items.blaze_rod });
		CSItems.addItemWithRecipe(luziferHoe, "Luzifers's Hoe", 1, new Object[] {
				"RRg",
				"rb ",
				" b ",
				'r',
				Items.redstone,
				'R',
				Blocks.nether_brick,
				'b',
				Items.blaze_rod });
		
		CSItems.addItemWithRecipe(lightsaberShaft, "Lightsaber Shaft", 1, new Object[] {
				"idi",
				"rGi",
				"iii",
				Character.valueOf('i'),
				Items.iron_ingot,
				'r',
				Items.diamond,
				'r',
				Items.redstone,
				'G',
				Blocks.glowstone });
		CSItems.addItem(lightsaberBlue, "Blue Lightsaber");
		CSItems.addItem(lightsaberGreen, "Green Lightsaber");
		CSItems.addItem(lightsaberPurple, "Purple Lightsaber");
		CSItems.addItem(lightsaberRed, "Red Lightsaber");
		CSItems.addItem(lightsaberWhite, "White Lightsaber");
		
		CSItems.addTool(emeraldSword, "Emerald Sword", emerald, 0);
		CSItems.addTool(emeraldShovel, "Emerald Shovel", emerald, 1);
		CSItems.addTool(emeraldPick, "Emerald Pickaxe", emerald, 2);
		CSItems.addTool(emeraldAxe, "Emerald Axe", emerald, 3);
		CSItems.addTool(emeraldHoe, "Emerald Hoe", emerald, 4);
		
		CSItems.addTool(netherstarSword, "Nether Star Sword", nether_star, 0);
		CSItems.addTool(netherstarShovel, "Nether Star Shovel", nether_star, 1);
		CSItems.addTool(netherstarPick, "Nether Star Pickaxe", nether_star, 2);
		CSItems.addTool(netherstarAxe, "Nether Star Axe", nether_star, 3);
		CSItems.addTool(netherstarHoe, "Nether Star Hoe", nether_star, 4);
		
		CSItems.addTool(potatoSword, "Potato Sword", potato, 0);
		CSItems.addTool(potatoShovel, "Potato Shovel", potato, 1);
		CSItems.addTool(potatoPick, "Potato Pickaxe", potato, 2);
		CSItems.addTool(potatoAxe, "Potato Axe", potato, 3);
		CSItems.addTool(potatoHoe, "Potato Hoe", potato, 4);
		
		CSItems.addTool(carrotSword, "Carrot Sword", carrot, 0);
		CSItems.addTool(carrotShovel, "Carrot Shovel", carrot, 1);
		CSItems.addTool(carrotPick, "Carrot Pickaxe", carrot, 2);
		CSItems.addTool(carrotAxe, "Carrot Axe", carrot, 3);
		CSItems.addTool(carrotHoe, "Carrot Hoe", carrot, 4);
		
		CSItems.addTool(fishSword, "Fish Sword", fish, 0);
		CSItems.addTool(fishShovel, "Fish Shovel", fish, 1);
		CSItems.addTool(fishPick, "Fish Pickaxe", fish, 2);
		CSItems.addTool(fishAxe, "Fish Axe", fish, 3);
		CSItems.addTool(fishHoe, "Fish Hoe", fish, 4);
		
		CSItems.addTool(baconSword, "Bacon Sword", porkchop, 0);
		CSItems.addTool(baconShovel, "Bacon Shovel", porkchop, 1);
		CSItems.addTool(baconPick, "Bacon Pickaxe", porkchop, 2);
		CSItems.addTool(baconAxe, "Bacon Axe", porkchop, 3);
		CSItems.addTool(baconHoe, "Bacon Hoe", porkchop, 4);
		
		CSItems.addTool(leatherPick, "Leather Pickaxe", leather, 0);
		CSItems.addTool(leatherShovel, "Leather Shovel", leather, 1);
		CSItems.addTool(leatherAxe, "Leather Axe", leather, 2);
		CSItems.addTool(leatherHoe, "Leather Hoe", leather, 3);
		CSItems.addTool(leatherSword, "Leather Sword", leather, 4);
		
		CSItems.addTool(glowstonePick, "Glowstone Pickaxe", glowstone, 0);
		CSItems.addTool(glowstoneShovel, "Glowstone Shovel", glowstone, 1);
		CSItems.addTool(glowstoneAxe, "Glowstone Axe", glowstone, 2);
		CSItems.addTool(glowstoneHoe, "Glowstone Hoe", glowstone, 3);
		CSItems.addTool(glowstoneSword, "Glowstone Sword", glowstone, 4);
		
		CSItems.addTool(slimePick, "Slime Pickaxe", slime, 0);
		CSItems.addTool(slimeShovel, "Slime Shovel", slime, 1);
		CSItems.addTool(slimeAxe, "Slime Axe", slime, 2);
		CSItems.addTool(slimeHoe, "Slime Hoe", slime, 3);
		CSItems.addTool(slimeSword, "Slime Sword", slime, 4);
		
		CSItems.addItemWithShapelessRecipe(spaceMultitool, "Space Multitool", 1, new Object[] {
				spacePick,
				spaceShovel,
				spaceAxe,
				spaceHoe,
				spaceSwordAdvanced });
		CSItems.addItemWithRecipe(spaceBow, "Space Bow", 1, new Object[] {
				"sS ",
				"s S",
				"sS ",
				'S',
				spaceIngot,
				's',
				Items.string });
		CSItems.addItemWithRecipe(spaceArrow, "Space Arrow", 4, new Object[] {
				"s",
				"|",
				"f",
				's',
				spaceIngot,
				'|',
				Items.stick,
				'f',
				Items.feather });
		CSItems.addItemWithRecipe(spaceIngot, "Space Ingot", 9, new Object[] {
				"s",
				's',
				space_2 });
		
		CSItems.addItemWithRecipe(blazerodAndSteel, "Blazerod and Steel", 1, new Object[] {
				"i ",
				" b",
				'i',
				Items.iron_ingot,
				'b',
				Items.blaze_rod });
		
		CSItems.addItemWithRecipe(goldShears, "Gold Shears", 1, new Object[] {
				"X ",
				" X",
				'X',
				Items.gold_ingot });
		CSItems.addItemWithRecipe(diamondShears, "Diamond Shears", 1, new Object[] {
				"X ",
				" X",
				'X',
				Items.diamond });
	}
	
	public void addBlocks()
	{
		CSBlocks.addBlock(spaceBlock, ItemCustomBlock.class, "Space Block");
		CSBlocks.addBlock(glowingBlock, ItemBlock.class, "Glowing Block");
		
		spaceBlock.setHarvestLevel("pickaxe", 2);
	}
}
