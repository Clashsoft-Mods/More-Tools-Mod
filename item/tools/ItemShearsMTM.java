package clashsoft.mods.moretools.item.tools;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class ItemShearsMTM extends Item
{
	public int			wool;
	public EnumRarity	rarity;
	
	public ItemShearsMTM(int uses, int woolCount)
	{
		this(uses, woolCount, EnumRarity.common);
	}
	
	public ItemShearsMTM(int uses, int woolCount, EnumRarity rarity)
	{
		this.setMaxStackSize(1);
		this.setMaxDamage(uses);
		this.setCreativeTab(CreativeTabs.tabTools);
		
		this.wool = woolCount;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack)
	{
		return this.rarity;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase living)
	{
		if (this.canHarvestBlock(block, stack) || block == Blocks.tripwire || block instanceof IShearable)
		{
			return true;
		}
		return super.onBlockDestroyed(stack, world, block, x, y, z, living);
	}
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		return block == Blocks.leaves || block == Blocks.leaves2 || block == Blocks.web || block == Blocks.tallgrass || block == Blocks.vine;
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int metadata)
	{
		if (block == Blocks.wool)
		{
			return 5F;
		}
		else if (this.canHarvestBlock(block, stack))
		{
			return 15F;
		}
		return super.getDigSpeed(stack, block, metadata);
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
	{
		if (entity.worldObj.isRemote)
		{
			return false;
		}
		if (entity instanceof IShearable)
		{
			IShearable target = (IShearable) entity;
			if (target.isShearable(itemstack, entity.worldObj, (int) entity.posX, (int) entity.posY, (int) entity.posZ))
			{
				ArrayList<ItemStack> drops = target.onSheared(itemstack, entity.worldObj, (int) entity.posX, (int) entity.posY, (int) entity.posZ, EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));
				
				Random rand = new Random();
				
				for (int i = 0; i <= this.wool; i++)
				{
					if (i != 0)
					{
						drops.add(drops.get(0));
					}
				}
				
				for (ItemStack stack : drops)
				{
					EntityItem ent = entity.entityDropItem(stack, 1.0F);
					ent.motionY += rand.nextFloat() * 0.05F;
					ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
					ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
				}
				itemstack.damageItem(1, entity);
			}
			return true;
		}
		return false;
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player)
	{
		if (player.worldObj.isRemote)
		{
			return false;
		}
		
		Block block = player.worldObj.getBlock(x, y, z);
		if (block instanceof IShearable)
		{
			IShearable target = (IShearable) block;
			if (target.isShearable(itemstack, player.worldObj, x, y, z))
			{
				ArrayList<ItemStack> drops = target.onSheared(itemstack, player.worldObj, x, y, z, EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));
				Random rand = new Random();
				
				for (ItemStack stack : drops)
				{
					float f = 0.7F;
					double d = rand.nextFloat() * f + (1.0F - f) * 0.5D;
					double d1 = rand.nextFloat() * f + (1.0F - f) * 0.5D;
					double d2 = rand.nextFloat() * f + (1.0F - f) * 0.5D;
					EntityItem entityitem = new EntityItem(player.worldObj, x + d, y + d1, z + d2, stack);
					entityitem.delayBeforeCanPickup = 10;
					player.worldObj.spawnEntityInWorld(entityitem);
				}
				
				itemstack.damageItem(1, player);
			}
		}
		return false;
	}
	
	@Override
	public Item setUnlocalizedName(String name)
	{
		super.setUnlocalizedName(name);
		super.setTextureName(name);
		return this;
	}
}
