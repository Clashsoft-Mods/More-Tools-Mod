package clashsoft.mods.moretools.item.dyeable;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;

public class ItemDyeableShovel extends ItemDyeableTool
{
	private static Block	blocksEffectiveAgainst[];
	
	public ItemDyeableShovel(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, 1, par2EnumToolMaterial, blocksEffectiveAgainst);
	}
	
	/**
	 * Returns if the item (tool) can harvest results from the block type.
	 */
	@Override
	public boolean canHarvestBlock(Block par1Block)
	{
		if (par1Block == Block.snow)
		{
			return true;
		}
		
		return par1Block == Block.blockSnow;
	}
	
	static
	{
		blocksEffectiveAgainst = (new Block[] { Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium });
	}
}
