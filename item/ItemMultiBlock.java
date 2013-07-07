package clashsoft.mods.moretools.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMultiBlock extends ItemBlock
{
	private final static String[] subNames =
		{
		"ore", "block", "old", "old", "old"
		};

	public ItemMultiBlock(int id)
	{
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata (int damageValue)
	{
		return damageValue;
	}
}
