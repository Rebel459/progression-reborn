package net.legacy.progression_reborn.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.legacy.progression_reborn.registry.PRBlocks;
import net.minecraft.client.renderer.RenderType;

@Environment(EnvType.CLIENT)
public final class PRBlockRenderLayers {

	public static void init() {
		BlockRenderLayerMap renderLayerRegistry = BlockRenderLayerMap.INSTANCE;

		renderLayerRegistry.putBlock(PRBlocks.ROSE_DOOR, RenderType.cutout());
		renderLayerRegistry.putBlock(PRBlocks.ROSE_TRAPDOOR, RenderType.cutout());

	}
}
