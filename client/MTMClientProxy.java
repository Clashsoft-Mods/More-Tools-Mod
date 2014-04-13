package clashsoft.mods.moretools.client;

import java.util.HashMap;
import java.util.Map;

import clashsoft.mods.moretools.common.MTMProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class MTMClientProxy extends MTMProxy
{
	public Map<String, Integer>	armorIndices	= new HashMap();
	
	public static int			space;
	public static int			god;
	public static int			luzifer;
	public static int			invisibility;
	public static int			glowstone;
	
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		space = this.getArmorIndex("space");
		god = this.getArmorIndex("god");
		luzifer = this.getArmorIndex("luzifer");
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
			this.armorIndices.put(name, Integer.valueOf(i)); 
			return i;
		}
		return integer.intValue();
	}
}
