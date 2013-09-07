package clashsoft.mods.moretools.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFlintAndSteel;

public class ItemFlintAndSteelMoreTools extends ItemFlintAndSteel
{
	public ItemFlintAndSteelMoreTools(int par1, int par2)
	{
		super(par1);
		this.maxStackSize = 1;
		this.setMaxDamage(par2);
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