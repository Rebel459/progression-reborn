package net.legacy.progression_reborn.registry;
import java.util.function.Function;

import net.legacy.progression_reborn.PRConstants;
import net.legacy.progression_reborn.sound.PRBlockSounds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.NotNull;

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
            Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)
    );
    public static final Block BLACKSTONE_GOLD_ORE = new Block(
            Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)
    );
    public static final Block BLACKSTONE_ROSE_ORE = new Block(
            Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)
    );

    public static final Block NETHER_ROSE_ORE = new Block(
            Properties.ofFullCopy(Blocks.NETHER_GOLD_ORE)
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
    public static final Block POLISHED_CUT_ROSE_STAIRS = new StairBlock(POLISHED_CUT_ROSE.defaultBlockState(), Properties.ofFullCopy(POLISHED_CUT_ROSE)
    );
    public static final Block POLISHED_CUT_ROSE_SLAB = new SlabBlock(
            Properties.ofFullCopy(POLISHED_CUT_ROSE)
    );

    public static final DoorBlock ROSE_DOOR = new DoorBlock(PRBlockSetType.ROSE, Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .strength(5.0F)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
    );
    public static final TrapDoorBlock ROSE_TRAPDOOR = new TrapDoorBlock(PRBlockSetType.ROSE, Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .strength(5.0F)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .requiresCorrectToolForDrops()
    );

    public static void init() {
    }

    @SafeVarargs
    private static void registerBlockAfter(ItemLike comparedItem, String path, Block block, ResourceKey<CreativeModeTab>... tabs) {
        registerBlockItemAfter(comparedItem, path, block, tabs);
        actualRegisterBlock(path, block);
    }

    @SafeVarargs
    private static void registerBlockItemAfter(ItemLike comparedItem, String name, Block block, ResourceKey<CreativeModeTab>... tabs) {
        registerBlockItemAfter(comparedItem, name, block, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
    }

    @SafeVarargs
    private static void registerBlockItemAfter(ItemLike comparedItem, String path, Block block, CreativeModeTab.TabVisibility visibility, ResourceKey<CreativeModeTab>... tabs) {
        actualRegisterBlockItem(path, block);
        PRCreativeTabs.addAfter(comparedItem, block, visibility, tabs);
    }

    private static void actualRegisterBlock(String path, Block block) {
        if (BuiltInRegistries.BLOCK.getOptional(PRConstants.id(path)).isEmpty()) {
            Registry.register(BuiltInRegistries.BLOCK, PRConstants.id(path), block);
        }
    }

    private static void actualRegisterBlockItem(String path, Block block) {
        if (BuiltInRegistries.ITEM.getOptional(PRConstants.id(path)).isEmpty()) {
            Registry.register(BuiltInRegistries.ITEM, PRConstants.id(path), new BlockItem(block, new Item.Properties()));
        }
    }
}
