package clashsoft.mods.moretools.common;

import clashsoft.cslib.minecraft.common.BaseProxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MTMProxy extends BaseProxy
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
	
	public int getArmorIndex(String name)
	{
		return 0;
	}
}
