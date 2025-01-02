package net.legacy.progression_reborn;

import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public final class ProgressionItems {
    private ProgressionItems() {}

    public static final Item ROSE_INGOT = new Item(new Item.Properties().stacksTo(64).fireResistant());
    public static final Item ROSE_NUGGET = new Item(new Item.Properties().stacksTo(64).fireResistant());
    public static final Item RAW_ROSE_NUGGET = new Item(new Item.Properties().stacksTo(64).fireResistant());

    public static final Item RAW_IRON_NUGGET = new Item(new Item.Properties().stacksTo(64));
    public static final Item RAW_GOLD_NUGGET = new Item(new Item.Properties().stacksTo(64));
    public static final Item RAW_COPPER_NUGGET = new Item(new Item.Properties().stacksTo(64));
    public static final Item DIAMOND_NUGGET = new Item(new Item.Properties().stacksTo(64));

    public static final Item IRON_UPGRADE_SMITHING_TEMPLATE = new Item(new Item.Properties().stacksTo(64));
    public static final Item ROSE_UPGRADE_SMITHING_TEMPLATE = new Item(new Item.Properties().stacksTo(64));
    
    public static final Item ENCHANTED_GOLDEN_CARROT = new Item(new Item.Properties().rarity(Rarity.RARE).food(ProgressionFoods.ENCHANTED_GOLDEN_CARROT).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    
    public static final Block ROSE_ORE = new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_GOLD_ORE));

    public static final Item COPPER_HELMET = new ArmorItem(ProgressionArmorMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(27)));
    public static final Item COPPER_CHESTPLATE = new ArmorItem(ProgressionArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(27)));
    public static final Item COPPER_LEGGINGS = new ArmorItem(ProgressionArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(27)));
    public static final Item COPPER_BOOTS = new ArmorItem(ProgressionArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(27)));

    public static final Item ROSE_HELMET = new ArmorItem(ProgressionArmorMaterials.ROSE, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(27)).fireResistant());
    public static final Item ROSE_CHESTPLATE = new ArmorItem(ProgressionArmorMaterials.ROSE, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(27)).fireResistant());
    public static final Item ROSE_LEGGINGS = new ArmorItem(ProgressionArmorMaterials.ROSE, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(27)).fireResistant());
    public static final Item ROSE_BOOTS = new ArmorItem(ProgressionArmorMaterials.ROSE, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(27)).fireResistant());

    public static void register() {
        registerItemAfter(Items.GOLDEN_CARROT, ENCHANTED_GOLDEN_CARROT, "enchanted_golden_carrot", CreativeModeTabs.FOOD_AND_DRINKS);

        registerItemAfter(Items.GOLD_INGOT, ROSE_INGOT, "rose_ingot", CreativeModeTabs.INGREDIENTS);

        registerItemAfter(Items.CHAINMAIL_BOOTS, COPPER_HELMET, "copper_helmet", CreativeModeTabs.COMBAT);
        registerItemAfter(COPPER_HELMET, COPPER_CHESTPLATE, "copper_chestplate", CreativeModeTabs.COMBAT);
        registerItemAfter(COPPER_CHESTPLATE, COPPER_LEGGINGS, "copper_leggings", CreativeModeTabs.COMBAT);
        registerItemAfter(COPPER_LEGGINGS, COPPER_BOOTS, "copper_boots", CreativeModeTabs.COMBAT);

        registerBlockAfter(Blocks.NETHER_GOLD_ORE, "rose_ore", ROSE_ORE, CreativeModeTabs.NATURAL_BLOCKS);
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
        FrozenCreativeTabs.addAfter(comparedItem, block, visibility, tabs);
    }

    private static void actualRegisterBlock(String path, Block block) {
        if (BuiltInRegistries.BLOCK.getOptional(ProgressionConstants.id(path)).isEmpty()) {
            Registry.register(BuiltInRegistries.BLOCK, ProgressionConstants.id(path), block);
        }
    }

    private static void actualRegisterBlockItem(String path, Block block) {
        if (BuiltInRegistries.ITEM.getOptional(ProgressionConstants.id(path)).isEmpty()) {
            Registry.register(BuiltInRegistries.ITEM, ProgressionConstants.id(path), new BlockItem(block, new Item.Properties()));
        }
    }


    @SafeVarargs
    private static void registerItemAfter(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull ResourceKey<CreativeModeTab>... tabs) {
        registerItemAfter(comparedItem, item, path, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
    }

    @SafeVarargs
    private static void registerItemAfter(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull CreativeModeTab.TabVisibility tabVisibility, @NotNull ResourceKey<CreativeModeTab>... tabs) {
        actualRegister(item, path);
        FrozenCreativeTabs.addAfter(comparedItem, item, tabVisibility, tabs);
    }

    private static void actualRegister(@NotNull Item item, @NotNull String path) {
        if (BuiltInRegistries.ITEM.getOptional(ProgressionConstants.id(path)).isEmpty()) {
            Registry.register(BuiltInRegistries.ITEM, ProgressionConstants.id(path), item);
        }
    }
}
