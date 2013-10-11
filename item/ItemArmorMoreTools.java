package clashsoft.mods.moretools.item;

import clashsoft.mods.moretools.MTMArmor;
import clashsoft.mods.moretools.MTMTools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemArmorMoreTools extends ItemArmor
{
	/**
	 * Stores the armor type: 0 is helmet, 1 is plate, 2 is legs and 3 is boots
	 */
	public final int				armorType;
	
	/** Holds the amount of damage that the armor reduces at full durability. */
	public final int				damageReduceAmount;
	
	/**
	 * Used on RenderPlayer to select the correspondent armor to be rendered on
	 * the player: 0 is cloth, 1 is chain, 2 is iron, 3 is diamond and 4 is
	 * gold.
	 */
	public final int				renderIndex;
	
	/** The EnumArmorMaterial used for this ItemArmor */
	public final EnumArmorMaterial	material;
	
	public ItemArmorMoreTools(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.material = par2EnumArmorMaterial;
		this.armorType = par4;
		this.renderIndex = par3;
		this.damageReduceAmount = par2EnumArmorMaterial.getDamageReductionAmount(par4);
		this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	/**
	 * Called each tick as long the item is on a player inventory. Uses by maps
	 * to check if is on a player hand and update it's contents.
	 */
	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack)
	{
		if (player instanceof EntityPlayer)
		{
			ItemStack helmet = player.inventory.armorInventory[3];
			ItemStack chestplate = player.inventory.armorInventory[2];
			ItemStack leggings = player.inventory.armorInventory[1];
			ItemStack boots = player.inventory.armorInventory[0];
			
			if (helmet != null && helmet.getItem() == MTMArmor.glowstoneHelmet)
			{
				setLight(world, player);
			}
			if (chestplate != null && chestplate.getItem() == MTMArmor.glowstoneChestplate)
			{
				setLight(world, player);
			}
			if (leggings != null && leggings.getItem() == MTMArmor.glowstoneLeggings)
			{
				setLight(world, player);
			}
			if (boots != null && boots.getItem() == MTMArmor.glowstoneBoots)
			{
				setLight(world, player);
			}
			
			if (leggings != null && leggings.getItem() == MTMArmor.slimeLeggings)
			{
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10, 1));
			}
			if (boots != null && boots.getItem() == MTMArmor.slimeBoots)
			{
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 10, 2));
			}
			
			if (helmet != null && chestplate != null && leggings != null && boots != null)
			{
				if (helmet.getItem() == MTMArmor.invisibilityHelmet && chestplate.getItem() == MTMArmor.invisibilityChestplate && leggings.getItem() == MTMArmor.invisibilityLeggings && boots.getItem() == MTMArmor.invisibilityBoots)
				{
					player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 4, 0));
				}
			}
		}
	}
	
	@Override
	public Item setUnlocalizedName(String name)
	{
		super.setUnlocalizedName(name);
		super.setTextureName(name);
		return this;
	}
	
	public static void setLight(World par1World, Entity par2Entity)
	{
		if (par1World.getBlockId(MathHelper.floor_double(par2Entity.posX), MathHelper.floor_double(par2Entity.posY), MathHelper.floor_double(par2Entity.posZ)) == 0)
		{
			par1World.setBlock(MathHelper.floor_double(par2Entity.posX), MathHelper.floor_double(par2Entity.posY), MathHelper.floor_double(par2Entity.posZ), MTMTools.glowing.blockID, 0, 0x02);
		}
	}
	
	/**
	 * Updates the WatchableObject (Byte) created in entityInit(), setting it to
	 * 0x01 if par1 is true or 0x00 if it is false.
	 */
	public static void setBesideClimbableBlock(Entity par1, boolean par2)
	{
		byte var2 = par1.getDataWatcher().getWatchableObjectByte(16);
		
		if (par2)
		{
			var2 = (byte) (var2 | 1);
		}
		else
		{
			var2 &= -2;
		}
		
		par1.getDataWatcher().updateObject(16, Byte.valueOf(var2));
	}
}