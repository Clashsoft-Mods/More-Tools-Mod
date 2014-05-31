package clashsoft.mods.moretools.item.tools.glowstone;

import clashsoft.mods.moretools.item.ItemGlowstoneArmor;
import clashsoft.mods.moretools.item.tools.ItemMTMHoe;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGlowstoneHoe extends ItemMTMHoe
{
	public ItemGlowstoneHoe(ToolMaterial material)
	{
		super(material);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean flag)
	{
		if (flag)
		{
			ItemGlowstoneArmor.glow(world, entity);
		}
	}
}
