package clashsoft.mods.moretools.item;

import net.minecraft.item.ItemBlock;

public class ItemMultiBlock extends ItemBlock
{	
	public ItemMultiBlock(int id)
	{
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int damageValue)
	{
		return damageValue;
	}
}
