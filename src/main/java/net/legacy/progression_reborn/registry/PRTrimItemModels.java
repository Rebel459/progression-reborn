package net.legacy.progression_reborn.registry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.legacy.progression_reborn.PRConstants;
import net.minecraft.resources.ResourceLocation;
import net.ramixin.mixson.inline.Mixson;

import java.util.List;

public final class PRTrimItemModels {
    private static final List<String> ARMOR_PIECE_TYPES = List.of("helmet", "chestplate", "leggings", "boots");

    private static final List<ResourceLocation> ARMOR_MATERIALS = List.of(
            ResourceLocation.withDefaultNamespace("leather"),
            ResourceLocation.withDefaultNamespace("chainmail"),
            ResourceLocation.withDefaultNamespace("iron"),
            ResourceLocation.withDefaultNamespace("golden"),
            ResourceLocation.withDefaultNamespace("diamond"),
            ResourceLocation.withDefaultNamespace("netherite")
    );


    public static void init() {}

    static {
        ARMOR_PIECE_TYPES.forEach(armorType -> ARMOR_MATERIALS.forEach(material -> registerItemModelModification(armorType, material)));
        registerItemModelModification("helmet", ResourceLocation.withDefaultNamespace("turtle"));

        registerAtlasModification("armor_trims");
        registerAtlasModification("blocks");
    }

    private static void registerItemModelModification(String armorPieceType, ResourceLocation armorMaterial) {
        Mixson.registerEvent(
                1,
                ResourceLocation.fromNamespaceAndPath(armorMaterial.getNamespace(), "items/" + armorMaterial.getPath() + "_" + armorPieceType).toString(),
                PRConstants.id("add_trims_to_" + armorMaterial.getPath() + "_" + armorPieceType).toString(),
                (context) -> {
                    JsonObject rootJson = context.getFile().getAsJsonObject();
                    JsonObject modelJson = rootJson.getAsJsonObject("model");
                    JsonArray casesArray = modelJson.getAsJsonArray("cases");
                    JsonObject baseCase = casesArray.get(0).getAsJsonObject();

                    PRTrimMaterials.TRIM_MATERIALS.forEach(trimMaterial -> {
                        JsonObject newCase = baseCase.deepCopy();

                        newCase.addProperty("when", trimMaterial.location().toString());
                        newCase.getAsJsonObject("model").addProperty("model", PRConstants.id("item/" + armorMaterial.getPath() + "_" + armorPieceType + "_" + trimMaterial.location().getPath() + "_trim").toString());

                        casesArray.add(newCase);
                    });
                }
        );
    }

    private static void registerAtlasModification(String atlasName) {
        Mixson.registerEvent(
                1,
                ResourceLocation.withDefaultNamespace("atlases/" + atlasName).toString(),
                PRConstants.id("add_trims_to_" + atlasName + "_atlas").toString(),
                (context) -> {
                    JsonObject rootJson = context.getFile().getAsJsonObject();
                    JsonArray sourcesArray = rootJson.getAsJsonArray("sources");

                    for (JsonElement sourceElement : sourcesArray) {
                        JsonObject sourceObject = sourceElement.getAsJsonObject();

                        if ("paletted_permutations".equals(sourceObject.get("type").getAsString())) {
                            JsonObject permutationsJson = sourceObject.getAsJsonObject("permutations");

                            PRTrimMaterials.TRIM_MATERIALS.forEach(trimMaterial -> {
                                String trimName = trimMaterial.location().getPath();
                                permutationsJson.addProperty(trimName, PRConstants.id("trims/color_palettes/" + trimName).toString());
                            });

                            break;
                        }
                    }
                }
        );
    }
}
