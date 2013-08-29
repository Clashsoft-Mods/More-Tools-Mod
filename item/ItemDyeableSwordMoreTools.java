package clashsoft.mods.moretools.item;

import clashsoft.mods.moretools.MoreToolsMod_Tools;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDyeableSwordMoreTools extends ItemDyeableToolMoreTools
{
    private final EnumToolMaterial toolMaterial;

    public ItemDyeableSwordMoreTools(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, 4 + par2EnumToolMaterial.getDamageVsEntity(), par2EnumToolMaterial, new Block[]{Block.web});
        this.toolMaterial = par2EnumToolMaterial;
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        if (par2Block.blockID == Block.web.blockID)
        {
            return 15.0F;
        }
        else
        {
            Material var3 = par2Block.blockMaterial;
            return var3 != Material.plants && var3 != Material.vine && var3 != Material.coral && var3 != Material.leaves && var3 != Material.pumpkin ? 1.0F : 1.5F;
        }
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
    {
        par1ItemStack.damageItem(1, par3EntityLiving);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLiving par7EntityLiving)
    {
        if ((double)Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
        {
            par1ItemStack.damageItem(2, par7EntityLiving);
        }

        return true;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.block;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block.blockID == Block.web.blockID;
    }

    public String func_77825_f()
    {
        return this.toolMaterial.toString();
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return this.toolMaterial.getToolCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
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

    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }

    /**
     * Return the armor material for this armor item.
     */
    public EnumToolMaterial getToolMaterial()
    {
        return this.toolMaterial;
    }

    /**
     * Return whether the specified armor ItemStack has a color.
     */
    public boolean hasColor(ItemStack par1ItemStack)
    {
        return this.toolMaterial != MoreToolsMod_Tools.LEATHER ? false : (!par1ItemStack.hasTagCompound() ? false : (!par1ItemStack.getTagCompound().hasKey("display") ? false : par1ItemStack.getTagCompound().getCompoundTag("display").hasKey("color")));
    }

    /**
     * Return the color for the specified armor ItemStack.
     */
    public int getColor(ItemStack par1ItemStack)
    {
        if (this.toolMaterial != MoreToolsMod_Tools.LEATHER)
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
        if (this.toolMaterial == MoreToolsMod_Tools.LEATHER)
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
        if (this.toolMaterial != MoreToolsMod_Tools.LEATHER)
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
