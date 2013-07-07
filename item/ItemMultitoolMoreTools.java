package clashsoft.mods.moretools.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemMultitoolMoreTools extends ItemToolMoreTools
{
    private static Block blocksEffectiveAgainst[];
    private float weaponDamage;

    public ItemMultitoolMoreTools(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, 2, par2EnumToolMaterial, blocksEffectiveAgainst);
        weaponDamage = 4 + par2EnumToolMaterial.getDamageVsEntity();
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        /*
         * Pickaxe functions. 
         */
    	
    	if (par1Block == Block.obsidian)
        {
            return toolMaterial.getHarvestLevel() == 3;
        }

        if (par1Block == Block.blockDiamond || par1Block == Block.oreDiamond)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }

        if (par1Block == Block.blockGold || par1Block == Block.oreGold)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }

        if (par1Block == Block.blockIron || par1Block == Block.oreIron)
        {
            return toolMaterial.getHarvestLevel() >= 1;
        }

        if (par1Block == Block.blockLapis || par1Block == Block.oreLapis)
        {
            return toolMaterial.getHarvestLevel() >= 1;
        }

        if (par1Block == Block.oreRedstone || par1Block == Block.oreRedstoneGlowing)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }

        if (par1Block.blockMaterial == Material.rock)
        {
            return true;
        }
        
        /*
         * Shovel functions.
         */
        
        if (par1Block == Block.snow)
        {
            return true;
        }
        
        return par1Block.blockMaterial == Material.iron;
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, int par2, int par3, int par4, int par5, EntityLiving par6EntityLiving)
    {
        if (par2 == Block.leaves.blockID || par2 == Block.web.blockID || par2 == Block.tallGrass.blockID || par2 == Block.vine.blockID)
        {
            par1ItemStack.damageItem(1, par6EntityLiving);
            return true;
        }
        else
        {
            return super.onBlockDestroyed(par1ItemStack, par2, par3, par4, par5, par6EntityLiving);
        }
    }
    
    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        if (par2Block != null && (par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.rock))
        {
            return efficiencyOnProperMaterial;
        }
        else
        {
            return super.getStrVsBlock(par1ItemStack, par2Block);
        }
    }

    static
    {
        blocksEffectiveAgainst = (new Block[]
                {
                    Block.cobblestone, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold,
                    Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail,
                    Block.railDetector, Block.railPowered,
                    
                    Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.pumpkin, Block.pumpkinLantern,
                    
                    Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium,
                });
    }
    
    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }

            if (event.getResult() == Result.ALLOW)
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
                return true;
            }

            int var11 = par3World.getBlockId(par4, par5, par6);
            int var12 = par3World.getBlockId(par4, par5 + 1, par6);

            if ((par7 == 0 || var12 != 0 || var11 != Block.grass.blockID) && var11 != Block.dirt.blockID)
            {
                return false;
            }
            else
            {
                Block var13 = Block.tilledField;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), var13.stepSound.getStepSound(), (var13.stepSound.getVolume() + 1.0F) / 2.0F, var13.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return true;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, var13.blockID, 0, 0x02);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return true;
                }
            }
        }
    }

    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
    
    public void useItemOnEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, World par3World)
    {
        double x = par2EntityLiving.posX;
        double y = par2EntityLiving.posY;
        double z = par2EntityLiving.posZ;
    	
    	if (par2EntityLiving instanceof Entity)
        {
            par3World.createExplosion(par2EntityLiving, x, y, z, 5, false);
        }
    }
}
