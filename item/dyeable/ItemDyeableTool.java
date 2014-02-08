package clashsoft.mods.moretools.item.dyeable;

import java.util.Set;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;

public class ItemDyeableTool extends ItemTool
{
	private IIcon[]					icons	= new IIcon[2];
	
	protected final ToolMaterial	material;
	protected final float			damage;
	
	public ItemDyeableTool(float weaponDamage, ToolMaterial toolMaterial, Set blocks)
	{
		super(weaponDamage, toolMaterial, blocks);
		this.material = toolMaterial;
		this.damage = weaponDamage + toolMaterial.getDamageVsEntity();
	}
	
	@Override
	public int getColorFromItemStack(ItemStack stack, int pass)
	{
		if (pass > 0)
		{
			return 16777215;
		}
		else
		{
			int color = this.getColor(stack);
			
			if (color < 0)
			{
				color = 16777215;
			}
			
			return color;
		}
	}
	
	@Override
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}
	
	@Override
	public int getItemEnchantability()
	{
		return this.material.getEnchantability();
	}
	
	public ToolMaterial getToolMaterial()
	{
		return this.material;
	}
	
	public boolean hasColor(ItemStack stack)
	{
		return this.getColor(stack) != 10511680;
	}
	
	public int getColor(ItemStack stack)
	{
		NBTTagCompound compound = stack.getTagCompound();
		
		if (compound == null)
		{
			return 10511680;
		}
		else
		{
			NBTTagCompound display = compound.getCompoundTag("display");
			return display == null ? 10511680 : (display.hasKey("color") ? display.getInteger("color") : 10511680);
		}
	}
	
	@Override
	public IIcon getIconFromDamageForRenderPass(int metadata, int pass)
	{
		return this.icons[pass < 2 ? pass : 1];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		String s = this instanceof ItemDyeableSword ? "sword" : this instanceof ItemDyeableSpade ? "spade" : this instanceof ItemDyeablePickaxe ? "pick" : this instanceof ItemDyeableAxe ? "axe" : "hoe";
		this.icons[0] = iconRegister.registerIcon("l" + s + "1");
		this.icons[1] = iconRegister.registerIcon("l" + s + "2");
	}
	
	public void removeColor(ItemStack stack)
	{
		NBTTagCompound compound = stack.getTagCompound();
		
		if (compound != null)
		{
			NBTTagCompound display = compound.getCompoundTag("display");
			
			if (display.hasKey("color"))
			{
				display.removeTag("color");
				
			}
		}
	}
	
	public void dye(ItemStack stack, int color)
	{
		NBTTagCompound compound = stack.getTagCompound();
		
		if (compound == null)
		{
			compound = new NBTTagCompound();
			stack.setTagCompound(compound);
		}
		
		NBTTagCompound display = compound.getCompoundTag("display");
		display.setInteger("color", color);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack stack, ItemStack material)
	{
		return this.material.customCraftingMaterial == material.getItem() ? true : super.getIsRepairable(stack, material);
	}
}
