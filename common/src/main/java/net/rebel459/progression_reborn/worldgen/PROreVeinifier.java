package net.rebel459.progression_reborn.worldgen;

import net.minecraft.SharedConstants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.NoiseChunk;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;
import net.rebel459.progression_reborn.registry.PRBlocks;

public final class PROreVeinifier {
	private static final float VEININESS_THRESHOLD = 0.4F;
	private static final int EDGE_ROUNDOFF_BEGIN = 20;
	private static final double MAX_EDGE_ROUNDOFF = 0.2D;
	private static final float VEIN_SOLIDNESS = 0.7F;
	private static final float MIN_RICHNESS = 0.1F;
	private static final float MAX_RICHNESS = 0.3F;
	private static final float MAX_RICHNESS_THRESHOLD = 0.6F;
	private static final float CHANCE_OF_RAW_ORE_BLOCK = 0.02F;
	private static final float SKIP_ORE_IF_GAP_NOISE_IS_BELOW = -0.3F;

	private PROreVeinifier() {
	}

	public static NoiseChunk.BlockStateFiller create(DensityFunction toggle, DensityFunction ridged, DensityFunction gap, PositionalRandomFactory randomFactory, DensityFunction finalDensity) {
		final BlockState debugState = SharedConstants.DEBUG_ORE_VEINS ? Blocks.AIR.defaultBlockState() : null;
		return functionContext -> {
			if (finalDensity.compute(functionContext) <= 0D) return null;

			final double veinSelector = toggle.compute(functionContext);
			final int y = functionContext.blockY();
			final VeinType type = veinSelector > 0D ? VeinType.QUARTZ : VeinType.GOLD;
			final double absVeinSelector = Math.abs(veinSelector);

			final int differenceFromMaxY = type.maxY - y;
			final int differenceFromMinY = y - type.minY;
			if (differenceFromMinY < 0 || differenceFromMaxY < 0) return debugState;

			final int smallestYDifference = Math.min(differenceFromMaxY, differenceFromMinY);
			final double roundoff = Mth.clampedMap(smallestYDifference, 0D, EDGE_ROUNDOFF_BEGIN, -MAX_EDGE_ROUNDOFF, 0D);
			if (absVeinSelector + roundoff < VEININESS_THRESHOLD) return debugState;

			final RandomSource random = randomFactory.at(functionContext.blockX(), y, functionContext.blockZ());
			if (random.nextFloat() > VEIN_SOLIDNESS) return debugState;
			if (ridged.compute(functionContext) >= 0D) return debugState;

			final double calculatedGap = Mth.clampedMap(absVeinSelector, VEININESS_THRESHOLD, MAX_RICHNESS_THRESHOLD, MIN_RICHNESS, MAX_RICHNESS);
			if (random.nextFloat() < calculatedGap && gap.compute(functionContext) > SKIP_ORE_IF_GAP_NOISE_IS_BELOW) {
				return random.nextFloat() < CHANCE_OF_RAW_ORE_BLOCK ? type.rawOreBlock : type.ore;
			}

			return SharedConstants.DEBUG_ORE_VEINS ? Blocks.OAK_BUTTON.defaultBlockState() : type.filler;
		};
	}

	public enum VeinType {
		QUARTZ(Blocks.NETHER_QUARTZ_ORE.defaultBlockState(), Blocks.QUARTZ_BLOCK.defaultBlockState(), Blocks.SMOOTH_BASALT.defaultBlockState(), 96, 188),
		GOLD(PRBlocks.BLACKSTONE_GOLD_ORE.defaultBlockState(), Blocks.RAW_GOLD_BLOCK.defaultBlockState(), Blocks.BLACKSTONE.defaultBlockState(), 4, 96);

		final BlockState ore;
		final BlockState rawOreBlock;
		final BlockState filler;
		public final int minY;
		public final int maxY;

		VeinType(final BlockState oreBlock, final BlockState rawOreBlock, final BlockState fillerBlock, final int minY, final int maxY) {
			this.ore = oreBlock;
			this.rawOreBlock = rawOreBlock;
			this.filler = fillerBlock;
			this.minY = minY;
			this.maxY = maxY;
		}
	}
}