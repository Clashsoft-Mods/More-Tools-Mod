package clashsoft.mods.moretools;

import clashsoft.clashsoftapi.ClashsoftMisc;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;

public class ItemDyeableToolMoreTools extends ItemToolMoreTools
{
	private Icon[] icons = new Icon[2];
	private Icon icon;
	
	private EnumToolMaterial material;
	
	public ItemDyeableToolMoreTools(int par1, int par2, EnumToolMaterial par3EnumToolMaterial, Block[] par4ArrayOfBlock)
	{
		super(par1, par2, par3EnumToolMaterial, par4ArrayOfBlock);
		material = par3EnumToolMaterial;
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
        return this.material.getEnchantability();
    }

    /**
     * Return the armor material for this armor item.
     */
    public EnumToolMaterial getToolMaterial()
    {
        return this.material;
    }

    /**
     * Return whether the specified armor ItemStack has a color.
     */
    public boolean hasColor(ItemStack par1ItemStack)
    {
        return this.material != MoreToolsMod_Tools.LEATHER ? false : (!par1ItemStack.hasTagCompound() ? false : (!par1ItemStack.getTagCompound().hasKey("display") ? false : par1ItemStack.getTagCompound().getCompoundTag("display").hasKey("color")));
    }

    /**
     * Return the color for the specified armor ItemStack.
     */
    public int getColor(ItemStack par1ItemStack)
    {
        if (this.material != MoreToolsMod_Tools.LEATHER)
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
     * Gets an icon index based on an item's damage value and the given render pass
     */
    public Icon getIconFromDamageForRenderPass(int par1, int par2)
    {
        return icons[par2 < 2 ? par2 : 1];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void updateIcons(IconRegister par1IconRegister) //Registers the Icons
    {
        String s = this instanceof ItemDyeableSwordMoreTools ? "sword" : this instanceof ItemDyeableSpadeMoreTools ? "spade" : this instanceof ItemDyeablePickaxeMoreTools ? "pick" : this instanceof ItemDyeableAxeMoreTools ? "axe" : "hoe";
    	this.icons[0] = par1IconRegister.registerIcon("l" + s + "1");
        this.icons[1] = par1IconRegister.registerIcon("l" + s + "2");
    }

    /**
     * Remove the color from the specified armor ItemStack.
     */
    public void removeColor(ItemStack par1ItemStack)
    {
        if (this.material == MoreToolsMod_Tools.LEATHER)
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
        if (this.material != MoreToolsMod_Tools.LEATHER)
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

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return this.material.getToolCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
}
