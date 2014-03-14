package oresanditems.world;

import java.util.Random;
import oresanditems.blocks.BlockInfo;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class GenerationHandler implements IWorldGenerator {

	private WorldGenerator jadeiteGen;
	
	// Our constructor registers our GenerationHandler into WorldGenerator and call a minecraft method WorldGenMinable 
	// We pass the id number for blockJadeite and int 10 which tells the method to try to create veins with up to 10 blocks 
	// (this depends on blocks it cannot replace such as waterfalls, air, etc)
	public GenerationHandler() {
		GameRegistry.registerWorldGenerator(this);
		jadeiteGen = new WorldGenMinable(BlockInfo.blockjadeite_id, 10);
	}
	
	// Generates random veins of ore of the same class. ChunkX and chunkZ represent a 16x16 chunks of blocks.
	// random generates a number 0 to 15 to add to chunkX and chunkZ to randomize x and z coordinates for vein placement
	// lowestY and highestY represent the lowest and highest possible y coordinate for the center of a vein of ores respectively
	// y is a random int between (and including both) the lowestY and highestY
	// world is our minecraft world, gen is the generator, attemps is the number of times this functions tries creating a vein
	// during each attempt we call the generate function on the WorldGenerator object (ore) we wish to generate
	private void generateStandardOre(Random random, int chunkX, int chunkZ, World world, int attempts, WorldGenerator gen, int lowestY, int highestY) {
		for (int i = 0; i < attempts; i+=1) {
			int x = chunkX*16 + random.nextInt(16);
			int y = random.nextInt(highestY - lowestY) + lowestY;
			int z = chunkZ*16 + random.nextInt(16);
			gen.generate(world, random, x, y, z);
		}
	}
	
	
	//calls our method generateStandardOre for our blockJadeite generator
	//generates blockJadeite blocks, 25 attempts for veins up to 5 blocks, from layers 0 to 18
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider ChunkGenerator, IChunkProvider chunkProvider) {
		generateStandardOre(random, chunkX, chunkZ, world, 25, jadeiteGen, 0, 18);
	}
	
}
