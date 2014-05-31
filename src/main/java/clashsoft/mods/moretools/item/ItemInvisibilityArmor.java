package clashsoft.mods.moretools.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemInvisibilityArmor extends ItemArmor
{
	public ItemInvisibilityArmor(ArmorMaterial material, int renderIndex, int type)
	{
		super(material, renderIndex, type);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		if (!world.isRemote)
		{
			ItemStack[] stacks = player.getLastActiveItems();
			if (stacks != null)
			{
				int count = 0;
				for (ItemStack stack1 : stacks)
				{
					if (stack1 != null && stack1.getItem() instanceof ItemInvisibilityArmor)
					{
						count++;
					}
				}
				if (count >= 4)
				{
					player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 2, 0, true));
				}
			}
		}
	}
}
