package clashsoft.mods.moretools.crafting;

import clashsoft.mods.moretools.addons.MTMTools;
import clashsoft.mods.moretools.item.dyeable.ItemDyeableTool;

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
	
	/**
	 * Returns an Item that is the result of this recipe
	 */
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventory)
	{
		ItemStack theTool = null;
		int[] colors = new int[3];
		int i = 0;
		int j = 0;
		int k = 0;
		ItemDyeableTool item = null;
		
		for (; k < inventory.getSizeInventory(); ++k)
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
					theTool.stackSize = 1;
					
					if (item.hasColor(stack))
					{
						int i1 = item.getColor(theTool);
						float f1 = (i1 >> 16 & 0xFF) / 255.0F;
						float f3 = (i1 >> 8 & 0xFF) / 255.0F;
						float f5 = (i1 & 0xFF) / 255.0F;
						
						i = (int) (i + Math.max(f1, Math.max(f3, f5)) * 255.0F);
						colors[0] = (int) (colors[0] + f1 * 255.0F);
						colors[1] = (int) (colors[1] + f3 * 255.0F);
						colors[2] = (int) (colors[2] + f5 * 255.0F);
						++j;
					}
				}
				else
				{
					return null;
				}
			}
			else if (stack.getItem() == Items.dye)
			{
				float[] arrayOfFloat = net.minecraft.entity.passive.EntitySheep.fleeceColorTable[net.minecraft.block.BlockColored.func_150032_b(stack.getItemDamage())];
				int i3 = (int) (arrayOfFloat[0] * 255.0F);
				int i4 = (int) (arrayOfFloat[1] * 255.0F);
				int i5 = (int) (arrayOfFloat[2] * 255.0F);
				
				i += Math.max(i3, Math.max(i4, i5));
				
				colors[0] += i3;
				colors[1] += i4;
				colors[2] += i5;
				++j;
			}
			else
			{
				return null;
			}
		}
		
		if (item == null)
			return null;
		
		k = colors[0] / j;
		int l = colors[1] / j;
		int i2 = colors[2] / j;
		
		float f2 = i / j;
		float f4 = Math.max(k, Math.max(l, i2));
		
		k = (int) (k * f2 / f4);
		l = (int) (l * f2 / f4);
		i2 = (int) (i2 * f2 / f4);
		
		int color = k;
		color = (color << 8) + l;
		color = (color << 8) + i2;
		
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
