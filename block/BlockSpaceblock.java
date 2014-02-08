package clashsoft.mods.moretools.block;

import clashsoft.cslib.minecraft.CustomBlock;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSpaceblock extends CustomBlock
{
	public static String[]	names		= new String[] { "Space Ore", "Space Block", "Old Space Block", "Old Space Block", "Old Space Block" };
	public static String[]	textures	= new String[] { "space_ore", "space_block_1", "space_block_2", "space_block_3", "space_block_4" };
	
	public BlockSpaceblock()
	{
		super(Material.rock, names, textures, new CreativeTabs[] { CreativeTabs.tabBlock });
	}
}
