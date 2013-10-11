package clashsoft.mods.moretools;

import clashsoft.clashsoftapi.util.CSCrafting;
import clashsoft.clashsoftapi.util.CSItems;
import clashsoft.mods.moretools.item.ItemArmorMoreTools;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;

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
	
	public static Item				obsidianHelmet			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 1, OBSIDIAN, ClientProxy.obsidian, 0)).setUnlocalizedName("obsidianHelmet");
	public static Item				obsidianChestplate		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 2, OBSIDIAN, ClientProxy.obsidian, 1)).setUnlocalizedName("obsidianChestplate");
	public static Item				obsidianLeggings		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 3, OBSIDIAN, ClientProxy.obsidian, 2)).setUnlocalizedName("obsidianLeggings");
	public static Item				obsidianBoots			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 4, OBSIDIAN, ClientProxy.obsidian, 3)).setUnlocalizedName("obsidianBoots");
	
	public static Item				redstoneHelmet			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 5, REDSTONE, ClientProxy.redstone, 0)).setUnlocalizedName("redstoneHelmet");
	public static Item				redstoneChestplate		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 6, REDSTONE, ClientProxy.redstone, 1)).setUnlocalizedName("redstoneChestplate");
	public static Item				redstoneLeggings		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 7, REDSTONE, ClientProxy.redstone, 2)).setUnlocalizedName("redstoneLeggings");
	public static Item				redstoneBoots			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 8, REDSTONE, ClientProxy.redstone, 3)).setUnlocalizedName("redstoneBoots");
	
	public static Item				coalHelmet				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 9, COAL, ClientProxy.coal, 0)).setUnlocalizedName("coalHelmet");
	public static Item				coalChestplate			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 10, COAL, ClientProxy.coal, 1)).setUnlocalizedName("coalChestplate");
	public static Item				coalLeggings			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 11, COAL, ClientProxy.coal, 2)).setUnlocalizedName("coalLeggings");
	public static Item				coalBoots				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 12, COAL, ClientProxy.coal, 3)).setUnlocalizedName("coalBoots");
	
	public static Item				lapisHelmet				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 13, LAPIS, ClientProxy.lapis, 0)).setUnlocalizedName("lapisHelmet");
	public static Item				lapisChestplate			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 14, LAPIS, ClientProxy.lapis, 1)).setUnlocalizedName("lapisChestplate");
	public static Item				lapisLeggings			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 15, LAPIS, ClientProxy.lapis, 2)).setUnlocalizedName("lapisLeggings");
	public static Item				lapisBoots				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 16, LAPIS, ClientProxy.lapis, 3)).setUnlocalizedName("lapisBoots");
	
	public static Item				enderHelmet				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 17, END, ClientProxy.ender, 0)).setUnlocalizedName("enderHelmet");
	public static Item				enderChestplate			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 18, END, ClientProxy.ender, 1)).setUnlocalizedName("enderChestplate");
	public static Item				enderLeggings			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 19, END, ClientProxy.ender, 2)).setUnlocalizedName("enderLeggings");
	public static Item				enderBoots				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 20, END, ClientProxy.ender, 3)).setUnlocalizedName("enderBoots");
	
	public static Item				spaceHelmet				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 21, SPACE, ClientProxy.space, 0)).setUnlocalizedName("spaceHelmet");
	public static Item				spaceChestplate			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 22, SPACE, ClientProxy.space, 1)).setUnlocalizedName("spaceChestplate");
	public static Item				spaceLeggings			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 23, SPACE, ClientProxy.space, 2)).setUnlocalizedName("spaceLeggings");
	public static Item				spaceBoots				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 24, SPACE, ClientProxy.space, 3)).setUnlocalizedName("spaceBoots");
	
	public static Item				boneHelmet				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 25, BONE, ClientProxy.bone, 0)).setUnlocalizedName("boneHelmet");
	public static Item				boneChestplate			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 26, BONE, ClientProxy.bone, 1)).setUnlocalizedName("boneChestplate");
	public static Item				boneLeggings			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 27, BONE, ClientProxy.bone, 2)).setUnlocalizedName("boneLeggings");
	public static Item				boneBoots				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 28, BONE, ClientProxy.bone, 3)).setUnlocalizedName("boneBoots");
	
	public static Item				sugarcaneHelmet			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 29, REED, ClientProxy.sugarcane, 0)).setUnlocalizedName("sugarcaneHelmet");
	public static Item				sugarcaneChestplate		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 30, REED, ClientProxy.sugarcane, 1)).setUnlocalizedName("sugarcaneChestplate");
	public static Item				sugarcaneLeggings		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 31, REED, ClientProxy.sugarcane, 2)).setUnlocalizedName("sugarcaneLeggings");
	public static Item				sugarcaneBoots			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 32, REED, ClientProxy.sugarcane, 3)).setUnlocalizedName("sugarcaneBoots");
	
	public static Item				blazerodHelmet			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 33, BLAZEROD, ClientProxy.blazerod, 0)).setUnlocalizedName("blazeHelmet");
	public static Item				blazerodChestplate		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 34, BLAZEROD, ClientProxy.blazerod, 1)).setUnlocalizedName("blazeChestplate");
	public static Item				blazerodLeggings		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 35, BLAZEROD, ClientProxy.blazerod, 2)).setUnlocalizedName("blazeLeggings");
	public static Item				blazerodBoots			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 36, BLAZEROD, ClientProxy.blazerod, 3)).setUnlocalizedName("blazeBoots");
	
	public static Item				dirtHelmet				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 37, DIRT, ClientProxy.dirt, 0)).setUnlocalizedName("dirtHelmet");
	public static Item				dirtChestplate			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 38, DIRT, ClientProxy.dirt, 1)).setUnlocalizedName("dirtChestplate");
	public static Item				dirtLeggings			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 39, DIRT, ClientProxy.dirt, 2)).setUnlocalizedName("dirtLeggings");
	public static Item				dirtBoots				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 40, DIRT, ClientProxy.dirt, 3)).setUnlocalizedName("dirtBoots");
	
	public static Item				glassHelmet				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 41, GLASS, ClientProxy.glass, 0)).setUnlocalizedName("glassHelmet");
	public static Item				glassChestplate			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 42, GLASS, ClientProxy.glass, 1)).setUnlocalizedName("glassChestplate");
	public static Item				glassLeggings			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 43, GLASS, ClientProxy.glass, 2)).setUnlocalizedName("glassLeggings");
	public static Item				glassBoots				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 44, GLASS, ClientProxy.glass, 3)).setUnlocalizedName("glassBoots");
	
	public static Item				sandstoneHelmet			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 45, SANDSTONE, ClientProxy.sandstone, 0)).setUnlocalizedName("sandstoneHelmet");
	public static Item				sandstoneChestplate		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 46, SANDSTONE, ClientProxy.sandstone, 1)).setUnlocalizedName("sandstoneChestplate");
	public static Item				sandstoneLeggings		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 47, SANDSTONE, ClientProxy.sandstone, 2)).setUnlocalizedName("sandstoneLeggings");
	public static Item				sandstoneBoots			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 48, SANDSTONE, ClientProxy.sandstone, 3)).setUnlocalizedName("sandstoneBoots");
	
	public static Item				brickHelmet				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 49, BRICK, ClientProxy.brick, 0)).setUnlocalizedName("brickHelmet");
	public static Item				brickChestplate			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 50, BRICK, ClientProxy.brick, 1)).setUnlocalizedName("brickChestplate");
	public static Item				brickLeggings			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 51, BRICK, ClientProxy.brick, 2)).setUnlocalizedName("brickLeggings");
	public static Item				brickBoots				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 52, BRICK, ClientProxy.brick, 3)).setUnlocalizedName("brickBoots");
	
	public static Item				endstoneHelmet			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 53, ENDSTONE, ClientProxy.endstone, 0)).setUnlocalizedName("endstoneHelmet");
	public static Item				endstoneChestplate		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 54, ENDSTONE, ClientProxy.endstone, 1)).setUnlocalizedName("endstoneChestplate");
	public static Item				endstoneLeggings		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 55, ENDSTONE, ClientProxy.endstone, 2)).setUnlocalizedName("endstoneLeggings");
	public static Item				endstoneBoots			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 56, ENDSTONE, ClientProxy.endstone, 3)).setUnlocalizedName("endstoneBoots");
	
	public static Item				godHelmet				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 57, HALLOWED, ClientProxy.hallowed, 0)).setUnlocalizedName("godHelmet");
	public static Item				godChestplate			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 58, HALLOWED, ClientProxy.hallowed, 1)).setUnlocalizedName("godChestplate");
	public static Item				godLeggings				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 59, HALLOWED, ClientProxy.hallowed, 2)).setUnlocalizedName("godLeggings");
	public static Item				godBoots				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 60, HALLOWED, ClientProxy.hallowed, 3)).setUnlocalizedName("godBoots");
	
	public static Item				luziferHelmet			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 61, GODDAWN, ClientProxy.goddawn, 0)).setUnlocalizedName("luziferHelmet");
	public static Item				luziferChestplate		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 62, GODDAWN, ClientProxy.goddawn, 1)).setUnlocalizedName("luziferChestplate");
	public static Item				luziferLeggings			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 63, GODDAWN, ClientProxy.goddawn, 2)).setUnlocalizedName("luziferLeggings");
	public static Item				luziferBoots			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 64, GODDAWN, ClientProxy.goddawn, 3)).setUnlocalizedName("luziferBoots");
	
	public static Item				invisibilityHelmet		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 69, INVISIBILITY, ClientProxy.invisibility, 0)).setUnlocalizedName("invisibilityHelmet");
	public static Item				invisibilityChestplate	= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 70, INVISIBILITY, ClientProxy.invisibility, 1)).setUnlocalizedName("invisibilityChestplate");
	public static Item				invisibilityLeggings	= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 71, INVISIBILITY, ClientProxy.invisibility, 2)).setUnlocalizedName("invisibilityLeggings");
	public static Item				invisibilityBoots		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 72, INVISIBILITY, ClientProxy.invisibility, 3)).setUnlocalizedName("invisibilityBoots");
	
	public static Item				emeraldHelmet			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 73, EMERALD, ClientProxy.emerald, 0)).setUnlocalizedName("emeraldHelmet");
	public static Item				emeraldChestplate		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 74, EMERALD, ClientProxy.emerald, 1)).setUnlocalizedName("emeraldChestplate");
	public static Item				emeraldLeggings			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 75, EMERALD, ClientProxy.emerald, 2)).setUnlocalizedName("emeraldLeggings");
	public static Item				emeraldBoots			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 76, EMERALD, ClientProxy.emerald, 3)).setUnlocalizedName("emeraldBoots");
	
	public static Item				netherstarHelmet		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 77, NETHERSTAR, ClientProxy.netherstar, 0)).setUnlocalizedName("netherstarHelmet");
	public static Item				netherstarChestplate	= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 78, NETHERSTAR, ClientProxy.netherstar, 1)).setUnlocalizedName("netherstarChestplate");
	public static Item				netherstarLeggings		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 79, NETHERSTAR, ClientProxy.netherstar, 2)).setUnlocalizedName("netherstarLeggings");
	public static Item				netherstarBoots			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 80, NETHERSTAR, ClientProxy.netherstar, 3)).setUnlocalizedName("netherstarBoots");
	
	public static Item				potatoHelmet			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 81, POTATO, ClientProxy.potato, 0)).setUnlocalizedName("potatoHelmet");
	public static Item				potatoChestplate		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 82, POTATO, ClientProxy.potato, 1)).setUnlocalizedName("potatoChestplate");
	public static Item				potatoLeggings			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 83, POTATO, ClientProxy.potato, 2)).setUnlocalizedName("potatoLeggings");
	public static Item				potatoBoots				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 84, POTATO, ClientProxy.potato, 3)).setUnlocalizedName("potatoBoots");
	
	public static Item				carrotHelmet			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 85, CARROT, ClientProxy.carrot, 0)).setUnlocalizedName("carrotHelmet");
	public static Item				carrotChestplate		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 86, CARROT, ClientProxy.carrot, 1)).setUnlocalizedName("carrotChestplate");
	public static Item				carrotLeggings			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 87, CARROT, ClientProxy.carrot, 2)).setUnlocalizedName("carrotLeggings");
	public static Item				carrotBoots				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 88, CARROT, ClientProxy.carrot, 3)).setUnlocalizedName("carrotBoots");
	
	public static Item				fishHelmet				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 89, FISH, ClientProxy.fish, 0)).setUnlocalizedName("fishHelmet");
	public static Item				fishChestplate			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 90, FISH, ClientProxy.fish, 1)).setUnlocalizedName("fishChestplate");
	public static Item				fishLeggings			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 91, FISH, ClientProxy.fish, 2)).setUnlocalizedName("fishLeggings");
	public static Item				fishBoots				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 92, FISH, ClientProxy.fish, 3)).setUnlocalizedName("fishBoots");
	
	public static Item				baconHelmet				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 93, BACON, ClientProxy.bacon, 0)).setUnlocalizedName("baconHelmet");
	public static Item				baconChestplate			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 94, BACON, ClientProxy.bacon, 1)).setUnlocalizedName("baconChestplate");
	public static Item				baconLeggings			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 95, BACON, ClientProxy.bacon, 2)).setUnlocalizedName("baconLeggings");
	public static Item				baconBoots				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 96, BACON, ClientProxy.bacon, 3)).setUnlocalizedName("baconBoots");
	
	public static Item				glowstoneHelmet			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 97, GLOWSTONE, ClientProxy.glowstone, 0)).setUnlocalizedName("glowstoneHelmet");
	public static Item				glowstoneChestplate		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 98, GLOWSTONE, ClientProxy.glowstone, 1)).setUnlocalizedName("glowstoneChestplate");
	public static Item				glowstoneLeggings		= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 99, GLOWSTONE, ClientProxy.glowstone, 2)).setUnlocalizedName("glowstoneLeggings");
	public static Item				glowstoneBoots			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 100 + 00, GLOWSTONE, ClientProxy.glowstone, 3)).setUnlocalizedName("glowstoneBoots");
	
	public static Item				slimeHelmet				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 101, SLIME, ClientProxy.slime, 0)).setUnlocalizedName("slimeHelmet");
	public static Item				slimeChestplate			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 102, SLIME, ClientProxy.slime, 1)).setUnlocalizedName("slimeChestplate");
	public static Item				slimeLeggings			= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 103, SLIME, ClientProxy.slime, 2)).setUnlocalizedName("slimeLeggings");
	public static Item				slimeBoots				= (new ItemArmorMoreTools(MoreToolsMod.ARMORY_ID + 104, SLIME, ClientProxy.slime, 3)).setUnlocalizedName("slimeBoots");
	
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
