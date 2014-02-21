package clashsoft.mods.moretools.item.tools.glowstone;

import clashsoft.mods.moretools.addons.MTMTools;
import clashsoft.mods.moretools.item.tools.ItemMTMPickaxe;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGlowstonePickaxe extends ItemMTMPickaxe
{
	public ItemGlowstonePickaxe(ToolMaterial material)
	{
		super(material);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean flag)
	{
		int x = (int) entity.posX;
		int y = (int) entity.posY;
		int z = (int) entity.posZ;
		
		if (world.isAirBlock(x, y, z))
		{
			world.setBlock(x, y, z, MTMTools.glowingBlock);
		}
	}
}
