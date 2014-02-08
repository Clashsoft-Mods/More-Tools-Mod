package clashsoft.mods.moretools.addons;

import clashsoft.cslib.addon.Addon;
import clashsoft.cslib.minecraft.util.CSItems;
import clashsoft.mods.moretools.client.MTMClientProxy;
import clashsoft.mods.moretools.item.armor.ItemArmorMTM;
import cpw.mods.fml.common.event.FMLInitializationEvent;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

@Addon(modName = "MoreToolsMod", addonName = "Armor")
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
	// public static EnumArmorMaterial EPIC =
	// EnumHelper.addArmorMaterial("EPIC", 4096, new int[] { 13, 18, 15, 10 },
	// 1);
	public static ArmorMaterial	INVISIBILITY	= EnumHelper.addArmorMaterial("INVISIBILITY", 24, new int[] { 2, 7, 5, 2 }, 10);
	public static ArmorMaterial	HALLOWED		= EnumHelper.addArmorMaterial("HALLOWED", 512, new int[] { 8, 10, 9, 5 }, 7);
	public static ArmorMaterial	GODDAWN			= EnumHelper.addArmorMaterial("GODDAWN", 512, new int[] { 8, 10, 9, 5 }, 7);
	public static ArmorMaterial	EMERALD			= EnumHelper.addArmorMaterial("EMERALD", 512, new int[] { 3, 8, 6, 3 }, 13);
	public static ArmorMaterial	NETHERSTAR		= EnumHelper.addArmorMaterial("NETHERSTAR", 512, new int[] { 11, 16, 14, 7 }, 20);
	public static ArmorMaterial	POTATO			= EnumHelper.addArmorMaterial("POTATO", 16, new int[] { 1, 3, 3, 2 }, 7);
	public static ArmorMaterial	CARROT			= POTATO;
	public static ArmorMaterial	FISH			= EnumHelper.addArmorMaterial("FISH", 16, new int[] { 1, 3, 2, 1 }, 7);
	public static ArmorMaterial	BACON			= FISH;
	public static ArmorMaterial	GLOWSTONE		= EnumHelper.addArmorMaterial("GLOWSTONE", 64, new int[] { 1, 1, 1, 1 }, 10);
	public static ArmorMaterial	SLIME			= EnumHelper.addArmorMaterial("SLIME", 80, new int[] { 1, 3, 2, 1 }, 7);
	
	// Items
	
	public static Item			obsidianHelmet;
	public static Item			obsidianChestplate;
	public static Item			obsidianLeggings;
	public static Item			obsidianBoots;																						;
	public static Item			redstoneHelmet;
	public static Item			redstoneChestplate;
	public static Item			redstoneLeggings;
	public static Item			redstoneBoots;																						;
	public static Item			coalHelmet;
	public static Item			coalChestplate;
	public static Item			coalLeggings;
	public static Item			coalBoots;																							;
	public static Item			lapisHelmet;
	public static Item			lapisChestplate;
	public static Item			lapisLeggings;
	public static Item			lapisBoots;																							;
	public static Item			enderHelmet;
	public static Item			enderChestplate;
	public static Item			enderLeggings;
	public static Item			enderBoots;																							;
	public static Item			spaceHelmet;
	public static Item			spaceChestplate;
	public static Item			spaceLeggings;
	public static Item			spaceBoots;																							;
	public static Item			boneHelmet;
	public static Item			boneChestplate;
	public static Item			boneLeggings;
	public static Item			boneBoots;																							;
	public static Item			sugarcaneHelmet;
	public static Item			sugarcaneChestplate;
	public static Item			sugarcaneLeggings;
	public static Item			sugarcaneBoots;																						;
	public static Item			blazerodHelmet;
	public static Item			blazerodChestplate;
	public static Item			blazerodLeggings;
	public static Item			blazerodBoots;																						;
	public static Item			dirtHelmet;
	public static Item			dirtChestplate;
	public static Item			dirtLeggings;
	public static Item			dirtBoots;																							;
	public static Item			glassHelmet;
	public static Item			glassChestplate;
	public static Item			glassLeggings;
	public static Item			glassBoots;																							;
	public static Item			sandstoneHelmet;
	public static Item			sandstoneChestplate;
	public static Item			sandstoneLeggings;
	public static Item			sandstoneBoots;																						;
	public static Item			brickHelmet;
	public static Item			brickChestplate;
	public static Item			brickLeggings;
	public static Item			brickBoots;																							;
	public static Item			endstoneHelmet;
	public static Item			endstoneChestplate;
	public static Item			endstoneLeggings;
	public static Item			endstoneBoots;																						;
	public static Item			godHelmet;
	public static Item			godChestplate;
	public static Item			godLeggings;
	public static Item			godBoots;																							;
	public static Item			luziferHelmet;
	public static Item			luziferChestplate;
	public static Item			luziferLeggings;
	public static Item			luziferBoots;																						;
	public static Item			invisibilityHelmet;
	public static Item			invisibilityChestplate;
	public static Item			invisibilityLeggings;
	public static Item			invisibilityBoots;																					;
	public static Item			emeraldHelmet;
	public static Item			emeraldChestplate;
	public static Item			emeraldLeggings;
	public static Item			emeraldBoots;																						;
	public static Item			netherstarHelmet;
	public static Item			netherstarChestplate;
	public static Item			netherstarLeggings;
	public static Item			netherstarBoots;																					;
	public static Item			potatoHelmet;
	public static Item			potatoChestplate;
	public static Item			potatoLeggings;
	public static Item			potatoBoots;																						;
	public static Item			carrotHelmet;
	public static Item			carrotChestplate;
	public static Item			carrotLeggings;
	public static Item			carrotBoots;																						;
	public static Item			fishHelmet;
	public static Item			fishChestplate;
	public static Item			fishLeggings;
	public static Item			fishBoots;																							;
	public static Item			baconHelmet;
	public static Item			baconChestplate;
	public static Item			baconLeggings;
	public static Item			baconBoots;																							;
	public static Item			glowstoneHelmet;
	public static Item			glowstoneChestplate;
	public static Item			glowstoneLeggings;
	public static Item			glowstoneBoots;																						;
	public static Item			slimeHelmet;
	public static Item			slimeChestplate;
	public static Item			slimeLeggings;
	public static Item			slimeBoots;
	
	public void load(FMLInitializationEvent event)
	{
		init();
		load();
	}
	
	private void init()
	{
		obsidianHelmet = (new ItemArmorMTM(OBSIDIAN, MTMClientProxy.obsidian, 0)).setUnlocalizedName("obsidianHelmet");
		obsidianChestplate = (new ItemArmorMTM(OBSIDIAN, MTMClientProxy.obsidian, 1)).setUnlocalizedName("obsidianChestplate");
		obsidianLeggings = (new ItemArmorMTM(OBSIDIAN, MTMClientProxy.obsidian, 2)).setUnlocalizedName("obsidianLeggings");
		obsidianBoots = (new ItemArmorMTM(OBSIDIAN, MTMClientProxy.obsidian, 3)).setUnlocalizedName("obsidianBoots");
		
		redstoneHelmet = (new ItemArmorMTM(REDSTONE, MTMClientProxy.redstone, 0)).setUnlocalizedName("redstoneHelmet");
		redstoneChestplate = (new ItemArmorMTM(REDSTONE, MTMClientProxy.redstone, 1)).setUnlocalizedName("redstoneChestplate");
		redstoneLeggings = (new ItemArmorMTM(REDSTONE, MTMClientProxy.redstone, 2)).setUnlocalizedName("redstoneLeggings");
		redstoneBoots = (new ItemArmorMTM(REDSTONE, MTMClientProxy.redstone, 3)).setUnlocalizedName("redstoneBoots");
		
		coalHelmet = (new ItemArmorMTM(COAL, MTMClientProxy.coal, 0)).setUnlocalizedName("coalHelmet");
		coalChestplate = (new ItemArmorMTM(COAL, MTMClientProxy.coal, 1)).setUnlocalizedName("coalChestplate");
		coalLeggings = (new ItemArmorMTM(COAL, MTMClientProxy.coal, 2)).setUnlocalizedName("coalLeggings");
		coalBoots = (new ItemArmorMTM(COAL, MTMClientProxy.coal, 3)).setUnlocalizedName("coalBoots");
		
		lapisHelmet = (new ItemArmorMTM(LAPIS, MTMClientProxy.lapis, 0)).setUnlocalizedName("lapisHelmet");
		lapisChestplate = (new ItemArmorMTM(LAPIS, MTMClientProxy.lapis, 1)).setUnlocalizedName("lapisChestplate");
		lapisLeggings = (new ItemArmorMTM(LAPIS, MTMClientProxy.lapis, 2)).setUnlocalizedName("lapisLeggings");
		lapisBoots = (new ItemArmorMTM(LAPIS, MTMClientProxy.lapis, 3)).setUnlocalizedName("lapisBoots");
		
		enderHelmet = (new ItemArmorMTM(END, MTMClientProxy.ender, 0)).setUnlocalizedName("enderHelmet");
		enderChestplate = (new ItemArmorMTM(END, MTMClientProxy.ender, 1)).setUnlocalizedName("enderChestplate");
		enderLeggings = (new ItemArmorMTM(END, MTMClientProxy.ender, 2)).setUnlocalizedName("enderLeggings");
		enderBoots = (new ItemArmorMTM(END, MTMClientProxy.ender, 3)).setUnlocalizedName("enderBoots");
		
		spaceHelmet = (new ItemArmorMTM(SPACE, MTMClientProxy.space, 0)).setUnlocalizedName("spaceHelmet");
		spaceChestplate = (new ItemArmorMTM(SPACE, MTMClientProxy.space, 1)).setUnlocalizedName("spaceChestplate");
		spaceLeggings = (new ItemArmorMTM(SPACE, MTMClientProxy.space, 2)).setUnlocalizedName("spaceLeggings");
		spaceBoots = (new ItemArmorMTM(SPACE, MTMClientProxy.space, 3)).setUnlocalizedName("spaceBoots");
		
		boneHelmet = (new ItemArmorMTM(BONE, MTMClientProxy.bone, 0)).setUnlocalizedName("boneHelmet");
		boneChestplate = (new ItemArmorMTM(BONE, MTMClientProxy.bone, 1)).setUnlocalizedName("boneChestplate");
		boneLeggings = (new ItemArmorMTM(BONE, MTMClientProxy.bone, 2)).setUnlocalizedName("boneLeggings");
		boneBoots = (new ItemArmorMTM(BONE, MTMClientProxy.bone, 3)).setUnlocalizedName("boneBoots");
		
		sugarcaneHelmet = (new ItemArmorMTM(REED, MTMClientProxy.sugarcane, 0)).setUnlocalizedName("sugarcaneHelmet");
		sugarcaneChestplate = (new ItemArmorMTM(REED, MTMClientProxy.sugarcane, 1)).setUnlocalizedName("sugarcaneChestplate");
		sugarcaneLeggings = (new ItemArmorMTM(REED, MTMClientProxy.sugarcane, 2)).setUnlocalizedName("sugarcaneLeggings");
		sugarcaneBoots = (new ItemArmorMTM(REED, MTMClientProxy.sugarcane, 3)).setUnlocalizedName("sugarcaneBoots");
		
		blazerodHelmet = (new ItemArmorMTM(BLAZEROD, MTMClientProxy.blazerod, 0)).setUnlocalizedName("blazeHelmet");
		blazerodChestplate = (new ItemArmorMTM(BLAZEROD, MTMClientProxy.blazerod, 1)).setUnlocalizedName("blazeChestplate");
		blazerodLeggings = (new ItemArmorMTM(BLAZEROD, MTMClientProxy.blazerod, 2)).setUnlocalizedName("blazeLeggings");
		blazerodBoots = (new ItemArmorMTM(BLAZEROD, MTMClientProxy.blazerod, 3)).setUnlocalizedName("blazeBoots");
		
		dirtHelmet = (new ItemArmorMTM(DIRT, MTMClientProxy.dirt, 0)).setUnlocalizedName("dirtHelmet");
		dirtChestplate = (new ItemArmorMTM(DIRT, MTMClientProxy.dirt, 1)).setUnlocalizedName("dirtChestplate");
		dirtLeggings = (new ItemArmorMTM(DIRT, MTMClientProxy.dirt, 2)).setUnlocalizedName("dirtLeggings");
		dirtBoots = (new ItemArmorMTM(DIRT, MTMClientProxy.dirt, 3)).setUnlocalizedName("dirtBoots");
		
		glassHelmet = (new ItemArmorMTM(GLASS, MTMClientProxy.glass, 0)).setUnlocalizedName("glassHelmet");
		glassChestplate = (new ItemArmorMTM(GLASS, MTMClientProxy.glass, 1)).setUnlocalizedName("glassChestplate");
		glassLeggings = (new ItemArmorMTM(GLASS, MTMClientProxy.glass, 2)).setUnlocalizedName("glassLeggings");
		glassBoots = (new ItemArmorMTM(GLASS, MTMClientProxy.glass, 3)).setUnlocalizedName("glassBoots");
		
		sandstoneHelmet = (new ItemArmorMTM(SANDSTONE, MTMClientProxy.sandstone, 0)).setUnlocalizedName("sandstoneHelmet");
		sandstoneChestplate = (new ItemArmorMTM(SANDSTONE, MTMClientProxy.sandstone, 1)).setUnlocalizedName("sandstoneChestplate");
		sandstoneLeggings = (new ItemArmorMTM(SANDSTONE, MTMClientProxy.sandstone, 2)).setUnlocalizedName("sandstoneLeggings");
		sandstoneBoots = (new ItemArmorMTM(SANDSTONE, MTMClientProxy.sandstone, 3)).setUnlocalizedName("sandstoneBoots");
		
		brickHelmet = (new ItemArmorMTM(BRICK, MTMClientProxy.brick, 0)).setUnlocalizedName("brickHelmet");
		brickChestplate = (new ItemArmorMTM(BRICK, MTMClientProxy.brick, 1)).setUnlocalizedName("brickChestplate");
		brickLeggings = (new ItemArmorMTM(BRICK, MTMClientProxy.brick, 2)).setUnlocalizedName("brickLeggings");
		brickBoots = (new ItemArmorMTM(BRICK, MTMClientProxy.brick, 3)).setUnlocalizedName("brickBoots");
		
		endstoneHelmet = (new ItemArmorMTM(ENDSTONE, MTMClientProxy.endstone, 0)).setUnlocalizedName("endstoneHelmet");
		endstoneChestplate = (new ItemArmorMTM(ENDSTONE, MTMClientProxy.endstone, 1)).setUnlocalizedName("endstoneChestplate");
		endstoneLeggings = (new ItemArmorMTM(ENDSTONE, MTMClientProxy.endstone, 2)).setUnlocalizedName("endstoneLeggings");
		endstoneBoots = (new ItemArmorMTM(ENDSTONE, MTMClientProxy.endstone, 3)).setUnlocalizedName("endstoneBoots");
		
		godHelmet = (new ItemArmorMTM(HALLOWED, MTMClientProxy.hallowed, 0)).setUnlocalizedName("godHelmet");
		godChestplate = (new ItemArmorMTM(HALLOWED, MTMClientProxy.hallowed, 1)).setUnlocalizedName("godChestplate");
		godLeggings = (new ItemArmorMTM(HALLOWED, MTMClientProxy.hallowed, 2)).setUnlocalizedName("godLeggings");
		godBoots = (new ItemArmorMTM(HALLOWED, MTMClientProxy.hallowed, 3)).setUnlocalizedName("godBoots");
		
		luziferHelmet = (new ItemArmorMTM(GODDAWN, MTMClientProxy.goddawn, 0)).setUnlocalizedName("luziferHelmet");
		luziferChestplate = (new ItemArmorMTM(GODDAWN, MTMClientProxy.goddawn, 1)).setUnlocalizedName("luziferChestplate");
		luziferLeggings = (new ItemArmorMTM(GODDAWN, MTMClientProxy.goddawn, 2)).setUnlocalizedName("luziferLeggings");
		luziferBoots = (new ItemArmorMTM(GODDAWN, MTMClientProxy.goddawn, 3)).setUnlocalizedName("luziferBoots");
		
		invisibilityHelmet = (new ItemArmorMTM(INVISIBILITY, MTMClientProxy.invisibility, 0)).setUnlocalizedName("invisibilityHelmet");
		invisibilityChestplate = (new ItemArmorMTM(INVISIBILITY, MTMClientProxy.invisibility, 1)).setUnlocalizedName("invisibilityChestplate");
		invisibilityLeggings = (new ItemArmorMTM(INVISIBILITY, MTMClientProxy.invisibility, 2)).setUnlocalizedName("invisibilityLeggings");
		invisibilityBoots = (new ItemArmorMTM(INVISIBILITY, MTMClientProxy.invisibility, 3)).setUnlocalizedName("invisibilityBoots");
		
		emeraldHelmet = (new ItemArmorMTM(EMERALD, MTMClientProxy.emerald, 0)).setUnlocalizedName("emeraldHelmet");
		emeraldChestplate = (new ItemArmorMTM(EMERALD, MTMClientProxy.emerald, 1)).setUnlocalizedName("emeraldChestplate");
		emeraldLeggings = (new ItemArmorMTM(EMERALD, MTMClientProxy.emerald, 2)).setUnlocalizedName("emeraldLeggings");
		emeraldBoots = (new ItemArmorMTM(EMERALD, MTMClientProxy.emerald, 3)).setUnlocalizedName("emeraldBoots");
		
		netherstarHelmet = (new ItemArmorMTM(NETHERSTAR, MTMClientProxy.netherstar, 0)).setUnlocalizedName("netherstarHelmet");
		netherstarChestplate = (new ItemArmorMTM(NETHERSTAR, MTMClientProxy.netherstar, 1)).setUnlocalizedName("netherstarChestplate");
		netherstarLeggings = (new ItemArmorMTM(NETHERSTAR, MTMClientProxy.netherstar, 2)).setUnlocalizedName("netherstarLeggings");
		netherstarBoots = (new ItemArmorMTM(NETHERSTAR, MTMClientProxy.netherstar, 3)).setUnlocalizedName("netherstarBoots");
		
		potatoHelmet = (new ItemArmorMTM(POTATO, MTMClientProxy.potato, 0)).setUnlocalizedName("potatoHelmet");
		potatoChestplate = (new ItemArmorMTM(POTATO, MTMClientProxy.potato, 1)).setUnlocalizedName("potatoChestplate");
		potatoLeggings = (new ItemArmorMTM(POTATO, MTMClientProxy.potato, 2)).setUnlocalizedName("potatoLeggings");
		potatoBoots = (new ItemArmorMTM(POTATO, MTMClientProxy.potato, 3)).setUnlocalizedName("potatoBoots");
		
		carrotHelmet = (new ItemArmorMTM(CARROT, MTMClientProxy.carrot, 0)).setUnlocalizedName("carrotHelmet");
		carrotChestplate = (new ItemArmorMTM(CARROT, MTMClientProxy.carrot, 1)).setUnlocalizedName("carrotChestplate");
		carrotLeggings = (new ItemArmorMTM(CARROT, MTMClientProxy.carrot, 2)).setUnlocalizedName("carrotLeggings");
		carrotBoots = (new ItemArmorMTM(CARROT, MTMClientProxy.carrot, 3)).setUnlocalizedName("carrotBoots");
		
		fishHelmet = (new ItemArmorMTM(FISH, MTMClientProxy.fish, 0)).setUnlocalizedName("fishHelmet");
		fishChestplate = (new ItemArmorMTM(FISH, MTMClientProxy.fish, 1)).setUnlocalizedName("fishChestplate");
		fishLeggings = (new ItemArmorMTM(FISH, MTMClientProxy.fish, 2)).setUnlocalizedName("fishLeggings");
		fishBoots = (new ItemArmorMTM(FISH, MTMClientProxy.fish, 3)).setUnlocalizedName("fishBoots");
		
		baconHelmet = (new ItemArmorMTM(BACON, MTMClientProxy.bacon, 0)).setUnlocalizedName("baconHelmet");
		baconChestplate = (new ItemArmorMTM(BACON, MTMClientProxy.bacon, 1)).setUnlocalizedName("baconChestplate");
		baconLeggings = (new ItemArmorMTM(BACON, MTMClientProxy.bacon, 2)).setUnlocalizedName("baconLeggings");
		baconBoots = (new ItemArmorMTM(BACON, MTMClientProxy.bacon, 3)).setUnlocalizedName("baconBoots");
		
		glowstoneHelmet = (new ItemArmorMTM(GLOWSTONE, MTMClientProxy.glowstone, 0)).setUnlocalizedName("glowstoneHelmet");
		glowstoneChestplate = (new ItemArmorMTM(GLOWSTONE, MTMClientProxy.glowstone, 1)).setUnlocalizedName("glowstoneChestplate");
		glowstoneLeggings = (new ItemArmorMTM(GLOWSTONE, MTMClientProxy.glowstone, 2)).setUnlocalizedName("glowstoneLeggings");
		glowstoneBoots = (new ItemArmorMTM(GLOWSTONE, MTMClientProxy.glowstone, 3)).setUnlocalizedName("glowstoneBoots");
		
		slimeHelmet = (new ItemArmorMTM(SLIME, MTMClientProxy.slime, 0)).setUnlocalizedName("slimeHelmet");
		slimeChestplate = (new ItemArmorMTM(SLIME, MTMClientProxy.slime, 1)).setUnlocalizedName("slimeChestplate");
		slimeLeggings = (new ItemArmorMTM(SLIME, MTMClientProxy.slime, 2)).setUnlocalizedName("slimeLeggings");
		slimeBoots = (new ItemArmorMTM(SLIME, MTMClientProxy.slime, 3)).setUnlocalizedName("slimeBoots");
	}
	
	private void load()
	{
		CSItems.addArmor(obsidianHelmet, "Obsidian Helmet", MTMTools.obsidian, 0);
		CSItems.addArmor(obsidianChestplate, "Obsidian Chestplate", MTMTools.obsidian, 1);
		CSItems.addArmor(obsidianLeggings, "Obsidian Leggings", MTMTools.obsidian, 2);
		CSItems.addArmor(obsidianBoots, "Obsidian Boots", MTMTools.obsidian, 3);
		
		CSItems.addArmor(redstoneHelmet, "Redstone Helmet", MTMTools.redstone_block, 0);
		CSItems.addArmor(redstoneChestplate, "Redstone Chestplate", MTMTools.redstone_block, 1);
		CSItems.addArmor(redstoneLeggings, "Redstone Leggings", MTMTools.redstone_block, 2);
		CSItems.addArmor(redstoneBoots, "Redstone Boots", MTMTools.redstone_block, 3);
		
		CSItems.addArmor(coalHelmet, "Coal Helmet", MTMTools.coal, 0);
		CSItems.addArmor(coalChestplate, "Coal Chestplate", MTMTools.coal, 1);
		CSItems.addArmor(coalLeggings, "Coal Leggings", MTMTools.coal, 2);
		CSItems.addArmor(coalBoots, "Coal Boots", MTMTools.coal, 3);
		
		CSItems.addArmor(lapisHelmet, "Lapis Helmet", MTMTools.lapis_block, 0);
		CSItems.addArmor(lapisChestplate, "Lapis Chestplate", MTMTools.lapis_block, 1);
		CSItems.addArmor(lapisLeggings, "Lapis Leggings", MTMTools.lapis_block, 2);
		CSItems.addArmor(lapisBoots, "Lapis Boots", MTMTools.lapis_block, 3);
		
		CSItems.addArmor(enderHelmet, "Ender Helmet", MTMTools.ender_pearl, 0);
		CSItems.addArmor(enderChestplate, "Ender Chestplate", MTMTools.ender_pearl, 1);
		CSItems.addArmor(enderLeggings, "Ender Leggings", MTMTools.ender_pearl, 2);
		CSItems.addArmor(enderBoots, "Ender Boots", MTMTools.ender_pearl, 3);
		
		CSItems.addArmor(spaceHelmet, "Space Helmet", MTMTools.space, 0);
		CSItems.addArmor(spaceChestplate, "Space Chestplate", MTMTools.space, 1);
		CSItems.addArmor(spaceLeggings, "Space Leggings", MTMTools.space, 2);
		CSItems.addArmor(spaceBoots, "Space Boots", MTMTools.space, 3);
		
		CSItems.addArmor(boneHelmet, "Bone Helmet", MTMTools.bone, 0);
		CSItems.addArmor(boneChestplate, "Bone Chestplate", MTMTools.bone, 1);
		CSItems.addArmor(boneLeggings, "Bone Leggings", MTMTools.bone, 2);
		CSItems.addArmor(boneBoots, "Bone Boots", MTMTools.bone, 3);
		
		CSItems.addArmor(sugarcaneHelmet, "Sugarcane Helmet", MTMTools.reeds, 0);
		CSItems.addArmor(sugarcaneChestplate, "Sugarcane Chestplate", MTMTools.reeds, 1);
		CSItems.addArmor(sugarcaneLeggings, "Sugarcane Leggings", MTMTools.reeds, 2);
		CSItems.addArmor(sugarcaneBoots, "Sugarcane Boots", MTMTools.reeds, 3);
		
		CSItems.addArmor(blazerodHelmet, "Blaze Helmet", MTMTools.blaze_rod, 0);
		CSItems.addArmor(blazerodChestplate, "Blaze Chestplate", MTMTools.blaze_rod, 1);
		CSItems.addArmor(blazerodLeggings, "Blaze Leggings", MTMTools.blaze_rod, 2);
		CSItems.addArmor(blazerodBoots, "Blaze Boots", MTMTools.blaze_rod, 3);
		
		CSItems.addArmor(dirtHelmet, "Dirt Helmet", MTMTools.dirt, 0);
		CSItems.addArmor(dirtChestplate, "Dirt Chestplate", MTMTools.dirt, 1);
		CSItems.addArmor(dirtLeggings, "Dirt Leggings", MTMTools.dirt, 2);
		CSItems.addArmor(dirtBoots, "Dirt Boots", MTMTools.dirt, 3);
		
		CSItems.addArmor(glassHelmet, "Glass Helmet", MTMTools.glass, 0);
		CSItems.addArmor(glassChestplate, "Glass Chestplate", MTMTools.glass, 1);
		CSItems.addArmor(glassLeggings, "Glass Leggings", MTMTools.glass, 2);
		CSItems.addArmor(glassBoots, "Glass Boots", MTMTools.glass, 3);
		
		CSItems.addArmor(sandstoneHelmet, "Sandstone Helmet", MTMTools.sandstone, 0);
		CSItems.addArmor(sandstoneChestplate, "Sandstone Chestplate", MTMTools.sandstone, 1);
		CSItems.addArmor(sandstoneLeggings, "Sandstone Leggings", MTMTools.sandstone, 2);
		CSItems.addArmor(sandstoneBoots, "Sandstone Boots", MTMTools.sandstone, 3);
		
		CSItems.addArmor(brickHelmet, "Brick Helmet", MTMTools.brick, 0);
		CSItems.addArmor(brickChestplate, "Brick Chestplate", MTMTools.brick, 1);
		CSItems.addArmor(brickLeggings, "Brick Leggings", MTMTools.brick, 2);
		CSItems.addArmor(brickBoots, "Brick Boots", MTMTools.brick, 3);
		
		CSItems.addArmor(endstoneHelmet, "Endstone Helmet", MTMTools.end_stone, 0);
		CSItems.addArmor(endstoneChestplate, "Endstone Chestplate", MTMTools.end_stone, 1);
		CSItems.addArmor(endstoneLeggings, "Endstone Leggings", MTMTools.end_stone, 2);
		CSItems.addArmor(endstoneBoots, "Endstone Boots", MTMTools.end_stone, 3);
		
		CSItems.addItemWithRecipe(godHelmet, "God's Helmet", 1, new Object[] { "GGG", "GgG", 'G', Blocks.gold_block, 'g', Items.glowstone_dust });
		CSItems.addItemWithRecipe(godChestplate, "God's Chestplate", 1, new Object[] { "GgG", "GGG", "GGG", 'G', Blocks.gold_block, 'g', Items.glowstone_dust });
		CSItems.addItemWithRecipe(godLeggings, "God's Leggings", 1, new Object[] { "GGG", "GgG", "GgG", 'G', Blocks.gold_block, 'g', Items.glowstone_dust });
		CSItems.addItemWithRecipe(godBoots, "God's Boots", 1, new Object[] { "g g", "GgG", "GgG", 'G', Blocks.gold_block, 'g', Items.glowstone_dust });
		
		CSItems.addItemWithRecipe(luziferHelmet, "Luzifer's Helmet", 1, new Object[] { "RRR", "RrR", 'R', Blocks.nether_brick, 'r', Items.redstone });
		CSItems.addItemWithRecipe(luziferChestplate, "Luzifer's Chestplate", 1, new Object[] { "RrR", "RRR", "RRR", 'R', Blocks.nether_brick, 'r', Items.redstone });
		CSItems.addItemWithRecipe(luziferLeggings, "Luzifer's Leggings", 1, new Object[] { "RRR", "RrR", "RrR", 'R', Blocks.nether_brick, 'r', Items.redstone });
		CSItems.addItemWithRecipe(luziferBoots, "Luzifer's Boots", 1, new Object[] { "r r", "RrR", "RrR", 'R', Blocks.nether_brick, 'r', Items.redstone });
		
		CSItems.addItemWithRecipe(invisibilityHelmet, "Invisibility Helmet", 1, new Object[] { "idi", "i i", 'i', Items.iron_ingot, 'd', Items.diamond });
		CSItems.addItemWithRecipe(invisibilityChestplate, "Invisibility Chestplate", 1, new Object[] { "i i", "idi", "iii", 'i', Items.iron_ingot, 'd', Items.diamond });
		CSItems.addItemWithRecipe(invisibilityLeggings, "Invisibility Leggings", 1, new Object[] { "idi", "i i", "i i", 'i', Items.iron_ingot, 'd', Items.diamond });
		CSItems.addItemWithRecipe(invisibilityBoots, "Invisibility Boots", 1, new Object[] { "d d", "i i", 'i', Items.iron_ingot, 'd', Items.diamond });
		
		CSItems.addArmor(emeraldHelmet, "Emerald Helmet", MTMTools.emerald, 0);
		CSItems.addArmor(emeraldChestplate, "Emerald Chestplate", MTMTools.emerald, 1);
		CSItems.addArmor(emeraldLeggings, "Emerald Leggings", MTMTools.emerald, 2);
		CSItems.addArmor(emeraldBoots, "Emerald Boots", MTMTools.emerald, 3);
		
		CSItems.addArmor(netherstarHelmet, "Nether Star Helmet", MTMTools.nether_star, 0);
		CSItems.addArmor(netherstarChestplate, "Nether Star Chestplate", MTMTools.nether_star, 1);
		CSItems.addArmor(netherstarLeggings, "Nether Star Leggings", MTMTools.nether_star, 2);
		CSItems.addArmor(netherstarBoots, "Nether Star Boots", MTMTools.nether_star, 3);
		
		CSItems.addArmor(potatoHelmet, "Potato Helmet", MTMTools.potato, 0);
		CSItems.addArmor(potatoChestplate, "Potato Chestplate", MTMTools.potato, 1);
		CSItems.addArmor(potatoLeggings, "Potato Leggings", MTMTools.potato, 2);
		CSItems.addArmor(potatoBoots, "Potato Boots", MTMTools.potato, 3);
		
		CSItems.addArmor(carrotHelmet, "Carrot Helmet", MTMTools.carrot, 0);
		CSItems.addArmor(carrotChestplate, "Carrot Chestplate", MTMTools.carrot, 1);
		CSItems.addArmor(carrotLeggings, "Carrot Leggings", MTMTools.carrot, 2);
		CSItems.addArmor(carrotBoots, "Carrot Boots", MTMTools.carrot, 3);
		
		CSItems.addArmor(fishHelmet, "Fishscale Helmet", MTMTools.fish, 0);
		CSItems.addArmor(fishChestplate, "Fishscale Chestplate", MTMTools.fish, 1);
		CSItems.addArmor(fishLeggings, "Fishscale Leggings", MTMTools.fish, 2);
		CSItems.addArmor(fishBoots, "Fishscale Boots", MTMTools.fish, 3);
		
		CSItems.addArmor(baconHelmet, "Bacon Helmet", MTMTools.porkchop, 0);
		CSItems.addArmor(baconChestplate, "Bacon Chestplate", MTMTools.porkchop, 1);
		CSItems.addArmor(baconLeggings, "Bacon Leggings", MTMTools.porkchop, 2);
		CSItems.addArmor(baconBoots, "Bacon Boots", MTMTools.porkchop, 3);
		
		CSItems.addArmor(glowstoneHelmet, "Glowstone Helmet", MTMTools.glowstone, 0);
		CSItems.addArmor(glowstoneChestplate, "Glowstone Chestplate", MTMTools.glowstone, 1);
		CSItems.addArmor(glowstoneLeggings, "Glowstone Leggings", MTMTools.glowstone, 2);
		CSItems.addArmor(glowstoneBoots, "Glowstone Boots", MTMTools.glowstone, 3);
		
		CSItems.addArmor(slimeHelmet, "Slime Helmet", MTMTools.glowstone_dust, 0);
		CSItems.addArmor(slimeChestplate, "Slime Chestplate", MTMTools.glowstone_dust, 1);
		CSItems.addArmor(slimeLeggings, "Slime Leggings", MTMTools.glowstone_dust, 2);
		CSItems.addArmor(slimeBoots, "Slime Boots", MTMTools.glowstone_dust, 3);
	}
}
