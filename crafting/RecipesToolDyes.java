package clashsoft.mods.moretools.crafting;

import java.util.ArrayList;

import clashsoft.mods.moretools.addons.MTMTools;
import clashsoft.mods.moretools.item.dyeable.ItemDyeableHoe;
import clashsoft.mods.moretools.item.dyeable.ItemDyeableSword;
import clashsoft.mods.moretools.item.dyeable.ItemDyeableTool;

import net.minecraft.block.BlockColored;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RecipesToolDyes implements IRecipe
{
	@Override
	/**
	 * Used to check if a recipe matches current crafting inventory
	 */
	public boolean matches(InventoryCrafting par1InventoryCrafting, World par2World)
	{
		ItemStack var3 = null;
		ArrayList var4 = new ArrayList();
		
		for (int var5 = 0; var5 < par1InventoryCrafting.getSizeInventory(); ++var5)
		{
			ItemStack var6 = par1InventoryCrafting.getStackInSlot(var5);
			
			if (var6 != null)
			{
				if (var6.getItem() instanceof ItemDyeableTool)
				{
					ItemDyeableTool var7 = (ItemDyeableTool) var6.getItem();
					
					if (var7.getToolMaterial() != MTMTools.LEATHER || var3 != null)
					{
						return false;
					}
					
					var3 = var6;
				}
				else
				{
					if (var6.itemID != Item.dyePowder.itemID)
					{
						return false;
					}
					
					var4.add(var6);
				}
			}
		}
		
		return var3 != null && !var4.isEmpty();
	}
	
	/**
	 * Returns an Item that is the result of this recipe
	 */
	@Override
	public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting)
	{
		ItemStack result = null;
		int[] rgb = new int[3];
		int var4 = 0;
		int var5 = 0;
		ItemDyeableTool theTool = null;
		int slot;
		int toolColor;
		float var10;
		float var11;
		int var17;
		
		for (slot = 0; slot < par1InventoryCrafting.getSizeInventory(); ++slot)
		{
			ItemStack stackInSlot = par1InventoryCrafting.getStackInSlot(slot);
			
			if (stackInSlot != null)
			{
				if (stackInSlot.getItem() instanceof ItemDyeableTool || stackInSlot.getItem() instanceof ItemDyeableSword || stackInSlot.getItem() instanceof ItemDyeableHoe)
				{
					theTool = (ItemDyeableTool) stackInSlot.getItem();
					
					if (theTool.getToolMaterial() != MTMTools.LEATHER || result != null)
					{
						return null;
					}
					
					result = stackInSlot.copy();
					
					if (theTool.hasColor(stackInSlot))
					{
						toolColor = theTool.getColor(result);
						var10 = (toolColor >> 16 & 255) / 255.0F;
						var11 = (toolColor >> 8 & 255) / 255.0F;
						float var12 = (toolColor & 255) / 255.0F;
						var4 = (int) (var4 + Math.max(var10, Math.max(var11, var12)) * 255.0F);
						rgb[0] = (int) (rgb[0] + var10 * 255.0F);
						rgb[1] = (int) (rgb[1] + var11 * 255.0F);
						rgb[2] = (int) (rgb[2] + var12 * 255.0F);
						++var5;
					}
				}
				else if (stackInSlot.itemID == Item.dyePowder.itemID)
				{	
					float[] var14 = EntitySheep.fleeceColorTable[BlockColored.getBlockFromDye(stackInSlot.getItemDamage())];
					int var16 = (int) (var14[0] * 255.0F);
					int var15 = (int) (var14[1] * 255.0F);
					var17 = (int) (var14[2] * 255.0F);
					var4 += Math.max(var16, Math.max(var15, var17));
					rgb[0] += var16;
					rgb[1] += var15;
					rgb[2] += var17;
					++var5;
				}
				else
					return null;
			}
		}
		
		if (theTool == null)
		{
			return null;
		}
		else
		{
			slot = rgb[0] / var5;
			int var13 = rgb[1] / var5;
			toolColor = rgb[2] / var5;
			var10 = (float) var4 / (float) var5;
			var11 = Math.max(slot, Math.max(var13, toolColor));
			slot = (int) (slot * var10 / var11);
			var13 = (int) (var13 * var10 / var11);
			toolColor = (int) (toolColor * var10 / var11);
			var17 = (slot << 8) + var13;
			var17 = (var17 << 8) + toolColor;
			theTool.func_82813_b(result, var17);
			return result;
		}
	}
	
	/**
	 * Returns the size of the recipe area
	 */
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
