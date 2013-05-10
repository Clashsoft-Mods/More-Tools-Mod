package clashsoft.mods.moretools;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class ItemBucketMoreTools extends ItemBucket
{
	public int liquid;
	public int liquidMeta;

	public ItemBucketMoreTools(int id, int liquid, int liquidMeta)
	{
		super(id, liquid);
		this.liquid = liquid;
		this.liquidMeta = liquidMeta;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		float f = 1.0F;
		double d0 = par3EntityPlayer.prevPosX + (par3EntityPlayer.posX - par3EntityPlayer.prevPosX) * (double)f;
		double d1 = par3EntityPlayer.prevPosY + (par3EntityPlayer.posY - par3EntityPlayer.prevPosY) * (double)f + 1.62D - (double)par3EntityPlayer.yOffset;
		double d2 = par3EntityPlayer.prevPosZ + (par3EntityPlayer.posZ - par3EntityPlayer.prevPosZ) * (double)f;
		boolean flag = this.liquid == 0;
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, flag);

		if (movingobjectposition == null)
		{
			return par1ItemStack;
		}
		else
		{
			FillBucketEvent event = new FillBucketEvent(par3EntityPlayer, par1ItemStack, par2World, movingobjectposition);
			if (MinecraftForge.EVENT_BUS.post(event))
			{
				return par1ItemStack;
			}

			if (event.getResult() == Event.Result.ALLOW)
			{
				if (par3EntityPlayer.capabilities.isCreativeMode)
				{
					return par1ItemStack;
				}

				if (--par1ItemStack.stackSize <= 0)
				{
					return event.result;
				}

				if (!par3EntityPlayer.inventory.addItemStackToInventory(event.result))
				{
					par3EntityPlayer.dropPlayerItem(event.result);
				}

				return par1ItemStack;
			}

			if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
			{
				int i = movingobjectposition.blockX;
				int j = movingobjectposition.blockY;
				int k = movingobjectposition.blockZ;

				if (!par2World.canMineBlock(par3EntityPlayer, i, j, k))
				{
					return par1ItemStack;
				}

				if (this.canPickup(par1ItemStack) && !par3EntityPlayer.isSneaking())
				{
					System.out.println(this);
					if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
					{
						System.out.println("dfas");
						return par1ItemStack;
					}

					if (par2World.getBlockMaterial(i, j, k) == Material.water && par2World.getBlockMetadata(i, j, k) == 0)
					{
						par2World.setBlockToAir(i, j, k);

						if (par3EntityPlayer.capabilities.isCreativeMode)
						{
							return par1ItemStack;
						}

						if (--par1ItemStack.stackSize <= 0)
						{
							return this.addLiquid(par1ItemStack, 9);
						}

						if (!par3EntityPlayer.inventory.addItemStackToInventory(this.addLiquid(par1ItemStack, 9)))
						{
							par3EntityPlayer.dropPlayerItem(this.addLiquid(par1ItemStack, 9));
						}

						return par1ItemStack;
					}

					if (par2World.getBlockMaterial(i, j, k) == Material.lava && par2World.getBlockMetadata(i, j, k) == 0)
					{
						par2World.setBlockToAir(i, j, k);

						if (par3EntityPlayer.capabilities.isCreativeMode)
						{
							return par1ItemStack;
						}

						if (--par1ItemStack.stackSize <= 0)
						{
							return this.addLiquid(par1ItemStack, 11);
						}

						if (!par3EntityPlayer.inventory.addItemStackToInventory(this.addLiquid(par1ItemStack, 11)))
						{
							par3EntityPlayer.dropPlayerItem(this.addLiquid(par1ItemStack, 11));
						}

						return par1ItemStack;
					}
				}
				else
				{
					if (this.liquid < 0)
					{
						return reduceLiquid(par1ItemStack);
					}

					if (movingobjectposition.sideHit == 0)
					{
						--j;
					}

					if (movingobjectposition.sideHit == 1)
					{
						++j;
					}

					if (movingobjectposition.sideHit == 2)
					{
						--k;
					}

					if (movingobjectposition.sideHit == 3)
					{
						++k;
					}

					if (movingobjectposition.sideHit == 4)
					{
						--i;
					}

					if (movingobjectposition.sideHit == 5)
					{
						++i;
					}

					if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
					{
						return par1ItemStack;
					}

					if (par3EntityPlayer.isSneaking() && this.tryPlaceContainedLiquid(par2World, d0, d1, d2, i, j, k) && !par3EntityPlayer.capabilities.isCreativeMode)
					{
						return this.reduceLiquid(par1ItemStack);
					}
				}
			}
			else if (canPickup(par1ItemStack) && movingobjectposition.entityHit instanceof EntityCow)
			{
				return this.addLiquid(par1ItemStack, 79);
			}

			return par1ItemStack;
		}
	}

	/**
	 * Attempts to place the liquid contained inside the bucket.
	 */
	public boolean tryPlaceContainedLiquid(World par1World, double par2, double par4, double par6, int par8, int par9, int par10)
	{
		if (this.liquid <= 0)
		{
			return false;
		}
		else if (!par1World.isAirBlock(par8, par9, par10) && par1World.getBlockMaterial(par8, par9, par10).isSolid())
		{
			return false;
		}
		else
		{
			if (par1World.provider.isHellWorld && this.liquid == Block.waterMoving.blockID)
			{
				par1World.playSoundEffect(par2 + 0.5D, par4 + 0.5D, par6 + 0.5D, "random.fizz", 0.5F, 2.6F + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.8F);

				for (int l = 0; l < 8; ++l)
				{
					par1World.spawnParticle("largesmoke", (double)par8 + Math.random(), (double)par9 + Math.random(), (double)par10 + Math.random(), 0.0D, 0.0D, 0.0D);
				}
			}
			else
			{
				par1World.setBlock(par8, par9, par10, this.liquid, this.liquidMeta, 3);
			}

			return true;
		}
	}

	public ItemStack reduceLiquid(ItemStack par1ItemStack)
	{
		return new ItemStack(Item.bucketEmpty);
	}
	
	public ItemStack addLiquid(ItemStack par1ItemStack, int par2)
	{
		switch(par2)
		{
		case 9: return new ItemStack(Item.bucketWater);
		case 11: return new ItemStack(Item.bucketLava);
		case 79: return new ItemStack(Item.bucketMilk);
		default: return par1ItemStack;
		}
	}
	
	public boolean canPickup(ItemStack par1ItemStack)
	{
		return liquid == 0;
	}
}
