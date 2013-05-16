package clashsoft.mods.moretools;

import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;

public class MoreToolsMod_Achievements
{
	public static MoreToolsMod_Achievements instance = new MoreToolsMod_Achievements();
	
	public static final Achievement spaceingot = new Achievement(1000, "spaceIngot", 9, 10, MoreToolsMod_Tools.spaceIngot, AchievementList.buildFurnace).registerAchievement();
	public static final Achievement spaceblock = new Achievement(1001, "spaceBlock", 10, 10, MoreToolsMod_Tools.spaceBlock, AchievementList.buildBetterPickaxe).registerAchievement();
	public static final Achievement spacestrong = new Achievement(1002, "spaceSwordStrong", 11, 10, MoreToolsMod_Tools.spaceSwordStrong, spaceblock).registerAchievement();
    public static final Achievement spaceweak = new Achievement(1003, "spaceSwordWeak", 10, 11, MoreToolsMod_Tools.spaceSwordWeak, spaceingot).registerAchievement();
    public static final Achievement moretools = new Achievement(1004, "moreTools", 9, 9, MoreToolsMod_Tools.spaceAxe, AchievementList.buildWorkBench).registerAchievement();
    public static final Achievement lightsaber = new Achievement(1005, "lightsaber", 8, 9, MoreToolsMod_Tools.lightsaberBlue, AchievementList.portal).registerAchievement();
    
	
	public void load()
	{
		GameRegistry.registerCraftingHandler(new MoreToolsModCraftingHandler());
		
    	ModLoader.addAchievementDesc(spaceingot, "Space Ingot", "Smelt Space Ore.");
    	ModLoader.addAchievementDesc(spaceblock, "Space BLOCK!", "Craft a Spaceblock.");
    	ModLoader.addAchievementDesc(spacestrong, "Overpowered", "Craft a Spacesword with two spaceblocks and one stick.");
    	ModLoader.addAchievementDesc(spaceweak, "Less Overpowered", "Craft a Spacesword with two spaceingots and one stick.");
    	ModLoader.addAchievementDesc(moretools, "MORE TOOLS!", "Craft a tool or an armory part");
    	ModLoader.addAchievementDesc(lightsaber, "Luke, I am your father.", "Use a light saber");
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
				player.triggerAchievement(spacestrong);
			}
			if (item.getItem() == MoreToolsMod_Tools.spaceSwordWeak)
			{
				player.triggerAchievement(spaceweak);
			}
			if (item.getItem() instanceof ItemToolMoreTools || item.getItem() instanceof ItemSwordMoreTools || item.getItem() instanceof ItemHoeMoreTools || item.getItem() instanceof ItemArmorMoreTools)
			{
				player.triggerAchievement(moretools);
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
