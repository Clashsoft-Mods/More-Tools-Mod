package clashsoft.mods.moretools.item.lightsabers;

import clashsoft.mods.moretools.addons.MTMTools;
import clashsoft.mods.moretools.item.tools.ItemSwordMTM;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLightsaber extends ItemSwordMTM
{
	public ItemLightsaber(ToolMaterial toolMaterial)
	{
		super(toolMaterial, EnumRarity.rare);
		this.maxStackSize = 1;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.isSneaking())
		{
			if (this == MTMTools.lightsaberBlue)
			{
				return new ItemStack(MTMTools.lightsaberGreen, 1, stack.getItemDamage());
			}
			else if (this == MTMTools.lightsaberGreen)
			{
				return new ItemStack(MTMTools.lightsaberPurple, 1, stack.getItemDamage());
			}
			else if (this == MTMTools.lightsaberPurple)
			{
				return new ItemStack(MTMTools.lightsaberRed, 1, stack.getItemDamage());
			}
			else if (this == MTMTools.lightsaberRed)
			{
				return new ItemStack(MTMTools.lightsaberWhite, 1, stack.getItemDamage());
			}
			else if (this == MTMTools.lightsaberShaft || this == MTMTools.lightsaberWhite)
			{
				return new ItemStack(MTMTools.lightsaberBlue, 1, stack.getItemDamage());
			}
		}
		return super.onItemRightClick(stack, world, player);
	}
}
