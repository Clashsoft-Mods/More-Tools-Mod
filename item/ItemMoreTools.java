package clashsoft.mods.moretools.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMoreTools extends Item
{
    public ItemMoreTools(int par1, CreativeTabs par2)
    {
        super(par1);
        this.setCreativeTab(par2);
    }
    
    /**
     * CLASHSOFT:
     * This code makes items use their unlocalized name as icon name
     */
    @Override
    public Item setUnlocalizedName(String name)
    {
    	super.setUnlocalizedName(name);
    	super.func_111206_d(name);
    	return this;
    }
}
