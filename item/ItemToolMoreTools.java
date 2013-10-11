package clashsoft.mods.moretools.item;

import clashsoft.mods.moretools.MTMTools;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class ItemToolMoreTools extends ItemTool
{
	private Block			blocksEffectiveAgainst[];
	protected float			efficiencyOnProperMaterial;
	
	/** Damage versus entities. */
	private float			damageVsEntity;
	
	/** The material this tool is made from. */
	public EnumToolMaterial	toolMaterial;
	
	protected ItemToolMoreTools(int par1, float par2, EnumToolMaterial par3EnumToolMaterial, Block par4ArrayOfBlock[])
	{
		super(par1, par2, par3EnumToolMaterial, par4ArrayOfBlock);
		efficiencyOnProperMaterial = 4F;
		toolMaterial = par3EnumToolMaterial;
		blocksEffectiveAgainst = par4ArrayOfBlock;
		maxStackSize = 1;
		setMaxDamage(par3EnumToolMaterial.getMaxUses());
		efficiencyOnProperMaterial = par3EnumToolMaterial.getEfficiencyOnProperMaterial();
		damageVsEntity = par2 + par3EnumToolMaterial.getDamageVsEntity();
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	
	/**
	 * Returns the strength of the stack against a given block. 1.0F base,
	 * (Quality+1)*2 if correct blocktype, 1.5F if sword
	 */
	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		for (int i = 0; i < blocksEffectiveAgainst.length; i++)
		{
			if (blocksEffectiveAgainst[i] == par2Block)
			{
				return efficiencyOnProperMaterial;
			}
		}
		
		return 1.0F;
	}
	
	/**
	 * Current implementations of this method in child classes do not use the
	 * entry argument beside ev. They just raise the damage on the stack.
	 */
	public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
	{
		par1ItemStack.damageItem(2, par3EntityLiving);
		return true;
	}
	
	public boolean onBlockDestroyed(ItemStack par1ItemStack, int par2, int par3, int par4, int par5, EntityLiving par6EntityLiving)
	{
		par1ItemStack.damageItem(1, par6EntityLiving);
		return true;
	}
	
	@Override
	public Multimap getItemAttributeModifiers()
	{
		Multimap multimap = HashMultimap.create();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Tool modifier", (double)this.damageVsEntity, 0));
        return multimap;
	}
	
	/**
	 * Returns True is the item is renderer in full 3D when hold.
	 */
	@Override
	public boolean isFull3D()
	{
		return true;
	}
	
	/**
	 * Return the enchantability factor of the item, most of the time is based
	 * on material.
	 */
	@Override
	public int getItemEnchantability()
	{
		return toolMaterial.getEnchantability();
	}
	
	/**
	 * Called each tick as long the item is on a player inventory. Uses by maps
	 * to check if is on a player hand and update it's contents.
	 */
	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		Item i = par1ItemStack.getItem();
		if ((i == MTMTools.glowstonePick || i == MTMTools.glowstoneShovel || i == MTMTools.glowstoneAxe) && par5)
		{
			ItemArmorMoreTools.setLight(par2World, par3Entity);
		}
	}
	
	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (this.toolMaterial == MTMTools.END && par3EntityPlayer.isSneaking())
		{
			ItemStack is = Item.enderPearl.onItemRightClick(par1ItemStack.copy(), par2World, par3EntityPlayer);
			par1ItemStack.damageItem(20, par3EntityPlayer);
		}
		return par1ItemStack;
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
