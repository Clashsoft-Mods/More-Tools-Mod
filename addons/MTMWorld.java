package clashsoft.mods.moretools.addons;

import java.util.Random;

import clashsoft.cslib.addon.Addon;
import cpw.mods.fml.common.IWorldGenerator;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

@Addon(modName = "MoreToolsMod", addonName = "World")
public class MTMWorld implements IWorldGenerator
{
	public void generateSurface(World world, Random rand, int chunkX, int chunkZ)
	{
		for (int i = 0; i < 5; i++)
		{
			int randPosX = chunkX * 16 + rand.nextInt(16);
			int randPosY = rand.nextInt(20);
			int randPosZ = chunkZ * 16 + rand.nextInt(16);
			(new WorldGenMinable(MTMTools.spaceBlock.blockID, 6)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
		if (rand.nextInt(64) == 0)
		{
			int randPosX = chunkX * 16 + rand.nextInt(16);
			int randPosY = rand.nextInt(20);
			int randPosZ = chunkZ * 16 + rand.nextInt(16);
			(new WorldGenMinable(MTMTools.spaceBlock.blockID, 24)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if (world.provider.isSurfaceWorld())
		{
			generateSurface(world, random, chunkX, chunkZ);
		}
	}
}
