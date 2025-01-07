package net.legacy.progression_reborn;
import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import org.jetbrains.annotations.NotNull;

public class PRBlocks {

    public static final Block PLACEHOLDER_BLOCK = register("placeholder_block",
            Block::new,
            Properties.ofFullCopy(Blocks.DIRT)
    );

    public static void init() {
    }

    private static <T extends Block> @NotNull T registerWithoutItem(String path, Function<Properties, T> block, Properties properties) {
        ResourceLocation id = net.legacy.progression_reborn.PRConstants.id(path);
        return doRegister(id, makeBlock(block, properties, id));
    }

    private static <T extends Block> @NotNull T register(String path, Function<Properties, T> block, Properties properties) {
        T registered = registerWithoutItem(path, block, properties);
        Items.registerBlock(registered);
        return registered;
    }

    private static <T extends Block> @NotNull T doRegister(ResourceLocation id, T block) {
        if (BuiltInRegistries.BLOCK.getOptional(id).isEmpty()) {
            return Registry.register(BuiltInRegistries.BLOCK, id, block);
        }
        throw new IllegalArgumentException("Block with id " + id + " is already in the block registry.");
    }

    private static <T extends Block> T makeBlock(@NotNull Function<Properties, T> function, @NotNull Properties properties, ResourceLocation id) {
        return function.apply(properties.setId(ResourceKey.create(Registries.BLOCK, id)));
    }
}
