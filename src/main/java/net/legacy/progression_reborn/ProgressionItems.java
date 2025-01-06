package net.legacy.progression_reborn;

import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item.Properties;

import java.util.function.Function;

public final class ProgressionItems {

    // Misc Items
    public static final Item DISC_FRAGMENT_FAR_LANDS = register("disc_fragment_far_lands",
            Item::new,
            new Properties()
                    .stacksTo(64)
    );
    public static final Item METAL_CHUNK = register("metal_chunk",
            Item::new,
            new Properties()
                    .stacksTo(64)
    );
    public static final Item WOODEN_BUCKET = register("wooden_bucket",
            Item::new,
            new Properties()
                    .stacksTo(16)
    );
    public static final Item COAL_BUCKET = register("coal_bucket",
            Item::new,
            new Properties()
                    .stacksTo(16)
    );
    public static final Item CHARCOAL_BUCKET = register("charcoal_bucket",
            Item::new,
            new Properties()
                    .stacksTo(16)
    );

    // Discs
    public static final Item MUSIC_DISC_SVALL = register("music_disc_svall",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(ProgressionJukeboxSongs.SVALL)
    );
    public static final Item MUSIC_DISC_TASWELL = register("music_disc_taswell",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(ProgressionJukeboxSongs.TASWELL)
    );
    public static final Item MUSIC_DISC_SHULKER = register("music_disc_shulker",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(ProgressionJukeboxSongs.SHULKER)
    );
    public static final Item MUSIC_DISC_TUNDRA = register("music_disc_tundra",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(ProgressionJukeboxSongs.TUNDRA)
    );
    public static final Item MUSIC_DISC_FAR_LANDS = register("music_disc_far_lands",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(ProgressionJukeboxSongs.FAR_LANDS)
    );

    // Food
    public static final Item ENCHANTED_BEETROOT = register("enchanted_beetroot",
            Item::new,
            new Properties()
                    .stacksTo(64)
                    .rarity(Rarity.RARE)
                    .food(ProgressionFoods.ENCHANTED_BEETROOT, ProgressionConsumables.ENCHANTED_BEETROOT)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
    );
    public static final Item ENCHANTED_BEETROOT_SOUP = register("enchanted_beetroot_soup",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.EPIC)
                    .food(ProgressionFoods.ENCHANTED_BEETROOT_SOUP, ProgressionConsumables.ENCHANTED_BEETROOT_SOUP)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
                    .usingConvertsTo(Items.BOWL)
    );

    public static void init() {
    }

    private static @NotNull <T extends Item> T register(String name, @NotNull Function<Properties, Item> function, Item.@NotNull Properties properties) {
        return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, ProgressionConstants.id(name)), function, properties);
    }

    public static Function<Properties, Item> createBlockItemWithCustomItemName(Block block) {
        return properties -> new BlockItem(block, properties.useItemDescriptionPrefix());
    }
}
