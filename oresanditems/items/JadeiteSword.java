package oresanditems.items;

import oresanditems.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class JadeiteSword extends ItemSword {

	// Constructor for JadeiteSword - passes id and material type to super, sets the CreativeTab to combat,
	// sets MaxStackSize (in inventory) to 1, and sets unlocalized name
	public JadeiteSword(int par1,EnumToolMaterial material) {
		super(par1, material);
		setCreativeTab(CreativeTabs.tabCombat);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.JADEITESWORD_UNLOCALIZED_NAME);
	}
	
	// Registers the Icon for JadeiteSword by giving file where the texture can be found
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ModInfo.ID+ ":" + ItemInfo.JADEITESWORD_ICON);
	}	
	
}