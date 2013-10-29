package clashsoft.mods.moretools.item.buckets;

import clashsoft.mods.moretools.addons.MTMTools;

import net.minecraft.item.ItemStack;

public class ItemGoldBucket extends ItemBucketMTM
{
	public ItemGoldBucket(int id, int liquid)
	{
		super(id, liquid, 0);
		this.setMaxStackSize(liquid == 0 ? 16 : 1);
		this.setHasSubtypes(true);
		this.setCreativeTab(null);
	}
	
	@Override
	public ItemStack reduceLiquid(ItemStack par1ItemStack)
	{
		return par1ItemStack.getItemDamage() <= 1 ? new ItemStack(MTMTools.goldBucket) : new ItemStack(par1ItemStack.getItem(), par1ItemStack.stackSize, par1ItemStack.getItemDamage() - 1);
	}
	
	@Override
	public ItemStack addLiquid(ItemStack par1ItemStack, int par2)
	{
		System.out.println("Added liquid");
		par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() + 1);
		System.out.println("Damage increased");
		switch (par2)
		{
		case 9:
			return new ItemStack(MTMTools.goldBucketWater, 1, par1ItemStack.getItemDamage());
		case 11:
			return new ItemStack(MTMTools.goldBucketLava, 1, par1ItemStack.getItemDamage());
		case 79:
			return new ItemStack(MTMTools.goldBucketMilk, 1, par1ItemStack.getItemDamage());
		default:
			return par1ItemStack;
		}
	}
	
	@Override
	public boolean canPickup(ItemStack par1ItemStack)
	{
		return par1ItemStack.getItemDamage() < 4;
	}
}
