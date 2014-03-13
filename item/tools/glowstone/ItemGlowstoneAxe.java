package clashsoft.mods.moretools.item.tools.glowstone;

import clashsoft.mods.moretools.item.ItemGlowstoneArmor;
import clashsoft.mods.moretools.item.tools.ItemMTMAxe;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGlowstoneAxe extends ItemMTMAxe
{
	public ItemGlowstoneAxe(ToolMaterial material)
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
