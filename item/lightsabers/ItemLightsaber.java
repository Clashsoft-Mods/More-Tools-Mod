package clashsoft.mods.moretools.item.lightsabers;

import clashsoft.mods.moretools.addons.MTMTools;
import clashsoft.mods.moretools.item.tools.ItemSwordMTM;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class ItemLightsaber extends ItemSwordMTM
{
	public ItemLightsaber(int itemID, EnumToolMaterial toolMaterial)
	{
		super(itemID, toolMaterial, EnumRarity.rare);
		this.maxStackSize = 1;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.isSneaking())
		{
			if (itemID == MTMTools.lightsaberBlue.itemID)
			{
				return new ItemStack(MTMTools.lightsaberGreen, 1, stack.getItemDamage());
			}
			else if (itemID == MTMTools.lightsaberGreen.itemID)
			{
				return new ItemStack(MTMTools.lightsaberPurple, 1, stack.getItemDamage());
			}
			else if (itemID == MTMTools.lightsaberPurple.itemID)
			{
				return new ItemStack(MTMTools.lightsaberRed, 1, stack.getItemDamage());
			}
			else if (itemID == MTMTools.lightsaberRed.itemID)
			{
				return new ItemStack(MTMTools.lightsaberWhite, 1, stack.getItemDamage());
			}
			else if (itemID == MTMTools.lightsaberShaft.itemID || itemID == MTMTools.lightsaberWhite.itemID)
			{
				return new ItemStack(MTMTools.lightsaberBlue, 1, stack.getItemDamage());
			}
		}
		return super.onItemRightClick(stack, world, player);
	}
}
