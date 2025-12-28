package net.legacy.progression_reborn.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.legacy.progression_reborn.registry.PRBlocks;
import net.legacy.progression_reborn.registry.PRItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import org.jetbrains.annotations.NotNull;

public final class PRModelProvider extends FabricModelProvider {

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
		generator.generateFlatItem(PRItems.ROSE_HELMET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.ROSE_CHESTPLATE, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.ROSE_LEGGINGS, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.ROSE_BOOTS, ModelTemplates.FLAT_ITEM);

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
        generator.generateSpear(PRItems.ROSE_SPEAR);

	}
}
