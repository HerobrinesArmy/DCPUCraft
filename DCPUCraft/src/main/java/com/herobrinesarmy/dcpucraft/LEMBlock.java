package com.herobrinesarmy.dcpucraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LEMBlock {

	public LEMBlock() {
	}

	public static BlockLEM1802 block;

	public static Object instance;

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {

		GameRegistry.registerBlock(block, "LEM1802");
	}

	public void registerRenderers() {
	}

	public void load() {

		GameRegistry.addRecipe(new ItemStack(block, 1), new Object[] { 
			"AAA",
    		"ABA",
    		"AAA", 'A', Blocks.dirt, 'B', Blocks.sand});
	}

	static {

		block = (BlockLEM1802) (new BlockLEM1802().setHardness(2.0F)
				.setResistance(10.0F).setLightLevel(0.0F).setBlockName("LEM1802")
				.setBlockTextureName("wood_planks_stained_white")
				.setLightOpacity(0).setStepSound(Block.soundTypeStone)
				.setCreativeTab(CreativeTabs.tabBlock));
		block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		Block.blockRegistry.addObject(176, "LEM1802", block);
		block.setHarvestLevel("pickaxe", 0);
	}

	public void generateSurface(World world, Random random, int chunkX,
			int chunkZ) {
	}

	public void generateNether(World world, Random random, int chunkX,
			int chunkZ) {
	}

	static class BlockLEM1802 extends Block {

		int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0;

		IIcon gor = null, dol = null, st1 = null, st2 = null, st3 = null,
				st4 = null;

		boolean red = false;

		protected BlockLEM1802() {
			super(Material.ground);

		}

		public int isProvidingStrongPower(IBlockAccess par1IBlockAccess,
				int par2, int par3, int par4, int par5) {
			return red ? 1 : 0;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public IIcon getIcon(int i, int par2) {
			switch (i) {
			case 0:
				return gor;
			case 1:
				return dol;
			case 2:
				return st1;
			case 3:
				return st2;
			case 4:
				return st4;
			case 5:
				return st3;
			default:
				return gor;
			}
		}

		@SideOnly(Side.CLIENT)
		@Override
		public void registerBlockIcons(IIconRegister reg) {
			this.gor = reg.registerIcon("test");
			this.dol = reg.registerIcon("test");
			this.st1 = reg.registerIcon("test");
			this.st2 = reg.registerIcon("test");
			this.st3 = reg.registerIcon("test");
			this.st4 = reg.registerIcon("test");
		}

		public int getRenderType() {
			return 0;
		}

		public int tickRate() {
			return 1;
		}

		@Override
		public void updateTick(World p_149674_1_, int p_149674_2_,
				int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
			super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_,
					p_149674_5_);
			System.out.println("tick");
		}
		public int quantityDropped(Random par1Random) {
			return 1;
		}
	}
}