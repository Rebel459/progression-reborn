package net.legacy.progression_reborn;

import com.mojang.datafixers.util.Pair;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class PRModelProvider extends FabricModelProvider {
	public static final List<Pair<BooleanProperty, Function<ResourceLocation, Variant>>> MULTIFACE_GENERATOR_NO_UV_LOCK = List.of(
		Pair.of(BlockStateProperties.NORTH, model -> Variant.variant().with(VariantProperties.MODEL, model)),
		Pair.of(
			BlockStateProperties.EAST,
			model -> Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
		),
		Pair.of(
			BlockStateProperties.SOUTH,
			model -> Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
		),
		Pair.of(
			BlockStateProperties.WEST,
			model -> Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
		),
		Pair.of(
			BlockStateProperties.UP,
			model -> Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
		),
		Pair.of(
			BlockStateProperties.DOWN,
			resourceLocation -> Variant.variant()
				.with(VariantProperties.MODEL, resourceLocation)
				.with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
		)
	);

	public PRModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(@NotNull BlockModelGenerators generator) {
		generator.createTrivialCube(PRBlocks.PLACEHOLDER_BLOCK);
	}

	@Override
	public void generateItemModels(@NotNull ItemModelGenerators generator) {
		generator.generateTrimmableItem(PRGearItems.COPPER_HELMET, PREquipmentAssets.COPPER, "helmet", false);
		generator.generateTrimmableItem(PRGearItems.COPPER_CHESTPLATE, PREquipmentAssets.COPPER, "chestplate", false);
		generator.generateTrimmableItem(PRGearItems.COPPER_LEGGINGS, PREquipmentAssets.COPPER, "leggings", false);
		generator.generateTrimmableItem(PRGearItems.COPPER_BOOTS, PREquipmentAssets.COPPER, "boots", false);

		generator.generateFlatItem(PRGearItems.PLACEHOLDER_SWORD, ModelTemplates.FLAT_ITEM);
	}

	@Contract("_, _ -> new")
	private static @NotNull ModelTemplate createItem(String string, TextureSlot... textureSlots) {
		return new ModelTemplate(Optional.of(net.legacy.progression_reborn.PRConstants.id("item/" + string)), Optional.empty(), textureSlots);
	}
}
