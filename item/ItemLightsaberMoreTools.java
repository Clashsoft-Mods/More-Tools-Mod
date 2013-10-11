package clashsoft.mods.moretools.item;

import clashsoft.mods.moretools.MTMTools;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class ItemLightsaberMoreTools extends ItemSwordMoreTools
{
	public ItemLightsaberMoreTools(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, par2EnumToolMaterial, 2);
		this.maxStackSize = 1;
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		ItemStack shaft = new ItemStack(MTMTools.lightsaberShaft, 1);
		ItemStack blue = new ItemStack(MTMTools.lightsaberBlue, 1);
		ItemStack green = new ItemStack(MTMTools.lightsaberGreen, 1);
		ItemStack purple = new ItemStack(MTMTools.lightsaberPurple, 1);
		ItemStack red = new ItemStack(MTMTools.lightsaberRed, 1);
		ItemStack white = new ItemStack(MTMTools.lightsaberWhite, 1);
		
		if (par1ItemStack == shaft)
		{
			return blue;
		}
		else if (par1ItemStack.itemID == 1986 + 256)
		{
			return green;
		}
		else if (par1ItemStack.itemID == 1987 + 256)
		{
			return purple;
		}
		else if (par1ItemStack.itemID == 1988 + 256)
		{
			return red;
		}
		else if (par1ItemStack.itemID == 1989 + 256)
		{
			return white;
		}
		else if (par1ItemStack.itemID == 1990 + 256)
		{
			return blue;
		}
		else
		{
			return blue;
		}
	}
}
