package clashsoft.mods.moretools.item.armor;

import clashsoft.mods.moretools.addons.MTMArmor;
import clashsoft.mods.moretools.addons.MTMTools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemArmorMTM extends ItemArmor
{
	/**
	 * Stores the armor type: 0 is helmet, 1 is plate, 2 is legs and 3 is boots
	 */
	public final int			armorType;
	
	/** Holds the amount of damage that the armor reduces at full durability. */
	public final int			damageReduceAmount;
	
	/**
	 * Used on RenderPlayer to select the correspondent armor to be rendered on the player: 0 is
	 * cloth, 1 is chain, 2 is iron, 3 is diamond and 4 is gold.
	 */
	public final int			renderIndex;
	
	/** The ArmorMaterial used for this ItemArmor */
	public final ArmorMaterial	material;
	
	public ItemArmorMTM(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
		this.material = material;
		this.armorType = armorType;
		this.renderIndex = renderIndex;
		this.damageReduceAmount = material.getDamageReductionAmount(armorType);
		this.setMaxDamage(material.getDurability(armorType));
		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
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
	
	public static void setLight(World world, Entity entity)
	{
		int x = (int) entity.posX;
		int y = (int) entity.posY;
		int z = (int) entity.posZ;
		if (world.isAirBlock(x, y, z))
		{
			world.setBlock(x, y, z, MTMTools.glowingBlock);
		}
	}
}