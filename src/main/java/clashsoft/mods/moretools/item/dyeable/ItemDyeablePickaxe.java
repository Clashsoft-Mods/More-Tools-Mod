package clashsoft.mods.moretools.item.dyeable;

import clashsoft.cslib.minecraft.item.datatools.ItemDataPickaxe;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ItemDyeablePickaxe extends ItemDyeableTool
{
	public ItemDyeablePickaxe(ToolMaterial toolMaterial)
	{
		super(2.0F, toolMaterial, ItemDataPickaxe.blocksEffectiveAgainst, "pickaxe");
	}
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		if (block == Blocks.obsidian)
		{
			return this.toolMaterial.getHarvestLevel() == 3;
		}
		if (block == Blocks.diamond_block || block == Blocks.diamond_ore)
		{
			return this.toolMaterial.getHarvestLevel() >= 2;
		}
		if (block == Blocks.emerald_ore || block == Blocks.emerald_block)
		{
			return this.toolMaterial.getHarvestLevel() >= 2;
		}
		if (block == Blocks.gold_block || block == Blocks.gold_ore)
		{
			return this.toolMaterial.getHarvestLevel() >= 2;
		}
		if (block == Blocks.iron_block || block == Blocks.iron_ore)
		{
			return this.toolMaterial.getHarvestLevel() >= 1;
		}
		if (block == Blocks.lapis_block || block == Blocks.lapis_ore)
		{
			return this.toolMaterial.getHarvestLevel() >= 1;
		}
		if (block == Blocks.redstone_ore || block == Blocks.lit_redstone_ore)
		{
			return this.toolMaterial.getHarvestLevel() >= 2;
		}
		if (block.getMaterial() == Material.rock)
		{
			return true;
		}
		if (block.getMaterial() == Material.iron)
		{
			return true;
		}
		return block.getMaterial() == Material.anvil;
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int metadata)
	{
		if (block.getMaterial() == Material.iron || block.getMaterial() == Material.anvil || block.getMaterial() == Material.rock)
		{
			return this.efficiencyOnProperMaterial;
		}
		return super.getDigSpeed(stack, block, metadata);
	}
}