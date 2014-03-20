package oresanditems.items;

import java.util.List;

import oresanditems.ModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMagicWand extends Item {

		//constructor - passes the id to the super class and sets the Creative Tab, Max Stackable Amount, and Unlocalized Name
		public ItemMagicWand(int par1) {
			super(par1);
			setCreativeTab(CreativeTabs.tabCombat);
			setMaxStackSize(2);
			setUnlocalizedName(ItemInfo.MAGICWAND_UNLOCALIZED_NAME);
		}

		//When used on an entity, that entity is flung into the air, resulting in damage when it hits the earth (unless it can fly)
		@Override
		public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase target) {
			if(!target.worldObj.isRemote)
				target.motionY = 2;
			return false;
		}
		
		//Registers the Icon used for the wand
		@Override
		@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister register) {
			itemIcon = register.registerIcon(ModInfo.ID+ ":" + ItemInfo.MAGICWAND_ICON);
		}
		
}