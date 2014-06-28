package com.herobrinesarmy.dcpucraft;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = DCPUCraft.MODID, version = DCPUCraft.VERSION)
public class DCPUCraft implements IFuelHandler, IWorldGenerator {

	public static final String MODID = "DCPUCraft";
	public static final String VERSION = "0.0";

	@SidedProxy(clientSide = "com.herobrinesarmy.dcpucraft.ClientProxy", serverSide = "com.herobrinesarmy.dcpucraft.CommonProxy")
	public static CommonProxy proxy;

	@Instance(MODID)
	public static DCPUCraft instance;

	LEMBlock lemBlock = new LEMBlock();
	DCPUBlock dcpuBlock = new DCPUBlock();

	@Override
	public int getBurnTime(ItemStack fuel) {
		if (lemBlock.addFuel(fuel) != 0)
		{
			return lemBlock.addFuel(fuel);
		}
		return 0;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		chunkX = chunkX * 16;
		chunkZ = chunkZ * 16;
		if (world.provider.dimensionId == -1)
		{
			lemBlock.generateNether(world, random, chunkX, chunkZ);
		}
		if (world.provider.dimensionId == 0)
		{
			lemBlock.generateSurface(world, random, chunkX, chunkZ);
		}
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		GameRegistry.registerFuelHandler(this); //TODO: I think this needs to go.
		GameRegistry.registerWorldGenerator(this, 1); //TODO: I think this needs to go.
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		lemBlock.load();
		dcpuBlock.load();
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		lemBlock.serverLoad(event);
		dcpuBlock.serverLoad(event);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LEMBlock.instance = instance;
		DCPUBlock.instance = instance;
		lemBlock.preInit(event);
		dcpuBlock.preInit(event);
		proxy.registerRenderers(this);
	}

	public static class GuiHandler implements IGuiHandler {
		@Override
		public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			return null;
		}

		@Override
		public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			return null;
		}
	}
}
