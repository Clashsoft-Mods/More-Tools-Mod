package clashsoft.mods.moretools.item.tools;

import java.util.HashSet;
import java.util.Set;

import clashsoft.cslib.minecraft.item.datatools.ItemDataAxe;
import clashsoft.cslib.minecraft.item.datatools.ItemDataPickaxe;
import clashsoft.cslib.minecraft.item.datatools.ItemDataSpade;

import net.minecraft.item.ItemTool;

public class ItemMultitool extends ItemTool
{
	public static Set blocks = new HashSet();
	
	static
	{
		blocks.addAll(ItemDataPickaxe.blocksEffectiveAgainst);
		blocks.addAll(ItemDataAxe.blocksEffectiveAgainst);
		blocks.addAll(ItemDataSpade.blocksEffectiveAgainst);
	}
	
	public ItemMultitool(ToolMaterial material)
	{
		super(6F, material, blocks);
	}	
}
