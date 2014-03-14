package oresanditems.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import oresanditems.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class JadeiteGem extends Item {

	// Constructor for JadeiteGem, passes the id, sets the CreativeTab to Materials, and sets the unlocalized name
	public JadeiteGem(int par1) {
		super(par1);
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName(ItemInfo.JADEITEGEM_UNLOCALIZED_NAME);
	}	

	// Registers the JadeiteGem Icon for the Client by giving file location where texture can be found
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ModInfo.ID+ ":" + ItemInfo.JADEITEGEM_ICON);
	}

}