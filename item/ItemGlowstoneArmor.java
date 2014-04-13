package clashsoft.mods.moretools.item;

import clashsoft.mods.moretools.addons.MTMTools;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemGlowstoneArmor extends ItemArmor
{
	public ItemGlowstoneArmor(ArmorMaterial material, int renderIndex, int type)
	{
		super(material, renderIndex, type);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		glow(world, player);
	}
	
	public static void glow(World world, Entity entity)
	{
		int x = MathHelper.floor_double(entity.posX);
		int y = (int) entity.posY;
		int z = MathHelper.floor_double(entity.posZ);
		
		for (int x1 = -2; x1 < 3; x1++)
		{
			for (int y1 = -2; y1 < 3; y1++)
			{
				for (int z1 = -2; z1 < 3; z1++)
				{
					// x == 0 && y == 0 && z == 0
					if ((x1 | y1 | z1) == 0)
					{
						continue;
					}
					
					int x2 = x + x1;
					int y2 = y + y1;
					int z2 = z + z1;
					if (world.getBlock(x2, y2, z2) == MTMTools.glowingBlock)
					{
						world.setBlockToAir(x2, y2, z2);
					}
				}
			}
		}
		
		if (world.isAirBlock(x, y, z))
		{
			world.setBlock(x, y, z, MTMTools.glowingBlock);
		}
	}
}
