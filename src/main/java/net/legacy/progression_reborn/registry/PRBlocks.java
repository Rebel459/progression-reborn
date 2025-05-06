package net.legacy.progression_reborn.registry;
import java.util.function.Function;

import net.legacy.progression_reborn.sound.PRBlockSounds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.NotNull;

public class PRBlocks {

    public static final Block COPPER_BLOCK = register("copper_block",
            Block::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3.0F, 6.0F)
                    .sound(SoundType.COPPER)
    );

    public static final Block BLACKSTONE_QUARTZ_ORE = register("blackstone_quartz_ore",
            Block::new,
            Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)
    );
    public static final Block BLACKSTONE_GOLD_ORE = register("blackstone_gold_ore",
            Block::new,
            Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)
    );
    public static final Block BLACKSTONE_ROSE_ORE = register("blackstone_rose_ore",
            Block::new,
            Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)
    );

    public static final Block NETHER_ROSE_ORE = register("nether_rose_ore",
            Block::new,
            Properties.ofFullCopy(Blocks.NETHER_GOLD_ORE)
    );
    public static final Block RAW_ROSE_BLOCK = register("raw_rose_block",
            Block::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(5.0F, 6.0F)
    );
    public static final Block ROSE_BLOCK = register("rose_block",
            Block::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(5.0F, 6.0F)
                    .sound(PRBlockSounds.ROSE_BLOCK)
    );

    public static final Block POLISHED_ROSE = register("polished_rose",
            Block::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(5.0F, 6.0F)
                    .sound(PRBlockSounds.ROSE_BLOCK)
    );
    public static final Block ROSE_LAMP = register("rose_lamp",
            Block::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3.0F, 6.0F)
                    .lightLevel(blockStatex -> 15)
                    .sound(PRBlockSounds.ROSE_LAMP)
    );

    public static final Block POLISHED_CUT_ROSE = register("polished_cut_rose",
            Block::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(5.0F, 6.0F)
                    .sound(PRBlockSounds.ROSE_BLOCK)
    );
    public static final Block POLISHED_CUT_ROSE_STAIRS = register("polished_cut_rose_stairs",
            properties -> new StairBlock(POLISHED_CUT_ROSE.defaultBlockState(), properties),
            Properties.ofFullCopy(POLISHED_CUT_ROSE)
    );
    public static final Block POLISHED_CUT_ROSE_SLAB = register("polished_cut_rose_slab",
            SlabBlock::new,
            Properties.ofFullCopy(POLISHED_CUT_ROSE)
    );

    public static final DoorBlock ROSE_DOOR = register("rose_door",
            properties -> new DoorBlock(PRBlockSetType.ROSE, properties),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .strength(5.0F)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
    );
    public static final TrapDoorBlock ROSE_TRAPDOOR = register("rose_trapdoor",
            properties -> new TrapDoorBlock(PRBlockSetType.ROSE, properties),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .strength(5.0F)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .requiresCorrectToolForDrops()
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
