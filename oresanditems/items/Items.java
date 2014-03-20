package oresanditems.items;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	public static Item MagicWand;
	public static Item JadeiteGem;
	public static Item JadeiteSword;
	public static EnumToolMaterial toolJadeite;
	public static EnumArmorMaterial armorJadeite;
	
	
	// Adds the Jadeite ToolMaterial with name JADIETE, harvest level 3 - only diamond, 2000 uses before it disappears,
	// 15 efficiency, 10 damage, and 35 enchantability (all very high)
	// Initializes the JadeiteGem and JadeiteSword objects 
	public static void init(){
		toolJadeite = EnumHelper.addToolMaterial("JADEITE", 3, 2000, 15.0F, 10.0F, 35);
		JadeiteGem = new JadeiteGem(ItemInfo.jadeitegem_id);
		JadeiteSword = new JadeiteSword(ItemInfo.jadeitesword_id, toolJadeite);
		MagicWand = new ItemMagicWand(ItemInfo.magicwand_id);
	}
	
	// Adds names of JadeiteGem and JadeiteSword to LanguageRegistry
	public static void addNames(){
		LanguageRegistry.addName(JadeiteGem, ItemInfo.JADEITEGEM_NAME);
		LanguageRegistry.addName(JadeiteSword, ItemInfo.JADEITESWORD_NAME);
		LanguageRegistry.addName(MagicWand, ItemInfo.MAGICWAND_NAME);
	}
	
	// Adds recipe for JadeiteSword (with JadeiteGem in both a stack or separate boxes) and Magic Wand to Crafting Table
	public static void registerRecipes() {		
		GameRegistry.addShapelessRecipe(new ItemStack(JadeiteSword, 1), new Object[] {new ItemStack(JadeiteGem), new ItemStack(JadeiteGem), new ItemStack(Item.stick)});
		GameRegistry.addShapelessRecipe(new ItemStack(JadeiteSword, 1), new Object[] {new ItemStack(JadeiteGem, 2), new ItemStack(Item.stick)});
		GameRegistry.addShapelessRecipe(new ItemStack(MagicWand, 1), new Object[] {new ItemStack(JadeiteGem, 4), new ItemStack(Item.diamond, 2)});
	}
	
}