package clashsoft.mods.moretools.item.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFlintAndSteel;

public class ItemMTMFlintAndSteel extends ItemFlintAndSteel
{
	public ItemMTMFlintAndSteel(int maxDamage)
	{
		this.maxStackSize = 1;
		this.setMaxDamage(maxDamage);
		this.setCreativeTab(CreativeTabs.tabTools);
	}
}