package clashsoft.mods.moretools.item.tools;

import java.util.HashSet;
import java.util.Set;

import clashsoft.cslib.minecraft.item.datatools.ItemDataAxe;
import clashsoft.cslib.minecraft.item.datatools.ItemDataPickaxe;
import clashsoft.cslib.minecraft.item.datatools.ItemDataSpade;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemMultitool extends ItemTool
{
	public static Set	blocks	= new HashSet();
	
	static
	{
		blocks.addAll(ItemDataPickaxe.blocksEffectiveAgainst);
		blocks.addAll(ItemDataAxe.blocksEffectiveAgainst);
		blocks.addAll(ItemDataSpade.blocksEffectiveAgainst);
	}
	
	public EnumRarity	rarity;
	
	public ItemMultitool(ToolMaterial material)
	{
		this(material, EnumRarity.common);
	}
	
	public ItemMultitool(ToolMaterial material, EnumRarity rarity)
	{
		super(6F, material, blocks);
		this.rarity = rarity;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return this.rarity;
	}
}
