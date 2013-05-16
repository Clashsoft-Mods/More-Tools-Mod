package clashsoft.mods.moretools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ItemLightsaberShaftMoreTools extends ItemMoreTools {

	public ItemLightsaberShaftMoreTools(int par1) {
		super(par1, CreativeTabs.tabRedstone);
		this.maxStackSize = 1;
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		ItemStack blue = new ItemStack(MoreToolsMod_Tools.lightsaberBlue, 1);
		par3EntityPlayer.triggerAchievement(MoreToolsMod_Achievements.instance.lightsaber);
		return blue;
	}

}
