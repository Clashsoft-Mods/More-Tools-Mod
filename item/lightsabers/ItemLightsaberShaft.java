package clashsoft.mods.moretools.item.lightsabers;

import clashsoft.mods.moretools.addons.MTMTools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLightsaberShaft extends Item
{
	public ItemLightsaberShaft()
	{
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		return new ItemStack(MTMTools.lightsaberBlue, 1);
	}
	
	@Override
	public Item setUnlocalizedName(String name)
	{
		super.setUnlocalizedName(name);
		super.setTextureName(name);
		return this;
	}
}
