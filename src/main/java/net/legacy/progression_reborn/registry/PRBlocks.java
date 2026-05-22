package net.legacy.progression_reborn.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.legacy.progression_reborn.ProgressionReborn;
import net.legacy.progression_reborn.lib.PRCreativeTabs;
import net.legacy.progression_reborn.sound.PRBlockSounds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.List;

public class PRBlocks {

    public static final Block COPPER_BLOCK = new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3.0F, 6.0F)
                    .sound(SoundType.COPPER)
    );

    public static final Block BLACKSTONE_QUARTZ_ORE = new Block(
            Properties.copy(Blocks.GILDED_BLACKSTONE)
    );
    public static final Block BLACKSTONE_GOLD_ORE = new Block(
            Properties.copy(Blocks.GILDED_BLACKSTONE)
    );
    public static final Block BLACKSTONE_ROSE_ORE = new Block(
            Properties.copy(Blocks.GILDED_BLACKSTONE)
    );

    public static final Block NETHER_ROSE_ORE = new Block(
            Properties.copy(Blocks.NETHER_GOLD_ORE)
    );
    public static final Block RAW_ROSE_BLOCK = new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(5.0F, 6.0F)
    );
    public static final Block ROSE_BLOCK = new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(5.0F, 6.0F)
                    .sound(PRBlockSounds.ROSE_BLOCK)
    );

    public static final Block POLISHED_ROSE = new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(5.0F, 6.0F)
                    .sound(PRBlockSounds.ROSE_BLOCK)
    );
    public static final Block ROSE_LAMP = new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3.0F, 6.0F)
                    .lightLevel(blockStatex -> 15)
                    .sound(PRBlockSounds.ROSE_LAMP)
    );

    public static final Block POLISHED_CUT_ROSE = new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(5.0F, 6.0F)
                    .sound(PRBlockSounds.ROSE_BLOCK)
    );
    public static final StairBlock POLISHED_CUT_ROSE_STAIRS = new StairBlock(POLISHED_CUT_ROSE.defaultBlockState(), Properties.copy(POLISHED_CUT_ROSE)
    );
    public static final SlabBlock POLISHED_CUT_ROSE_SLAB = new SlabBlock(
            Properties.copy(POLISHED_CUT_ROSE)
    );

    public static final DoorBlock ROSE_DOOR = new DoorBlock(Properties.of()
            .mapColor(MapColor.COLOR_MAGENTA)
            .strength(5.0F)
            .noOcclusion()
            .pushReaction(PushReaction.DESTROY)
            .requiresCorrectToolForDrops(), PRBlockSetType.ROSE
    );
    public static final TrapDoorBlock ROSE_TRAPDOOR = new TrapDoorBlock(Properties.of()
            .mapColor(MapColor.COLOR_MAGENTA)
            .strength(5.0F)
            .noOcclusion()
            .isValidSpawn(Blocks::never)
            .requiresCorrectToolForDrops(), PRBlockSetType.ROSE
    );

    public static void register() {

        // Building Blocks

        registerBlockAfter(Blocks.AMETHYST_BLOCK, "copper_block", COPPER_BLOCK, CreativeModeTabs.BUILDING_BLOCKS);

        registerBlockAfter(Blocks.WAXED_OXIDIZED_COPPER, "rose_block", ROSE_BLOCK, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlockAfter(ROSE_BLOCK, "polished_rose", POLISHED_ROSE, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlockAfter(POLISHED_ROSE, "polished_cut_rose", POLISHED_CUT_ROSE, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlockAfter(POLISHED_CUT_ROSE, "polished_cut_rose_stairs", POLISHED_CUT_ROSE_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlockAfter(POLISHED_CUT_ROSE_STAIRS, "polished_cut_rose_slab", POLISHED_CUT_ROSE_SLAB, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlockAfter(POLISHED_CUT_ROSE_SLAB, "rose_door", ROSE_DOOR, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlockAfter(ROSE_DOOR, "rose_trapdoor", ROSE_TRAPDOOR, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlockAfter(ROSE_TRAPDOOR, "rose_lamp", ROSE_LAMP, CreativeModeTabs.BUILDING_BLOCKS);

        // Natural Blocks

        registerBlockAfter(Blocks.NETHER_QUARTZ_ORE, "blackstone_quartz_ore", BLACKSTONE_QUARTZ_ORE, CreativeModeTabs.NATURAL_BLOCKS);
        registerBlockAfter(Blocks.NETHER_GOLD_ORE, "blackstone_gold_ore", BLACKSTONE_GOLD_ORE, CreativeModeTabs.NATURAL_BLOCKS);
        registerBlockAfter(BLACKSTONE_GOLD_ORE, "nether_rose_ore", NETHER_ROSE_ORE, CreativeModeTabs.NATURAL_BLOCKS);
        registerBlockAfter(NETHER_ROSE_ORE, "blackstone_rose_ore", BLACKSTONE_ROSE_ORE, CreativeModeTabs.NATURAL_BLOCKS);

        registerBlockAfter(Blocks.RAW_GOLD_BLOCK, "raw_rose_block", RAW_ROSE_BLOCK, CreativeModeTabs.NATURAL_BLOCKS);

        // Functional Blocks

        registerBlockAfter(Blocks.WAXED_OXIDIZED_COPPER, "rose_lamp", ROSE_LAMP, CreativeModeTabs.FUNCTIONAL_BLOCKS);

    }

    @SafeVarargs
    private static void registerBlockAfter(ItemLike comparedItem, String path, Block block, ResourceKey<CreativeModeTab>... tabs) {
        registerBlockItemAfter(comparedItem, path, block, tabs);
        actualRegisterBlock(path, block);
    }

    @SafeVarargs
    private static void registerBlockItemAfter(ItemLike comparedItem, String path, Block block, ResourceKey<CreativeModeTab>... tabs) {
        actualRegisterBlockItem(path, block);
        if (comparedItem != null) {
            comparedItem.asItem();
            if (block != null) {
                block.asItem();
                for (ResourceKey<CreativeModeTab> tab : tabs) {
                    ItemStack stack = new ItemStack(block);
                    stack.setCount(1);
                    List<ItemStack> list = List.of(stack);
                    ItemGroupEvents.modifyEntriesEvent(tab).register((entries) -> entries.addAfter(comparedItem, list, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
                }
            }
        }
    }

    private static void actualRegisterBlock(String path, Block block) {
        if (BuiltInRegistries.BLOCK.getOptional(ProgressionReborn.id(path)).isEmpty()) {
            Registry.register(BuiltInRegistries.BLOCK, ProgressionReborn.id(path), block);
        }
    }

    private static void actualRegisterBlockItem(String path, Block block) {
        if (BuiltInRegistries.ITEM.getOptional(ProgressionReborn.id(path)).isEmpty()) {
            Registry.register(BuiltInRegistries.ITEM, ProgressionReborn.id(path), new BlockItem(block, new Item.Properties()));
        }
    }
}
