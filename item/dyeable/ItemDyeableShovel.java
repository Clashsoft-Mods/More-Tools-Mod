package clashsoft.mods.moretools.item.dyeable;

import clashsoft.cslib.minecraft.item.datatools.ItemDataSpade;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ItemDyeableShovel extends ItemDyeableTool
{
	public ItemDyeableShovel(ToolMaterial toolMaterial)
	{
		super(1.0F, toolMaterial, ItemDataSpade.blocksEffectiveAgainst, "shovel");
	}
	
	public boolean canHarvestBlock(ItemStack stack, Block block, int metadata)
	{
		return block == Blocks.snow_layer || block == Blocks.snow;
	}
}
