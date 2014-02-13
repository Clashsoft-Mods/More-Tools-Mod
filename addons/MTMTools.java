package clashsoft.mods.moretools.addons;

import clashsoft.cslib.minecraft.addon.Addon;
import clashsoft.cslib.minecraft.block.CSBlocks;
import clashsoft.cslib.minecraft.block.CustomBlock;
import clashsoft.cslib.minecraft.crafting.CSCrafting;
import clashsoft.cslib.minecraft.enchantment.CustomEnchantment;
import clashsoft.cslib.minecraft.item.CSItems;
import clashsoft.cslib.minecraft.item.CSStacks;
import clashsoft.cslib.minecraft.item.block.ItemCustomBlock;
import clashsoft.mods.moretools.MTMVersion;
import clashsoft.mods.moretools.MoreToolsMod;
import clashsoft.mods.moretools.block.BlockGlowing;
import clashsoft.mods.moretools.block.BlockSpaceblock;
import clashsoft.mods.moretools.crafting.RecipesToolDyes;
import clashsoft.mods.moretools.item.ItemLightsaber;
import clashsoft.mods.moretools.item.dyeable.*;
import clashsoft.mods.moretools.item.tools.*;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

@Addon(modName = MTMVersion.NAME, addonName = "Tools")
public class MTMTools implements CSStacks
{
	public static MTMTools		instance		= new MTMTools();
	
	public static ToolMaterial	OBSIDIAN		= EnumHelper.addToolMaterial("OBSIDIAN", 3, 4096, 25F, 10, 10);
	public static ToolMaterial	REDSTONE		= EnumHelper.addToolMaterial("REDSTONE", 2, 64, 6F, 2.5F, 15);
	public static ToolMaterial	COAL			= EnumHelper.addToolMaterial("COAL", 1, 128, 3F, 2.1F, 15);
	public static ToolMaterial	LAPIS			= EnumHelper.addToolMaterial("LAPIS", 2, 256, 3F, 2F, 15);
	public static ToolMaterial	END				= EnumHelper.addToolMaterial("END", 2, 512, 5F, 2.8F, 15);
	public static ToolMaterial	SPACE			= EnumHelper.addToolMaterial("SPACE1", 3, 4096, 30F, 10F, 12);
	public static ToolMaterial	SPACE_STRONG	= EnumHelper.addToolMaterial("SPACE2", 3, 6144, 40F, 12F, 14);
	public static ToolMaterial	SPACE_EPIC		= EnumHelper.addToolMaterial("SPACE3", 3, 8196, 50F, 14F, 16);
	public static ToolMaterial	BONE			= EnumHelper.addToolMaterial("BONE", 1, 32, 1.5F, 1.2F, 15);
	public static ToolMaterial	REED			= EnumHelper.addToolMaterial("REED", 0, 16, 0.5F, 0.2F, 15);
	public static ToolMaterial	BLAZEROD		= EnumHelper.addToolMaterial("BLAZEROD", 2, 512, 6F, 1.9F, 15);
	public static ToolMaterial	DIRT			= EnumHelper.addToolMaterial("DIRT", 0, 16, 0.8F, -0.1F, 15);
	public static ToolMaterial	GLASS			= EnumHelper.addToolMaterial("GLASS", 0, 16, 0.5F, 1.3F, 15);
	public static ToolMaterial	SANDSTONE		= EnumHelper.addToolMaterial("SANDSTONE", 1, 128, 3F, 1.8F, 15);
	public static ToolMaterial	BRICK			= EnumHelper.addToolMaterial("BRICK", 1, 128, 2.5F, 1.75F, 15);
	public static ToolMaterial	ENDSTONE		= EnumHelper.addToolMaterial("ENDSTONE", 2, 256, 3.5F, 2.9F, 15);
	public static ToolMaterial	EXCALIBUR		= EnumHelper.addToolMaterial("EXCALIBUR", 3, 16392, 10F, 20F, 1);
	public static ToolMaterial	GOD				= EnumHelper.addToolMaterial("GOD", 3, 2048, 5F, 15F, 10);
	public static ToolMaterial	LUZIFER			= EnumHelper.addToolMaterial("LUZIFER", 3, 2048, 5F, 15F, 10);
	public static ToolMaterial	LASER			= EnumHelper.addToolMaterial("LASER", 3, -1, 1F, 25F, 1);
	public static ToolMaterial	EMERALD			= EnumHelper.addToolMaterial("EMERALD2", 3, 1536, 8F, 2.95F, 17);
	public static ToolMaterial	NETHERSTAR		= EnumHelper.addToolMaterial("NETHERSTAR", 3, 2048, 12F, 4F, 20);
	public static ToolMaterial	POTATO			= EnumHelper.addToolMaterial("POTATO", 1, 64, 3F, 0.6F, 15);
	public static ToolMaterial	CARROT			= EnumHelper.addToolMaterial("CARROT", 1, 64, 3F, 0.6F, 15);
	public static ToolMaterial	FISH			= EnumHelper.addToolMaterial("FISH", 1, 64, 2.5F, 0.7F, 15);
	public static ToolMaterial	BACON			= EnumHelper.addToolMaterial("BACON", 1, 64, 2.5F, 0.7F, 15);
	public static ToolMaterial	LEATHER			= ToolMaterial.WOOD;
	public static ToolMaterial	GLOWSTONE		= EnumHelper.addToolMaterial("GLOWSTONE", 2, 64, 1F, 1F, 16);
	public static ToolMaterial	SLIME			= EnumHelper.addToolMaterial("SLIME", 1, 80, 1.2F, 0.85F, 15);
	
	public static Enchantment	quickDraw		= new CustomEnchantment(7, 1, 3, EnumEnchantmentType.bow, "quickdraw");
	
	public static CustomBlock	spaceBlock;
	public static BlockGlowing	glowingBlock;
	
	public static Item			excaliburSword;
	
	public static Item			godSword;
	public static Item			godShovel;
	public static Item			godPickaxe;
	public static Item			godAxe;
	public static Item			godHoe;
	
	public static Item			luziferSword;
	public static Item			luziferShovel;
	public static Item			luziferPickaxe;
	public static Item			luziferAxe;
	public static Item			luziferHoe;
	
	public static Item			leatherSword;
	public static Item			leatherShovel;
	public static Item			leatherPickaxe;
	public static Item			leatherAxe;
	public static Item			leatherHoe;
	
	public static Item			glowstoneSword;
	public static Item			glowstoneShovel;
	public static Item			glowstonePickaxe;
	public static Item			glowstoneAxe;
	public static Item			glowstoneHoe;
	
	public static Item			lightsaber;
	
	public static Item			spaceSword;
	public static Item			spaceSword1;
	public static Item			spaceSword2;
	public static Item			spaceShovel;
	public static Item			spacePickaxe;
	public static Item			spaceAxe;
	public static Item			spaceHoe;
	
	public static Item			spaceMultitool;
	public static Item			spaceBow;
	public static Item			spaceArrow;
	public static Item			spaceIngot;
	
	public static Item			blazerodAndSteel;
	
	public static Item			goldShears;
	public static Item			diamondShears;
	
	public static ItemStack		space;
	public static ItemStack		space_2;
	
	public void load(FMLPreInitializationEvent event)
	{
		this.init();
		this.load();
	}
	
	public void init()
	{
		String[] types = MoreToolsMod.toolTypes;
		ToolMaterial[] materials = MoreToolsMod.toolMaterials;
		String[] materialNames = MoreToolsMod.materialNames;
		ItemStack[] stacks = MoreToolsMod.stacks;
		
		for (int mat = 0; mat < materials.length; mat++)
		{
			for (int type = 0; type < types.length; type++)
			{
				ToolMaterial material = materials[mat];
				String materialName = materialNames[mat];
				ItemStack stack = stacks[mat];
				
				this.addTool(materialName, material, EnumRarity.common, stack, type);
			}
		}
		
		spaceSword = new ItemMTMSword(SPACE, EnumRarity.uncommon).setUnlocalizedName("space_sword").setTextureName("moretools:space_sword");
		spaceSword1 = new ItemMTMSword(SPACE_STRONG, EnumRarity.rare).setUnlocalizedName("space_sword_1").setTextureName("moretools:space_sword_1");
		spaceSword2 = new ItemMTMSword(SPACE_EPIC, EnumRarity.epic).setUnlocalizedName("space_sword_2").setTextureName("moretools:space_sword_2");
		spaceShovel = new ItemMTMShovel(SPACE, EnumRarity.uncommon).setUnlocalizedName("space_shovel").setTextureName("moretools:space_shovel");
		spacePickaxe = new ItemMTMPickaxe(SPACE, EnumRarity.uncommon).setUnlocalizedName("space_pickaxe").setTextureName("moretools:space_pickaxe");
		spaceAxe = new ItemMTMAxe(SPACE, EnumRarity.uncommon).setUnlocalizedName("space_axe").setTextureName("moretools:space_axe");
		spaceHoe = new ItemMTMHoe(SPACE, EnumRarity.uncommon).setUnlocalizedName("space_hoe").setTextureName("moretools:space_hoe");
		
		spaceMultitool = new ItemMultitool(SPACE, EnumRarity.uncommon).setUnlocalizedName("space_multitool").setTextureName("moretools:space_multitool");
		spaceArrow = new Item().setUnlocalizedName("space_arrow").setTextureName("moretools:space_arrow").setCreativeTab(CreativeTabs.tabCombat);
		spaceIngot = new Item().setUnlocalizedName("space_ingot").setTextureName("moretools:space_ingot").setCreativeTab(CreativeTabs.tabMaterials);
		spaceBow = new ItemMTMBow(spaceIngot).setUnlocalizedName("space_bow").setTextureName("moretools:space_bow");
		
		lightsaber = new ItemLightsaber(LASER).setUnlocalizedName("lightsaber").setTextureName("moretools:lightsaber");
		
		excaliburSword = new ItemMTMSword(EXCALIBUR, EnumRarity.epic).setUnlocalizedName("excalibur").setTextureName("moretools:excalibur");
		
		godSword = new ItemMTMSword(GOD, EnumRarity.rare).setUnlocalizedName("god_sword").setTextureName("moretools:god_sword");
		godShovel = new ItemMTMShovel(GOD, EnumRarity.rare).setUnlocalizedName("god_shovel").setTextureName("moretools:god_shovel");
		godPickaxe = new ItemMTMPickaxe(GOD, EnumRarity.rare).setUnlocalizedName("god_pickaxe").setTextureName("moretools:god_pickaxe");
		godAxe = new ItemMTMAxe(GOD, EnumRarity.rare).setUnlocalizedName("god_axe").setTextureName("moretools:god_axe");
		godHoe = new ItemMTMHoe(GOD, EnumRarity.rare).setUnlocalizedName("god_hoe").setTextureName("moretools:god_hoe");
		
		luziferSword = new ItemMTMSword(LUZIFER, EnumRarity.rare).setUnlocalizedName("luzifer_sword").setTextureName("moretools:luzifer_sword");
		luziferShovel = new ItemMTMShovel(LUZIFER, EnumRarity.rare).setUnlocalizedName("luzifer_shovel").setTextureName("moretools:luzifer_shovel");
		luziferPickaxe = new ItemMTMPickaxe(LUZIFER, EnumRarity.rare).setUnlocalizedName("luzifer_pickaxe").setTextureName("moretools:luzifer_pickaxe");
		luziferAxe = new ItemMTMAxe(LUZIFER, EnumRarity.rare).setUnlocalizedName("luzifer_axe").setTextureName("moretools:luzifer_axe");
		luziferHoe = new ItemMTMHoe(LUZIFER, EnumRarity.rare).setUnlocalizedName("luzifer_hoe").setTextureName("moretools:luzifer_hoe");
		
		leatherSword = new ItemDyeableSword(LEATHER).setUnlocalizedName("leather_sword").setTextureName("moretools:leather_sword");
		leatherShovel = new ItemDyeableShovel(LEATHER).setUnlocalizedName("leather_shovel").setTextureName("moretools:leather_shovel");
		leatherPickaxe = new ItemDyeablePickaxe(LEATHER).setUnlocalizedName("leather_pickaxe").setTextureName("moretools:leather_pickaxe");
		leatherAxe = new ItemDyeableAxe(LEATHER).setUnlocalizedName("leather_axe").setTextureName("moretools:leather_axe");
		leatherHoe = new ItemDyeableHoe(LEATHER).setUnlocalizedName("leather_hoe").setTextureName("moretools:leather_hoe");
		
		glowstoneSword = new ItemMTMSword(GLOWSTONE).setUnlocalizedName("glowstone_sword").setTextureName("moretools:glowstone_sword");
		glowstoneShovel = new ItemMTMShovel(GLOWSTONE).setUnlocalizedName("glowstone_shovel").setTextureName("moretools:glowstone_shovel");
		glowstonePickaxe = new ItemMTMPickaxe(GLOWSTONE).setUnlocalizedName("glowstone_pickaxe").setTextureName("moretools:glowstone_pickaxe");
		glowstoneAxe = new ItemMTMAxe(GLOWSTONE).setUnlocalizedName("glowstone_axe").setTextureName("moretools:glowstone_axe");
		glowstoneHoe = new ItemMTMHoe(GLOWSTONE).setUnlocalizedName("glowstone_hoe").setTextureName("moretools:glowstone_hoe");
		
		blazerodAndSteel = new ItemMTMFlintAndSteel(128).setUnlocalizedName("blazerod_and_steel").setTextureName("moretools:blazerod_and_steel");
		
		goldShears = new ItemMTMShears(128, 3).setUnlocalizedName("gold_shears").setTextureName("moretools:gold_shears");
		diamondShears = new ItemMTMShears(256, 5, EnumRarity.uncommon).setUnlocalizedName("diamond_shears").setTextureName("moretools:diamond_shears");
		
		// Blocks
		
		spaceBlock = (CustomBlock) (new BlockSpaceblock()).setBlockName("spaceblock").setHardness(3F);
		glowingBlock = (BlockGlowing) (new BlockGlowing()).setBlockName("glowing");
		
		spaceBlock.setHarvestLevel("pickaxe", 2);
		
		space = new ItemStack(spaceIngot);
		space_2 = new ItemStack(spaceBlock, 1, 1);
	}
	
	public void load()
	{
		CSItems.addTool(spaceSword, "space_sword_0", space, 0);
		CSItems.addTool(spaceSword1, "space_sword_1", space_2, 0);
		CSItems.addTool(spaceSword2, "space_sword_2", space_2, space, 0);
		CSItems.addTool(spaceShovel, "space_shovel", space, 1);
		CSItems.addTool(spacePickaxe, "space_pickaxe", space, 2);
		CSItems.addTool(spaceAxe, "space_axe", space, 3);
		CSItems.addTool(spaceHoe, "space_hoe", space, 4);
		
		CSItems.addItemWithShapelessRecipe(spaceMultitool, "space_multitool", 1, spacePickaxe, spaceShovel, spaceAxe, spaceHoe, spaceSword);
		CSItems.addItemWithRecipe(spaceBow, "space_bow", 1, "sS ", "s S", "sS ", 'S', spaceIngot, 's', Items.string);
		CSItems.addItemWithRecipe(spaceArrow, "space_arrow", 4, "s", "|", "f", 's', spaceIngot, '|', Items.stick, 'f', Items.feather);
		CSItems.addItemWithRecipe(spaceIngot, "space_ingot", 9, "s", 's', space_2);
		
		CSItems.addItemWithRecipe(lightsaber, "lightsaber", 1, "idi", "rGi", "iii", 'i', Items.iron_ingot, 'r', Items.diamond, 'r', Items.redstone, 'G', Blocks.glowstone);
		
		CSItems.addItemWithRecipe(excaliburSword, "excalibur", 1, "gNg", "hDh", "d|d", 'g', Items.ghast_tear, 'N', Items.nether_star, 'D', Blocks.dragon_egg, 'h', new ItemStack(Items.skull, 1, 1), '|', Items.blaze_rod, 'd', Items.diamond);
		
		CSItems.addItemWithRecipe(godSword, "god_sword", 1, "gGg", "gGg", " b ", 'g', Items.glowstone_dust, 'G', Blocks.gold_block, 'b', Items.stick);
		CSItems.addItemWithRecipe(godShovel, "god_shovel", 1, "gGg", " b ", " b ", 'g', Items.glowstone_dust, 'G', Blocks.gold_block, 'b', Items.stick);
		CSItems.addItemWithRecipe(godPickaxe, "god_pickaxe", 1, "GGG", "gbg", " b ", 'g', Items.glowstone_dust, 'G', Blocks.gold_block, 'b', Items.stick);
		CSItems.addItemWithRecipe(godAxe, "god_axe", 1, "GGg", "Gb ", "gb ", 'g', Items.glowstone_dust, 'G', Blocks.gold_block, 'b', Items.stick);
		CSItems.addItemWithRecipe(godHoe, "god_hoe", 1, "GGg", "gb ", " b ", 'g', Items.glowstone_dust, 'G', Blocks.gold_block, 'b', Items.stick);
		
		CSItems.addItemWithRecipe(luziferSword, "luzifer_sword", 1, "rRr", "rRr", " b ", 'r', Items.redstone, 'R', Blocks.nether_brick, 'b', Items.blaze_rod);
		CSItems.addItemWithRecipe(luziferShovel, "luzifer_shovel", 1, "rRr", " b ", " b ", 'r', Items.redstone, 'R', Blocks.nether_brick, 'b', Items.blaze_rod);
		CSItems.addItemWithRecipe(luziferPickaxe, "luzifer_pickaxe", 1, "RRR", "rbr", " b ", 'r', Items.redstone, 'R', Blocks.nether_brick, 'b', Items.blaze_rod);
		CSItems.addItemWithRecipe(luziferAxe, "luzifer_axe", 1, "RRg", "Rb ", "rb ", 'r', Items.redstone, 'R', Blocks.nether_brick, 'b', Items.blaze_rod);
		CSItems.addItemWithRecipe(luziferHoe, "luzifer_hoe", 1, "RRg", "rb ", " b ", 'r', Items.redstone, 'R', Blocks.nether_brick, 'b', Items.blaze_rod);
		
		CSItems.addTool(leatherSword, "leather_sword", CSStacks.leather, 0);
		CSItems.addTool(leatherShovel, "leather_shovel", CSStacks.leather, 1);
		CSItems.addTool(leatherPickaxe, "leather_pickaxe", CSStacks.leather, 2);
		CSItems.addTool(leatherAxe, "leather_axe", CSStacks.leather, 3);
		CSItems.addTool(leatherHoe, "leather_hoe", CSStacks.leather, 4);
		
		CSItems.addTool(glowstoneSword, "glowstone_sword", CSStacks.glowstone, 0);
		CSItems.addTool(glowstoneShovel, "glowstone_shovel", CSStacks.glowstone, 1);
		CSItems.addTool(glowstonePickaxe, "glowstone_pickaxe", CSStacks.glowstone, 2);
		CSItems.addTool(glowstoneAxe, "glowstone_axe", CSStacks.glowstone, 3);
		CSItems.addTool(glowstoneHoe, "glowstone_hoe", CSStacks.glowstone, 4);
		
		CSItems.addItemWithRecipe(blazerodAndSteel, "blazerod_and_steel", 1, "i ", " b", 'i', Items.iron_ingot, 'b', Items.blaze_rod);
		
		CSItems.addItemWithRecipe(goldShears, "gold_shears", 1, "X ", " X", 'X', Items.gold_ingot);
		CSItems.addItemWithRecipe(diamondShears, "diamond_shears", 1, "X ", " X", 'X', Items.diamond);
		
		// Blocks
		
		CSBlocks.addBlock(spaceBlock, ItemCustomBlock.class, "space_block");
		CSBlocks.addBlock(glowingBlock, ItemBlock.class, "glowing_block");
		
		// Recipes
		
		CSCrafting.addStorageBlock(new ItemStack(spaceIngot), new ItemStack(spaceBlock, 1, 1), 3);
		
		CSCrafting.addSmelting(new ItemStack(spaceBlock, 1, 0), new ItemStack(spaceIngot, 1), 0.5F);
		CSCrafting.registerRecipe(new RecipesToolDyes());
	}
	
	public Item addTool(String materialName, ToolMaterial material, EnumRarity rarity, ItemStack stack, int type)
	{
		Item item = null;
		String name = materialName + "_" + MoreToolsMod.toolTypes[type];
		
		if (type == 0) // Sword
		{
			item = new ItemMTMSword(material, rarity);
		}
		else if (type == 1) // Shovel
		{
			item = new ItemMTMShovel(material, rarity);
		}
		else if (type == 2) // Pickaxe
		{
			item = new ItemMTMPickaxe(material, rarity);
		}
		else if (type == 3) // Axe
		{
			item = new ItemMTMAxe(material, rarity);
		}
		else if (type == 4) // Hoe
		{
			item = new ItemMTMHoe(material, rarity);
		}
		else
		{
			return null;
		}
		
		item.setUnlocalizedName(name);
		item.setTextureName("moretools:" + name);
		
		CSItems.addTool(item, name, stack, type);
		
		return item;
	}
}
