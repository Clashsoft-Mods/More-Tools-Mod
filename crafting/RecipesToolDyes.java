package clashsoft.mods.moretools.crafting;

import clashsoft.mods.moretools.addons.MTMTools;
import clashsoft.mods.moretools.item.dyeable.ItemDyeableTool;

import net.minecraft.block.BlockColored;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RecipesToolDyes implements IRecipe
{
	@Override
	public boolean matches(InventoryCrafting inventory, World world)
	{
		ItemStack theTool = null;
		int dyes = 0;
		
		for (int i = 0; i < inventory.getSizeInventory(); ++i)
		{
			ItemStack stack = inventory.getStackInSlot(i);
			
			if (stack != null)
			{
				Item item = stack.getItem();
				if (item instanceof ItemDyeableTool)
				{
					ItemDyeableTool tool = (ItemDyeableTool) item;
					
					if (tool.getToolMaterial() != MTMTools.LEATHER)
					{
						return false;
					}
					
					theTool = stack;
				}
				else
				{
					if (stack.getItem() != Items.dye)
					{
						return false;
					}
					dyes++;
				}
			}
		}
		
		return theTool != null && dyes > 0;
	}
	
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventory)
	{
		ItemStack theTool = null;
		int[] colors = new int[3];
		int saturation = 0;
		int coloredItems = 0;
		ItemDyeableTool item = null;
		
		for (int k = 0; k < inventory.getSizeInventory(); ++k)
		{
			ItemStack stack = inventory.getStackInSlot(k);
			if (stack == null)
			{
				continue;
			}
			if (stack.getItem() instanceof ItemDyeableTool)
			{
				item = (ItemDyeableTool) stack.getItem();
				
				if (theTool == null)
				{
					theTool = stack.copy();
					
					if (item.hasColor(stack))
					{
						int color = item.getColor(theTool);
						int r = (color >> 16 & 0xFF);
						int g = (color >> 8 & 0xFF);
						int b = (color & 0xFF);
						
						saturation += Math.max(r, Math.max(g, b));
						colors[0] += r;
						colors[1] += g;
						colors[2] += b;
						++coloredItems;
					}
				}
				else
				{
					return null;
				}
			}
			else if (stack.getItem() == Items.dye)
			{
				float[] colors1 = EntitySheep.fleeceColorTable[BlockColored.func_150032_b(stack.getItemDamage())];
				int r = (int) (colors1[0] * 255.0F);
				int g = (int) (colors1[1] * 255.0F);
				int b = (int) (colors1[2] * 255.0F);
				
				saturation += Math.max(r, Math.max(g, b));
				
				colors[0] += r;
				colors[1] += g;
				colors[2] += b;
				++coloredItems;
			}
			else
			{
				return null;
			}
		}
		
		if (item == null)
			return null;
		
		int r = colors[0] / coloredItems;
		int g = colors[1] / coloredItems;
		int b = colors[2] / coloredItems;
		
		float f2 = saturation / coloredItems;
		float f4 = Math.max(r, Math.max(g, b));
		
		r = (int) (r * f2 / f4);
		g = (int) (g * f2 / f4);
		b = (int) (b * f2 / f4);
		
		int color = (r << 16) | (g <<8) | b;
		
		item.dye(theTool, color);
		return theTool;
	}
	
	@Override
	public int getRecipeSize()
	{
		return 10;
	}
	
	@Override
	public ItemStack getRecipeOutput()
	{
		return null;
	}
}
