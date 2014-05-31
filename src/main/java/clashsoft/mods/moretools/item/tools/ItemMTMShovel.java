package clashsoft.mods.moretools.item.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemMTMShovel extends ItemSpade
{
	public EnumRarity	rarity;
	
	public ItemMTMShovel(ToolMaterial material)
	{
		this(material, EnumRarity.common);
	}
	
	public ItemMTMShovel(ToolMaterial material, EnumRarity rarity)
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
