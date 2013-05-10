package clashsoft.mods.moretools;

import clashsoft.clashsoftapi.CSBlocks;
import clashsoft.clashsoftapi.CSCrafting;
import clashsoft.clashsoftapi.CSItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.src.ModLoader;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

//@Mod (modid = "MoreToolsModToolsID", name="MoreToolsMod(Tools)", version="1.5")
//@NetworkMod (clientSideRequired = true, serverSideRequired = false)
public class MoreToolsMod_Tools
{
//	@Instance("MoreToolsModToolsID")
	public static MoreToolsMod_Tools instance = new MoreToolsMod_Tools();
//	
//	@SidedProxy(clientSide = "clashsoft.mods.moretools.ClientProxy", serverSide = "clashsoft.mods.moretools.CommonProxy")
//	public static CommonProxy proxy;
	
	//Tool Materials.
	
	private EnumToolMaterial OBSIDIAN = CSItems.addToolMaterial("OBSIDIAN", 3, 4096, 25F, 10, 10, 0x1e182b, new ItemStack(Block.obsidian));
    private EnumToolMaterial REDSTONE = EnumHelper.addToolMaterial("REDSTONE", 2, 64, 6F, 4, 15);
    private EnumToolMaterial COAL = EnumHelper.addToolMaterial("COAL", 1, 128, 3F, 5, 15);
    private EnumToolMaterial LAPIS = EnumHelper.addToolMaterial("LAPIS", 2, 256, 3F, 6, 15);
    private EnumToolMaterial END = EnumHelper.addToolMaterial("END", 2, 512, 5F, 7, 15);
    private static EnumToolMaterial SPACESTRONG = EnumHelper.addToolMaterial("SPACESTRONG", 3, 8196, 70F, 50, 20);
    private static EnumToolMaterial SPACEWEAK = EnumHelper.addToolMaterial("SPACEWEAK", 3, 6144, 50F, 25, 18);
    private EnumToolMaterial BONE = EnumHelper.addToolMaterial("BONE", 1, 32, 1.5F, 4, 15);
    private EnumToolMaterial REED = EnumHelper.addToolMaterial("REED", 0, 16, 0.5F, 5, 15);
    private EnumToolMaterial BLAZEROD = EnumHelper.addToolMaterial("BLAZEROD", 2, 512, 6F, 9, 15);
    private EnumToolMaterial DIRT = EnumHelper.addToolMaterial("DIRT", 0, 16, 0.8F, 3, 15);
    private EnumToolMaterial GLASS = EnumHelper.addToolMaterial("GLASS", 0, 16, 0.5F, 6, 15);
    private EnumToolMaterial SANDSTONE = EnumHelper.addToolMaterial("SANDSTONE", 1, 128, 3F, 6, 15);
    private EnumToolMaterial BRICK = EnumHelper.addToolMaterial("BRICK", 1, 128, 2.5F, 3, 15);
    private EnumToolMaterial ENDSTONE = EnumHelper.addToolMaterial("ENDSTONE", 2, 256, 3.5F, 5, 15);
    private EnumToolMaterial EXCALIBUR = EnumHelper.addToolMaterial("EXCALIBUR", 3, 1048576, 10F, 100, 1);
    private EnumToolMaterial GOD = EnumHelper.addToolMaterial("GOD", 3, 4096, 5F, 20, 10);
    private EnumToolMaterial LUZIFER = EnumHelper.addToolMaterial("LUZIFER", 3, 4096, 5F, 20, 10);
    private static EnumToolMaterial LASER = EnumHelper.addToolMaterial("LASER", 3, -1, 1F, 60, 1);
    private EnumToolMaterial EMERALD2 = EnumHelper.addToolMaterial("EMERALD", 3, 1536, 10F, 10, 17);
    private EnumToolMaterial NETHERSTAR = EnumHelper.addToolMaterial("NETHERSTAR", 3, 2048, 12F, 15, 20);
    private EnumToolMaterial POTATO = EnumHelper.addToolMaterial("POTATO", 1, 64, 3F, 5, 15);
    private EnumToolMaterial CARROT = EnumHelper.addToolMaterial("CARROT", 1, 64, 3F, 5, 15);
    private EnumToolMaterial FISH = EnumHelper.addToolMaterial("FISH", 1, 64, 2.5F, 6, 15);
    private EnumToolMaterial BACON = EnumHelper.addToolMaterial("BACON", 1, 64, 2.5F, 6, 15);
    public static EnumToolMaterial LEATHER = EnumToolMaterial.WOOD;
    private static EnumToolMaterial GLOWSTONE = EnumHelper.addToolMaterial("GLOWSTONE", 2, 64, 1F, 5, 16);
    private static EnumToolMaterial SLIME = EnumHelper.addToolMaterial("SLIME", 1, 80, 1.2F, 5, 15);
    
    public static Enchantment quickDraw = new EnchantmentMoreTools(7, 1, 3, EnumEnchantmentType.bow, "quickdraw");
	
	//Rarities.
    
    private static int EPIC = 0;
	private static int RARE = 1;
	private static int UNCOMMON = 2;
	private static int COMMON = 3;
    
    //Integers.
    
    int l1 = 0;			//Swords.
    int l2 = 16;		//Shovels.
    int l3 = 32;		//Picks.
    int l4 = 48;		//Axes.
    int l5 = 64;		//Hoes.
    int l6 = 80;		//Swords.
    int l7 = 96;		//...
    int l8 = 112;		//...
    int l9 = 128;		//...
    int l10 = 144;		//
    int l11 = 160;		//
    int l12 = 176;		//
    int l13 = 192;		//
    int l14 = 208;		//
    int l15 = 224;		//
    int l16 = 240;		//Misc
    
    int c1 = 0;			//Obsidian		Epic
    int c2 = 1;			//Redstone		Lightsabers
    int c3 = 2;			//Coal			Emerald
    int c4 = 3;			//Lapis			Netherstar
    int c5 = 4;			//End			Potatoe
    int c6 = 5;			//Bone			Carrot
    int c7 = 6;			//Sugarcanes	Fish
    int c8 = 7;			//Blazerods		Bacon
    int c9 = 8;			//Dirt			Glowstone
    int c10 = 9;		//Glass
    int c11 = 10;		//Sandstone
    int c12 = 11;		//Bricks
    int c13 = 12;		//Endstone
    int c14 = 13;		//Space
    int c15 = 14;		//Hallowed
    int c16 = 15;		//Goddawn
    
    //Items.
    
    public static final Item spacePick = (new ItemPickaxeMoreTools(1926, SPACESTRONG)).setUnlocalizedName("spacePickaxe");
	public static final Item spaceShovel = (new ItemSpadeMoreTools(1927, SPACESTRONG)).setUnlocalizedName("spaceShovel");
	public static final Item spaceAxe = (new ItemAxeMoreTools(1928, SPACESTRONG)).setUnlocalizedName("spaceAxe");
	public static final Item spaceHoe = (new ItemHoeMoreTools(1929, SPACESTRONG)).setUnlocalizedName("spaceHoe");
	public static final Item spaceSwordStrong = (new ItemSwordMoreTools(1930, SPACESTRONG, EPIC)).setUnlocalizedName("spaceSwordStrong");
	
	public static final Item spaceMultitool = (new ItemMultitoolMoreTools(2400, SPACESTRONG)).setUnlocalizedName("spacemulti");
	public static final Item spaceArrow = (new ItemMoreTools(2402, CreativeTabs.tabCombat)).setUnlocalizedName("spacearrow");
	public static final Item spaceBow = (new ItemBowMoreTools(2401, spaceArrow, false)).setUnlocalizedName("spacebow");
    public static final Item spaceIngot = (new ItemMoreTools(2403, CreativeTabs.tabMaterials)).setUnlocalizedName("spaceingot");
    public static final Item spaceSwordWeak = (new ItemSwordMoreTools(2404, SPACEWEAK, RARE)).setUnlocalizedName("spaceSwordWeak");
    
    public static final Item lightsaberShaft = (new ItemLightsaberShaftMoreTools(2405)).setUnlocalizedName("lsshaft");
    public static final Item lightsaberBlue = (new ItemLightsaberMoreTools(1986, LASER)).setUnlocalizedName("lightSaber1");
    public static final Item lightsaberGreen = (new ItemLightsaberMoreTools(1987, LASER)).setUnlocalizedName("lightSaber2");
    public static final Item lightsaberPurple = (new ItemLightsaberMoreTools(1988, LASER)).setUnlocalizedName("lightSaber3");
    public static final Item lightsaberRed = (new ItemLightsaberMoreTools(1989, LASER)).setUnlocalizedName("lightSaber4");
    public static final Item lightsaberWhite = (new ItemLightsaberMoreTools(1990, LASER)).setUnlocalizedName("lightSaber5");
    
    public static final Item glowstonePick = (new ItemPickaxeMoreTools(2046, GLOWSTONE)).setUnlocalizedName("glowstonePickaxe");
    public static final Item glowstoneShovel = (new ItemSpadeMoreTools(2047, GLOWSTONE)).setUnlocalizedName("glowstoneShovel");
    public static final Item glowstoneAxe = (new ItemAxeMoreTools(2048, GLOWSTONE)).setUnlocalizedName("glowstoneAxe");
    public static final Item glowstoneHoe = (new ItemHoeMoreTools(2049, GLOWSTONE)).setUnlocalizedName("glowstoneHoe");
    public static final Item glowstoneSword = (new ItemSwordMoreTools(2050, GLOWSTONE, COMMON)).setUnlocalizedName("glowstoneSword");
    
    public static final Item slimePick = (new ItemPickaxeMoreTools(2051, SLIME)).setUnlocalizedName("slimePickaxe");
    public static final Item slimeShovel = (new ItemSpadeMoreTools(2052, SLIME)).setUnlocalizedName("slimeShovel");
    public static final Item slimeAxe = (new ItemAxeMoreTools(2053, SLIME)).setUnlocalizedName("slimeAxe");
    public static final Item slimeHoe = (new ItemHoeMoreTools(2054, SLIME)).setUnlocalizedName("slimeHoe");
    public static final Item slimeSword = (new ItemSwordMoreTools(2055, SLIME, COMMON)).setUnlocalizedName("slimeSword");
    
    public static final Item goldBucket = (new ItemGoldBucket(2108, 0)).setUnlocalizedName("bucketgold");
    public static final Item goldBucketWater = (new ItemGoldBucket(2109, Block.waterStill.blockID)).setUnlocalizedName("bucketgoldWater");
    public static final Item goldBucketLava = (new ItemGoldBucket(2110, Block.lavaStill.blockID)).setUnlocalizedName("bucketgoldLava");
    public static final Item goldBucketMilk = (new ItemBucketMilk(2111)).setUnlocalizedName("bucketgoldMilk");
    
    public static final Block spaceBlock = (new BlockSpaceblock(250)).setHardness(3F).setLightValue(15/16).setUnlocalizedName("spaceblock");
    public static final Block spaceOre = new Block(251, Material.rock).setHardness(2.5F).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("spaceore");
    public static final Block glowing = (new BlockGlowing(252)).setHardness(0F).setLightValue(1F).setUnlocalizedName("glowing");
    
    public void load(FMLInitializationEvent event)
    {
        load2();
		
		//Obsidian tools.
    	
    	Item obsidianPick = (new ItemPickaxeMoreTools(1901, OBSIDIAN)).setUnlocalizedName("obsidianPickaxe");
        Item obsidianShovel = (new ItemSpadeMoreTools(1902, OBSIDIAN)).setUnlocalizedName("obsidianShovel");
        Item obsidianAxe = (new ItemAxeMoreTools(1903, OBSIDIAN)).setUnlocalizedName("obsidianAxe");
        Item obsidianHoe = (new ItemHoeMoreTools(1904, OBSIDIAN)).setUnlocalizedName("obsidianHoe");
        Item obsidianSword = (new ItemSwordMoreTools(1905, OBSIDIAN, UNCOMMON)).setUnlocalizedName("obsidianSword");
        ModLoader.addName(obsidianPick, "Obsidian Pickaxe");
        ModLoader.addName(obsidianShovel, "Obsidian Shovel");
        ModLoader.addName(obsidianAxe, "Obsidian Axe");
        ModLoader.addName(obsidianHoe, "Obsidian Hoe");
        ModLoader.addName(obsidianSword, "Obsidian Sword");
        ModLoader.addRecipe(new ItemStack(obsidianPick, 1), new Object[] {
            "XXX", " | ", " | ", Character.valueOf('X'), Block.obsidian, Character.valueOf('|'), Item.stick
        });
        ModLoader.addRecipe(new ItemStack(obsidianShovel, 1), new Object[] {
            "X", "|", "|", 		 Character.valueOf('X'), Block.obsidian, Character.valueOf('|'), Item.stick
        });
        ModLoader.addRecipe(new ItemStack(obsidianAxe, 1), new Object[] {
            "XX", "X|", " |", 	 Character.valueOf('X'), Block.obsidian, Character.valueOf('|'), Item.stick
        });
        ModLoader.addRecipe(new ItemStack(obsidianHoe, 1), new Object[] {
            "XX", " |", " |", 	 Character.valueOf('X'), Block.obsidian, Character.valueOf('|'), Item.stick
        });
        ModLoader.addRecipe(new ItemStack(obsidianSword, 1), new Object[] {
            "X", "X", "|", 		 Character.valueOf('X'), Block.obsidian, Character.valueOf('|'), Item.stick
        });
        
        //Redstone tools.
        
        Item redstonePick = (new ItemPickaxeMoreTools(1906, REDSTONE)).setUnlocalizedName("redstonePickaxe");
        Item redstoneShovel = (new ItemSpadeMoreTools(1907, REDSTONE)).setUnlocalizedName("redstoneShovel");
        Item redstoneAxe = (new ItemAxeMoreTools(1908, REDSTONE)).setUnlocalizedName("redstoneAxe");
        Item redstoneHoe = (new ItemHoeMoreTools(1909, REDSTONE)).setUnlocalizedName("redstoneHoe");
        Item redstoneSword = (new ItemSwordMoreTools(1910, REDSTONE, UNCOMMON)).setUnlocalizedName("redstoneSword");
        CSItems.addItemWithRecipe(redstonePick, c15 + l3, "Redstone Pickaxe", 1, new Object[]{"XXX", " | ", " | ", Character.valueOf('X'), Block.blockRedstone, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(redstoneShovel, c15 + l2, "Redstone Shovel", 1, new Object[]{"X", "|", "|", Character.valueOf('X'), Block.blockRedstone, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(redstoneAxe, c15 + l4, "Redstone Axe", 1, new Object[]{"XX", "X|", " |", Character.valueOf('X'), Block.blockRedstone, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(redstoneHoe, c15 + l5, "Redstone Hoe", 1, new Object[]{"XX", " |", " |", Character.valueOf('X'), Block.blockRedstone, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(redstoneSword, c15 + l1, "Redstone Sword", 1, new Object[]{"X", "X", "|", Character.valueOf('X'), Block.blockRedstone, Character.valueOf('|'), Item.stick}); 
        
        //Coal tools.
        
        Item coalPick = (new ItemPickaxeMoreTools(1911, COAL)).setUnlocalizedName("coalPickaxe");
        Item coalShovel = (new ItemSpadeMoreTools(1912, COAL)).setUnlocalizedName("coalShovel");
        Item coalAxe = (new ItemAxeMoreTools(1913, COAL)).setUnlocalizedName("coalAxe");
        Item coalHoe = (new ItemHoeMoreTools(1914, COAL)).setUnlocalizedName("coalHoe");
        Item coalSword = (new ItemSwordMoreTools(1915, COAL, COMMON)).setUnlocalizedName("coalSword");
        ModLoader.addName(coalPick, "Coal Pickaxe");
        ModLoader.addName(coalShovel, "Coal Shovel");
        ModLoader.addName(coalAxe, "Coal Axe");
        ModLoader.addName(coalHoe, "Coal Hoe");
        ModLoader.addName(coalSword, "Coal Sword");
        ModLoader.addRecipe(new ItemStack(coalPick, 1), new Object[] {
            "XXX", " | ", " | ", Character.valueOf('X'), Item.coal, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(coalShovel, 1), new Object[] {
            "X", "|", "|", 		 Character.valueOf('X'), Item.coal, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(coalAxe, 1), new Object[] {
            "XX", "X|", " |", 	 Character.valueOf('X'), Item.coal, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(coalHoe, 1), new Object[] {
            "XX", " |", " |", 	 Character.valueOf('X'), Item.coal, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(coalSword, 1), new Object[] {
            "X", "X", "|", 		 Character.valueOf('X'), Item.coal, Character.valueOf('|'), Item.stick
        });
        
        //Lapislazuli tools.
        
        Item lapisPick = (new ItemPickaxeMoreTools(1916, LAPIS)).setUnlocalizedName("lapisPickaxe");
        Item lapisShovel = (new ItemSpadeMoreTools(1917, LAPIS)).setUnlocalizedName("lapisShovel");
        Item lapisAxe = (new ItemAxeMoreTools(1918, LAPIS)).setUnlocalizedName("lapisAxe");
        Item lapisHoe = (new ItemHoeMoreTools(1919, LAPIS)).setUnlocalizedName("lapisHoe");
        Item lapisSword = (new ItemSwordMoreTools(1920, LAPIS, COMMON)).setUnlocalizedName("lapisSword");
        ModLoader.addName(lapisPick, "Lapislazuli Pickaxe");
        ModLoader.addName(lapisShovel, "Lapislazuli Shovel");
        ModLoader.addName(lapisAxe, "Lapislazuli Axe");
        ModLoader.addName(lapisHoe, "Lapislazuli Hoe");
        ModLoader.addName(lapisSword, "Lapislazuli Sword");
        ModLoader.addRecipe(new ItemStack(lapisPick, 1), new Object[] {
            "XXX", " | ", " | ", Character.valueOf('X'), Block.blockLapis, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(lapisShovel, 1), new Object[] {
            "X", "|", "|", 		 Character.valueOf('X'), Block.blockLapis, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(lapisAxe, 1), new Object[] {
            "XX", "X|", " |", 	 Character.valueOf('X'), Block.blockLapis, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(lapisHoe, 1), new Object[] {
            "XX", " |", " |", 	 Character.valueOf('X'), Block.blockLapis, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(lapisSword, 1), new Object[] {
            "X", "X", "|", 		 Character.valueOf('X'), Block.blockLapis, Character.valueOf('|'), Item.stick
        });
        
        //Endertools.
        
        Item enderPick = (new ItemPickaxeMoreTools(1921, END)).setUnlocalizedName("enderPickaxe");
        Item enderShovel = (new ItemSpadeMoreTools(1922, END)).setUnlocalizedName("enderShovel");
        Item enderAxe = (new ItemAxeMoreTools(1923, END)).setUnlocalizedName("enderAxe");
        Item enderHoe = (new ItemHoeMoreTools(1924, END)).setUnlocalizedName("enderHoe");
        Item enderSword = (new ItemSwordMoreTools(1925, END, RARE)).setUnlocalizedName("enderSword");
        ModLoader.addName(enderPick, "Ender Pickaxe");
        ModLoader.addName(enderShovel, "Ender Shovel");
        ModLoader.addName(enderAxe, "Ender Axe");
        ModLoader.addName(enderHoe, "Ender Hoe");
        ModLoader.addName(enderSword, "Ender Sword");
        ModLoader.addRecipe(new ItemStack(enderPick, 1), new Object[] {
            "XXX", " | ", " | ", Character.valueOf('X'), Item.enderPearl, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(enderShovel, 1), new Object[] {
            "X", "|", "|", 		 Character.valueOf('X'), Item.enderPearl, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(enderAxe, 1), new Object[] {
            "XX", "X|", " |", 	 Character.valueOf('X'), Item.enderPearl, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(enderHoe, 1), new Object[] {
            "XX", " |", " |", 	 Character.valueOf('X'), Item.enderPearl, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(enderSword, 1), new Object[] {
            "X", "X", "|", 		 Character.valueOf('X'), Item.enderPearl, Character.valueOf('|'), Item.stick
        });
        
        //Space Tools.
        
        ModLoader.addName(spacePick, "Spacepickaxe");
        ModLoader.addName(spaceShovel, "Spaceshovel");
        ModLoader.addName(spaceAxe, "Spaceaxe");
        ModLoader.addName(spaceHoe, "Spacehoe");
        ModLoader.addName(spaceSwordStrong, "Epic Spacesword");
        ModLoader.addName(spaceSwordWeak, "Normal Spacesword");
        ModLoader.addRecipe(new ItemStack(spacePick, 1), new Object[] {
            "XXX", " | ", " | ", Character.valueOf('X'), spaceIngot, Character.valueOf('|'), Item.stick
        });                     
        ModLoader.addRecipe(new ItemStack(spaceShovel, 1), new Object[] {
            "X", "|", "|", 		 Character.valueOf('X'), spaceIngot, Character.valueOf('|'), Item.stick
        });                     
        ModLoader.addRecipe(new ItemStack(spaceAxe, 1), new Object[] {
            "XX", "X|", " |", 	 Character.valueOf('X'), spaceIngot, Character.valueOf('|'), Item.stick
        });                     
        ModLoader.addRecipe(new ItemStack(spaceHoe, 1), new Object[] {
            "XX", " |", " |", 	 Character.valueOf('X'), spaceIngot, Character.valueOf('|'), Item.stick
        });                     
        ModLoader.addRecipe(new ItemStack(spaceSwordStrong, 1), new Object[] {
            "X", "X", "|", 		 Character.valueOf('X'), spaceBlock, Character.valueOf('|'), Item.stick
        });
        ModLoader.addRecipe(new ItemStack(spaceSwordWeak, 1), new Object[] {
        	"X", "X", "|", Character.valueOf('X'), spaceIngot, Character.valueOf('|'), Item.stick
        });
        
        //Bone tools.
        
        Item bonePick = (new ItemPickaxeMoreTools(1931, BONE)).setUnlocalizedName("bonePickaxe");
        Item boneShovel = (new ItemSpadeMoreTools(1932, BONE)).setUnlocalizedName("boneShovel");
        Item boneAxe = (new ItemAxeMoreTools(1933, BONE)).setUnlocalizedName("boneAxe");
        Item boneHoe = (new ItemHoeMoreTools(1934, BONE)).setUnlocalizedName("boneHoe");
        Item boneSword = (new ItemSwordMoreTools(1935, BONE, COMMON)).setUnlocalizedName("boneSword");
        ModLoader.addName(bonePick, "Bone Pickaxe");
        ModLoader.addName(boneShovel, "Bone Shovel");
        ModLoader.addName(boneAxe, "Bone Axe");
        ModLoader.addName(boneHoe, "Bone Hoe");
        ModLoader.addName(boneSword, "Bone Sword");
        ModLoader.addRecipe(new ItemStack(bonePick, 1), new Object[] {
            "XXX", " | ", " | ", Character.valueOf('X'), Item.bone, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(boneShovel, 1), new Object[] {
            "X", "|", "|", 		 Character.valueOf('X'), Item.bone, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(boneAxe, 1), new Object[] {
            "XX", "X|", " |", 	 Character.valueOf('X'), Item.bone, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(boneHoe, 1), new Object[] {
            "XX", " |", " |", 	 Character.valueOf('X'), Item.bone, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(boneSword, 1), new Object[] {
            "X", "X", "|", 		 Character.valueOf('X'), Item.bone, Character.valueOf('|'), Item.stick
        });
        
        //Sugarcane Tools.
        
        Item sugarcanePick = (new ItemPickaxeMoreTools(1936, REED)).setUnlocalizedName("sugarcanePickaxe");
        Item sugarcaneShovel = (new ItemSpadeMoreTools(1937, REED)).setUnlocalizedName("sugarcaneShovel");
        Item sugarcaneAxe = (new ItemAxeMoreTools(1938, REED)).setUnlocalizedName("sugarcaneAxe");
        Item sugarcaneHoe = (new ItemHoeMoreTools(1939, REED)).setUnlocalizedName("sugarcaneHoe");
        Item sugarcaneSword = (new ItemSwordMoreTools(1940, REED, COMMON)).setUnlocalizedName("sugarcaneSword");
        ModLoader.addName(sugarcanePick, "Sugarcane Pickaxe");
        ModLoader.addName(sugarcaneShovel, "Sugarcane Shovel");
        ModLoader.addName(sugarcaneAxe, "Sugarcane Axe");
        ModLoader.addName(sugarcaneHoe, "Sugarcane Hoe");
        ModLoader.addName(sugarcaneSword, "Senseis Sword");
        ModLoader.addRecipe(new ItemStack(sugarcanePick, 1), new Object[] {
            "XXX", " | ", " | ", Character.valueOf('X'), Item.reed, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(sugarcaneShovel, 1), new Object[] {
            "X", "|", "|", 		 Character.valueOf('X'), Item.reed, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(sugarcaneAxe, 1), new Object[] {
            "XX", "X|", " |", 	 Character.valueOf('X'), Item.reed, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(sugarcaneHoe, 1), new Object[] {
            "XX", " |", " |", 	 Character.valueOf('X'), Item.reed, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(sugarcaneSword, 1), new Object[] {
            "X", "X", "|", 		 Character.valueOf('X'), Item.reed, Character.valueOf('|'), Item.stick
        });
        
        //Blazerod Tools.
        
        Item blazerodPick = (new ItemPickaxeMoreTools(1941, BLAZEROD)).setUnlocalizedName("blazePickaxe");
        Item blazerodShovel = (new ItemSpadeMoreTools(1942, BLAZEROD)).setUnlocalizedName("blazeShovel");
        Item blazerodAxe = (new ItemAxeMoreTools(1943, BLAZEROD)).setUnlocalizedName("blazeAxe");
        Item blazerodHoe = (new ItemHoeMoreTools(1944, BLAZEROD)).setUnlocalizedName("blazeHoe");
        Item blazerodSword = (new ItemSwordMoreTools(1945, BLAZEROD, UNCOMMON)).setUnlocalizedName("blazeSword");
        ModLoader.addName(blazerodPick, "Blaze Pickaxe");
        ModLoader.addName(blazerodShovel, "Blaze Shovel");
        ModLoader.addName(blazerodAxe, "Blaze Axe");
        ModLoader.addName(blazerodHoe, "Blaze Hoe");
        ModLoader.addName(blazerodSword, "Blaze Sword");
        ModLoader.addRecipe(new ItemStack(blazerodPick, 1), new Object[] {
            "XXX", " | ", " | ", Character.valueOf('X'), Item.blazeRod, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(blazerodShovel, 1), new Object[] {
            "X", "|", "|", 		 Character.valueOf('X'), Item.blazeRod, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(blazerodAxe, 1), new Object[] {
            "XX", "X|", " |", 	 Character.valueOf('X'), Item.blazeRod, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(blazerodHoe, 1), new Object[] {
            "XX", " |", " |", 	 Character.valueOf('X'), Item.blazeRod, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(blazerodSword, 1), new Object[] {
            "X", "X", "|", 		 Character.valueOf('X'), Item.blazeRod, Character.valueOf('|'), Item.stick
        });
        
        //Dirt Tools.
        
        Item dirtPick = (new ItemPickaxeMoreTools(1946, DIRT)).setUnlocalizedName("dirtPickaxe");
        Item dirtShovel = (new ItemSpadeMoreTools(1947, DIRT)).setUnlocalizedName("dirtShovel");
        Item dirtAxe = (new ItemAxeMoreTools(1948, DIRT)).setUnlocalizedName("dirtAxe");
        Item dirtHoe = (new ItemHoeMoreTools(1949, DIRT)).setUnlocalizedName("dirtHoe");
        Item dirtSword = (new ItemSwordMoreTools(1950, DIRT, COMMON)).setUnlocalizedName("dirtSword");
        ModLoader.addName(dirtPick, "Dirt Pickaxe");
        ModLoader.addName(dirtShovel, "Dirt Shovel");
        ModLoader.addName(dirtAxe, "Dirt Axe");
        ModLoader.addName(dirtHoe, "Dirt Hoe");
        ModLoader.addName(dirtSword, "Dirt Sword");
        ModLoader.addRecipe(new ItemStack(dirtPick, 1), new Object[] {
            "XXX", " | ", " | ", Character.valueOf('X'), Block.dirt, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(dirtShovel, 1), new Object[] {
            "X", "|", "|", 		 Character.valueOf('X'), Block.dirt, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(dirtAxe, 1), new Object[] {
            "XX", "X|", " |", 	 Character.valueOf('X'), Block.dirt, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(dirtHoe, 1), new Object[] {
            "XX", " |", " |", 	 Character.valueOf('X'), Block.dirt, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(dirtSword, 1), new Object[] {
            "X", "X", "|", 		 Character.valueOf('X'), Block.dirt, Character.valueOf('|'), Item.stick
        });
        
        //Glass Tools.
        
        Item glassPick = (new ItemPickaxeMoreTools(1951, GLASS)).setUnlocalizedName("glassPickaxe");
        Item glassShovel = (new ItemSpadeMoreTools(1952, GLASS)).setUnlocalizedName("glassShovel");
        Item glassAxe = (new ItemAxeMoreTools(1953, GLASS)).setUnlocalizedName("glassAxe");
        Item glassHoe = (new ItemHoeMoreTools(1954, GLASS)).setUnlocalizedName("glassHoe");
        Item glassSword = (new ItemSwordMoreTools(1955, GLASS, COMMON)).setUnlocalizedName("glassSword");
        ModLoader.addName(glassPick, "Glass Pickaxe");
        ModLoader.addName(glassShovel, "Glass Shovel");
        ModLoader.addName(glassAxe, "Glass Axe");
        ModLoader.addName(glassHoe, "Glass Hoe");
        ModLoader.addName(glassSword, "Glass Sword");
        ModLoader.addRecipe(new ItemStack(glassPick, 1), new Object[] {
            "XXX", " | ", " | ", Character.valueOf('X'), Block.glass, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(glassShovel, 1), new Object[] {
            "X", "|", "|", 		 Character.valueOf('X'), Block.glass, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(glassAxe, 1), new Object[] {
            "XX", "X|", " |", 	 Character.valueOf('X'), Block.glass, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(glassHoe, 1), new Object[] {
            "XX", " |", " |", 	 Character.valueOf('X'), Block.glass, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(glassSword, 1), new Object[] {
            "X", "X", "|", 		 Character.valueOf('X'), Block.glass, Character.valueOf('|'), Item.stick
        });
        
        //Sandstone Tools.
        
        Item sandstonePick = (new ItemPickaxeMoreTools(1956, SANDSTONE)).setUnlocalizedName("sandstonePickaxe");
        Item sandstoneShovel = (new ItemSpadeMoreTools(1957, SANDSTONE)).setUnlocalizedName("sandstoneShovel");
        Item sandstoneAxe = (new ItemAxeMoreTools(1958, SANDSTONE)).setUnlocalizedName("sandstoneAxe");
        Item sandstoneHoe = (new ItemHoeMoreTools(1959, SANDSTONE)).setUnlocalizedName("sandstoneHoe");
        Item sandstoneSword = (new ItemSwordMoreTools(1960, SANDSTONE, COMMON)).setUnlocalizedName("sandstoneSword");
        ModLoader.addName(sandstonePick, "Sandstone Pickaxe");
        ModLoader.addName(sandstoneShovel, "Sandstone Shovel");
        ModLoader.addName(sandstoneAxe, "Sandstone Axe");
        ModLoader.addName(sandstoneHoe, "Sandstone Hoe");
        ModLoader.addName(sandstoneSword, "Sandstone Sword");
        ModLoader.addRecipe(new ItemStack(sandstonePick, 1), new Object[] {
            "XXX", " | ", " | ", Character.valueOf('X'), Block.sandStone, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(sandstoneShovel, 1), new Object[] {
            "X", "|", "|", 		 Character.valueOf('X'), Block.sandStone, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(sandstoneAxe, 1), new Object[] {
            "XX", "X|", " |", 	 Character.valueOf('X'), Block.sandStone, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(sandstoneHoe, 1), new Object[] {
            "XX", " |", " |", 	 Character.valueOf('X'), Block.sandStone, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(sandstoneSword, 1), new Object[] {
            "X", "X", "|", 		 Character.valueOf('X'), Block.sandStone, Character.valueOf('|'), Item.stick
        });
        
        //Brick Tools.
        
        Item brickPick = (new ItemPickaxeMoreTools(1961, BRICK)).setUnlocalizedName("brickPickaxe");
        Item brickShovel = (new ItemSpadeMoreTools(1962, BRICK)).setUnlocalizedName("brickShovel");
        Item brickAxe = (new ItemAxeMoreTools(1963, BRICK)).setUnlocalizedName("brickAxe");
        Item brickHoe = (new ItemHoeMoreTools(1964, BRICK)).setUnlocalizedName("brickHoe");
        Item brickSword = (new ItemSwordMoreTools(1965, BRICK, COMMON)).setUnlocalizedName("brickSword");
        ModLoader.addName(brickPick, "Brick Pickaxe");
        ModLoader.addName(brickShovel, "Brick Shovel");
        ModLoader.addName(brickAxe, "Brick Axe");
        ModLoader.addName(brickHoe, "Brick Hoe");
        ModLoader.addName(brickSword, "Brick Sword");
        ModLoader.addRecipe(new ItemStack(brickPick, 1), new Object[] {
            "XXX", " | ", " | ", Character.valueOf('X'), Item.brick, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(brickShovel, 1), new Object[] {
            "X", "|", "|", 		 Character.valueOf('X'), Item.brick, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(brickAxe, 1), new Object[] {
            "XX", "X|", " |", 	 Character.valueOf('X'), Item.brick, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(brickHoe, 1), new Object[] {
            "XX", " |", " |", 	 Character.valueOf('X'), Item.brick, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(brickSword, 1), new Object[] {
            "X", "X", "|", 		 Character.valueOf('X'), Item.brick, Character.valueOf('|'), Item.stick
        });
        
        //Endstone Tools.
        
        Item endstonePick = (new ItemPickaxeMoreTools(1966, ENDSTONE)).setUnlocalizedName("endstonePickaxe");
        Item endstoneShovel = (new ItemSpadeMoreTools(1967, ENDSTONE)).setUnlocalizedName("endstoneShovel");
        Item endstoneAxe = (new ItemAxeMoreTools(1968, ENDSTONE)).setUnlocalizedName("endstoneAxe");
        Item endstoneHoe = (new ItemHoeMoreTools(1969, ENDSTONE)).setUnlocalizedName("endstoneHoe");
        Item endstoneSword = (new ItemSwordMoreTools(1970, ENDSTONE, UNCOMMON)).setUnlocalizedName("endstoneSword");
        ModLoader.addName(endstonePick, "Endstone Pickaxe");
        ModLoader.addName(endstoneShovel, "Endstone Shovel");
        ModLoader.addName(endstoneAxe, "Endstone Axe");
        ModLoader.addName(endstoneHoe, "Endstone Hoe");
        ModLoader.addName(endstoneSword, "Endstone Sword");
        ModLoader.addRecipe(new ItemStack(endstonePick, 1), new Object[] {
            "XXX", " | ", " | ", Character.valueOf('X'), Block.whiteStone, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(endstoneShovel, 1), new Object[] {
            "X", "|", "|", 		 Character.valueOf('X'), Block.whiteStone, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(endstoneAxe, 1), new Object[] {
            "XX", "X|", " |", 	 Character.valueOf('X'), Block.whiteStone, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(endstoneHoe, 1), new Object[] {
            "XX", " |", " |", 	 Character.valueOf('X'), Block.whiteStone, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(endstoneSword, 1), new Object[] {
            "X", "X", "|", 		 Character.valueOf('X'), Block.whiteStone, Character.valueOf('|'), Item.stick
        });
        
        //Excalibur.
        
        Item excaliburSword = (new ItemSwordMoreTools(1975, EXCALIBUR, EPIC)).setUnlocalizedName("epicSword");
        ModLoader.addName(excaliburSword, "Excalibur");
        ModLoader.addRecipe(new ItemStack(excaliburSword, 1), new Object[]{
        	"gGg",
        	"gDg",
        	" | ",
        	Character.valueOf('g'), Item.ghastTear, Character.valueOf('G'), Block.blockGold,
        	Character.valueOf('D'), Block.blockDiamond,
        	Character.valueOf('|'), Item.stick
        });
        
        //Hallowed Tools.
        
        Item godPick = (new ItemPickaxeMoreTools(1976, GOD)).setUnlocalizedName("godPickaxe");
        Item godShovel = (new ItemSpadeMoreTools(1977, GOD)).setUnlocalizedName("godShovel");
        Item godAxe = (new ItemAxeMoreTools(1978, GOD)).setUnlocalizedName("godAxe");
        Item godHoe = (new ItemHoeMoreTools(1979, GOD)).setUnlocalizedName("godHoe");
        Item godSword = (new ItemSwordMoreTools(1980, GOD, EPIC)).setUnlocalizedName("godSword");
        ModLoader.addName(godPick, "God's Pickaxe");
        ModLoader.addName(godShovel, "God's Shovel");
        ModLoader.addName(godAxe, "God's Axe");
        ModLoader.addName(godHoe, "God's Hoe");
        ModLoader.addName(godSword, "God's Sword");
        ModLoader.addRecipe(new ItemStack(godPick, 1), new Object[]{
        	"GGG", "g|g", " | ", Character.valueOf('g'), Item.lightStoneDust, Character.valueOf('G'), Block.blockGold, Character.valueOf('|'), Item.stick
        });
        ModLoader.addRecipe(new ItemStack(godShovel, 1), new Object[]{
        	"gGg", " | ", " | ", Character.valueOf('g'), Item.lightStoneDust, Character.valueOf('G'), Block.blockGold, Character.valueOf('|'), Item.stick
        });
        ModLoader.addRecipe(new ItemStack(godAxe, 1), new Object[]{
        	"GGg", "G|g", " | ", Character.valueOf('g'), Item.lightStoneDust, Character.valueOf('G'), Block.blockGold, Character.valueOf('|'), Item.stick
        });
        ModLoader.addRecipe(new ItemStack(godHoe, 1), new Object[]{
        	"GGg", "g| ", " | ", Character.valueOf('g'), Item.lightStoneDust, Character.valueOf('G'), Block.blockGold, Character.valueOf('|'), Item.stick
        });
        ModLoader.addRecipe(new ItemStack(godSword, 1), new Object[]{
        	"gGg", "gGg", " | ", Character.valueOf('g'), Item.lightStoneDust, Character.valueOf('G'), Block.blockGold, Character.valueOf('|'), Item.stick
        });
        
        //Goddawn Tools.
        
        Item luziferPick = (new ItemPickaxeMoreTools(1981, LUZIFER)).setUnlocalizedName("luziferPickaxe");
        Item luziferShovel = (new ItemSpadeMoreTools(1982, LUZIFER)).setUnlocalizedName("luziferShovel");
        Item luziferAxe = (new ItemAxeMoreTools(1983, LUZIFER)).setUnlocalizedName("luziferAxe");
        Item luziferHoe = (new ItemHoeMoreTools(1984, LUZIFER)).setUnlocalizedName("luziferHoe");
        Item luziferSword = (new ItemSwordMoreTools(1985, LUZIFER, EPIC)).setUnlocalizedName("luziferSword");
        ModLoader.addName(luziferPick, "Luzifer's Pickaxe");
        ModLoader.addName(luziferShovel, "Luzifer's Shovel");
        ModLoader.addName(luziferAxe, "Luzifer's Axe");
        ModLoader.addName(luziferHoe, "Luzifer's Hoe");
        ModLoader.addName(luziferSword, "Luzifer's Sword");
        ModLoader.addRecipe(new ItemStack(luziferPick, 1), new Object[]{
        	"NNN", "r|r", " | ", Character.valueOf('r'), Item.redstone, Character.valueOf('N'), Block.netherrack, Character.valueOf('|'), Item.stick
        });
        ModLoader.addRecipe(new ItemStack(luziferShovel, 1), new Object[]{
        	"rNr", " | ", " | ", Character.valueOf('r'), Item.redstone, Character.valueOf('N'), Block.netherrack, Character.valueOf('|'), Item.stick
        });
        ModLoader.addRecipe(new ItemStack(luziferAxe, 1), new Object[]{
        	"NNr", "N|r", " | ", Character.valueOf('r'), Item.redstone, Character.valueOf('N'), Block.netherrack, Character.valueOf('|'), Item.stick
        });
        ModLoader.addRecipe(new ItemStack(luziferHoe, 1), new Object[]{
        	"NNr", "r| ", " | ", Character.valueOf('r'), Item.redstone, Character.valueOf('N'), Block.netherrack, Character.valueOf('|'), Item.stick
        });
        ModLoader.addRecipe(new ItemStack(luziferSword, 1), new Object[]{
        	"rNr", "rNr", " | ", Character.valueOf('r'), Item.redstone, Character.valueOf('N'), Block.netherrack, Character.valueOf('|'), Item.stick
        });
        
        //Lightsabers.
        
        ModLoader.addName(lightsaberShaft, "Lightsaber Shaft");
        ModLoader.addName(lightsaberBlue, "Blue Lightsaber");
        ModLoader.addName(lightsaberGreen, "Green Lightsaber");
        ModLoader.addName(lightsaberPurple, "Purple Lightsaber");
        ModLoader.addName(lightsaberRed, "Red Lightsaber");
        ModLoader.addName(lightsaberWhite, "White Lightsaber");
        ModLoader.addRecipe(new ItemStack(lightsaberShaft, 1), new Object[]{
        	"idi",
        	"rGi",
        	"iii",
        	Character.valueOf('i'), Item.ingotIron, Character.valueOf('r'), Item.diamond,
        	Character.valueOf('r'), Item.redstone, Character.valueOf('G'), Block.glowStone
        });
        
        //Emerald Tools.
        
        Item emeraldPick = (new ItemPickaxeMoreTools(1991, EMERALD2)).setUnlocalizedName("emeraldPickaxe");
        Item emeraldShovel = (new ItemSpadeMoreTools(1992, EMERALD2)).setUnlocalizedName("emeraldShovel");
        Item emeraldAxe = (new ItemAxeMoreTools(1993, EMERALD2)).setUnlocalizedName("emeraldAxe");
        Item emeraldHoe = (new ItemHoeMoreTools(1994, EMERALD2)).setUnlocalizedName("emeraldHoe");
        Item emeraldSword = (new ItemSwordMoreTools(1995, EMERALD2, EPIC)).setUnlocalizedName("emeraldSword");
        ModLoader.addName(emeraldPick, "Emerald Pickaxe");
        ModLoader.addName(emeraldShovel, "Emerald Shovel");
        ModLoader.addName(emeraldAxe, "Emerald Axe");
        ModLoader.addName(emeraldHoe, "Emerald Hoe");
        ModLoader.addName(emeraldSword, "Emerald Sword");
        ModLoader.addRecipe(new ItemStack(emeraldPick, 1), new Object[]{
            "XXX", " | ", " | ", Character.valueOf('X'), Item.emerald, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(emeraldShovel, 1), new Object[]{
            "X", "|", "|", 		 Character.valueOf('X'), Item.emerald, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(emeraldAxe, 1), new Object[]{
            "XX", "X|", " |", 	 Character.valueOf('X'), Item.emerald, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(emeraldHoe, 1), new Object[]{
            "XX", " |", " |", 	 Character.valueOf('X'), Item.emerald, Character.valueOf('|'), Item.stick
        });                      
        ModLoader.addRecipe(new ItemStack(emeraldSword, 1), new Object[]{
            "X", "X", "|", 		 Character.valueOf('X'), Item.emerald, Character.valueOf('|'), Item.stick
        });
        
        //Netherstar tools
        
        Item netherstarPick = (new ItemPickaxeMoreTools(1996, NETHERSTAR)).setUnlocalizedName("netherstarPickaxe");
        Item netherstarShovel = (new ItemSpadeMoreTools(1997, NETHERSTAR)).setUnlocalizedName("netherstarShovel");
        Item netherstarAxe = (new ItemAxeMoreTools(1998, NETHERSTAR)).setUnlocalizedName("netherstarAxe");
        Item netherstarHoe = (new ItemHoeMoreTools(1999, NETHERSTAR)).setUnlocalizedName("netherstarHoe");
        Item netherstarSword = (new ItemSwordMoreTools(2020, NETHERSTAR, EPIC)).setUnlocalizedName("netherstarSword");
        CSItems.addItemWithRecipe(netherstarPick, c4 + l8, "Nether Star Pickaxe", 1, new Object[]{"XXX", " | ", " | ", Character.valueOf('X'), Item.netherStar, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(netherstarShovel, c4 + l7, "Nether Star Shovel", 1, new Object[]{"X", "|", "|", Character.valueOf('X'), Item.netherStar, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(netherstarAxe, c4 + l9, "Nether Star Axe", 1, new Object[]{"XX", "X|", " |", Character.valueOf('X'), Item.netherStar, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(netherstarHoe, c4 + l10, "Nether Star Hoe", 1, new Object[]{"XX", " |", " |", Character.valueOf('X'), Item.netherStar, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(netherstarSword, c4 + l6, "Nether Star Sword", 1, new Object[]{"X", "X", "|", Character.valueOf('X'), Item.netherStar, Character.valueOf('|'), Item.stick});
        
        //Potato tools
        
        Item potatoPick = (new ItemPickaxeMoreTools(2021, POTATO)).setUnlocalizedName("potatoPickaxe");
        Item potatoShovel = (new ItemSpadeMoreTools(2022, POTATO)).setUnlocalizedName("potatoShovel");
        Item potatoAxe = (new ItemAxeMoreTools(2023, POTATO)).setUnlocalizedName("potatoAxe");
        Item potatoHoe = (new ItemHoeMoreTools(2024, POTATO)).setUnlocalizedName("potatoHoe");
        Item potatoSword = (new ItemSwordMoreTools(2025, POTATO, COMMON)).setUnlocalizedName("potatoSword");
        CSItems.addItemWithRecipe(potatoPick, c5 + l8, "Potato Pickaxe", 1, new Object[]{"XXX", " | ", " | ", Character.valueOf('X'), Item.potato, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(potatoShovel, c5 + l7, "Potato Shovel", 1, new Object[]{"X", "|", "|", Character.valueOf('X'), Item.potato, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(potatoAxe, c5 + l9, "Potato Axe", 1, new Object[]{"XX", "X|", " |", Character.valueOf('X'), Item.potato, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(potatoHoe, c5 + l10, "Potato Hoe", 1, new Object[]{"XX", " |", " |", Character.valueOf('X'), Item.potato, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(potatoSword, c5 + l6, "Potato Sword", 1, new Object[]{"X", "|", "|", Character.valueOf('X'), Item.potato, Character.valueOf('|'), Item.stick});
        
        //Carrot tools
        
        Item carrotPick = (new ItemPickaxeMoreTools(2026, CARROT)).setUnlocalizedName("carrotPickaxe");
        Item carrotShovel = (new ItemSpadeMoreTools(2027, CARROT)).setUnlocalizedName("carrotShovel");
        Item carrotAxe = (new ItemAxeMoreTools(2028, CARROT)).setUnlocalizedName("carrotAxe");
        Item carrotHoe = (new ItemHoeMoreTools(2029, CARROT)).setUnlocalizedName("carrotHoe");
        Item carrotSword = (new ItemSwordMoreTools(2030, CARROT, COMMON)).setUnlocalizedName("carrotSword");
        CSItems.addItemWithRecipe(carrotPick, c6 + l8, "Carrot Pickaxe", 1, new Object[]{"XXX", " | ", " | ", Character.valueOf('X'), Item.carrot, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(carrotShovel, c6 + l7, "Carrot Shovel", 1, new Object[]{"X", "|", "|", Character.valueOf('X'), Item.carrot, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(carrotAxe, c6 + l9, "Carrot Axe", 1, new Object[]{"XX", "X|", " |", Character.valueOf('X'), Item.carrot, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(carrotHoe, c6 + l10, "Carrot Hoe", 1, new Object[]{"XX", " |", " |", Character.valueOf('X'), Item.carrot, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(carrotSword, c6 + l6, "Carrot Sword", 1, new Object[]{"X", "X", "|", Character.valueOf('X'), Item.carrot, Character.valueOf('|'), Item.stick});
        
        //Fish tools
        
        Item fishPick = (new ItemPickaxeMoreTools(2031, FISH)).setUnlocalizedName("fishPickaxe");
        Item fishShovel = (new ItemSpadeMoreTools(2032, FISH)).setUnlocalizedName("fishShovel");
        Item fishAxe = (new ItemAxeMoreTools(2033, FISH)).setUnlocalizedName("fishAxe");
        Item fishHoe = (new ItemHoeMoreTools(2034, FISH)).setUnlocalizedName("fishHoe");
        Item fishSword = (new ItemSwordMoreTools(2035, FISH, COMMON)).setUnlocalizedName("fishSword");
        CSItems.addItemWithRecipe(fishPick, c7 + l8, "Fish Pickaxe", 1, new Object[]{"XXX", " | ", " | ", Character.valueOf('X'), Item.fishRaw, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(fishShovel, c7 + l7, "Fish Shovel", 1, new Object[]{"X", "|", "|", Character.valueOf('X'), Item.fishRaw, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(fishAxe, c7 + l9, "Fish Axe", 1, new Object[]{"XX", "X|", " |", Character.valueOf('X'), Item.fishRaw, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(fishHoe, c7 + l10, "Fish Hoe", 1, new Object[]{"XX", " |", " |", Character.valueOf('X'), Item.fishRaw, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(fishSword, c7 + l6, "Fish Sword", 1, new Object[]{"X", "X", "|", Character.valueOf('X'), Item.fishRaw, Character.valueOf('|'), Item.stick});
        
        //Bacon tools.
        
        Item baconPick = (new ItemPickaxeMoreTools(2036, BACON)).setUnlocalizedName("baconPickaxe");
        Item baconShovel = (new ItemSpadeMoreTools(2037, BACON)).setUnlocalizedName("baconShovel");
        Item baconAxe = (new ItemAxeMoreTools(2038, BACON)).setUnlocalizedName("baconAxe");
        Item baconHoe = (new ItemHoeMoreTools(2039, BACON)).setUnlocalizedName("baconHoe");
        Item baconSword = (new ItemSwordMoreTools(2040, BACON, COMMON)).setUnlocalizedName("baconSword");
        CSItems.addItemWithRecipe(baconPick, c8 + l8, "Bacon Pickaxe", 1, new Object[]{"XXX", " | ", " | ", Character.valueOf('X'), Item.porkRaw, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(baconShovel, c8 + l7, "Bacon Shovel", 1, new Object[]{"X", "|", "|", Character.valueOf('X'), Item.porkRaw, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(baconAxe, c8 + l9, "Bacon Axe", 1, new Object[]{"XX", "X|", " |", Character.valueOf('X'), Item.porkRaw, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(baconHoe, c8 + l10, "Bacon Hoe", 1, new Object[]{"XX", " |", " |", Character.valueOf('X'), Item.porkRaw, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(baconSword, c8 + l6, "Bacon Sword", 1, new Object[]{"X", "X", "|", Character.valueOf('X'), Item.porkRaw, Character.valueOf('|'), Item.stick});
        
        //Dyeable tools.
        
        Item leatherPick = (new ItemDyeablePickaxeMoreTools(2041, LEATHER)).setUnlocalizedName("leatherPickaxe");
        Item leatherShovel = (new ItemDyeableSpadeMoreTools(2042, LEATHER)).setUnlocalizedName("leatherShovel");
        Item leatherAxe = (new ItemDyeableAxeMoreTools(2043, LEATHER)).setUnlocalizedName("leatherAxe");
        Item leatherHoe = (new ItemDyeableHoeMoreTools(2044, LEATHER)).setUnlocalizedName("leatherHoe");
        Item leatherSword = (new ItemDyeableSwordMoreTools(2045, LEATHER)).setUnlocalizedName("leatherSword");
        CSItems.addItemWithRecipe(leatherPick, c15 + l3, "Leather Pickaxe", 1, new Object[]{"XXX", " | ", " | ", Character.valueOf('X'), Item.leather, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(leatherShovel, c15 + l2, "Leather Shovel", 1, new Object[]{"X", "|", "|", Character.valueOf('X'), Item.leather, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(leatherAxe, c15 + l4, "Leather Axe", 1, new Object[]{"XX", "X|", " |", Character.valueOf('X'), Item.leather, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(leatherHoe, c15 + l5, "Leather Hoe", 1, new Object[]{"XX", " |", " |", Character.valueOf('X'), Item.leather, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(leatherSword, c15 + l1, "Leather Sword", 1, new Object[]{"X", "X", "|", Character.valueOf('X'), Item.leather, Character.valueOf('|'), Item.stick});
        
        //Glowstone Tools
        
        CSItems.addItemWithRecipe(glowstonePick, c9 + l8, "Glowstone Pickaxe", 1, new Object[]{"XXX", " | ", " | ", Character.valueOf('X'), Block.glowStone, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(glowstoneShovel, c9 + l7, "Glowstone Shovel", 1, new Object[]{"X", "|", "|", Character.valueOf('X'), Block.glowStone, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(glowstoneAxe, c9 + l9, "Glowstone Axe", 1, new Object[]{"XX", "X|", " |", Character.valueOf('X'), Block.glowStone, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(glowstoneHoe, c9 + l10, "Glowstone Hoe", 1, new Object[]{"XX", " |", " |", Character.valueOf('X'), Block.glowStone, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(glowstoneSword, c9 + l6, "Glowstone Sword", 1, new Object[]{"X", "X", "|", Character.valueOf('X'), Block.glowStone, Character.valueOf('|'), Item.stick});
        
        //Slimeball Tools
        
        CSItems.addItemWithRecipe(slimePick, c10 + l8, "Slime Pickaxe", 1, new Object[]{"XXX", " | ", " | ", Character.valueOf('X'), Item.slimeBall, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(slimeShovel, c10 + l7, "Slime Shovel", 1, new Object[]{"X", "|", "|", Character.valueOf('X'), Item.slimeBall, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(slimeAxe, c10 + l9, "Slime Axe", 1, new Object[]{"XX", "X|", " |", Character.valueOf('X'), Item.slimeBall, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(slimeHoe, c10 + l10, "Slime Hoe", 1, new Object[]{"XX", " |", " |", Character.valueOf('X'), Item.slimeBall, Character.valueOf('|'), Item.stick});
        CSItems.addItemWithRecipe(slimeSword, c10 + l6, "Slime Sword", 1, new Object[]{"X", "X", "|", Character.valueOf('X'), Item.slimeBall, Character.valueOf('|'), Item.stick});
        
        //Space things.
        
        //Space Ore.
        GameRegistry.registerBlock(spaceBlock, ItemMultiBlock.class, "SpaceBlock");
        ModLoader.addName(spaceBlock, "Space Block");
        GameRegistry.registerBlock(spaceOre, ItemBlock.class, "SpaceOre");
        ModLoader.addName(spaceOre, "Space Ore");
        
        ModLoader.addRecipe(new ItemStack(spaceBlock, 1, 1), new Object[] {"sss", "sss", "sss", Character.valueOf('s'), spaceIngot});
        //Space Multitool.
        CSItems.addItemWithShapelessRecipe(spaceMultitool, c4 + l1, "Space Multitool", 1, new Object[]{spacePick, spaceShovel, spaceAxe, spaceHoe, spaceSwordStrong});
        //Space Bow.
        CSItems.addItemWithRecipe(spaceBow, c2 + l1, "Space Bow", 1, new Object[]{"sS ", "s S", "sS ", 'S', spaceIngot, 's', Item.silk});
        //Space Arrow
        CSItems.addItemWithRecipe(spaceArrow, c3 + l1, "Space Arrow", 4, new Object[]{"s", "|", "f", Character.valueOf('s'), spaceIngot,Character.valueOf('|'), Item.stick,Character.valueOf('f'), Item.feather});
        //Space Ingot.
        CSItems.addItemWithRecipe(spaceIngot, 0, "Space Ingot", 9, new Object[]{"s", 's', new ItemStack(spaceBlock, 1, 1)});
        
        CSCrafting.addSmelting(new ItemStack(spaceOre, 1, 0), new ItemStack(spaceIngot, 1), 0.5F);
        CSCrafting.addSmelting(new ItemStack(spaceBlock, 1, 0), new ItemStack(spaceIngot, 1), 0.5F);
        
        //Other items.
        
        //Blazerod and Steel.
        Item blazerodAndSteel = (new ItemFlintAndSteelMoreTools(2104, 128)).setUnlocalizedName("blazeandsteel");
        CSItems.addItemWithRecipe(blazerodAndSteel, c5 + l1, "Blazerod and Steel", 1, new Object[]{"i ", " b", Character.valueOf('i'), Item.ingotIron, Character.valueOf('b'), Item.blazeRod});
        
        Item goldShears = (new ItemShearsMoreTools(2105, 32, 2)).setUnlocalizedName("shearsgold");
        CSItems.addItemWithRecipe(goldShears, 6, "Gold Shears", 1, new Object[]{"X ", " X", Character.valueOf('X'), Item.ingotGold});
        Item diamondShears = (new ItemShearsMoreTools(2106, 1024, 5)).setUnlocalizedName("shearsdiamond");
        CSItems.addItemWithRecipe(diamondShears, 22, "Diamond Shears", 1, new Object[]{"X ", " X", Character.valueOf('X'), Item.diamond});
        //Item skeletonBow = (new ItemBowMoreTools(2107, Item.arrow, true)).setUnlocalizedName("skeletonBow");
        
        //Glowing Block used by Glowstone Tools
        
        CSBlocks.addBlock(glowing, "Glowing Block");
    }
	
	public void load2()
	{
		MinecraftForge.setBlockHarvestLevel(spaceOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(spaceBlock, "pickaxe", 2);
		CraftingManager.getInstance().getRecipeList().add(new RecipesToolDyes());
		LanguageRegistry.instance().addStringLocalization("enchantment.quickdraw", "Quick Draw");
	}
	
	public void addName(Object o, String name){
		
		LanguageRegistry.instance().addNameForObject(o, "en_US", name);
	}
}
