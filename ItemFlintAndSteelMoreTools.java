package clashsoft.mods.moretools;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class ItemFlintAndSteelMoreTools extends ItemFlintAndSteel
{
    public ItemFlintAndSteelMoreTools(int par1, int par2)
    {
        super(par1);
        this.maxStackSize = 1;
        this.setMaxDamage(par2);
        this.setCreativeTab(CreativeTabs.tabTools);
    }
}