package oresanditems.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import oresanditems.blocks.BlockInfo;
import oresanditems.items.ItemInfo;

public class ConfigHandler {
	
	private static final String CATEGORY = "new items";
	
	// init creates our config file, loads it, aligns actual id values with default values with config.get,
	// then saves the config file.the ids for Items are subtracted by 256 to counteract Minecraft's 
	// default feature of adding 256 to Item ids
	public static void init(File file) {
		Configuration config = new Configuration(file);
		config.load();
		ItemInfo.jadeitegem_id = config.get(CATEGORY, ItemInfo.JADEITEGEM_KEY, ItemInfo.JADEITEGEM_DEFAULT).getInt() - 256;
		ItemInfo.jadeitesword_id = config.get(CATEGORY, ItemInfo.JADEITESWORD_KEY, ItemInfo.JADEITESWORD_DEFAULT).getInt() - 256;
		BlockInfo.blockjadeite_id = config.getBlock(BlockInfo.BLOCKJADEITE_KEY, BlockInfo.BLOCKJADEITE_DEFAULT).getInt();
		config.save();
	}
	
}