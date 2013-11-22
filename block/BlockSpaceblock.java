package clashsoft.mods.moretools.block;

import clashsoft.cslib.minecraft.CustomBlock;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSpaceblock extends CustomBlock
{
	public static String[]	names		= new String[] { "Space Block", "Old Space Block", "Old Space Block", "Old Space Block" };
	public static String[]	textures	= new String[] { "spaceblock_1", "spaceblock_old_1", "spaceblock_old_2", "spaceblock_old_3" };
	
	public BlockSpaceblock(int id)
	{
		super(id, Material.rock, names, textures, new CreativeTabs[] { CreativeTabs.tabBlock });
	}
}
