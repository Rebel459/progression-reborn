package net.legacy.progression_reborn;

import net.legacy.progression_reborn_old.ProgressionConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class ProgressionItemTags {
    public static final TagKey<Item> METAL_TOOL_MATERIALS = bind("metal_tool_materials");
    public static final TagKey<Item> ANCIENT_TOOL_MATERIALS = bind("ancient_tool_materials");

    public static final TagKey<Item> REPAIRS_DUNGEON_ARMOR = bind("repairs_dungeon_armor");
    public static final TagKey<Item> REPAIRS_FORTRESS_ARMOR = bind("repairs_fortress_armor");
    public static final TagKey<Item> REPAIRS_WARD_ARMOR = bind("repairs_ward_armor");

    @NotNull
    private static TagKey<Item> bind(@NotNull String path) {
        return TagKey.create(Registries.ITEM, ProgressionConstants.id(path));
    }

}