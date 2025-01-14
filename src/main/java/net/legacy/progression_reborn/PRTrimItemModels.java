package net.legacy.progression_reborn;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.ramixin.mixson.Mixson;
import net.ramixin.mixson.events.ModificationEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class PRTrimItemModels {
    private static final List<String> ARMORS = List.of("helmet", "chestplate", "leggings", "boots");
    private static final List<String> ARMOR_MATERIALS = List.of("leather", "chainmail", "iron", "golden", "diamond", "netherite");
    private static final List<String> ARMOR_MATERIALS_ROSE = List.of("rose");

    @SuppressWarnings("UnnecessaryReturnStatement")
    private PRTrimItemModels() {
        return;
    }

    public static void init() {
        /*
         * Add trim materials to each armor.
         */
        ARMORS.forEach(armor -> ARMOR_MATERIALS.forEach(armorMaterial -> registerAddTrimsToArmor(armor, armorMaterial)));
        ARMORS.forEach(armor -> ARMOR_MATERIALS_ROSE.forEach(armorMaterial -> registerAddTrimsToArmorRose(armor, armorMaterial)));

        // (dare to be different)
        registerAddTrimsToArmor("helmet", "turtle");

        /*
         * Add trim materials to vanilla atlases.
         */
        registerAddTrimsToAtlas("armor_trims");
        registerAddTrimsToAtlas("blocks");
    }

    private static void registerAddTrimsToArmor(String armor, String armorMaterial) {
        Mixson.registerModificationEvent(
                ResourceLocation.withDefaultNamespace("items/" + armorMaterial + "_" + armor),
                ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "add_trims_to_" + armorMaterial + "_" + armor),
                new ModificationEvent() {
                    @Override
                    public @NotNull JsonElement run(JsonElement elem) {
                        JsonObject root = elem.getAsJsonObject();
                        JsonObject model = root.getAsJsonObject("model");
                        JsonArray cases = model.getAsJsonArray("cases");
                        JsonObject case0 = cases.get(0).getAsJsonObject();

                        PRTrimMaterials.TRIM_MATERIALS.forEach(trim -> {
                            JsonObject newCase = case0.deepCopy();

                            newCase.addProperty("when", trimMaterialId(trim).toString());
                            newCase.getAsJsonObject("model")
                                    .addProperty("model", itemModelId(armor, armorMaterial, trim).toString());

                            cases.add(newCase);
                        });

                        return elem;
                    }

                    @Override
                    public int ordinal() {
                        return 0;
                    }
                }
        );
    }

    private static void registerAddTrimsToArmorRose(String armor, String armorMaterial) {
        Mixson.registerModificationEvent(
                ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "items/" + armorMaterial + "_" + armor),
                ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "add_trims_to_" + armorMaterial + "_" + armor),
                new ModificationEvent() {
                    @Override
                    public @NotNull JsonElement run(JsonElement elem) {
                        JsonObject root = elem.getAsJsonObject();
                        JsonObject model = root.getAsJsonObject("model");
                        JsonArray cases = model.getAsJsonArray("cases");
                        JsonObject case0 = cases.get(0).getAsJsonObject();

                        PRTrimMaterials.TRIM_MATERIALS.forEach(trim -> {
                            JsonObject newCase = case0.deepCopy();

                            newCase.addProperty("when", trimMaterialId(trim).toString());
                            newCase.getAsJsonObject("model")
                                    .addProperty("model", itemModelId(armor, armorMaterial, trim).toString());

                            cases.add(newCase);
                        });

                        return elem;
                    }

                    @Override
                    public int ordinal() {
                        return 0;
                    }
                }
        );
    }

    private static void registerAddTrimsToAtlas(String name) {
        Mixson.registerModificationEvent(
                ResourceLocation.withDefaultNamespace("atlases/" + name),
                ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "add_trims_to_" + name + "_atlas"),
                new ModificationEvent() {
                    @Override
                    public @NotNull JsonElement run(JsonElement elem) {
                        JsonObject root = elem.getAsJsonObject();
                        JsonArray sources = root.getAsJsonArray("sources");

                        for (int i = 0; i < sources.size(); ++i) {
                            JsonObject source = sources.get(i).getAsJsonObject();

                            if ("paletted_permutations".equals(source.getAsJsonPrimitive("type").getAsString())) {
                                JsonObject permutations = source.getAsJsonObject("permutations");

                                PRTrimMaterials.TRIM_MATERIALS.forEach(trim ->
                                        permutations.addProperty(trim, paletteId(trim).toString())
                                );

                                break;
                            }
                        }

                        return elem;
                    }

                    @Override
                    public int ordinal() {
                        return 0;
                    }
                }
        );
    }

    private static ResourceLocation trimMaterialId(String trim) {
        return ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, trim);
    }

    private static ResourceLocation itemModelId(String armor, String armorMaterial, String trim) {
        return ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "item/" + armorMaterial + "_" + armor + "_" + trim + "_trim");
    }

    private static ResourceLocation paletteId(String trim) {
        return ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "trims/color_palettes/" + trim);
    }
}
