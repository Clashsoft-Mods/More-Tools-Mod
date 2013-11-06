package clashsoft.mods.moretools.addons;

import clashsoft.clashsoftapi.util.CSCrafting;
import clashsoft.clashsoftapi.util.CSItems;
import clashsoft.clashsoftapi.util.addons.Addon;
import clashsoft.mods.moretools.MoreToolsMod;
import clashsoft.mods.moretools.client.MTMClientProxy;
import clashsoft.mods.moretools.item.armor.ItemArmorMTM;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;

@Addon(modName = "MoreToolsMod", addonName = "Armor")
public class MTMArmor
{
	public static MTMArmor			instance				= new MTMArmor();
	
	// Armor Materials
	
	public static EnumArmorMaterial	OBSIDIAN				= EnumHelper.addArmorMaterial("OBSIDIAN", 2048, new int[] { 10, 15, 13, 6 }, 7);
	public static EnumArmorMaterial	REDSTONE				= EnumHelper.addArmorMaterial("REDSTONE", 100, new int[] { 1, 4, 3, 2 }, 10);
	public static EnumArmorMaterial	COAL					= EnumHelper.addArmorMaterial("COAL", 128, new int[] { 1, 5, 3, 2 }, 10);
	public static EnumArmorMaterial	LAPIS					= EnumHelper.addArmorMaterial("LAPIS", 128, new int[] { 1, 5, 3, 2 }, 10);
	public static EnumArmorMaterial	END						= EnumHelper.addArmorMaterial("END", 1024, new int[] { 3, 8, 7, 6 }, 10);
	public static EnumArmorMaterial	SPACE					= EnumHelper.addArmorMaterial("SPACE", 700, new int[] { 7, 10, 9, 8 }, 15);
	public static EnumArmorMaterial	BONE					= EnumHelper.addArmorMaterial("BONE", 24, new int[] { 1, 5, 3, 2 }, 10);
	public static EnumArmorMaterial	REED					= EnumHelper.addArmorMaterial("REED", 16, new int[] { 1, 5, 3, 2 }, 10);
	public static EnumArmorMaterial	BLAZEROD				= EnumHelper.addArmorMaterial("BLAZEROD", 64, new int[] { 4, 10, 7, 3 }, 10);
	public static EnumArmorMaterial	DIRT					= EnumHelper.addArmorMaterial("DIRT", 16, new int[] { 1, 1, 1, 1 }, 10);
	public static EnumArmorMaterial	GLASS					= EnumHelper.addArmorMaterial("GLASS", 16, new int[] { 1, 1, 1, 1 }, 10);
	public static EnumArmorMaterial	SANDSTONE				= EnumHelper.addArmorMaterial("SANDSTONE", 64, new int[] { 2, 4, 3, 2 }, 10);
	public static EnumArmorMaterial	BRICK					= EnumHelper.addArmorMaterial("BRICK", 32, new int[] { 2, 4, 3, 2 }, 10);
	public static EnumArmorMaterial	ENDSTONE				= EnumHelper.addArmorMaterial("ENDSTONE", 100, new int[] { 3, 5, 4, 2 }, 10);
	// public static EnumArmorMaterial EPIC =
	// EnumHelper.addArmorMaterial("EPIC", 4096, new int[] { 13, 18, 15, 10 },
	// 1);
	public static EnumArmorMaterial	INVISIBILITY			= EnumHelper.addArmorMaterial("INVISIBILITY", 24, new int[] { 2, 7, 5, 2 }, 10);
	public static EnumArmorMaterial	HALLOWED				= EnumHelper.addArmorMaterial("HALLOWED", 512, new int[] { 8, 10, 9, 5 }, 7);
	public static EnumArmorMaterial	GODDAWN					= EnumHelper.addArmorMaterial("GODDAWN", 512, new int[] { 8, 10, 9, 5 }, 7);
	public static EnumArmorMaterial	EMERALD					= EnumHelper.addArmorMaterial("EMERALD", 512, new int[] { 3, 8, 6, 3 }, 13);
	public static EnumArmorMaterial	NETHERSTAR				= EnumHelper.addArmorMaterial("NETHERSTAR", 512, new int[] { 11, 16, 14, 7 }, 20);
	public static EnumArmorMaterial	POTATO					= EnumHelper.addArmorMaterial("POTATO", 16, new int[] { 1, 3, 3, 2 }, 7);
	public static EnumArmorMaterial	CARROT					= POTATO;
	public static EnumArmorMaterial	FISH					= EnumHelper.addArmorMaterial("FISH", 16, new int[] { 1, 3, 2, 1 }, 7);
	public static EnumArmorMaterial	BACON					= FISH;
	public static EnumArmorMaterial	GLOWSTONE				= EnumHelper.addArmorMaterial("GLOWSTONE", 64, new int[] { 1, 1, 1, 1 }, 10);
	public static EnumArmorMaterial	SLIME					= EnumHelper.addArmorMaterial("SLIME", 80, new int[] { 1, 3, 2, 1 }, 7);
	
	// Items
	
	public static Item				obsidianHelmet			= (new ItemArmorMTM(MoreToolsMod.armorID + 1, OBSIDIAN, MTMClientProxy.obsidian, 0)).setUnlocalizedName("obsidianHelmet");
	public static Item				obsidianChestplate		= (new ItemArmorMTM(MoreToolsMod.armorID + 2, OBSIDIAN, MTMClientProxy.obsidian, 1)).setUnlocalizedName("obsidianChestplate");
	public static Item				obsidianLeggings		= (new ItemArmorMTM(MoreToolsMod.armorID + 3, OBSIDIAN, MTMClientProxy.obsidian, 2)).setUnlocalizedName("obsidianLeggings");
	public static Item				obsidianBoots			= (new ItemArmorMTM(MoreToolsMod.armorID + 4, OBSIDIAN, MTMClientProxy.obsidian, 3)).setUnlocalizedName("obsidianBoots");
	
	public static Item				redstoneHelmet			= (new ItemArmorMTM(MoreToolsMod.armorID + 5, REDSTONE, MTMClientProxy.redstone, 0)).setUnlocalizedName("redstoneHelmet");
	public static Item				redstoneChestplate		= (new ItemArmorMTM(MoreToolsMod.armorID + 6, REDSTONE, MTMClientProxy.redstone, 1)).setUnlocalizedName("redstoneChestplate");
	public static Item				redstoneLeggings		= (new ItemArmorMTM(MoreToolsMod.armorID + 7, REDSTONE, MTMClientProxy.redstone, 2)).setUnlocalizedName("redstoneLeggings");
	public static Item				redstoneBoots			= (new ItemArmorMTM(MoreToolsMod.armorID + 8, REDSTONE, MTMClientProxy.redstone, 3)).setUnlocalizedName("redstoneBoots");
	
	public static Item				coalHelmet				= (new ItemArmorMTM(MoreToolsMod.armorID + 9, COAL, MTMClientProxy.coal, 0)).setUnlocalizedName("coalHelmet");
	public static Item				coalChestplate			= (new ItemArmorMTM(MoreToolsMod.armorID + 10, COAL, MTMClientProxy.coal, 1)).setUnlocalizedName("coalChestplate");
	public static Item				coalLeggings			= (new ItemArmorMTM(MoreToolsMod.armorID + 11, COAL, MTMClientProxy.coal, 2)).setUnlocalizedName("coalLeggings");
	public static Item				coalBoots				= (new ItemArmorMTM(MoreToolsMod.armorID + 12, COAL, MTMClientProxy.coal, 3)).setUnlocalizedName("coalBoots");
	
	public static Item				lapisHelmet				= (new ItemArmorMTM(MoreToolsMod.armorID + 13, LAPIS, MTMClientProxy.lapis, 0)).setUnlocalizedName("lapisHelmet");
	public static Item				lapisChestplate			= (new ItemArmorMTM(MoreToolsMod.armorID + 14, LAPIS, MTMClientProxy.lapis, 1)).setUnlocalizedName("lapisChestplate");
	public static Item				lapisLeggings			= (new ItemArmorMTM(MoreToolsMod.armorID + 15, LAPIS, MTMClientProxy.lapis, 2)).setUnlocalizedName("lapisLeggings");
	public static Item				lapisBoots				= (new ItemArmorMTM(MoreToolsMod.armorID + 16, LAPIS, MTMClientProxy.lapis, 3)).setUnlocalizedName("lapisBoots");
	
	public static Item				enderHelmet				= (new ItemArmorMTM(MoreToolsMod.armorID + 17, END, MTMClientProxy.ender, 0)).setUnlocalizedName("enderHelmet");
	public static Item				enderChestplate			= (new ItemArmorMTM(MoreToolsMod.armorID + 18, END, MTMClientProxy.ender, 1)).setUnlocalizedName("enderChestplate");
	public static Item				enderLeggings			= (new ItemArmorMTM(MoreToolsMod.armorID + 19, END, MTMClientProxy.ender, 2)).setUnlocalizedName("enderLeggings");
	public static Item				enderBoots				= (new ItemArmorMTM(MoreToolsMod.armorID + 20, END, MTMClientProxy.ender, 3)).setUnlocalizedName("enderBoots");
	
	public static Item				spaceHelmet				= (new ItemArmorMTM(MoreToolsMod.armorID + 21, SPACE, MTMClientProxy.space, 0)).setUnlocalizedName("spaceHelmet");
	public static Item				spaceChestplate			= (new ItemArmorMTM(MoreToolsMod.armorID + 22, SPACE, MTMClientProxy.space, 1)).setUnlocalizedName("spaceChestplate");
	public static Item				spaceLeggings			= (new ItemArmorMTM(MoreToolsMod.armorID + 23, SPACE, MTMClientProxy.space, 2)).setUnlocalizedName("spaceLeggings");
	public static Item				spaceBoots				= (new ItemArmorMTM(MoreToolsMod.armorID + 24, SPACE, MTMClientProxy.space, 3)).setUnlocalizedName("spaceBoots");
	
	public static Item				boneHelmet				= (new ItemArmorMTM(MoreToolsMod.armorID + 25, BONE, MTMClientProxy.bone, 0)).setUnlocalizedName("boneHelmet");
	public static Item				boneChestplate			= (new ItemArmorMTM(MoreToolsMod.armorID + 26, BONE, MTMClientProxy.bone, 1)).setUnlocalizedName("boneChestplate");
	public static Item				boneLeggings			= (new ItemArmorMTM(MoreToolsMod.armorID + 27, BONE, MTMClientProxy.bone, 2)).setUnlocalizedName("boneLeggings");
	public static Item				boneBoots				= (new ItemArmorMTM(MoreToolsMod.armorID + 28, BONE, MTMClientProxy.bone, 3)).setUnlocalizedName("boneBoots");
	
	public static Item				sugarcaneHelmet			= (new ItemArmorMTM(MoreToolsMod.armorID + 29, REED, MTMClientProxy.sugarcane, 0)).setUnlocalizedName("sugarcaneHelmet");
	public static Item				sugarcaneChestplate		= (new ItemArmorMTM(MoreToolsMod.armorID + 30, REED, MTMClientProxy.sugarcane, 1)).setUnlocalizedName("sugarcaneChestplate");
	public static Item				sugarcaneLeggings		= (new ItemArmorMTM(MoreToolsMod.armorID + 31, REED, MTMClientProxy.sugarcane, 2)).setUnlocalizedName("sugarcaneLeggings");
	public static Item				sugarcaneBoots			= (new ItemArmorMTM(MoreToolsMod.armorID + 32, REED, MTMClientProxy.sugarcane, 3)).setUnlocalizedName("sugarcaneBoots");
	
	public static Item				blazerodHelmet			= (new ItemArmorMTM(MoreToolsMod.armorID + 33, BLAZEROD, MTMClientProxy.blazerod, 0)).setUnlocalizedName("blazeHelmet");
	public static Item				blazerodChestplate		= (new ItemArmorMTM(MoreToolsMod.armorID + 34, BLAZEROD, MTMClientProxy.blazerod, 1)).setUnlocalizedName("blazeChestplate");
	public static Item				blazerodLeggings		= (new ItemArmorMTM(MoreToolsMod.armorID + 35, BLAZEROD, MTMClientProxy.blazerod, 2)).setUnlocalizedName("blazeLeggings");
	public static Item				blazerodBoots			= (new ItemArmorMTM(MoreToolsMod.armorID + 36, BLAZEROD, MTMClientProxy.blazerod, 3)).setUnlocalizedName("blazeBoots");
	
	public static Item				dirtHelmet				= (new ItemArmorMTM(MoreToolsMod.armorID + 37, DIRT, MTMClientProxy.dirt, 0)).setUnlocalizedName("dirtHelmet");
	public static Item				dirtChestplate			= (new ItemArmorMTM(MoreToolsMod.armorID + 38, DIRT, MTMClientProxy.dirt, 1)).setUnlocalizedName("dirtChestplate");
	public static Item				dirtLeggings			= (new ItemArmorMTM(MoreToolsMod.armorID + 39, DIRT, MTMClientProxy.dirt, 2)).setUnlocalizedName("dirtLeggings");
	public static Item				dirtBoots				= (new ItemArmorMTM(MoreToolsMod.armorID + 40, DIRT, MTMClientProxy.dirt, 3)).setUnlocalizedName("dirtBoots");
	
	public static Item				glassHelmet				= (new ItemArmorMTM(MoreToolsMod.armorID + 41, GLASS, MTMClientProxy.glass, 0)).setUnlocalizedName("glassHelmet");
	public static Item				glassChestplate			= (new ItemArmorMTM(MoreToolsMod.armorID + 42, GLASS, MTMClientProxy.glass, 1)).setUnlocalizedName("glassChestplate");
	public static Item				glassLeggings			= (new ItemArmorMTM(MoreToolsMod.armorID + 43, GLASS, MTMClientProxy.glass, 2)).setUnlocalizedName("glassLeggings");
	public static Item				glassBoots				= (new ItemArmorMTM(MoreToolsMod.armorID + 44, GLASS, MTMClientProxy.glass, 3)).setUnlocalizedName("glassBoots");
	
	public static Item				sandstoneHelmet			= (new ItemArmorMTM(MoreToolsMod.armorID + 45, SANDSTONE, MTMClientProxy.sandstone, 0)).setUnlocalizedName("sandstoneHelmet");
	public static Item				sandstoneChestplate		= (new ItemArmorMTM(MoreToolsMod.armorID + 46, SANDSTONE, MTMClientProxy.sandstone, 1)).setUnlocalizedName("sandstoneChestplate");
	public static Item				sandstoneLeggings		= (new ItemArmorMTM(MoreToolsMod.armorID + 47, SANDSTONE, MTMClientProxy.sandstone, 2)).setUnlocalizedName("sandstoneLeggings");
	public static Item				sandstoneBoots			= (new ItemArmorMTM(MoreToolsMod.armorID + 48, SANDSTONE, MTMClientProxy.sandstone, 3)).setUnlocalizedName("sandstoneBoots");
	
	public static Item				brickHelmet				= (new ItemArmorMTM(MoreToolsMod.armorID + 49, BRICK, MTMClientProxy.brick, 0)).setUnlocalizedName("brickHelmet");
	public static Item				brickChestplate			= (new ItemArmorMTM(MoreToolsMod.armorID + 50, BRICK, MTMClientProxy.brick, 1)).setUnlocalizedName("brickChestplate");
	public static Item				brickLeggings			= (new ItemArmorMTM(MoreToolsMod.armorID + 51, BRICK, MTMClientProxy.brick, 2)).setUnlocalizedName("brickLeggings");
	public static Item				brickBoots				= (new ItemArmorMTM(MoreToolsMod.armorID + 52, BRICK, MTMClientProxy.brick, 3)).setUnlocalizedName("brickBoots");
	
	public static Item				endstoneHelmet			= (new ItemArmorMTM(MoreToolsMod.armorID + 53, ENDSTONE, MTMClientProxy.endstone, 0)).setUnlocalizedName("endstoneHelmet");
	public static Item				endstoneChestplate		= (new ItemArmorMTM(MoreToolsMod.armorID + 54, ENDSTONE, MTMClientProxy.endstone, 1)).setUnlocalizedName("endstoneChestplate");
	public static Item				endstoneLeggings		= (new ItemArmorMTM(MoreToolsMod.armorID + 55, ENDSTONE, MTMClientProxy.endstone, 2)).setUnlocalizedName("endstoneLeggings");
	public static Item				endstoneBoots			= (new ItemArmorMTM(MoreToolsMod.armorID + 56, ENDSTONE, MTMClientProxy.endstone, 3)).setUnlocalizedName("endstoneBoots");
	
	public static Item				godHelmet				= (new ItemArmorMTM(MoreToolsMod.armorID + 57, HALLOWED, MTMClientProxy.hallowed, 0)).setUnlocalizedName("godHelmet");
	public static Item				godChestplate			= (new ItemArmorMTM(MoreToolsMod.armorID + 58, HALLOWED, MTMClientProxy.hallowed, 1)).setUnlocalizedName("godChestplate");
	public static Item				godLeggings				= (new ItemArmorMTM(MoreToolsMod.armorID + 59, HALLOWED, MTMClientProxy.hallowed, 2)).setUnlocalizedName("godLeggings");
	public static Item				godBoots				= (new ItemArmorMTM(MoreToolsMod.armorID + 60, HALLOWED, MTMClientProxy.hallowed, 3)).setUnlocalizedName("godBoots");
	
	public static Item				luziferHelmet			= (new ItemArmorMTM(MoreToolsMod.armorID + 61, GODDAWN, MTMClientProxy.goddawn, 0)).setUnlocalizedName("luziferHelmet");
	public static Item				luziferChestplate		= (new ItemArmorMTM(MoreToolsMod.armorID + 62, GODDAWN, MTMClientProxy.goddawn, 1)).setUnlocalizedName("luziferChestplate");
	public static Item				luziferLeggings			= (new ItemArmorMTM(MoreToolsMod.armorID + 63, GODDAWN, MTMClientProxy.goddawn, 2)).setUnlocalizedName("luziferLeggings");
	public static Item				luziferBoots			= (new ItemArmorMTM(MoreToolsMod.armorID + 64, GODDAWN, MTMClientProxy.goddawn, 3)).setUnlocalizedName("luziferBoots");
	
	public static Item				invisibilityHelmet		= (new ItemArmorMTM(MoreToolsMod.armorID + 69, INVISIBILITY, MTMClientProxy.invisibility, 0)).setUnlocalizedName("invisibilityHelmet");
	public static Item				invisibilityChestplate	= (new ItemArmorMTM(MoreToolsMod.armorID + 70, INVISIBILITY, MTMClientProxy.invisibility, 1)).setUnlocalizedName("invisibilityChestplate");
	public static Item				invisibilityLeggings	= (new ItemArmorMTM(MoreToolsMod.armorID + 71, INVISIBILITY, MTMClientProxy.invisibility, 2)).setUnlocalizedName("invisibilityLeggings");
	public static Item				invisibilityBoots		= (new ItemArmorMTM(MoreToolsMod.armorID + 72, INVISIBILITY, MTMClientProxy.invisibility, 3)).setUnlocalizedName("invisibilityBoots");
	
	public static Item				emeraldHelmet			= (new ItemArmorMTM(MoreToolsMod.armorID + 73, EMERALD, MTMClientProxy.emerald, 0)).setUnlocalizedName("emeraldHelmet");
	public static Item				emeraldChestplate		= (new ItemArmorMTM(MoreToolsMod.armorID + 74, EMERALD, MTMClientProxy.emerald, 1)).setUnlocalizedName("emeraldChestplate");
	public static Item				emeraldLeggings			= (new ItemArmorMTM(MoreToolsMod.armorID + 75, EMERALD, MTMClientProxy.emerald, 2)).setUnlocalizedName("emeraldLeggings");
	public static Item				emeraldBoots			= (new ItemArmorMTM(MoreToolsMod.armorID + 76, EMERALD, MTMClientProxy.emerald, 3)).setUnlocalizedName("emeraldBoots");
	
	public static Item				netherstarHelmet		= (new ItemArmorMTM(MoreToolsMod.armorID + 77, NETHERSTAR, MTMClientProxy.netherstar, 0)).setUnlocalizedName("netherstarHelmet");
	public static Item				netherstarChestplate	= (new ItemArmorMTM(MoreToolsMod.armorID + 78, NETHERSTAR, MTMClientProxy.netherstar, 1)).setUnlocalizedName("netherstarChestplate");
	public static Item				netherstarLeggings		= (new ItemArmorMTM(MoreToolsMod.armorID + 79, NETHERSTAR, MTMClientProxy.netherstar, 2)).setUnlocalizedName("netherstarLeggings");
	public static Item				netherstarBoots			= (new ItemArmorMTM(MoreToolsMod.armorID + 80, NETHERSTAR, MTMClientProxy.netherstar, 3)).setUnlocalizedName("netherstarBoots");
	
	public static Item				potatoHelmet			= (new ItemArmorMTM(MoreToolsMod.armorID + 81, POTATO, MTMClientProxy.potato, 0)).setUnlocalizedName("potatoHelmet");
	public static Item				potatoChestplate		= (new ItemArmorMTM(MoreToolsMod.armorID + 82, POTATO, MTMClientProxy.potato, 1)).setUnlocalizedName("potatoChestplate");
	public static Item				potatoLeggings			= (new ItemArmorMTM(MoreToolsMod.armorID + 83, POTATO, MTMClientProxy.potato, 2)).setUnlocalizedName("potatoLeggings");
	public static Item				potatoBoots				= (new ItemArmorMTM(MoreToolsMod.armorID + 84, POTATO, MTMClientProxy.potato, 3)).setUnlocalizedName("potatoBoots");
	
	public static Item				carrotHelmet			= (new ItemArmorMTM(MoreToolsMod.armorID + 85, CARROT, MTMClientProxy.carrot, 0)).setUnlocalizedName("carrotHelmet");
	public static Item				carrotChestplate		= (new ItemArmorMTM(MoreToolsMod.armorID + 86, CARROT, MTMClientProxy.carrot, 1)).setUnlocalizedName("carrotChestplate");
	public static Item				carrotLeggings			= (new ItemArmorMTM(MoreToolsMod.armorID + 87, CARROT, MTMClientProxy.carrot, 2)).setUnlocalizedName("carrotLeggings");
	public static Item				carrotBoots				= (new ItemArmorMTM(MoreToolsMod.armorID + 88, CARROT, MTMClientProxy.carrot, 3)).setUnlocalizedName("carrotBoots");
	
	public static Item				fishHelmet				= (new ItemArmorMTM(MoreToolsMod.armorID + 89, FISH, MTMClientProxy.fish, 0)).setUnlocalizedName("fishHelmet");
	public static Item				fishChestplate			= (new ItemArmorMTM(MoreToolsMod.armorID + 90, FISH, MTMClientProxy.fish, 1)).setUnlocalizedName("fishChestplate");
	public static Item				fishLeggings			= (new ItemArmorMTM(MoreToolsMod.armorID + 91, FISH, MTMClientProxy.fish, 2)).setUnlocalizedName("fishLeggings");
	public static Item				fishBoots				= (new ItemArmorMTM(MoreToolsMod.armorID + 92, FISH, MTMClientProxy.fish, 3)).setUnlocalizedName("fishBoots");
	
	public static Item				baconHelmet				= (new ItemArmorMTM(MoreToolsMod.armorID + 93, BACON, MTMClientProxy.bacon, 0)).setUnlocalizedName("baconHelmet");
	public static Item				baconChestplate			= (new ItemArmorMTM(MoreToolsMod.armorID + 94, BACON, MTMClientProxy.bacon, 1)).setUnlocalizedName("baconChestplate");
	public static Item				baconLeggings			= (new ItemArmorMTM(MoreToolsMod.armorID + 95, BACON, MTMClientProxy.bacon, 2)).setUnlocalizedName("baconLeggings");
	public static Item				baconBoots				= (new ItemArmorMTM(MoreToolsMod.armorID + 96, BACON, MTMClientProxy.bacon, 3)).setUnlocalizedName("baconBoots");
	
	public static Item				glowstoneHelmet			= (new ItemArmorMTM(MoreToolsMod.armorID + 97, GLOWSTONE, MTMClientProxy.glowstone, 0)).setUnlocalizedName("glowstoneHelmet");
	public static Item				glowstoneChestplate		= (new ItemArmorMTM(MoreToolsMod.armorID + 98, GLOWSTONE, MTMClientProxy.glowstone, 1)).setUnlocalizedName("glowstoneChestplate");
	public static Item				glowstoneLeggings		= (new ItemArmorMTM(MoreToolsMod.armorID + 99, GLOWSTONE, MTMClientProxy.glowstone, 2)).setUnlocalizedName("glowstoneLeggings");
	public static Item				glowstoneBoots			= (new ItemArmorMTM(MoreToolsMod.armorID + 100 + 00, GLOWSTONE, MTMClientProxy.glowstone, 3)).setUnlocalizedName("glowstoneBoots");
	
	public static Item				slimeHelmet				= (new ItemArmorMTM(MoreToolsMod.armorID + 101, SLIME, MTMClientProxy.slime, 0)).setUnlocalizedName("slimeHelmet");
	public static Item				slimeChestplate			= (new ItemArmorMTM(MoreToolsMod.armorID + 102, SLIME, MTMClientProxy.slime, 1)).setUnlocalizedName("slimeChestplate");
	public static Item				slimeLeggings			= (new ItemArmorMTM(MoreToolsMod.armorID + 103, SLIME, MTMClientProxy.slime, 2)).setUnlocalizedName("slimeLeggings");
	public static Item				slimeBoots				= (new ItemArmorMTM(MoreToolsMod.armorID + 104, SLIME, MTMClientProxy.slime, 3)).setUnlocalizedName("slimeBoots");
	
	public void load(FMLInitializationEvent event)
	{
		this.addArmorItem(obsidianHelmet, new ItemStack(Block.obsidian), "Obsidian Helmet", 0);
		this.addArmorItem(obsidianChestplate, new ItemStack(Block.obsidian), "Obsidian Chestplate", 1);
		this.addArmorItem(obsidianLeggings, new ItemStack(Block.obsidian), "Obsidian Leggings", 2);
		this.addArmorItem(obsidianBoots, new ItemStack(Block.obsidian), "Obsidian Boots", 3);
		
		this.addArmorItem(redstoneHelmet, new ItemStack(Item.redstone), "Redstone Helmet", 0);
		this.addArmorItem(redstoneChestplate, new ItemStack(Item.redstone), "Redstone Chestplate", 1);
		this.addArmorItem(redstoneLeggings, new ItemStack(Item.redstone), "Redstone Leggings", 2);
		this.addArmorItem(redstoneBoots, new ItemStack(Item.redstone), "Redstone Boots", 3);
		
		this.addArmorItem(coalHelmet, new ItemStack(Item.coal), "Coal Helmet", 0);
		this.addArmorItem(coalChestplate, new ItemStack(Item.coal), "Coal Chestplate", 1);
		this.addArmorItem(coalLeggings, new ItemStack(Item.coal), "Coal Leggings", 2);
		this.addArmorItem(coalBoots, new ItemStack(Item.coal), "Coal Boots", 3);
		
		this.addArmorItem(lapisHelmet, new ItemStack(Block.blockLapis), "Lapis Helmet", 0);
		this.addArmorItem(lapisChestplate, new ItemStack(Block.blockLapis), "Lapis Chestplate", 1);
		this.addArmorItem(lapisLeggings, new ItemStack(Block.blockLapis), "Lapis Leggings", 2);
		this.addArmorItem(lapisBoots, new ItemStack(Block.blockLapis), "Lapis Boots", 3);
		
		this.addArmorItem(enderHelmet, new ItemStack(Item.enderPearl), "Ender Helmet", 0);
		this.addArmorItem(enderChestplate, new ItemStack(Item.enderPearl), "Ender Chestplate", 1);
		this.addArmorItem(enderLeggings, new ItemStack(Item.enderPearl), "Ender Leggings", 2);
		this.addArmorItem(enderBoots, new ItemStack(Item.enderPearl), "Ender Boots", 3);
		
		this.addArmorItem(spaceHelmet, new ItemStack(MTMTools.spaceIngot), "Space Helmet", 0);
		this.addArmorItem(spaceChestplate, new ItemStack(MTMTools.spaceIngot), "Space Chestplate", 1);
		this.addArmorItem(spaceLeggings, new ItemStack(MTMTools.spaceIngot), "Space Leggings", 2);
		this.addArmorItem(spaceBoots, new ItemStack(MTMTools.spaceIngot), "Space Boots", 3);
		
		this.addArmorItem(boneHelmet, new ItemStack(Item.bone), "Bone Helmet", 0);
		this.addArmorItem(boneChestplate, new ItemStack(Item.bone), "Bone Chestplate", 1);
		this.addArmorItem(boneLeggings, new ItemStack(Item.bone), "Bone Leggings", 2);
		this.addArmorItem(boneBoots, new ItemStack(Item.bone), "Bone Boots", 3);
		
		this.addArmorItem(sugarcaneHelmet, new ItemStack(Item.reed), "Sugarcane Helmet", 0);
		this.addArmorItem(sugarcaneChestplate, new ItemStack(Item.reed), "Sugarcane Chestplate", 1);
		this.addArmorItem(sugarcaneLeggings, new ItemStack(Item.reed), "Sugarcane Leggings", 2);
		this.addArmorItem(sugarcaneBoots, new ItemStack(Item.reed), "Sugarcane Boots", 3);
		
		this.addArmorItem(blazerodHelmet, new ItemStack(Item.blazeRod), "Blaze Helmet", 0);
		this.addArmorItem(blazerodChestplate, new ItemStack(Item.blazeRod), "Blaze Chestplate", 1);
		this.addArmorItem(blazerodLeggings, new ItemStack(Item.blazeRod), "Blaze Leggings", 2);
		this.addArmorItem(blazerodBoots, new ItemStack(Item.blazeRod), "Blaze Boots", 3);
		
		this.addArmorItem(dirtHelmet, new ItemStack(Block.dirt), "Dirt Helmet", 0);
		this.addArmorItem(dirtChestplate, new ItemStack(Block.dirt), "Dirt Chestplate", 1);
		this.addArmorItem(dirtLeggings, new ItemStack(Block.dirt), "Dirt Leggings", 2);
		this.addArmorItem(dirtBoots, new ItemStack(Block.dirt), "Dirt Boots", 3);
		
		this.addArmorItem(glassHelmet, new ItemStack(Block.glass), "Glass Helmet", 0);
		this.addArmorItem(glassChestplate, new ItemStack(Block.glass), "Glass Chestplate", 1);
		this.addArmorItem(glassLeggings, new ItemStack(Block.glass), "Glass Leggings", 2);
		this.addArmorItem(glassBoots, new ItemStack(Block.glass), "Glass Boots", 3);
		
		this.addArmorItem(sandstoneHelmet, new ItemStack(Block.sandStone), "Sandstone Helmet", 0);
		this.addArmorItem(sandstoneChestplate, new ItemStack(Block.sandStone), "Sandstone Chestplate", 1);
		this.addArmorItem(sandstoneLeggings, new ItemStack(Block.sandStone), "Sandstone Leggings", 2);
		this.addArmorItem(sandstoneBoots, new ItemStack(Block.sandStone), "Sandstone Boots", 3);
		
		this.addArmorItem(brickHelmet, new ItemStack(Item.brick), "Brick Helmet", 0);
		this.addArmorItem(brickChestplate, new ItemStack(Item.brick), "Brick Chestplate", 1);
		this.addArmorItem(brickLeggings, new ItemStack(Item.brick), "Brick Leggings", 2);
		this.addArmorItem(brickBoots, new ItemStack(Item.brick), "Brick Boots", 3);
		
		this.addArmorItem(endstoneHelmet, new ItemStack(Block.whiteStone), "Endstone Helmet", 0);
		this.addArmorItem(endstoneChestplate, new ItemStack(Block.whiteStone), "Endstone Chestplate", 1);
		this.addArmorItem(endstoneLeggings, new ItemStack(Block.whiteStone), "Endstone Leggings", 2);
		this.addArmorItem(endstoneBoots, new ItemStack(Block.whiteStone), "Endstone Boots", 3);
		
		CSItems.addItemWithRecipe(godHelmet, "God's Helmet", 1, new Object[] { "GGG", "GgG", 'G', Block.blockGold, 'g', Item.glowstone });
		CSItems.addItemWithRecipe(godChestplate, "God's Chestplate", 1, new Object[] { "GgG", "GGG", "GGG", 'G', Block.blockGold, 'g', Item.glowstone });
		CSItems.addItemWithRecipe(godLeggings, "God's Leggings", 1, new Object[] { "GGG", "GgG", "GgG", 'G', Block.blockGold, 'g', Item.glowstone });
		CSItems.addItemWithRecipe(godBoots, "God's Boots", 1, new Object[] { "g g", "GgG", "GgG", 'G', Block.blockGold, 'g', Item.glowstone });
		
		CSItems.addItemWithRecipe(luziferHelmet, "Luzifer's Helmet", 1, new Object[] { "RRR", "RrR", 'R', Block.netherBrick, 'r', Item.redstone });
		CSItems.addItemWithRecipe(luziferChestplate, "Luzifer's Chestplate", 1, new Object[] { "RrR", "RRR", "RRR", 'R', Block.netherBrick, 'r', Item.redstone });
		CSItems.addItemWithRecipe(luziferLeggings, "Luzifer's Leggings", 1, new Object[] { "RRR", "RrR", "RrR", 'R', Block.netherBrick, 'r', Item.redstone });
		CSItems.addItemWithRecipe(luziferBoots, "Luzifer's Boots", 1, new Object[] { "r r", "RrR", "RrR", 'R', Block.netherBrick, 'r', Item.redstone });
		
		CSItems.addItemWithRecipe(invisibilityHelmet, "Invisibility Helmet", 1, new Object[] { "idi", "i i", 'i', Item.ingotIron, 'd', Item.diamond });
		CSItems.addItemWithRecipe(invisibilityChestplate, "Invisibility Chestplate", 1, new Object[] { "i i", "idi", "iii", 'i', Item.ingotIron, 'd', Item.diamond });
		CSItems.addItemWithRecipe(invisibilityLeggings, "Invisibility Leggings", 1, new Object[] { "idi", "i i", "i i", 'i', Item.ingotIron, 'd', Item.diamond });
		CSItems.addItemWithRecipe(invisibilityBoots, "Invisibility Boots", 1, new Object[] { "d d", "i i", 'i', Item.ingotIron, 'd', Item.diamond });
		
		this.addArmorItem(emeraldHelmet, new ItemStack(Item.emerald), "Emerald Helmet", 0);
		this.addArmorItem(emeraldChestplate, new ItemStack(Item.emerald), "Emerald Chestplate", 1);
		this.addArmorItem(emeraldLeggings, new ItemStack(Item.emerald), "Emerald Leggings", 2);
		this.addArmorItem(emeraldBoots, new ItemStack(Item.emerald), "Emerald Boots", 3);
		
		this.addArmorItem(netherstarHelmet, new ItemStack(Item.netherStar), "Nether Star Helmet", 0);
		this.addArmorItem(netherstarChestplate, new ItemStack(Item.netherStar), "Nether Star Chestplate", 1);
		this.addArmorItem(netherstarLeggings, new ItemStack(Item.netherStar), "Nether Star Leggings", 2);
		this.addArmorItem(netherstarBoots, new ItemStack(Item.netherStar), "Nether Star Boots", 3);
		
		this.addArmorItem(potatoHelmet, new ItemStack(Item.potato), "Potato Helmet", 0);
		this.addArmorItem(potatoChestplate, new ItemStack(Item.potato), "Potato Chestplate", 1);
		this.addArmorItem(potatoLeggings, new ItemStack(Item.potato), "Potato Leggings", 2);
		this.addArmorItem(potatoBoots, new ItemStack(Item.potato), "Potato Boots", 3);
		
		this.addArmorItem(carrotHelmet, new ItemStack(Item.carrot), "Carrot Helmet", 0);
		this.addArmorItem(carrotChestplate, new ItemStack(Item.carrot), "Carrot Chestplate", 1);
		this.addArmorItem(carrotLeggings, new ItemStack(Item.carrot), "Carrot Leggings", 2);
		this.addArmorItem(carrotBoots, new ItemStack(Item.carrot), "Carrot Boots", 3);
		
		this.addArmorItem(fishHelmet, new ItemStack(Item.fishRaw), "Fishscale Helmet", 0);
		this.addArmorItem(fishChestplate, new ItemStack(Item.fishRaw), "Fishscale Chestplate", 1);
		this.addArmorItem(fishLeggings, new ItemStack(Item.fishRaw), "Fishscale Leggings", 2);
		this.addArmorItem(fishBoots, new ItemStack(Item.fishRaw), "Fishscale Boots", 3);
		
		this.addArmorItem(baconHelmet, new ItemStack(Item.porkRaw), "Bacon Helmet", 0);
		this.addArmorItem(baconChestplate, new ItemStack(Item.porkRaw), "Bacon Chestplate", 1);
		this.addArmorItem(baconLeggings, new ItemStack(Item.porkRaw), "Bacon Leggings", 2);
		this.addArmorItem(baconBoots, new ItemStack(Item.porkRaw), "Bacon Boots", 3);
		
		this.addArmorItem(glowstoneHelmet, new ItemStack(Block.glowStone), "Glowstone Helmet", 0);
		this.addArmorItem(glowstoneChestplate, new ItemStack(Block.glowStone), "Glowstone Chestplate", 1);
		this.addArmorItem(glowstoneLeggings, new ItemStack(Block.glowStone), "Glowstone Leggings", 2);
		this.addArmorItem(glowstoneBoots, new ItemStack(Block.glowStone), "Glowstone Boots", 3);
		
		this.addArmorItem(slimeHelmet, new ItemStack(Item.slimeBall), "Slime Helmet", 0);
		this.addArmorItem(slimeChestplate, new ItemStack(Item.slimeBall), "Slime Chestplate", 1);
		this.addArmorItem(slimeLeggings, new ItemStack(Item.slimeBall), "Slime Leggings", 2);
		this.addArmorItem(slimeBoots, new ItemStack(Item.slimeBall), "Slime Boots", 3);
	}
	
	/**
	 * Adds an ArmorItem with all things.
	 * 
	 * @param item
	 * @param input
	 * @param name
	 * @param iconIndex
	 * @param part
	 */
	public void addArmorItem(Item item, ItemStack input, String name, int part)
	{
		this.addName(item, name);
		CSCrafting.addArmorRecipe(new ItemStack(item), input, part);
	}
	
	public void addName(Object o, String name)
	{
		LanguageRegistry.instance().addNameForObject(o, "en_US", name);
	}
}
