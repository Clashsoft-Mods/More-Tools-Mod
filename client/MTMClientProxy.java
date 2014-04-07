package clashsoft.mods.moretools.client;

import java.util.HashMap;
import java.util.Map;

import clashsoft.mods.moretools.common.MTMProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;

public class MTMClientProxy extends MTMProxy
{
	public Map<String, Integer>	armorIndices	= new HashMap();
	
	public static int			space;
	public static int			hallowed;
	public static int			goddawn;
	public static int			invisibility;
	public static int			glowstone;
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		space = this.getArmorIndex("space");
		hallowed = this.getArmorIndex("hallowed");
		goddawn = this.getArmorIndex("goddawn");
		invisibility = this.getArmorIndex("invisibility");
		glowstone = this.getArmorIndex("glowstone");
	}
	
	@Override
	public int getArmorIndex(String name)
	{
		Integer integer = this.armorIndices.get(name);
		if (integer == null)
		{
			int i = RenderingRegistry.addNewArmourRendererPrefix(name);
			integer = Integer.valueOf(i);
			this.armorIndices.put(name, integer);
		}
		return integer.intValue();
	}
}
