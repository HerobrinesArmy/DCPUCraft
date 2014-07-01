package com.herobrinesarmy.dcpucraft;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.herobrinesarmy.dcpucraft.emulation.VirtualMonitor;

import cpw.mods.fml.client.registry.ClientRegistry;
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
      GameRegistry.registerTileEntity(LEMTileEntity.class, "LEMTileEntity");
   }

   public void registerRenderers() {
      ClientRegistry.bindTileEntitySpecialRenderer(LEMTileEntity.class, new LEMTileEntityRenderer());
   }

   public void load() {
      GameRegistry.addRecipe(new ItemStack(block, 1), new Object[] {"AAA", "ABA", "AAA", 'A', Blocks.dirt, 'B', Blocks.sand});
   }

   static {
      block = (BlockLEM1802) (new BlockLEM1802().setHardness(2.0F).setResistance(10.0F).setLightLevel(0.0F).setBlockName("LEM1802").setBlockTextureName("LEM1802").setLightOpacity(0).setStepSound(Block.soundTypeStone).setCreativeTab(CreativeTabs.tabBlock));
      block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      Block.blockRegistry.addObject(601, "LEM1802", block);
      block.setHarvestLevel("pickaxe", 0);
   }

   public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
   }

   public void generateNether(World world, Random random, int chunkX, int chunkZ) {
   }

   static class BlockLEM1802 extends BlockContainer {

      int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0;

      IIcon gor = null, dol = null, st1 = null, st2 = null, st3 = null, st4 = null;

      boolean red = false;

      protected BlockLEM1802() {
         super(Material.ground);
         setTickRandomly(false);
      }

      public int isProvidingStrongPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
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
      
      @Override
      public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
         return false;
      }
      
      @Override
      public boolean isOpaqueCube() {
         return false;
      }

      @Override
      public TileEntity createTileEntity(World world, int metadata) {
         return new LEMTileEntity();
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

      @Override
      public int tickRate(World p_149738_1_) {
         return 1;
      }

      protected BufferedWriter bw;

      @Override
      public void updateTick(World world, int x, int y, int z, Random random) {
         System.out.println("tick");
         if (bw == null) {
            try {
               bw = new BufferedWriter(new FileWriter(new File("D:/fdsa.txt")));
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         try {
            bw.write("tick\r\n");
            bw.flush();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }

      public int quantityDropped(Random par1Random) {
         return 1;
      }

      @Override
      public TileEntity createNewTileEntity(World world, int metadata) {
         return createTileEntity(world, metadata);
      }
   }

   static class LEMTileEntity extends TileEntity {
      public VirtualMonitor lem = new VirtualMonitor();

      public LEMTileEntity() {
         lem.powerOn();
      }

      @Override
      public void writeToNBT(NBTTagCompound par1) {
         super.writeToNBT(par1);
         //       par1.setString("ram", new String(dcpu.ram));
         //       par1.setString("registers", new String(dcpu.registers));
         //       par1.setInteger("ex", dcpu.ex);
         //       par1.setInteger("ia", dcpu.ia);
         //       par1.setInteger("pc", dcpu.pc);
         //       par1.setInteger("sp", dcpu.sp);
         //       par1.setInteger("cycles", dcpu.cycles);
      }

      @Override
      public void readFromNBT(NBTTagCompound par1) {
         super.readFromNBT(par1);
         //       dcpu.ram = par1.getString("ram").toCharArray();
         //       dcpu.registers = par1.getString("registers").toCharArray();
         //       dcpu.ex = (char) par1.getInteger("ex");
         //       dcpu.ia = (char) par1.getInteger("ia");
         //       dcpu.pc = (char) par1.getInteger("pc");
         //       dcpu.sp = (char) par1.getInteger("sp");
         //       lastCycle = dcpu.cycles = (char) par1.getInteger("cycles");
      }

      @Override
      public boolean canUpdate() {
         return true; //TODO Check to see if it's on
      }

      @Override
      public void updateEntity() {
         //TODO
      }
   }
}
