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

public final class ProgressionModelProvider extends FabricModelProvider {
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

	public ProgressionModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(@NotNull BlockModelGenerators generator) {
		generator.createTrivialCube(ProgressionBlocks.CRACKED_END_STONE_BRICKS);
	}

	@Override
	public void generateItemModels(@NotNull ItemModelGenerators generator) {
		generator.generateTrimmableItem(ProgressionGearItems.DUNGEON_HELMET, ProgressionEquipmentAssets.DUNGEON, "helmet", false);
		generator.generateTrimmableItem(ProgressionGearItems.DUNGEON_CHESTPLATE, ProgressionEquipmentAssets.DUNGEON, "chestplate", false);
		generator.generateTrimmableItem(ProgressionGearItems.DUNGEON_LEGGINGS, ProgressionEquipmentAssets.DUNGEON, "leggings", false);
		generator.generateTrimmableItem(ProgressionGearItems.DUNGEON_BOOTS, ProgressionEquipmentAssets.DUNGEON, "boots", false);

		generator.generateTrimmableItem(ProgressionGearItems.FORTRESS_HELMET, ProgressionEquipmentAssets.FORTRESS, "helmet", false);
		generator.generateTrimmableItem(ProgressionGearItems.FORTRESS_CHESTPLATE, ProgressionEquipmentAssets.FORTRESS, "chestplate", false);
		generator.generateTrimmableItem(ProgressionGearItems.FORTRESS_LEGGINGS, ProgressionEquipmentAssets.FORTRESS, "leggings", false);
		generator.generateTrimmableItem(ProgressionGearItems.FORTRESS_BOOTS, ProgressionEquipmentAssets.FORTRESS, "boots", false);

		generator.generateTrimmableItem(ProgressionGearItems.WARD_HELMET, ProgressionEquipmentAssets.WARD, "helmet", false);
		generator.generateTrimmableItem(ProgressionGearItems.WARD_CHESTPLATE, ProgressionEquipmentAssets.WARD, "chestplate", false);
		generator.generateTrimmableItem(ProgressionGearItems.WARD_LEGGINGS, ProgressionEquipmentAssets.WARD, "leggings", false);
		generator.generateTrimmableItem(ProgressionGearItems.WARD_BOOTS, ProgressionEquipmentAssets.WARD, "boots", false);

		generator.generateFlatItem(ProgressionGearItems.ANCIENT_KNIFE, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(ProgressionGearItems.HOOK, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(ProgressionItems.METAL_CHUNK, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(ProgressionItems.DISC_FRAGMENT_FAR_LANDS, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(ProgressionItems.WOODEN_BUCKET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(ProgressionItems.CHARCOAL_BUCKET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(ProgressionItems.COAL_BUCKET, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(ProgressionItems.MUSIC_DISC_SVALL, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(ProgressionItems.MUSIC_DISC_TASWELL, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(ProgressionItems.MUSIC_DISC_TUNDRA, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(ProgressionItems.MUSIC_DISC_FAR_LANDS, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(ProgressionItems.MUSIC_DISC_SHULKER, ModelTemplates.FLAT_ITEM);
	}

	@Contract("_, _ -> new")
	private static @NotNull ModelTemplate createItem(String string, TextureSlot... textureSlots) {
		return new ModelTemplate(Optional.of(ProgressionConstants.id("item/" + string)), Optional.empty(), textureSlots);
	}
}
