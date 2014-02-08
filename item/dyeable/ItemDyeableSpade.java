package clashsoft.mods.moretools.item.dyeable;

import clashsoft.cslib.minecraft.item.datatools.ItemDataSpade;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ItemDyeableSpade extends ItemDyeableTool
{
	public ItemDyeableSpade(ToolMaterial toolMaterial)
	{
		super(1.0F, toolMaterial, ItemDataSpade.blocksEffectiveAgainst);
	}
	
	public boolean canHarvestBlock(ItemStack stack, Block block, int metadata)
	{
		return block == Blocks.snow_layer || block == Blocks.snow;
	}
}
