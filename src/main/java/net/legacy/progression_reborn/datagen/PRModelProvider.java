package net.legacy.progression_reborn.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.legacy.progression_reborn.ProgressionReborn;
import net.legacy.progression_reborn.registry.PRBlocks;
import net.legacy.progression_reborn.registry.PREquipmentAssets;
import net.legacy.progression_reborn.registry.PRItems;
import net.legacy.progression_reborn.registry.PRTrimMaterials;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
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

        this.registerArmorTrims(generator, Items.TURTLE_HELMET, EquipmentAssets.TURTLE_SCUTE, "helmet", false);
        this.registerArmorTrims(generator, Items.LEATHER_HELMET, EquipmentAssets.LEATHER, "helmet", true);
        this.registerArmorTrims(generator, Items.LEATHER_CHESTPLATE, EquipmentAssets.LEATHER, "chestplate", true);
        this.registerArmorTrims(generator, Items.LEATHER_LEGGINGS, EquipmentAssets.LEATHER, "leggings", true);
        this.registerArmorTrims(generator, Items.COPPER_HELMET, EquipmentAssets.COPPER, "helmet", false);
        this.registerArmorTrims(generator, Items.COPPER_CHESTPLATE, EquipmentAssets.COPPER, "chestplate", false);
        this.registerArmorTrims(generator, Items.COPPER_LEGGINGS, EquipmentAssets.COPPER, "leggings", false);
        this.registerArmorTrims(generator, Items.COPPER_BOOTS, EquipmentAssets.COPPER, "boots", false);
        this.registerArmorTrims(generator, Items.LEATHER_BOOTS, EquipmentAssets.LEATHER, "boots", true);
        this.registerArmorTrims(generator, Items.CHAINMAIL_HELMET, EquipmentAssets.CHAINMAIL, "helmet", false);
        this.registerArmorTrims(generator, Items.CHAINMAIL_CHESTPLATE, EquipmentAssets.CHAINMAIL, "chestplate", false);
        this.registerArmorTrims(generator, Items.CHAINMAIL_LEGGINGS, EquipmentAssets.CHAINMAIL, "leggings", false);
        this.registerArmorTrims(generator, Items.CHAINMAIL_BOOTS, EquipmentAssets.CHAINMAIL, "boots", false);
        this.registerArmorTrims(generator, Items.IRON_HELMET, EquipmentAssets.IRON, "helmet", false);
        this.registerArmorTrims(generator, Items.IRON_CHESTPLATE, EquipmentAssets.IRON, "chestplate", false);
        this.registerArmorTrims(generator, Items.IRON_LEGGINGS, EquipmentAssets.IRON, "leggings", false);
        this.registerArmorTrims(generator, Items.IRON_BOOTS, EquipmentAssets.IRON, "boots", false);
        this.registerArmorTrims(generator, Items.DIAMOND_HELMET, EquipmentAssets.DIAMOND, "helmet", false);
        this.registerArmorTrims(generator, Items.DIAMOND_CHESTPLATE, EquipmentAssets.DIAMOND, "chestplate", false);
        this.registerArmorTrims(generator, Items.DIAMOND_LEGGINGS, EquipmentAssets.DIAMOND, "leggings", false);
        this.registerArmorTrims(generator, Items.DIAMOND_BOOTS, EquipmentAssets.DIAMOND, "boots", false);
        this.registerArmorTrims(generator, Items.GOLDEN_HELMET, EquipmentAssets.GOLD, "helmet", false);
        this.registerArmorTrims(generator, Items.GOLDEN_CHESTPLATE, EquipmentAssets.GOLD, "chestplate", false);
        this.registerArmorTrims(generator, Items.GOLDEN_LEGGINGS, EquipmentAssets.GOLD, "leggings", false);
        this.registerArmorTrims(generator, Items.GOLDEN_BOOTS, EquipmentAssets.GOLD, "boots", false);
        this.registerArmorTrims(generator, Items.NETHERITE_HELMET, EquipmentAssets.NETHERITE, "helmet", false);
        this.registerArmorTrims(generator, Items.NETHERITE_CHESTPLATE, EquipmentAssets.NETHERITE, "chestplate", false);
        this.registerArmorTrims(generator, Items.NETHERITE_LEGGINGS, EquipmentAssets.NETHERITE, "leggings", false);
        this.registerArmorTrims(generator, Items.NETHERITE_BOOTS, EquipmentAssets.NETHERITE, "boots", false);

        this.registerArmorTrims(generator, PRItems.ROSE_HELMET, PREquipmentAssets.ROSE, "helmet", false);
        this.registerArmorTrims(generator, PRItems.ROSE_CHESTPLATE, PREquipmentAssets.ROSE, "chestplate", false);
        this.registerArmorTrims(generator, PRItems.ROSE_LEGGINGS, PREquipmentAssets.ROSE, "leggings", false);
        this.registerArmorTrims(generator, PRItems.ROSE_BOOTS, PREquipmentAssets.ROSE, "boots", false);

	}

    private void uploadArmor2(ItemModelGenerators generator, Identifier id, Identifier layer0, Identifier layer1) {
        ModelTemplates.TWO_LAYERED_ITEM.create(id, TextureMapping.layered(layer0, layer1), generator.modelOutput);
    }

    private void uploadArmor3(ItemModelGenerators generator, Identifier id, Identifier layer0, Identifier layer1, Identifier layer2) {
        ModelTemplates.THREE_LAYERED_ITEM.create(id, TextureMapping.layered(layer0, layer1, layer2), generator.modelOutput);
    }

    private void registerArmorTrims(ItemModelGenerators generator, Item armor, ResourceKey<EquipmentAsset> equipmentKey, String armorType, boolean dyeable) {
        Identifier armorModelId = TextureMapping.getItemTexture(armor);
        Identifier armorTextures = TextureMapping.getItemTexture(armor);
        Identifier armorOverlayTextures = TextureMapping.getItemTexture(armor, "_overlay");
        for (ItemModelGenerators.TrimMaterialData trimMaterial : TRIM_MATERIALS) {
            Identifier trimmedModelId = Identifier.fromNamespaceAndPath(ProgressionReborn.MOD_ID,
                    armorModelId.getPath()).withSuffix("_" + trimMaterial.assets().base().suffix() + "_trim");
            Identifier trimTextureId = Identifier.withDefaultNamespace(
                    "trims/items/" + armorType + "_trim_" + trimMaterial.assets().assetId(equipmentKey).suffix());
            if (dyeable) {
                this.uploadArmor3(generator, trimmedModelId, armorTextures, armorOverlayTextures, trimTextureId);
            } else {
                this.uploadArmor2(generator, trimmedModelId, armorTextures, trimTextureId);
            }
        }
    }
}
