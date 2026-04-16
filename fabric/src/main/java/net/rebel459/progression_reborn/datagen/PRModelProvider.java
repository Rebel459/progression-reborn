package net.rebel459.progression_reborn.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.rebel459.progression_reborn.registry.PRBlocks;
import net.rebel459.progression_reborn.registry.PRItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import org.jetbrains.annotations.NotNull;

public final class PRModelProvider extends FabricModelProvider {

    public PRModelProvider(FabricPackOutput output) {
        super(output);
    }

	@Override
	public void generateBlockStateModels(@NotNull BlockModelGenerators generator) {
		generator.createTrivialCube(PRBlocks.COPPER_BLOCK.get());
		generator.createTrivialCube(PRBlocks.BLACKSTONE_QUARTZ_ORE.get());
		generator.createTrivialCube(PRBlocks.BLACKSTONE_GOLD_ORE.get());
		generator.createTrivialCube(PRBlocks.BLACKSTONE_ROSE_ORE.get());
		generator.createTrivialCube(PRBlocks.NETHER_ROSE_ORE.get());
		generator.createTrivialCube(PRBlocks.RAW_ROSE_BLOCK.get());
		generator.createTrivialCube(PRBlocks.ROSE_BLOCK.get());
		generator.createTrivialCube(PRBlocks.POLISHED_ROSE.get());
		generator.createTrivialCube(PRBlocks.POLISHED_CUT_ROSE.get());
		generator.createTrivialCube(PRBlocks.ROSE_LAMP.get());
		generator.createDoor(PRBlocks.ROSE_DOOR.get());
		generator.createTrapdoor(PRBlocks.ROSE_TRAPDOOR.get());

	}

	@Override
	public void generateItemModels(@NotNull ItemModelGenerators generator) {
		generator.generateFlatItem(PRItems.ROSE_HELMET.get(), ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.ROSE_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.ROSE_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.ROSE_BOOTS.get(), ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(PRItems.RAW_COPPER_NUGGET.get(), ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.RAW_IRON_NUGGET.get(), ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.RAW_GOLD_NUGGET.get(), ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.RAW_ROSE_NUGGET.get(), ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.ROSE_NUGGET.get(), ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.DIAMOND_SHARD.get(), ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.RAW_ROSE.get(), ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.ROSE_INGOT.get(), ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.IRON_ALLOY.get(), ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.ROSE_ALLOY.get(), ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(PRItems.IRON_UPGRADE_SMITHING_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(PRItems.ROSE_UPGRADE_SMITHING_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);

        generator.generateFlatItem(PRItems.ROSE_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(PRItems.ROSE_NAUTILUS_ARMOR.get(), ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(PRItems.ROSE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(PRItems.ROSE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(PRItems.ROSE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(PRItems.ROSE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(PRItems.ROSE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateSpear(PRItems.ROSE_SPEAR.get());

	}
}
