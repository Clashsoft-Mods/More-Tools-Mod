package clashsoft.mods.moretools;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class MoreToolsMod_WorldGen implements IWorldGenerator
{
	public void generateSurface(World world, Random rand, int chunkX, int chunkZ)
  	{
  		for(int i = 0; i < 5; i++)
  		{
  			int randPosX = chunkX * 16 + rand.nextInt(16);
  			int randPosY = rand.nextInt(20);
  			int randPosZ = chunkZ * 16 + rand.nextInt(16);
  			(new WorldGenMinable(MoreToolsMod_Tools.spaceOre.blockID, 6)).generate(world, rand, randPosX, randPosY, randPosZ);
  		}
  		if (rand.nextInt(100) == 0)
  		{
  			int randPosX = chunkX * 16 + rand.nextInt(16);
  			int randPosY = rand.nextInt(20);
  			int randPosZ = chunkZ * 16 + rand.nextInt(16);
  			(new WorldGenMinable(MoreToolsMod_Tools.spaceBlock.blockID, 12)).generate(world, rand, randPosX, randPosY, randPosZ);
  		}
    }
	
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if (world.provider.isSurfaceWorld())
		{
			generateSurface(world, random, chunkX, chunkZ);
		}
	}
	
}
