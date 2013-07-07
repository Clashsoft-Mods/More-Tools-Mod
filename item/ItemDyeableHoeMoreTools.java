package clashsoft.mods.moretools.item;

import clashsoft.mods.moretools.MoreToolsMod_Tools;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDyeableHoeMoreTools extends ItemDyeableToolMoreTools
{
    protected EnumToolMaterial theToolMaterial;
    
    private String[] textures = new String[] {"lhoe1", "lhoe2"};

    public ItemDyeableHoeMoreTools(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, 0, par2EnumToolMaterial, new Block[]{});
        this.theToolMaterial = par2EnumToolMaterial;
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
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

    public String func_77842_f()
    {
        return this.theToolMaterial.toString();
    }
    
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
        if (par2 > 0)
        {
            return 16777215;
        }
        else
        {
            int var3 = this.getColor(par1ItemStack);

            if (var3 < 0)
            {
                var3 = 16777215;
            }

            return var3;
        }
    }

    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.theToolMaterial.getEnchantability();
    }

    /**
     * Return the armor material for this armor item.
     */
    public EnumToolMaterial getToolMaterial()
    {
        return this.theToolMaterial;
    }

    /**
     * Return whether the specified armor ItemStack has a color.
     */
    public boolean hasColor(ItemStack par1ItemStack)
    {
        return this.theToolMaterial != MoreToolsMod_Tools.LEATHER ? false : (!par1ItemStack.hasTagCompound() ? false : (!par1ItemStack.getTagCompound().hasKey("display") ? false : par1ItemStack.getTagCompound().getCompoundTag("display").hasKey("color")));
    }

    /**
     * Return the color for the specified armor ItemStack.
     */
    public int getColor(ItemStack par1ItemStack)
    {
        if (this.theToolMaterial != MoreToolsMod_Tools.LEATHER)
        {
            return -1;
        }
        else
        {
            NBTTagCompound var2 = par1ItemStack.getTagCompound();

            if (var2 == null)
            {
                return 10511680;
            }
            else
            {
                NBTTagCompound var3 = var2.getCompoundTag("display");
                return var3 == null ? 10511680 : (var3.hasKey("color") ? var3.getInteger("color") : 10511680);
            }
        }
    }

    /**
     * Remove the color from the specified armor ItemStack.
     */
    public void removeColor(ItemStack par1ItemStack)
    {
        if (this.theToolMaterial == MoreToolsMod_Tools.LEATHER)
        {
            NBTTagCompound var2 = par1ItemStack.getTagCompound();

            if (var2 != null)
            {
                NBTTagCompound var3 = var2.getCompoundTag("display");

                if (var3.hasKey("color"))
                {
                    var3.removeTag("color");
                }
            }
        }
    }

    public void func_82813_b(ItemStack par1ItemStack, int par2)
    {
        if (this.theToolMaterial != MoreToolsMod_Tools.LEATHER)
        {
            throw new UnsupportedOperationException("Can\'t dye non-leather!");
        }
        else
        {
            NBTTagCompound var3 = par1ItemStack.getTagCompound();

            if (var3 == null)
            {
                var3 = new NBTTagCompound();
                par1ItemStack.setTagCompound(var3);
            }

            NBTTagCompound var4 = var3.getCompoundTag("display");

            if (!var3.hasKey("display"))
            {
                var3.setCompoundTag("display", var4);
            }

            var4.setInteger("color", par2);
        }
    }
}
