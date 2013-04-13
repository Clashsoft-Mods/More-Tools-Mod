package clashsoft.mods.moretools;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingHandlerMoreTools implements ICraftingHandler
{
	private MoreToolsMod_Tools tools = new MoreToolsMod_Tools();
	private MoreToolsMod_Achievements achs = new MoreToolsMod_Achievements();
	private Minecraft mc = ModLoader.getMinecraftInstance();
	
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
	{
		/*
		if (item.itemID == tools.spaceSwordStrong.shiftedIndex)
		{
			mc.thePlayer.triggerAchievement(achs.spacestrong);
		}
		else if (item.itemID == tools.spaceSwordWeak.shiftedIndex)
		{
			mc.thePlayer.triggerAchievement(achs.spaceweak);
		}
		else if (item.itemID == tools.spaceIngot.shiftedIndex)
		{
			mc.thePlayer.triggerAchievement(achs.spaceingot);
		}
		else if (item.itemID == tools.spaceBlock.blockID);
		{
			mc.thePlayer.triggerAchievement(achs.spaceblock);
		}
		if (item.itemID > 1901 + 265 && item.itemID < 2596 + 265)
		{
			mc.thePlayer.triggerAchievement(achs.moretools);
		}
		else
		{
			
		}
		*/
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item)
	{

	}

}
