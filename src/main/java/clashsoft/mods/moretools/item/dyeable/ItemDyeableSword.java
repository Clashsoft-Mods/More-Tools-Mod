package clashsoft.mods.moretools.item.dyeable;

import java.util.Collections;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDyeableSword extends ItemDyeableTool
{
	public ItemDyeableSword(ToolMaterial toolMaterial)
	{
		super(4F, toolMaterial, Collections.EMPTY_SET, "sword");
		
		this.maxStackSize = 1;
		this.setMaxDamage(toolMaterial.getMaxUses());
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int metadata)
	{
		if (block == Blocks.web)
		{
			return 15.0F;
		}
		
		Material material = block.getMaterial();
		if (material == Material.plants || material == Material.vine || material == Material.coral || material == Material.leaves || material == Material.gourd)
		{
			return 1.5F;
		}
		return 1.0F;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase living, EntityLivingBase living2)
	{
		stack.damageItem(1, living2);
		return true;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase living)
	{
		if (block.getBlockHardness(world, x, y, z) != 0.0D)
		{
			stack.damageItem(2, living);
		}
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.block;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 72000;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		return block == Blocks.web;
	}
	
	@Override
	public int getItemEnchantability()
	{
		return this.material.getEnchantability();
	}
	
	@Override
	public boolean getIsRepairable(ItemStack stack, ItemStack material)
	{
		if (this.material.customCraftingMaterial == material.getItem())
		{
			return true;
		}
		return super.getIsRepairable(stack, material);
	}
	
	@Override
	public Multimap getItemAttributeModifiers()
	{
		Multimap localMultimap = super.getItemAttributeModifiers();
		
		localMultimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", this.damage, 0));
		
		return localMultimap;
	}
}
