package oresanditems.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import oresanditems.ModInfo;
import oresanditems.items.ItemInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockJadeite extends BlockOre {
	
	// Constructor for our BlockJadeite, sends the int par1 (will be block id) to super class
	// Sets the BlockJadeite's CreativeTab as the block tab, sets the Hardness
	public BlockJadeite(int par1) {
		super(par1);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(3.5F);
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName(BlockInfo.BLOCKJADEITE_UNLOCALIZED_NAME);
	}

	// Declaring the top, sidem and bottom icons for BlockJadeite, client side only
	@SideOnly(Side.CLIENT)
	private Icon blockjadeitetopIcon;
	@SideOnly(Side.CLIENT)
	private Icon blockjadeitebottomIcon;
	@SideOnly(Side.CLIENT)
	private Icon blockjadeitesideIcon;
	
	
	// Registering the 3 Icons on the client side. The texture location, ":", and three String values for the 3 icons
	// tell the client where to find the textures for BlockJadeite Icons
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockjadeitetopIcon = register.registerIcon(ModInfo.ID + ":" + BlockInfo.BLOCKJADEITE_TOP);
		blockjadeitebottomIcon = register.registerIcon(ModInfo.ID + ":" + BlockInfo.BLOCKJADEITE_BOTTOM);
		blockjadeitesideIcon = register.registerIcon(ModInfo.ID+ ":" + BlockInfo.BLOCKJADEITE_SIDE);
	}
	
	
	// Int side represents the sides of the block - 0 for bottom, 1 for top, and 2-5 for sides
	// We find side's value and return appropriate Icon
	// Meta holds a value which represent different "states" of a block - will use in future versions!
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		if (side == 0)
			return blockjadeitebottomIcon;
		else if (side == 1)
			return blockjadeitetopIcon;
		else
			return blockjadeitesideIcon;
	}
	
	// Sets the dropped item of BlockJadeite when mined to the JadeiteGem (default # of item dropped for BlockOre is 1)
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return ItemInfo.jadeitegem_id;
	}
	
	//Sets the Exp for mining the BlockJadeite to randomly be from 4 to 9 for every block (slightly higher than diamond's Exp)
	@Override
	public int getExpDrop(World par1World, int par5, int par7) {
		return MathHelper.getRandomIntegerInRange(par1World.rand, 4, 9);
	}

}