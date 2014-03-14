package clashsoft.mods.moretools.block;

import clashsoft.cslib.minecraft.block.CustomBlock;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSpaceblock extends CustomBlock
{
	public static String[]	names		= new String[] {
			"ore",
			"block",
			"old",
			"old",
			"old"						};
	public static String[]	textures	= new String[] {
			"moretools:space_ore",
			"moretools:space_block",
			"moretools:space_block_1",
			"moretools:space_block_2",
			"moretools:space_block_3"	};
	
	public BlockSpaceblock()
	{
		super(Material.rock, names, textures, new CreativeTabs[] { CreativeTabs.tabBlock });
	}
}
