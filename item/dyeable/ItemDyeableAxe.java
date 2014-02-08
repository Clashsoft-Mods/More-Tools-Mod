package clashsoft.mods.moretools.item.dyeable;

import clashsoft.cslib.minecraft.item.datatools.ItemDataAxe;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public class ItemDyeableAxe extends ItemDyeableTool
{
	public ItemDyeableAxe(ToolMaterial toolMaterial)
	{
		super(3F, toolMaterial, ItemDataAxe.blocksEffectiveAgainst);
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int metadata)
	{
		if (block.getMaterial() == Material.wood)
		{
			return this.efficiencyOnProperMaterial;
		}
		else
		{
			return super.getDigSpeed(stack, block, metadata);
		}
	}
}
