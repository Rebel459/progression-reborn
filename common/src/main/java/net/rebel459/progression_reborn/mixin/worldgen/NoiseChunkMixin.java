package net.rebel459.progression_reborn.mixin.worldgen;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseChunk;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.RandomState;
import net.rebel459.progression_reborn.config.PRConfig;
import net.rebel459.progression_reborn.worldgen.PROreVeinifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(NoiseChunk.class)
public class NoiseChunkMixin {

	@WrapOperation(
		method = "<init>",
		at = @At(
			value = "INVOKE",
			target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
			ordinal = 0
		)
	)
	private boolean addNetherOreVeins(
			List<NoiseChunk.BlockStateFiller> list, Object object, Operation<Boolean> original,
            @Local(argsOnly = true) RandomState randomState,
            @Local(argsOnly = true) NoiseGeneratorSettings noiseGeneratorSettings,
            @Local(name = "wrappedRouter") NoiseRouter wrappedRouter
	) {
		if (PRConfig.get().generation.nether_ore_veins && (noiseGeneratorSettings.defaultBlock().is(Blocks.NETHERRACK) || noiseGeneratorSettings.defaultBlock().is(Blocks.BLACKSTONE))) {
			list.add(
				PROreVeinifier.create(
					wrappedRouter.veinToggle(),
					wrappedRouter.veinRidged(),
					wrappedRouter.veinGap(),
					randomState.oreRandom(),
					wrappedRouter.finalDensity()
				)
			);
		}
		return original.call(list, object);
	}
}