package clashsoft.mods.moretools.item;

import clashsoft.mods.moretools.MoreToolsMod_Tools;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemHoeMoreTools extends ItemHoe
{
	public EnumToolMaterial theToolMaterial;
	
    public ItemHoeMoreTools(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, par2EnumToolMaterial);
        theToolMaterial = par2EnumToolMaterial;
        maxStackSize = 1;
        setMaxDamage(par2EnumToolMaterial.getMaxUses());
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }

            if (event.getResult() == Result.ALLOW)
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
                return true;
            }

            int var11 = par3World.getBlockId(par4, par5, par6);
            int var12 = par3World.getBlockId(par4, par5 + 1, par6);

            if ((par7 == 0 || var12 != 0 || var11 != Block.grass.blockID) && var11 != Block.dirt.blockID)
            {
                return false;
            }
            else
            {
                Block var13 = Block.tilledField;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), var13.stepSound.getStepSound(), (var13.stepSound.getVolume() + 1.0F) / 2.0F, var13.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return true;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, var13.blockID, 0, 0x02);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return true;
                }
            }
        }
    }


    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }
    
    /**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
    {
    	Item i = par1ItemStack.getItem();
    	if ((i == MoreToolsMod_Tools.glowstoneHoe) && par5)
    	{
    		ItemArmorMoreTools.setLight(par2World, par3Entity);
    	}
    }
    
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	if (this.theToolMaterial == MoreToolsMod_Tools.END && par3EntityPlayer.isSneaking())
		{
			Item.enderPearl.onItemRightClick(par1ItemStack.copy(), par2World, par3EntityPlayer);
			par1ItemStack.damageItem(20, par3EntityPlayer);
		}
        return par1ItemStack;
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
