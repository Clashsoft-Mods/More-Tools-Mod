package clashsoft.mods.moretools;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemToolMoreTools extends ItemTool
{
    private Block blocksEffectiveAgainst[];
    protected float efficiencyOnProperMaterial;

    /** Damage versus entities. */
    private int damageVsEntity;

    /** The material this tool is made from. */
    protected EnumToolMaterial toolMaterial;

    protected ItemToolMoreTools(int par1, int par2, EnumToolMaterial par3EnumToolMaterial, Block par4ArrayOfBlock[])
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
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
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
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
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

    /**
     * Returns the damage against a given entity.
     */
    public int getDamageVsEntity(Entity par1Entity)
    {
        return damageVsEntity;
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return toolMaterial.getEnchantability();
    }
    
    int counter = 5;
    /**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
    {
    	Item i = par1ItemStack.getItem();
    	if ((i == MoreToolsMod_Tools.glowstonePick || i == MoreToolsMod_Tools.glowstoneShovel || i == MoreToolsMod_Tools.glowstoneAxe) && par5)
    	{
    		ItemArmorMoreTools.setLight(par2World, par3Entity);
    	}
    }
}
