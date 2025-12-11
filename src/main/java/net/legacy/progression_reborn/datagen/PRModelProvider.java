package net.legacy.progression_reborn.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.legacy.progression_reborn.registry.PRBlocks;
import net.legacy.progression_reborn.registry.PREquipmentAssets;
import net.legacy.progression_reborn.registry.PRItems;
import net.legacy.progression_reborn.registry.PRTrimMaterials;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public final class PRModelProvider extends FabricModelProvider {
    public static final MaterialAssetGroup ROSE_INGOT = MaterialAssetGroup.create("rose_ingot", Map.of(PREquipmentAssets.ROSE, "rose_ingot_darker"));
    public static final MaterialAssetGroup ROSE_INGOT_DARKER = MaterialAssetGroup.create("rose_ingot_darker");

    private static final List<ItemModelGenerators.TrimMaterialData> TRIM_MATERIALS = List.of(
            new ItemModelGenerators.TrimMaterialData(ROSE_INGOT, PRTrimMaterials.ROSE),
            new ItemModelGenerators.TrimMaterialData(ROSE_INGOT_DARKER, PRTrimMaterials.ROSE_DARKER)
    );

	public PRModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(@NotNull BlockModelGenerators generator) {
		generator.createTrivialCube(PRBlocks.COPPER_BLOCK);
		generator.createTrivialCube(PRBlocks.BLACKSTONE_QUARTZ_ORE);
		generator.createTrivialCube(PRBlocks.BLACKSTONE_GOLD_ORE);
		generator.createTrivialCube(PRBlocks.BLACKSTONE_ROSE_ORE);
		generator.createTrivialCube(PRBlocks.NETHER_ROSE_ORE);
		generator.createTrivialCube(PRBlocks.RAW_ROSE_BLOCK);
		generator.createTrivialCube(PRBlocks.ROSE_BLOCK);
		generator.createTrivialCube(PRBlocks.POLISHED_ROSE);
		generator.createTrivialCube(PRBlocks.POLISHED_CUT_ROSE);
		generator.createTrivialCube(PRBlocks.ROSE_LAMP);
		generator.createDoor(PRBlocks.ROSE_DOOR);
		generator.createTrapdoor(PRBlocks.ROSE_TRAPDOOR);

	}

	@Override
	public void generateItemModels(@NotNull ItemModelGenerators generator) {
		generator.generateTrimmableItem(PRItems.ROSE_HELMET, PREquipmentAssets.ROSE, Identifier.withDefaultNamespace("trims/items/helmet_trim"), false);
		generator.generateTrimmableItem(PRItems.ROSE_CHESTPLATE, PREquipmentAssets.ROSE, Identifier.withDefaultNamespace("trims/items/chestplate_trim"), false);
		generator.generateTrimmableItem(PRItems.ROSE_LEGGINGS, PREquipmentAssets.ROSE, Identifier.withDefaultNamespace("trims/items/leggings_trim"), false);
		generator.generateTrimmableItem(PRItems.ROSE_BOOTS, PREquipmentAssets.ROSE, Identifier.withDefaultNamespace("trims/items/boots_trim"), false);

		generator.generateFlatItem(PRItems.RAW_COPPER_NUGGET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.RAW_IRON_NUGGET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.RAW_GOLD_NUGGET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.RAW_ROSE_NUGGET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.ROSE_NUGGET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.DIAMOND_SHARD, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.RAW_ROSE, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.ROSE_INGOT, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.IRON_ALLOY, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.ROSE_ALLOY, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(PRItems.IRON_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.ROSE_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);

        generator.generateFlatItem(PRItems.ROSE_HORSE_ARMOR, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(PRItems.ROSE_NAUTILUS_ARMOR, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(PRItems.ROSE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(PRItems.ROSE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(PRItems.ROSE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(PRItems.ROSE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(PRItems.ROSE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        // Rose Spear is done manually

	}
}
