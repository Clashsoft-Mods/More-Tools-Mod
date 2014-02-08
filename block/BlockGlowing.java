package clashsoft.mods.moretools.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockGlowing extends Block
{
	public BlockGlowing()
	{
		super(Material.air);
		this.setBlockBounds(0.4995F, 0.4995F, 0.4995F, 0.5005F, 0.5005F, 0.5005F);
		this.setTickRandomly(true);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		world.setBlockToAir(x, y, z);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return null;
	}
}
