package clashsoft.mods.moretools.addons;

import clashsoft.cslib.minecraft.item.CSItems;
import clashsoft.cslib.minecraft.item.CSStacks;
import clashsoft.mods.moretools.MoreToolsMod;
import clashsoft.mods.moretools.client.MTMClientProxy;
import clashsoft.mods.moretools.item.ItemGlowstoneArmor;
import clashsoft.mods.moretools.item.ItemInvisibilityArmor;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class MTMArmor
{
	public static MTMArmor		instance		= new MTMArmor();
	
	// Armor Materials
	
	public static ArmorMaterial	OBSIDIAN		= EnumHelper.addArmorMaterial("OBSIDIAN", 2048, new int[] { 10, 15, 13, 6 }, 7);
	public static ArmorMaterial	REDSTONE		= EnumHelper.addArmorMaterial("REDSTONE", 100, new int[] { 1, 4, 3, 2 }, 10);
	public static ArmorMaterial	COAL			= EnumHelper.addArmorMaterial("COAL", 128, new int[] { 1, 5, 3, 2 }, 10);
	public static ArmorMaterial	LAPIS			= EnumHelper.addArmorMaterial("LAPIS", 128, new int[] { 1, 5, 3, 2 }, 10);
	public static ArmorMaterial	END				= EnumHelper.addArmorMaterial("END", 1024, new int[] { 3, 8, 7, 6 }, 10);
	public static ArmorMaterial	SPACE			= EnumHelper.addArmorMaterial("SPACE", 700, new int[] { 7, 10, 9, 8 }, 15);
	public static ArmorMaterial	BONE			= EnumHelper.addArmorMaterial("BONE", 24, new int[] { 1, 5, 3, 2 }, 10);
	public static ArmorMaterial	REED			= EnumHelper.addArmorMaterial("REED", 16, new int[] { 1, 5, 3, 2 }, 10);
	public static ArmorMaterial	BLAZEROD		= EnumHelper.addArmorMaterial("BLAZEROD", 64, new int[] { 4, 10, 7, 3 }, 10);
	public static ArmorMaterial	DIRT			= EnumHelper.addArmorMaterial("DIRT", 16, new int[] { 1, 1, 1, 1 }, 10);
	public static ArmorMaterial	GLASS			= EnumHelper.addArmorMaterial("GLASS", 16, new int[] { 1, 1, 1, 1 }, 10);
	public static ArmorMaterial	SANDSTONE		= EnumHelper.addArmorMaterial("SANDSTONE", 64, new int[] { 2, 4, 3, 2 }, 10);
	public static ArmorMaterial	BRICK			= EnumHelper.addArmorMaterial("BRICK", 32, new int[] { 2, 4, 3, 2 }, 10);
	public static ArmorMaterial	ENDSTONE		= EnumHelper.addArmorMaterial("ENDSTONE", 100, new int[] { 3, 5, 4, 2 }, 10);
	
	public static ArmorMaterial	EPIC			= EnumHelper.addArmorMaterial("EPIC", 4096, new int[] { 13, 18, 15, 10 }, 1);
	
	public static ArmorMaterial	INVISIBILITY	= EnumHelper.addArmorMaterial("INVISIBILITY", 24, new int[] { 2, 7, 5, 2 }, 10);
	public static ArmorMaterial	GOD				= EnumHelper.addArmorMaterial("HALLOWED", 512, new int[] { 8, 10, 9, 5 }, 7);
	public static ArmorMaterial	LUZIFER			= EnumHelper.addArmorMaterial("GODDAWN", 512, new int[] { 8, 10, 9, 5 }, 7);
	public static ArmorMaterial	EMERALD			= EnumHelper.addArmorMaterial("EMERALD", 512, new int[] { 3, 8, 6, 3 }, 13);
	public static ArmorMaterial	NETHERSTAR		= EnumHelper.addArmorMaterial("NETHERSTAR", 512, new int[] { 11, 16, 14, 7 }, 20);
	public static ArmorMaterial	POTATO			= EnumHelper.addArmorMaterial("POTATO", 16, new int[] { 1, 3, 3, 2 }, 7);
	public static ArmorMaterial	CARROT			= POTATO;
	public static ArmorMaterial	FISH			= EnumHelper.addArmorMaterial("FISH", 16, new int[] { 1, 3, 2, 1 }, 7);
	public static ArmorMaterial	BACON			= FISH;
	public static ArmorMaterial	GLOWSTONE		= EnumHelper.addArmorMaterial("GLOWSTONE", 64, new int[] { 1, 1, 1, 1 }, 10);
	public static ArmorMaterial	SLIME			= EnumHelper.addArmorMaterial("SLIME", 80, new int[] { 1, 3, 2, 1 }, 7);
	
	public static Item			spaceHelmet;
	public static Item			spaceChestplate;
	public static Item			spaceLeggings;
	public static Item			spaceBoots;
	
	public static Item			godHelmet;
	public static Item			godChestplate;
	public static Item			godLeggings;
	public static Item			godBoots;
	
	public static Item			luziferHelmet;
	public static Item			luziferChestplate;
	public static Item			luziferLeggings;
	public static Item			luziferBoots;
	
	public static Item			glowstoneHelmet;
	public static Item			glowstoneChestplate;
	public static Item			glowstoneLeggings;
	public static Item			glowstoneBoots;
	
	public static Item			invisibilityHelmet;
	public static Item			invisibilityChestplate;
	public static Item			invisibilityLeggings;
	public static Item			invisibilityBoots;
	
	public void load(FMLPreInitializationEvent event)
	{
		this.init();
		this.load();
	}
	
	private void init()
	{
		String[] types = MoreToolsMod.armorTypes;
		ArmorMaterial[] materials = MoreToolsMod.armorMaterials;
		String[] materialNames = MoreToolsMod.materialNames;
		ItemStack[] stacks = MoreToolsMod.stacks;
		
		for (int mat = 0; mat < materials.length; mat++)
		{
			for (int type = 0; type < types.length; type++)
			{
				ArmorMaterial material = materials[mat];
				String materialName = materialNames[mat];
				ItemStack stack = stacks[mat];
				
				this.addArmor(materialName, material, stack, type);
			}
		}
		
		spaceHelmet = new ItemArmor(SPACE, MTMClientProxy.space, 0).setUnlocalizedName("space_helmet").setTextureName("moretools:space_helmet");
		spaceChestplate = new ItemArmor(SPACE, MTMClientProxy.space, 1).setUnlocalizedName("space_chestplate").setTextureName("moretools:space_chestplate");
		spaceLeggings = new ItemArmor(SPACE, MTMClientProxy.space, 2).setUnlocalizedName("space_leggings").setTextureName("moretools:space_leggings");
		spaceBoots = new ItemArmor(SPACE, MTMClientProxy.space, 3).setUnlocalizedName("space_boots").setTextureName("moretools:space_boots");
		
		godHelmet = new ItemArmor(GOD, MTMClientProxy.god, 0).setUnlocalizedName("god_helmet").setTextureName("moretools:god_helmet");
		godChestplate = new ItemArmor(GOD, MTMClientProxy.god, 1).setUnlocalizedName("god_chestplate").setTextureName("moretools:god_chestplate");
		godLeggings = new ItemArmor(GOD, MTMClientProxy.god, 2).setUnlocalizedName("god_leggings").setTextureName("moretools:god_leggings");
		godBoots = new ItemArmor(GOD, MTMClientProxy.god, 3).setUnlocalizedName("god_boots").setTextureName("moretools:god_boots");
		
		luziferHelmet = new ItemArmor(LUZIFER, MTMClientProxy.luzifer, 0).setUnlocalizedName("luzifer_helmet").setTextureName("moretools:luzifer_helmet");
		luziferChestplate = new ItemArmor(LUZIFER, MTMClientProxy.luzifer, 1).setUnlocalizedName("luzifer_chestplate").setTextureName("moretools:luzifer_chestplate");
		luziferLeggings = new ItemArmor(LUZIFER, MTMClientProxy.luzifer, 2).setUnlocalizedName("luzifer_leggings").setTextureName("moretools:luzifer_leggings");
		luziferBoots = new ItemArmor(LUZIFER, MTMClientProxy.luzifer, 3).setUnlocalizedName("luzifer_boots").setTextureName("moretools:luzifer_boots");
		
		invisibilityHelmet = new ItemInvisibilityArmor(INVISIBILITY, MTMClientProxy.invisibility, 0).setUnlocalizedName("invisibility_helmet").setTextureName("moretools:invisibility_helmet");
		invisibilityChestplate = new ItemInvisibilityArmor(INVISIBILITY, MTMClientProxy.invisibility, 1).setUnlocalizedName("invisibility_chestplate").setTextureName("moretools:invisibility_chestplate");
		invisibilityLeggings = new ItemInvisibilityArmor(INVISIBILITY, MTMClientProxy.invisibility, 2).setUnlocalizedName("invisibility_leggings").setTextureName("moretools:invisibility_leggings");
		invisibilityBoots = new ItemInvisibilityArmor(INVISIBILITY, MTMClientProxy.invisibility, 3).setUnlocalizedName("invisibility_boots").setTextureName("moretools:invisibility_boots");
		
		glowstoneHelmet = new ItemGlowstoneArmor(GLOWSTONE, MTMClientProxy.glowstone, 0).setUnlocalizedName("glowstone_helmet").setTextureName("moretools:glowstone_helmet");
		glowstoneChestplate = new ItemGlowstoneArmor(GLOWSTONE, MTMClientProxy.glowstone, 1).setUnlocalizedName("glowstone_chestplate").setTextureName("moretools:glowstone_chestplate");
		glowstoneLeggings = new ItemGlowstoneArmor(GLOWSTONE, MTMClientProxy.glowstone, 2).setUnlocalizedName("glowstone_leggings").setTextureName("moretools:glowstone_leggings");
		glowstoneBoots = new ItemGlowstoneArmor(GLOWSTONE, MTMClientProxy.glowstone, 3).setUnlocalizedName("glowstone_boots").setTextureName("moretools:glowstone_boots");
	}
	
	private void load()
	{
		CSItems.addArmor(spaceHelmet, "space_helmet", MTMTools.space, 0);
		CSItems.addArmor(spaceChestplate, "space_chestplate", MTMTools.space, 1);
		CSItems.addArmor(spaceLeggings, "space_leggings", MTMTools.space, 2);
		CSItems.addArmor(spaceBoots, "space_boots", MTMTools.space, 3);
		
		CSItems.addItemWithRecipe(godHelmet, "god_helmet", 1, "GGG", "GgG", 'G', Blocks.gold_block, 'g', Items.glowstone_dust);
		CSItems.addItemWithRecipe(godChestplate, "god_chestplate", 1, "GgG", "GGG", "GGG", 'G', Blocks.gold_block, 'g', Items.glowstone_dust);
		CSItems.addItemWithRecipe(godLeggings, "god_leggings", 1, "GGG", "GgG", "GgG", 'G', Blocks.gold_block, 'g', Items.glowstone_dust);
		CSItems.addItemWithRecipe(godBoots, "god_boots", 1, "g g", "GgG", "GgG", 'G', Blocks.gold_block, 'g', Items.glowstone_dust);
		
		CSItems.addItemWithRecipe(luziferHelmet, "luzifer_helmet", 1, "RRR", "RrR", 'R', Blocks.nether_brick, 'r', Items.redstone);
		CSItems.addItemWithRecipe(luziferChestplate, "luzifer_chestplate", 1, "RrR", "RRR", "RRR", 'R', Blocks.nether_brick, 'r', Items.redstone);
		CSItems.addItemWithRecipe(luziferLeggings, "luzifer_leggings", 1, "RRR", "RrR", "RrR", 'R', Blocks.nether_brick, 'r', Items.redstone);
		CSItems.addItemWithRecipe(luziferBoots, "luzifer_boots", 1, "r r", "RrR", "RrR", 'R', Blocks.nether_brick, 'r', Items.redstone);
		
		CSItems.addItemWithRecipe(invisibilityHelmet, "invisibility_helmet", 1, "idi", "i i", 'i', Items.iron_ingot, 'd', Items.diamond);
		CSItems.addItemWithRecipe(invisibilityChestplate, "invisibility_chestplate", 1, "i i", "idi", "iii", 'i', Items.iron_ingot, 'd', Items.diamond);
		CSItems.addItemWithRecipe(invisibilityLeggings, "invisibility_leggings", 1, "idi", "i i", "i i", 'i', Items.iron_ingot, 'd', Items.diamond);
		CSItems.addItemWithRecipe(invisibilityBoots, "invisibility_boots", 1, "d d", "i i", 'i', Items.iron_ingot, 'd', Items.diamond);
		
		CSItems.addArmor(glowstoneHelmet, "glowstone_helmet", CSStacks.glowstone, 0);
		CSItems.addArmor(glowstoneChestplate, "glowstone_chestplate", CSStacks.glowstone, 1);
		CSItems.addArmor(glowstoneLeggings, "glowstone_leggings", CSStacks.glowstone, 2);
		CSItems.addArmor(glowstoneBoots, "glowstone_boots", CSStacks.glowstone, 3);
	}
	
	public Item addArmor(String materialName, ArmorMaterial material, ItemStack stack, int type)
	{
		String name = materialName + "_" + MoreToolsMod.armorTypes[type];
		
		Item item = new ItemArmor(material, MoreToolsMod.proxy.getArmorIndex(materialName), type);
		
		item.setUnlocalizedName(name);
		item.setTextureName("moretools:" + name);
		
		CSItems.addArmor(item, name, stack, type);
		
		return item;
	}
}
