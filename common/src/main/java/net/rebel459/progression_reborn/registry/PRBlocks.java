package net.rebel459.progression_reborn.registry;
import java.util.function.Function;

import net.rebel459.progression_reborn.ProgressionReborn;
import net.rebel459.progression_reborn.sound.PRBlockSounds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.rebel459.unified.platform.UnifiedHelpers;
import net.rebel459.unified.platform.UnifiedRegistries;
import net.rebel459.unified.util.SuppliedBlock;
import org.jetbrains.annotations.NotNull;

public class PRBlocks {

    public static UnifiedRegistries.Blocks BLOCKS = UnifiedRegistries.Blocks.create(ProgressionReborn.MOD_ID);

    public static final SuppliedBlock COPPER_BLOCK = BLOCKS.register("copper_block",
            Block::new,
            () -> Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3.0F, 6.0F)
                    .sound(SoundType.COPPER)
    );

    public static final SuppliedBlock BLACKSTONE_QUARTZ_ORE = BLOCKS.register("blackstone_quartz_ore",
            Block::new,
            () -> Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)
    );
    public static final SuppliedBlock BLACKSTONE_GOLD_ORE = BLOCKS.register("blackstone_gold_ore",
            Block::new,
            () -> Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)
    );
    public static final SuppliedBlock BLACKSTONE_ROSE_ORE = BLOCKS.register("blackstone_rose_ore",
            Block::new,
            () -> Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)
    );

    public static final SuppliedBlock NETHER_ROSE_ORE = BLOCKS.register("nether_rose_ore",
            Block::new,
            () -> Properties.ofFullCopy(Blocks.NETHER_GOLD_ORE)
    );
    public static final SuppliedBlock RAW_ROSE_BLOCK = BLOCKS.register("raw_rose_block",
            Block::new,
            () -> Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(5.0F, 6.0F)
    );
    public static final SuppliedBlock ROSE_BLOCK = BLOCKS.register("rose_block",
            Block::new,
            () -> Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(5.0F, 6.0F)
                    .sound(PRBlockSounds.ROSE_BLOCK)
    );

    public static final SuppliedBlock POLISHED_ROSE = BLOCKS.register("polished_rose",
            Block::new,
            () -> Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(5.0F, 6.0F)
                    .sound(PRBlockSounds.ROSE_BLOCK)
    );
    public static final SuppliedBlock ROSE_LAMP = BLOCKS.register("rose_lamp",
            Block::new,
            () -> Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3.0F, 6.0F)
                    .lightLevel(blockStatex -> 15)
                    .sound(PRBlockSounds.ROSE_LAMP)
    );

    public static final SuppliedBlock POLISHED_CUT_ROSE = BLOCKS.register("polished_cut_rose",
            Block::new,
            () -> Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(5.0F, 6.0F)
                    .sound(PRBlockSounds.ROSE_BLOCK)
    );
    public static final SuppliedBlock POLISHED_CUT_ROSE_STAIRS = BLOCKS.register("polished_cut_rose_stairs",
            properties -> new StairBlock(POLISHED_CUT_ROSE.defaultBlockState(), properties),
            () -> Properties.ofFullCopy(POLISHED_CUT_ROSE.get())
    );
    public static final SuppliedBlock POLISHED_CUT_ROSE_SLAB = BLOCKS.register("polished_cut_rose_slab",
            SlabBlock::new,
            () -> Properties.ofFullCopy(POLISHED_CUT_ROSE.get())
    );

    public static final SuppliedBlock ROSE_DOOR = BLOCKS.register("rose_door",
            properties -> new DoorBlock(PRBlockSetType.ROSE, properties),
            () -> Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .strength(5.0F)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
    );
    public static final SuppliedBlock ROSE_TRAPDOOR = BLOCKS.register("rose_trapdoor",
            properties -> new TrapDoorBlock(PRBlockSetType.ROSE, properties),
            () -> Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .strength(5.0F)
                    .noOcclusion()
                    .isValidSpawn((_, _, _, _) -> false)
                    .requiresCorrectToolForDrops()
    );

    public static void init() {}
}
