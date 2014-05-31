package clashsoft.mods.moretools.item.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemMTMHoe extends ItemHoe
{
	public EnumRarity	rarity;
	
	public ItemMTMHoe(ToolMaterial material)
	{
		this(material, EnumRarity.common);
	}
	
	public ItemMTMHoe(ToolMaterial material, EnumRarity rarity)
	{
		super(material);
		this.rarity = rarity;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack)
	{
		return this.rarity;
	}
}
