package clashsoft.mods.moretools.item;

import clashsoft.mods.moretools.item.tools.ItemMTMSword;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemLightsaber extends ItemMTMSword
{
	public static final String[]	types	= new String[] {
			"shaft",
			"blue",
			"green",
			"red",
			"purple",
			"white"						};
	
	public IIcon[]					icons;
	
	public ItemLightsaber(ToolMaterial toolMaterial)
	{
		super(toolMaterial, EnumRarity.rare);
		this.setHasSubtypes(true);
		this.setMaxDamage(1);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			int newDamage = (stack.getItemDamage() + 1) % types.length;
			stack.setItemDamage(newDamage);
			return true;
		}
		return false;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return "item.lightsaber." + types[stack.getItemDamage()];
	}
	
	@Override
	public IIcon getIconFromDamage(int metadata)
	{
		return this.icons[metadata];
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.icons = new IIcon[6];
		this.icons[0] = iconRegister.registerIcon("moretools:lightsaber");
		for (int i = 1; i < this.icons.length; i++)
		{
			icons[i] = iconRegister.registerIcon("moretools:lightsaber_" + types[i]);
		}
	}
}
