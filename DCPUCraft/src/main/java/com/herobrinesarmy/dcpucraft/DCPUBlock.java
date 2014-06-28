package com.herobrinesarmy.dcpucraft;

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

import com.herobrinesarmy.dcpucraft.emulation.DCPU;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DCPUBlock {

   public DCPUBlock() {
   }

   public static BlockDCPU block;

   public static Object instance;

   public int addFuel(ItemStack fuel) {
      return 0;
   }

   public void serverLoad(FMLServerStartingEvent event) {
   }

   public void preInit(FMLPreInitializationEvent event) {
      GameRegistry.registerBlock(block, "DCPU");
      GameRegistry.registerTileEntity(DCPUTileEntity.class, "DCPUTileEntity");
   }

   public void registerRenderers() {
   }

   public void load() {

      GameRegistry.addRecipe(new ItemStack(block, 1), new Object[] { "AA", "AB", 'A', Blocks.dirt, 'B', Blocks.sand });
   }

   static {

      block = (BlockDCPU) (new BlockDCPU().setHardness(2.0F).setResistance(10.0F).setLightLevel(0.0F).setBlockName("DCPU").setBlockTextureName("DCPU")
            .setLightOpacity(0).setStepSound(Block.soundTypeStone).setCreativeTab(CreativeTabs.tabBlock));
      block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      Block.blockRegistry.addObject(600, "DCPU", block);
      block.setHarvestLevel("pickaxe", 0);
   }

   public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
   }

   public void generateNether(World world, Random random, int chunkX, int chunkZ) {
   }

   static class BlockDCPU extends BlockContainer {

      int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0;

      IIcon gor = null, dol = null, st1 = null, st2 = null, st3 = null, st4 = null;

      boolean red = false;

      protected BlockDCPU() {
         super(Material.ground);
         setTickRandomly(false);
      }

      @Override
      public TileEntity createTileEntity(World world, int metadata) {
         return new DCPUTileEntity();
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

//      protected BufferedWriter bw;

      @Override
      public void updateTick(World world, int x, int y, int z, Random random) {
         System.out.println("tick");
//         if (bw == null) {
//            try {
//               bw = new BufferedWriter(new FileWriter(new File("D:/fdsa.txt")));
//            } catch (IOException e) {
//               e.printStackTrace();
//            }
//         }
//         try {
//            bw.write("tick\r\n");
//            bw.flush();
//         } catch (IOException e) {
//            e.printStackTrace();
//         }
      }

      public int quantityDropped(Random par1Random) {
         return 1;
      }

      @Override
      public TileEntity createNewTileEntity(World world, int metadata) {
         return createTileEntity(world, metadata);
      }
   }

   static class DCPUTileEntity extends TileEntity {
//      protected BufferedWriter bw;
      public DCPU dcpu = new DCPU();
      private long start;
      private int lastCycle;
      
      public DCPUTileEntity() {
         start = System.nanoTime();
      }
      
      @Override
      public void writeToNBT(NBTTagCompound par1)
      {
         super.writeToNBT(par1);
         par1.setString("ram", new String(dcpu.ram));
         par1.setString("registers", new String(dcpu.registers));
         par1.setInteger("ex", dcpu.ex);
         par1.setInteger("ia", dcpu.ia);
         par1.setInteger("pc", dcpu.pc);
         par1.setInteger("sp", dcpu.sp);
         par1.setInteger("cycles", dcpu.cycles);
//         if (bw != null)
//         {
//            try {
//               bw.close();
//            } catch (IOException e) {
//               e.printStackTrace();
//            }
//            bw = null;
//         }
      }

      @Override
      public void readFromNBT(NBTTagCompound par1)
      {
         super.readFromNBT(par1);
         dcpu.ram = par1.getString("ram").toCharArray();
         dcpu.registers = par1.getString("registers").toCharArray();
         dcpu.ex = (char) par1.getInteger("ex");
         dcpu.ia = (char) par1.getInteger("ia");
         dcpu.pc = (char) par1.getInteger("pc");
         dcpu.sp = (char) par1.getInteger("sp");
         lastCycle = dcpu.cycles = (char) par1.getInteger("cycles");
      }
      
      @Override
      public boolean canUpdate() {
         return true; //TODO Check to see if it's on
      }
      
      @Override
      public void updateEntity() {
         long time = System.nanoTime();
         long delta = time - start;
         lastCycle = dcpu.cycles;
         long cyclesToDo = delta / 10000;
         while (dcpu.cycles < lastCycle + cyclesToDo)
//         for (int i = 0; i < 100; i++)
         {
            dcpu.tick();
            if (dcpu.cycles >= 1667)
            {
               dcpu.tickHardware();
               dcpu.cycles -= 1667;
               lastCycle -= 1667;
            }
         }
//         lastCycle += cyclesToDo;
         start = time;//+= delta * 10000;
         System.out.println("Did " + cyclesToDo + " ticks. PC is now at " + ((int)dcpu.pc));
//         if (bw == null) {
//            try {
//               bw = new BufferedWriter(new FileWriter(new File("D:/fdsa4.txt")));
//            } catch (IOException e) {
//               e.printStackTrace();
//            }
//         }
//         try {
//            bw.write("Did " + cyclesToDo + " ticks. PC is now at " + ((int)dcpu.pc) + "\r\n");
//            bw.close();
//            bw = null;
//         } catch (IOException e) {
//            e.printStackTrace();
//         }
      }
   }
}
