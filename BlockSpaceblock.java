package clashsoft.mods.moretools;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSpaceblock extends Block
{
	public static String[] names = new String[]
			{
		"", "Space Block", "Old Space Block", "Old Space Block", "Old Space Block"
			};
	private static String[] textures = new String[]
			{
			"spaceore", "spaceblock_1", "spaceblock_old_1", "spaceblock_old_2", "spaceblock_old_3" 
			};
	public static Icon[] icons;
	
	public BlockSpaceblock (int id)
	{
		super(id, Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public Icon getIcon(int side, int metadata)
	{
		return icons[metadata];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.icons = new Icon[textures.length];

        for (int i = 0; i < textures.length; ++i)
        {
            this.icons[i] = par1IconRegister.registerIcon(textures[i]);
        }
    }
	
	@Override
	public int damageDropped (int metadata)
	{
		return metadata;
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems)
	{
		for (int ix = 1; ix < names.length; ix++) {
			subItems.add(new ItemStack(this, 1, ix));
		}
	}
	
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
		if (par1World.getBlockMetadata(par2, par3, par4) < 5)
		{
			double d = (float)par2 + par5Random.nextFloat();
	        double d1 = (float)par3 + 0.8F;
	        double d2 = (float)par4 + par5Random.nextFloat();
	        double d3 = 0.0D;
	        double d4 = 0.0D;
	        double d5 = 0.0D;
	        par1World.spawnParticle("smoke", d, d1, d2, d3, d4, d5);
		}
    }	
}
