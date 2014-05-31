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
	public IIcon			icon;
	
	protected ToolMaterial	material;
	protected float			damage;
	protected String		type;
	
	public ItemDyeableTool(float weaponDamage, ToolMaterial toolMaterial, Set blocks, String type)
	{
		super(weaponDamage, toolMaterial, blocks);
		this.material = toolMaterial;
		this.damage = weaponDamage + toolMaterial.getDamageVsEntity();
		this.type = type;
	}
	
	@Override
	public int getColorFromItemStack(ItemStack stack, int pass)
	{
		if (pass == 0)
		{
			int color = this.getColor(stack);
			
			if (color < 0)
			{
				color = 16777215;
			}
			
			return color;
		}
		return 16777215;
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
		NBTTagCompound nbt = stack.getTagCompound();
		
		if (nbt == null)
		{
			return 10511680;
		}
		
		NBTTagCompound display = nbt.getCompoundTag("display");
		if (display != null && display.hasKey("color"))
		{
			return display.getInteger("color");
		}
		return 10511680;
	}
	
	@Override
	public IIcon getIconFromDamageForRenderPass(int metadata, int pass)
	{
		return pass == 0 ? this.icon : this.itemIcon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.icon = iconRegister.registerIcon("moretools:leather_" + this.type + "_1");
		this.itemIcon = iconRegister.registerIcon("moretools:leather_" + this.type + "_2");
	}
	
	public void removeColor(ItemStack stack)
	{
		NBTTagCompound nbt = stack.getTagCompound();
		
		if (nbt != null)
		{
			NBTTagCompound display = nbt.getCompoundTag("display");
			display.removeTag("color");
		}
	}
	
	public void dye(ItemStack stack, int color)
	{
		NBTTagCompound nbt = stack.getTagCompound();
		
		if (nbt == null)
		{
			nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
		}
		
		NBTTagCompound display = nbt.getCompoundTag("display");
		
		if (!nbt.hasKey("display", 10))
		{
			nbt.setTag("display", display);
		}
		
		display.setInteger("color", color);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack stack, ItemStack material)
	{
		return this.material.customCraftingMaterial == material.getItem() ? true : super.getIsRepairable(stack, material);
	}
}
