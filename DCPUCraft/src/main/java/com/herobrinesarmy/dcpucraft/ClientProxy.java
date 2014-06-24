package com.herobrinesarmy.dcpucraft;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers(DCPUCraft ins) {
		ins.lemBlock.registerRenderers();
	}
}
