package clashsoft.mods.moretools.item.tools;

import clashsoft.mods.moretools.addons.MTMTools;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class ItemBowMTM extends Item
{
	private static String[]	textures	= new String[] { "spacebow", "spacebow_1", "spacebow_2", "spacebow_3" };
	private IIcon[]			icons;
	
	private Item			arrowToConsume;
	
	public ItemBowMTM(Item arrow)
	{
		maxStackSize = 1;
		setMaxDamage(384);
		this.arrowToConsume = arrow;
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	@Override
	public boolean isFull3D()
	{
		return true;
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int time)
	{
		int j = this.getMaxItemUseDuration(stack) - time;
		
		ArrowLooseEvent event = new ArrowLooseEvent(player, stack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
		{
			return;
		}
		j = event.charge;
		
		boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;
		
		if (flag || player.inventory.hasItem(arrowToConsume))
		{
			float f = (j / 20.0F) + (EnchantmentHelper.getEnchantmentLevel(MTMTools.quickDraw.effectId, stack) * 0.04F);
			f = (f * f + f * 2.0F) / 3.0F;
			
			if (f < 0.1D)
			{
				return;
			}
			
			if (f > 1.0F)
			{
				f = 1.0F;
			}
			
			EntityArrow entityarrow = new EntityArrow(world, player, f * 2.0F);
			
			if (f == 1.0F)
			{
				entityarrow.setIsCritical(true);
			}
			
			int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);
			
			if (k > 0)
			{
				entityarrow.setDamage(entityarrow.getDamage() + k * 0.5D + 0.5D);
			}
			
			int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);
			
			if (l > 0)
			{
				entityarrow.setKnockbackStrength(l);
			}
			
			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0)
			{
				entityarrow.setFire(100);
			}
			
			stack.damageItem(1, player);
			world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
			
			if (flag)
			{
				entityarrow.canBePickedUp = 2;
			}
			else
			{
				player.inventory.consumeInventoryItem(arrowToConsume);
			}
			
			if (!world.isRemote)
			{
				world.spawnEntityInWorld(entityarrow);
			}
		}
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 71232;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.bow;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.capabilities.isCreativeMode || player.inventory.hasItem(arrowToConsume))
		{
			player.setItemInUse(stack, getMaxItemUseDuration(stack));
		}
		
		return stack;
	}
	
	@Override
	public int getItemEnchantability()
	{
		return 1;
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		boolean isSpaceBow = this == MTMTools.spaceBow;
		if (usingItem != null && usingItem.getItem() == MTMTools.spaceBow)
		{
			int k = usingItem.getMaxItemUseDuration() - useRemaining;
			int var1 = 18 - (EnchantmentHelper.getEnchantmentLevel(MTMTools.quickDraw.effectId, stack) * 4);
			int var2 = 13 - (EnchantmentHelper.getEnchantmentLevel(MTMTools.quickDraw.effectId, stack) * 4);
			int var3 = 0;
			if (k >= var1)
				return icons[3];
			if (k > var2)
				return icons[2];
			if (k > var3)
				return icons[1];
		}
		return icons[0];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.icons = new IIcon[textures.length];
		for (int i = 0; i < textures.length; i++)
		{
			this.icons[i] = iconRegister.registerIcon(textures[i]);
		}
	}
	
	@Override
	public Item setUnlocalizedName(String name)
	{
		super.setUnlocalizedName(name);
		super.setTextureName(name);
		return this;
	}
}
