package net.rebel459.progression_reborn.mixin.entity;

import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.rebel459.progression_reborn.registry.PRDataComponents;
import net.rebel459.progression_reborn.registry.PREnchantments;
import net.rebel459.progression_reborn.util.CollectionHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin {
    @Shadow
    private int pickupDelay;

    @Inject(method = "playerTouch", at = @At("HEAD"), cancellable = true)
    private void collectItem(Player player, CallbackInfo ci) {
        ItemEntity itemEntity = ItemEntity.class.cast(this);
        if (this.pickupDelay > 0 || player.level().isClientSide()) return;

        ItemStack itemStack = itemEntity.getItem();
        Item item = itemStack.getItem();
        ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
        if (!CollectionHelper.COLLECTION_ITEMS.containsKey(item) || chestplate.isEmpty() || chestplate.getEnchantments().getLevel(player.level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(PREnchantments.COLLECTION)) <= 0) return;
        var itemLookup = player.level().registryAccess().lookupOrThrow(Registries.ITEM);
        Identifier itemId = itemLookup.getKey(item);
        if (!chestplate.has(PRDataComponents.STORED_ITEMS.get())) {
            chestplate.applyComponents(DataComponentPatch.builder()
                    .set(PRDataComponents.STORED_ITEMS.get(), Map.of())
                    .build()
            );
        }
        Map<Identifier, Integer> stored = new HashMap<>(chestplate.getOrDefault(PRDataComponents.STORED_ITEMS.get(), Map.of()));
        int currentStoredCount = stored.getOrDefault(itemId, 0);
        int remainingCapacity = CollectionHelper.getMaxStackSize(item) - currentStoredCount;
        if (remainingCapacity <= 0) {
            return;
        }

        int pickedUpCount = Math.min(itemStack.getCount(), remainingCapacity);
        stored.put(itemId, currentStoredCount + pickedUpCount);

        var remainingStored = new HashMap<>(stored);
        stored.forEach((storedId, count) -> {
            var optional = itemLookup.get(storedId);
            if (optional.isEmpty()) {
                remainingStored.remove(storedId);
                return;
            }

            Item resultItem = CollectionHelper.COLLECTION_ITEMS.get(optional.get().value());
            if (resultItem == null) {
                return;
            }

            while (count >= CollectionHelper.getCountPerConversion(item)) {
                ItemStack resultStack = resultItem.getDefaultInstance();
                if (!player.getInventory().add(resultStack)) {
                    break;
                }
                count -= CollectionHelper.getCountPerConversion(item);
            }

            if (count == 0) {
                remainingStored.remove(storedId);
            } else {
                remainingStored.put(storedId, count);
            }
        });

        chestplate.set(PRDataComponents.STORED_ITEMS.get(), remainingStored);
        player.take(itemEntity, pickedUpCount);
        player.onItemPickup(itemEntity);
        player.awardStat(Stats.ITEM_PICKED_UP.get(item), pickedUpCount);
        itemStack.shrink(pickedUpCount);
        if (itemStack.isEmpty()) {
            itemEntity.discard();
        } else {
            itemEntity.setItem(itemStack);
        }
        ci.cancel();
    }
}
