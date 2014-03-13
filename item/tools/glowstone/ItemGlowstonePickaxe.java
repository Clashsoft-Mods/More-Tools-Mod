package clashsoft.mods.moretools.item.tools.glowstone;

import clashsoft.mods.moretools.item.ItemGlowstoneArmor;
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
		if (flag)
		{
			ItemGlowstoneArmor.glow(world, entity);
		}
	}
}
