package com.herobrinesarmy.dcpucraft;

public class ClientProxy extends CommonProxy {
   KeyHandler kh;
	@Override
	public void registerRenderers(DCPUCraft ins) {
	   kh = KeyHandler.instance;
		ins.lemBlock.registerRenderers();
		ins.dcpuBlock.registerRenderers();
	}
}
