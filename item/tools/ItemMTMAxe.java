package clashsoft.mods.moretools.item.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemMTMAxe extends ItemAxe
{
	public EnumRarity	rarity;
	
	public ItemMTMAxe(ToolMaterial material)
	{
		this(material, EnumRarity.common);
	}
	
	public ItemMTMAxe(ToolMaterial material, EnumRarity rarity)
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
