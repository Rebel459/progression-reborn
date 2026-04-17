package net.rebel459.progression_reborn.registry;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.rebel459.progression_reborn.ProgressionReborn;
import net.rebel459.progression_reborn.sound.PRBlockSounds;
import net.rebel459.unified.platform.UnifiedRegistries;
import net.rebel459.unified.util.SuppliedBlock;

public class PRBlocks {

    public static UnifiedRegistries.Blocks BLOCKS = UnifiedRegistries.Blocks.create(ProgressionReborn.MOD_ID);

    public static final SuppliedBlock COPPER_BLOCK = BLOCKS.register("copper_block",
            properties -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.UNAFFECTED, properties),
            () -> Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3.0F, 6.0F)
                    .sound(SoundType.COPPER)
    );
    public static final SuppliedBlock WAXED_COPPER_BLOCK = BLOCKS.register("waxed_copper_block",
            Block::new,
            () -> Properties.ofFullCopy(COPPER_BLOCK.get())
    );
    public static final SuppliedBlock EXPOSED_COPPER = BLOCKS.register("exposed_copper",
            properties -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.EXPOSED, properties),
            () -> Properties.ofFullCopy(COPPER_BLOCK.get())
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
    );
    public static final SuppliedBlock WAXED_EXPOSED_COPPER = BLOCKS.register("waxed_exposed_copper",
            Block::new,
            () -> Properties.ofFullCopy(EXPOSED_COPPER.get())
    );
    public static final SuppliedBlock WEATHERED_COPPER = BLOCKS.register("weathered_copper",
            properties -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.WEATHERED, properties),
            () -> Properties.ofFullCopy(COPPER_BLOCK.get())
                    .mapColor(MapColor.WARPED_STEM)
    );
    public static final SuppliedBlock WAXED_WEATHERED_COPPER = BLOCKS.register("waxed_weathered_copper",
            Block::new,
            () -> Properties.ofFullCopy(WEATHERED_COPPER.get())
    );
    public static final SuppliedBlock OXIDIZED_COPPER = BLOCKS.register("oxidized_copper",
            properties -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.OXIDIZED, properties),
            () -> Properties.ofFullCopy(COPPER_BLOCK.get())
                    .mapColor(MapColor.WARPED_NYLIUM)
    );
    public static final SuppliedBlock WAXED_OXIDIZED_COPPER = BLOCKS.register("waxed_oxidized_copper",
            Block::new,
            () -> Properties.ofFullCopy(OXIDIZED_COPPER.get())
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
            properties -> new DoorBlock(PRBlockSetTypes.ROSE, properties),
            () -> Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .strength(5.0F)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
    );
    public static final SuppliedBlock ROSE_TRAPDOOR = BLOCKS.register("rose_trapdoor",
            properties -> new TrapDoorBlock(PRBlockSetTypes.ROSE, properties),
            () -> Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .strength(5.0F)
                    .noOcclusion()
                    .isValidSpawn((_, _, _, _) -> false)
                    .requiresCorrectToolForDrops()
    );
    public static final SuppliedBlock ROSE_CHAIN = BLOCKS.register("rose_chain",
            ChainBlock::new,
            () -> Properties.ofFullCopy(Blocks.IRON_CHAIN)
                    .mapColor(MapColor.COLOR_MAGENTA)
    );
    public static final SuppliedBlock ROSE_LANTERN = BLOCKS.register("rose_lantern",
            LanternBlock::new,
            () -> Properties.ofFullCopy(Blocks.LANTERN)
                    .mapColor(MapColor.COLOR_MAGENTA)
    );

    public static final SuppliedBlock GOLD_CHAIN = BLOCKS.register("gold_chain",
            ChainBlock::new,
            () -> Properties.ofFullCopy(Blocks.IRON_CHAIN)
                    .mapColor(MapColor.GOLD)
    );
    public static final SuppliedBlock GOLD_LANTERN = BLOCKS.register("gold_lantern",
            LanternBlock::new,
            () -> Properties.ofFullCopy(Blocks.LANTERN)
                    .mapColor(MapColor.GOLD)
    );

    public static void init() {}
}
