package net.legacy.progression_reborn;

import net.legacy.progression_reborn.PRConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class PRItemTags {
    public static final TagKey<Item> COPPER_TOOL_MATERIALS = bind("copper_tool_materials");
    public static final TagKey<Item> ROSE_TOOL_MATERIALS = bind("rose_tool_materials");

    public static final TagKey<Item> REPAIRS_COPPER_ARMOR = bind("repairs_copper_armor");
    public static final TagKey<Item> REPAIRS_ROSE_ARMOR = bind("repairs_rose_armor");

    @NotNull
    private static TagKey<Item> bind(@NotNull String path) {
        return TagKey.create(Registries.ITEM, PRConstants.id(path));
    }

}