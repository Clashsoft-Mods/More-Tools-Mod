package clashsoft.mods.moretools;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import clashsoft.clashsoftapi.CSLang;

import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;

public class MoreToolsMod_Achievements
{
	public static MoreToolsMod_Achievements instance = new MoreToolsMod_Achievements();
	
	public static final Achievement spaceingot =  new Achievement(1000, "spaceIngot", 5, 5, MoreToolsMod_Tools.spaceIngot, AchievementList.buildFurnace).registerAchievement();
	public static final Achievement spaceblock =  new Achievement(1001, "spaceBlock", 8, 5, new ItemStack(MoreToolsMod_Tools.spaceBlock, 1, 1), spaceingot).registerAchievement();
	public static final Achievement spacestrong = new Achievement(1002, "spaceSwordStrong", 8, 7, MoreToolsMod_Tools.spaceSwordStrong, spaceblock).registerAchievement();
    public static final Achievement spaceweak =   new Achievement(1003, "spaceSwordWeak", 5, 7, MoreToolsMod_Tools.spaceSwordWeak, spaceingot).registerAchievement();
    public static final Achievement moretools =   new Achievement(1004, "moreTools", 8, 3, MoreToolsMod_Tools.spaceAxe, AchievementList.buildWorkBench).registerAchievement();
    public static final Achievement lightsaber =  new Achievement(1005, "lightsaber", -3, 7, MoreToolsMod_Tools.lightsaberBlue, AchievementList.portal).registerAchievement();
    
    public static final HashMap<EnumToolMaterial, Achievement> materialachievements = new HashMap<EnumToolMaterial, Achievement>();
    
	public void load()
	{
		MoreToolsMod_Tools t = MoreToolsMod_Tools.instance;
		
		GameRegistry.registerCraftingHandler(new MoreToolsModCraftingHandler());
		
		addMaterialAchievement(new ItemStack(Item.coal), t.COAL);
		addMaterialAchievement(new ItemStack(Item.redstone), t.REDSTONE);
		addMaterialAchievement(new ItemStack(Item.dyePowder, 1, 4), t.LAPIS);
		addMaterialAchievement(new ItemStack(Block.obsidian), t.OBSIDIAN);
		addMaterialAchievement(new ItemStack(Item.enderPearl), t.END);
		ItemStack is = new ItemStack(t.spaceIngot);
		is.setItemName("Space Ingot");
		addMaterialAchievement(is, t.SPACE1);
		addMaterialAchievement(new ItemStack(Item.brick), t.BRICK);
		addMaterialAchievement(new ItemStack(Item.reed), t.REED);
		addMaterialAchievement(new ItemStack(Item.blazeRod), t.BLAZEROD);
		addMaterialAchievement(new ItemStack(Item.bone), t.BONE);
		addMaterialAchievement(new ItemStack(Block.dirt), t.DIRT);
		addMaterialAchievement(new ItemStack(Block.glass), t.GLASS);
		addMaterialAchievement(new ItemStack(Block.whiteStone), t.ENDSTONE);
		addMaterialAchievement(new ItemStack(Block.sandStone), t.SANDSTONE);
		addMaterialAchievement(new ItemStack(Item.emerald), t.EMERALD2);
		addMaterialAchievement(new ItemStack(Item.netherStar), t.NETHERSTAR);
		addMaterialAchievement(new ItemStack(Item.leather), t.LEATHER);
		addMaterialAchievement(new ItemStack(Item.potato), t.POTATO);
		addMaterialAchievement(new ItemStack(Item.carrot), t.CARROT);
		addMaterialAchievement(new ItemStack(Item.fishRaw), t.FISH);
		addMaterialAchievement(new ItemStack(Item.porkRaw), t.BACON);
		addMaterialAchievement(new ItemStack(Block.glowStone), t.GLOWSTONE);
		addMaterialAchievement(new ItemStack(Item.slimeBall), t.SLIME);
		
    	ModLoader.addAchievementDesc(spaceingot, "Space Ingot", "Smelt Space Ore.");
    	ModLoader.addAchievementDesc(spaceblock, "Space BLOCK!", "Craft a Spaceblock.");
    	ModLoader.addAchievementDesc(spacestrong, "Overpowered", "Craft a Spacesword with two spaceblocks and one stick.");
    	ModLoader.addAchievementDesc(spaceweak, "Less Overpowered", "Craft a Spacesword with two spaceingots and one stick.");
    	ModLoader.addAchievementDesc(moretools, "MORE TOOLS!", "Craft a tool or an armory part");
    	ModLoader.addAchievementDesc(lightsaber, "Luke, I am your father.", "Use a light saber");
	}
	
	public static void addMaterialAchievement(ItemStack material, EnumToolMaterial material2)
	{
		int id = materialachievements.size();
		String s = "materialachievement_" + material.toString();
		int posY = 1 + (id < 6 ? 0 : (id < 12 ? 1 : (id < 18 ? 2 : 3)));
		int posX = 10 + (id < 6 ? id : (id < 12 ? id - 6 : (id < 18 ? id - 12 : id - 18)));
		
		Achievement a = new Achievement(1010 + id, s, posX, posY, material, moretools).registerAchievement();
		materialachievements.put(material2, a);
		
		String name = material.getDisplayName() + " Tools";
		String description = "Craft a tool out of " + material.getDisplayName() + ".";
		CSLang.addAchievementUS(a, name, description);
	}
	
	public static class MoreToolsModCraftingHandler implements ICraftingHandler
	{
		@Override
		public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
		{
			if (item.itemID == MoreToolsMod_Tools.spaceBlock.blockID)
			{
				player.triggerAchievement(spaceblock);
			}
			if (item.getItem() == MoreToolsMod_Tools.spaceSwordStrong)
			{
				player.triggerAchievement(materialachievements.get(MoreToolsMod_Tools.SPACE1));
				player.triggerAchievement(spacestrong);
			}
			if (item.getItem() == MoreToolsMod_Tools.spaceSwordWeak)
			{
				player.triggerAchievement(materialachievements.get(MoreToolsMod_Tools.SPACE1));
				player.triggerAchievement(spaceweak);
			}
			if (item.getItem() instanceof ItemToolMoreTools || item.getItem() instanceof ItemSwordMoreTools || item.getItem() instanceof ItemHoeMoreTools || item.getItem() instanceof ItemArmorMoreTools)
			{
				player.triggerAchievement(moretools);
				
				if (item.getItem() instanceof ItemToolMoreTools)
					player.triggerAchievement(materialachievements.get(((ItemToolMoreTools)item.getItem()).toolMaterial));
				else if (item.getItem() instanceof ItemSwordMoreTools)
					player.triggerAchievement(materialachievements.get(((ItemSwordMoreTools)item.getItem()).toolMaterial));
				else if (item.getItem() instanceof ItemHoeMoreTools)
					player.triggerAchievement(materialachievements.get(((ItemHoeMoreTools)item.getItem()).theToolMaterial));
				else if (item.getItem() instanceof ItemArmorMoreTools)
					player.triggerAchievement(materialachievements.get(((ItemArmorMoreTools)item.getItem()).material));
			}
		}

		@Override
		public void onSmelting(EntityPlayer player, ItemStack item)
		{
			if (item.getItem() == MoreToolsMod_Tools.spaceIngot)
			{
				player.triggerAchievement(spaceingot);
			}
		}
	}
}
