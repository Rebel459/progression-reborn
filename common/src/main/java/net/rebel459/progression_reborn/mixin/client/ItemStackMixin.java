package net.rebel459.progression_reborn.mixin.client;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.rebel459.progression_reborn.client.StoredItemsTooltip;
import net.rebel459.progression_reborn.registry.PRDataComponents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Mixin(ItemStack.class)
public class ItemStackMixin {

    @Inject(method = "getTooltipImage", at = @At("HEAD"), cancellable = true)
    private void renderStoredItemsTooltip(CallbackInfoReturnable<java.util.Optional<TooltipComponent>> cir) {
        ItemStack stack = ItemStack.class.cast(this);
        Map<Identifier, Integer> stored = stack.getOrDefault(PRDataComponents.STORED_ITEMS.get(), Map.of());
        if (stored.isEmpty()) {
            return;
        }

        List<StoredItemsTooltip.Tooltip.Entry> entries = stored.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 0)
                .map(entry -> {
                    Item item = BuiltInRegistries.ITEM.getValue(entry.getKey());
                    return item == null ? null : new StoredItemsTooltip.Tooltip.Entry(new ItemStack(item), entry.getValue());
                })
                .filter(entry -> entry != null && !entry.stack().isEmpty())
                .sorted(Comparator.comparingInt(StoredItemsTooltip.Tooltip.Entry::count).reversed()
                        .thenComparing(entry -> BuiltInRegistries.ITEM.getKey(entry.stack().getItem()).toString()))
                .toList();

        if (!entries.isEmpty()) {
            cir.setReturnValue(java.util.Optional.of(new StoredItemsTooltip.Tooltip(entries, StoredItemsTooltip.hasKeyDown())));
        }
    }
}
