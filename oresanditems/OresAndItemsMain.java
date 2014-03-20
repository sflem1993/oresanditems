package oresanditems; 

import oresanditems.blocks.Blocks;
import oresanditems.config.ConfigHandler;
import oresanditems.items.Items;
import oresanditems.network.PacketHandler;
import oresanditems.proxies.CommonProxy;
import oresanditems.world.GenerationHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

//@Mod gives info for Client Side, @NetworkMod for Server side
@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
@NetworkMod(channels = {ModInfo.CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class OresAndItemsMain {
	
	@Instance(ModInfo.ID)
	public static OresAndItemsMain instance;
	
	@SidedProxy(clientSide = "oresanditems.proxies.ClientProxy", serverSide = "oresanditems.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	
	// Event before Initialization of mod. Calls init for ConfigHandler, Items, Blocks, and Sounds and Renders
	@EventHandler()
	public void preInit(FMLPreInitializationEvent Event) {
		ConfigHandler.init(Event.getSuggestedConfigurationFile());
		Items.init();
		Blocks.init();
		proxy.initSounds();
		proxy.initRenderers();
	}
	
	// Event as mod initializes. Calls addNames for Items and Blocks, registerRecipies for Items, and initializes GenerationHandler
	@EventHandler()
	public void load(FMLInitializationEvent Event) {
		Items.addNames();
		Blocks.addNames();
		Items.registerRecipes();
		new GenerationHandler();
	}
	
}