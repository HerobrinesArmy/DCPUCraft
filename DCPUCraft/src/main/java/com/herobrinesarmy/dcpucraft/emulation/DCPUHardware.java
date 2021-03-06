package com.herobrinesarmy.dcpucraft.emulation;

import java.util.Random;

public abstract class DCPUHardware implements Identifiable {
   public static final int TYPE_LEM = 0x7349F615;
   public static final int TYPE_KEYBOARD = 0x30CF7406;
   public static final int TYPE_CLOCK = 0x12D0B402;
   public static final int MANUFACTORER_NYA_ELEKTRISKA = 0x1C6C8B36;
   public static final int MANUFACTORER_MOJANG = 0x4AB55488;
   public static final int MANUFACTORER_MACKAPAR = 0x1EB37E91;
   private final int type;
   private final int revision;
   private final int manufactorer;
   public DCPU dcpu;

   public DCPUHardware(int type, int revision, int manufactorer) {
      this.type = type;
      this.revision = revision;
      this.manufactorer = manufactorer;
   }

   public DCPUHardware connectTo(DCPU dcpu) {
      this.dcpu = dcpu;
      dcpu.addHardware(this);
      return this;
   }

   public DCPUHardware disconnect() {
      dcpu.removeHardware(this);
      dcpu = null;
      return this;
   }

   public void query() {
      this.dcpu.registers[0] = (char) (this.type & 0xFFFF);
      this.dcpu.registers[1] = (char) (this.type >> 16 & 0xFFFF);
      this.dcpu.registers[2] = (char) (this.revision & 0xFFFF);
      this.dcpu.registers[3] = (char) (this.manufactorer & 0xFFFF);
      this.dcpu.registers[4] = (char) (this.manufactorer >> 16 & 0xFFFF);
   }

   public void interrupt() {
   }

   public void tick60hz() {
   }

   public void powerOff() {
   }

   public void powerOn() {
   }

   public static void main(String[] args) throws Exception {
      System.out.println("0x" + Integer.toHexString(new Random().nextInt()));
      System.out.println("0x" + Integer.toHexString(new Random().nextInt()));
      System.out.println("0x" + Integer.toHexString(new Random().nextInt()));
      System.out.println("0x" + Integer.toHexString(new Random().nextInt()));
      System.out.println("0x" + Integer.toHexString(new Random().nextInt()));
      System.out.println("0x" + Integer.toHexString(new Random().nextInt()));
   }

   public boolean isConnected() {
      return dcpu != null;
   }

   public void onDestroy() {
   }
}
