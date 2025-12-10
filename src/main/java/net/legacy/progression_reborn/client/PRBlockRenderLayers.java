package net.legacy.progression_reborn.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.legacy.progression_reborn.registry.PRBlocks;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

@Environment(EnvType.CLIENT)
public final class PRBlockRenderLayers {

	public static void init() {

		BlockRenderLayerMap.putBlock(PRBlocks.ROSE_DOOR, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(PRBlocks.ROSE_TRAPDOOR, ChunkSectionLayer.CUTOUT);
	}
}
