package clashsoft.mods.moretools.item.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFlintAndSteel;

public class ItemFlintAndSteelMTM extends ItemFlintAndSteel
{
	public ItemFlintAndSteelMTM(int maxDamage)
	{
		this.maxStackSize = 1;
		this.setMaxDamage(maxDamage);
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	
	/**
	 * CLASHSOFT: This code makes items use their unlocalized name as icon name
	 */
	@Override
	public Item setUnlocalizedName(String name)
	{
		super.setUnlocalizedName(name);
		super.setTextureName(name);
		return this;
	}
}