package clashsoft.mods.moretools;

import clashsoft.cslib.minecraft.update.CSUpdate;
import clashsoft.cslib.util.CSArrays;
import cpw.mods.fml.common.ModMetadata;

public class MTMVersion
{
	public static final String		MODID			= "moretools";
	public static final String		NAME			= "More Tools Mod";
	public static final String		ACRONYM			= "mtm";
	
	public static final int			REVISION		= 0;
	public static final String		VERSION			= CSUpdate.CURRENT_VERSION + "-" + REVISION;
	
	public static void updateCheck()
	{
		CSUpdate.updateCheckCS(NAME, ACRONYM, VERSION);
	}
	
	public static void write(ModMetadata metadata)
	{
		metadata.autogenerated = false;
		metadata.name = NAME;
		metadata.modId = MODID;
		metadata.version = VERSION;
		metadata.logoFile = "moretools:logo.png";
		metadata.url = "https://github.com/Clashsoft/More-Tools-Mod/wiki";
		metadata.authorList = CSArrays.asList("Clashsoft");
	}
}
