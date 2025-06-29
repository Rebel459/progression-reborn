package net.legacy.progression_reborn.tag;

import net.legacy.progression_reborn.PRConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class PRItemTags {

    public static final TagKey<Item> STONE_PICKAXES = bind("stone_pickaxes");

    @NotNull
    private static TagKey<Item> bind(@NotNull String path) {
        return TagKey.create(Registries.ITEM, PRConstants.id(path));
    }

}