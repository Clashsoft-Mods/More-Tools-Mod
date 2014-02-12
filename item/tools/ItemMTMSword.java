package clashsoft.mods.moretools.item.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemMTMSword extends ItemSword
{
	public EnumRarity	rarity;
	
	public ItemMTMSword(ToolMaterial material)
	{
		this(material, EnumRarity.common);
	}
	
	public ItemMTMSword(ToolMaterial material, EnumRarity rarity)
	{
		super(material);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.rarity = rarity;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack)
	{
		return this.rarity;
	}
}
