package net.legacy.progression_reborn.tag;

import net.legacy.progression_reborn.ProgressionReborn;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class PRItemTags {
    public static final TagKey<Item> ROSE_TOOL_MATERIALS = bind("rose_tool_materials");
    public static final TagKey<Item> REPAIRS_ROSE_ARMOR = bind("repairs_rose_armor");

    public static final TagKey<Item> STONE_PICKAXES = bind("stone_pickaxes");

    @NotNull
    private static TagKey<Item> bind(@NotNull String path) {
        return TagKey.create(Registries.ITEM, ProgressionReborn.id(path));
    }

}