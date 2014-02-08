package clashsoft.mods.moretools.item.tools;

import clashsoft.mods.moretools.addons.MTMTools;
import clashsoft.mods.moretools.item.armor.ItemArmorMTM;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHoeMTM extends ItemHoe
{
	public EnumRarity	rarity;
	
	public ItemHoeMTM(ToolMaterial material)
	{
		this(material, EnumRarity.common);
	}
	
	public ItemHoeMTM(ToolMaterial material, EnumRarity rarity)
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
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean holding)
	{
		if ((this == MTMTools.glowstoneHoe) && holding)
		{
			ItemArmorMTM.setLight(world, entity);
		}
	}
	
	@Override
	public Item setUnlocalizedName(String name)
	{
		super.setUnlocalizedName(name);
		super.setTextureName(name);
		return this;
	}
}
