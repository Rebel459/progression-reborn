package net.legacy.progression_reborn.lib;

import java.util.ArrayList;
import java.util.List;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.InstrumentItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.level.ItemLike;

public final class PRCreativeTabs {
    public static void add(ItemLike item, @PRNotNull ResourceKey<CreativeModeTab>... tabs) {
        if (item != null && item.asItem() != null) {
            for(ResourceKey<CreativeModeTab> tab : tabs) {
                ItemGroupEvents.modifyEntriesEvent(tab).register((ItemGroupEvents.ModifyEntries)(entries) -> {
                    ItemStack stack = new ItemStack(item);
                    stack.setCount(1);
                    entries.accept(stack);
                });
            }

        }
    }

    public static void addBefore(ItemLike comparedItem, ItemLike item, ResourceKey<CreativeModeTab>... tabs) {
        addBefore(comparedItem, item, TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
    }

    public static void addBefore(ItemLike comparedItem, ItemLike item, CreativeModeTab.TabVisibility tabVisibility, @PRNotNull ResourceKey<CreativeModeTab>... tabs) {
        if (comparedItem != null && comparedItem.asItem() != null && item != null && item.asItem() != null) {
            for(ResourceKey<CreativeModeTab> tab : tabs) {
                ItemStack stack = new ItemStack(item);
                stack.setCount(1);
                List<ItemStack> list = List.of(stack);
                ItemGroupEvents.modifyEntriesEvent(tab).register((ItemGroupEvents.ModifyEntries)(entries) -> entries.addBefore(comparedItem, list, tabVisibility));
            }

        }
    }

    public static void addBefore(ItemLike comparedItem, ItemLike item, String path, CreativeModeTab.TabVisibility tabVisibility, @PRNotNull ResourceKey<CreativeModeTab>... tabs) {
        if (comparedItem != null && comparedItem.asItem() != null && item != null && item.asItem() != null) {
            for(ResourceKey<CreativeModeTab> tab : tabs) {
                ItemStack stack = new ItemStack(item);
                stack.setCount(1);
                List<ItemStack> list = List.of(stack);
                ItemGroupEvents.modifyEntriesEvent(tab).register((ItemGroupEvents.ModifyEntries)(entries) -> {
                    entries.addBefore(comparedItem, list, tabVisibility);
                });
            }

        }
    }

    public static void addAfter(ItemLike comparedItem, ItemLike item, ResourceKey<CreativeModeTab>... tabs) {
        addAfter(comparedItem, item, TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
    }

    public static void addAfter(ItemLike comparedItem, ItemLike item, CreativeModeTab.TabVisibility tabVisibility, @PRNotNull ResourceKey<CreativeModeTab>... tabs) {
        if (comparedItem != null && comparedItem.asItem() != null && item != null && item.asItem() != null) {
            for(ResourceKey<CreativeModeTab> tab : tabs) {
                ItemStack stack = new ItemStack(item);
                stack.setCount(1);
                List<ItemStack> list = List.of(stack);
                ItemGroupEvents.modifyEntriesEvent(tab).register((ItemGroupEvents.ModifyEntries)(entries) -> entries.addAfter(comparedItem, list, tabVisibility));
            }

        }
    }

    public static void addAfter(ItemLike comparedItem, ItemLike item, String path, CreativeModeTab.TabVisibility tabVisibility, @PRNotNull ResourceKey<CreativeModeTab>... tabs) {
        if (comparedItem != null && comparedItem.asItem() != null && item != null && item.asItem() != null) {
            for(ResourceKey<CreativeModeTab> tab : tabs) {
                ItemStack stack = new ItemStack(item);
                stack.setCount(1);
                List<ItemStack> list = List.of(stack);
                ItemGroupEvents.modifyEntriesEvent(tab).register((ItemGroupEvents.ModifyEntries)(entries) -> {
                    entries.addAfter(comparedItem, list, tabVisibility);
                });
            }

        }
    }

    public static void addInstrument(Item instrument, TagKey<Instrument> tagKey, CreativeModeTab.TabVisibility tabVisibility, @PRNotNull ResourceKey<CreativeModeTab>... tabs) {
        if (instrument != null) {
            for(ResourceKey<CreativeModeTab> tab : tabs) {
                ItemGroupEvents.modifyEntriesEvent(tab).register((ItemGroupEvents.ModifyEntries)(entries) -> {
                    for(Holder<Instrument> holder : BuiltInRegistries.INSTRUMENT.getTagOrEmpty(tagKey)) {
                        ItemStack stack = InstrumentItem.create(instrument, holder);
                        stack.setCount(1);
                        entries.accept(stack, tabVisibility);
                    }

                });
            }

        }
    }

    public static void addInstrumentBefore(ItemLike comparedItem, Item instrument, TagKey<Instrument> tagKey, CreativeModeTab.TabVisibility tabVisibility, @PRNotNull ResourceKey<CreativeModeTab>... tabs) {
        if (comparedItem != null && comparedItem.asItem() != null && instrument != null) {
            for(ResourceKey<CreativeModeTab> tab : tabs) {
                ItemGroupEvents.modifyEntriesEvent(tab).register((ItemGroupEvents.ModifyEntries)(entries) -> {
                    List<ItemStack> list = new ArrayList();

                    for(Holder<Instrument> holder : BuiltInRegistries.INSTRUMENT.getTagOrEmpty(tagKey)) {
                        ItemStack stack = InstrumentItem.create(instrument, holder);
                        stack.setCount(1);
                        list.add(stack);
                    }

                    entries.addBefore(comparedItem, list, tabVisibility);
                });
            }

        }
    }

    public static void addInstrumentAfter(Item comparedItem, Item instrument, TagKey<Instrument> tagKey, CreativeModeTab.TabVisibility tabVisibility, @PRNotNull ResourceKey<CreativeModeTab>... tabs) {
        if (comparedItem != null && comparedItem.asItem() != null && instrument != null) {
            for(ResourceKey<CreativeModeTab> tab : tabs) {
                ItemGroupEvents.modifyEntriesEvent(tab).register((ItemGroupEvents.ModifyEntries)(entries) -> {
                    List<ItemStack> list = new ArrayList();

                    for(Holder<Instrument> holder : BuiltInRegistries.INSTRUMENT.getTagOrEmpty(tagKey)) {
                        ItemStack stack = InstrumentItem.create(instrument, holder);
                        stack.setCount(1);
                        list.add(stack);
                    }

                    entries.addAfter(comparedItem, list, tabVisibility);
                });
            }

        }
    }

    private PRCreativeTabs() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
