package oresanditems.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {

	public static Block blockjadeite;

	// Initializes a BlockJadeite and registers it with GameRegistry
	// Sets harvest level for pickaxe to 3 (only a diamond pickaxe can mine)
	public static void init() {
		blockjadeite = new BlockJadeite(BlockInfo.blockjadeite_id);
		GameRegistry.registerBlock(blockjadeite, BlockInfo.BLOCKJADEITE_KEY);
		MinecraftForge.setBlockHarvestLevel(blockjadeite, "pickaxe", 3);
	}
	
	// Adds BlockJadeite name to LanguageRegistry
	public static void addNames() {
		LanguageRegistry.addName(blockjadeite, BlockInfo.BLOCKJADEITE_NAME);
	}
	
}
