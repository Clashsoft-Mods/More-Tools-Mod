package clashsoft.mods.moretools;

import java.util.Random;

import clashsoft.clashsoftapi.ClashsoftMisc;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.*;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class ItemBowMoreTools extends Item
{
	private static String[] spacetextures = new String[] {"spacebow", "spacebow_1", "spacebow_2", "spacebow_3"};
	private static Icon[] spaceicons;
	private static String[] textures = new String[] {"spacebow", "spacebow_1", "spacebow_2", "spacebow_3"};
	private static Icon[] icons;
	
    private Item arrowToConsume;
    private boolean isSkeletonBow;
	
	public ItemBowMoreTools(int par1, Item par2, boolean par3)
    {
        super(par1);
        maxStackSize = 1;
        setMaxDamage(384);
        this.arrowToConsume = par2;
        this.isSkeletonBow = par3;
        this.setCreativeTab(CreativeTabs.tabCombat);
    }
    
    @Override
    public boolean isFull3D()
    {
    	return true;
    }

    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
    {
    	int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

        if (flag || par3EntityPlayer.inventory.hasItem(arrowToConsume.itemID))
        {
            float f = ((float)j / 20.0F) + (EnchantmentHelper.getEnchantmentLevel(MoreToolsMod_Tools.quickDraw.effectId, par1ItemStack) * 0.04F);
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityArrow entityarrow = new EntityArrow(par2World, par3EntityPlayer, f * 2.0F);

            if (f == 1.0F)
            {
                entityarrow.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

            if (k > 0)
            {
                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

            if (l > 0)
            {
                entityarrow.setKnockbackStrength(l);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
            {
                entityarrow.setFire(100);
            }

            par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag)
            {
                entityarrow.canBePickedUp = 2;
            }
            else
            {
                par3EntityPlayer.inventory.consumeInventoryItem(Item.arrow.itemID);
            }

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(entityarrow);
            }
        }
    }

    public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 71232;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(arrowToConsume.itemID))
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
        }

        return par1ItemStack;
    }
    
    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }
    
    @Override
    public Icon getIconFromDamage(int par1)
    {
    	if (this == MoreToolsMod_Tools.spaceBow)
    	{
    		return spaceicons[0];
    	}
    	return super.getIconFromDamage(par1);
    }
    
    @Override
    public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
        boolean isSpaceBow = this == MoreToolsMod_Tools.spaceBow;
    	if (usingItem != null && usingItem.getItem().itemID == MoreToolsMod_Tools.spaceBow.itemID)
        {
            int k = usingItem.getMaxItemUseDuration() - useRemaining;
            int var1 = 18 - (EnchantmentHelper.getEnchantmentLevel(MoreToolsMod_Tools.quickDraw.effectId, stack) * 4);
            int var2 = 13 - (EnchantmentHelper.getEnchantmentLevel(MoreToolsMod_Tools.quickDraw.effectId, stack) * 4);
            int var3 = 0;
            if (k >= var1) return isSpaceBow ? spaceicons[3] : icons[3];
            if (k >  var2) return isSpaceBow ? spaceicons[2] : icons[2];
            if (k >  var3) return isSpaceBow ? spaceicons[1] : icons[1];
        }
        return isSpaceBow ? spaceicons[0] : icons[0];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void updateIcons(IconRegister par1IconRegister) //Registers the Icons
    {
        spaceicons = new Icon[spacetextures.length];
    	for (int i = 0; i < spacetextures.length; i++)
        {
        	spaceicons[i] = par1IconRegister.registerIcon(spacetextures[i]);
        }
    	icons = new Icon[textures.length];
    	for (int i = 0; i < textures.length; i++)
        {
        	icons[i] = par1IconRegister.registerIcon(textures[i]);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public Icon func_94599_c(int par1)
    {
        return this == MoreToolsMod_Tools.spaceBow ? spaceicons[par1] : icons[par1];
    }
}
