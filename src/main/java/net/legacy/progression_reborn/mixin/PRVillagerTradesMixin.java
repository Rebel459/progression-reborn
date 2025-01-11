package net.legacy.progression_reborn.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.legacy.progression_reborn.PRGearItems;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = VillagerTrades.class, priority = 1001)
public class PRVillagerTradesMixin {

    @WrapOperation
            (
                    method = "<clinit>",
                    at = @At
                            (
                                    value = "NEW",
                                    target = "(Lnet/minecraft/world/item/ItemStack;IIII)Lnet/minecraft/world/entity/npc/VillagerTrades$ItemsForEmeralds;"
                            )
            )
    private static VillagerTrades.ItemsForEmeralds modifyVillagerTrades(ItemStack itemStack, int emeraldCost, int numberOfItems, int maxUses, int villagerXp, Operation<VillagerTrades.ItemsForEmeralds> original){
        if (itemStack == new ItemStack(Items.IRON_BOOTS))
            return original.call(new ItemStack(PRGearItems.COPPER_BOOTS), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack == new ItemStack(Items.IRON_CHESTPLATE))
            return original.call(new ItemStack(PRGearItems.COPPER_CHESTPLATE), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack == new ItemStack(Items.IRON_LEGGINGS))
            return original.call(new ItemStack(PRGearItems.COPPER_LEGGINGS), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack == new ItemStack(Items.IRON_HELMET))
            return original.call(new ItemStack(PRGearItems.COPPER_HELMET), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack == new ItemStack(Items.IRON_HOE))
            return original.call(new ItemStack(PRGearItems.COPPER_HOE), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack == new ItemStack(Items.IRON_SWORD))
            return original.call(new ItemStack(PRGearItems.COPPER_SWORD), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack == new ItemStack(Items.IRON_PICKAXE))
            return original.call(new ItemStack(PRGearItems.COPPER_PICKAXE), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack == new ItemStack(Items.IRON_AXE))
            return original.call(new ItemStack(PRGearItems.COPPER_AXE), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack == new ItemStack(Items.IRON_SHOVEL))
            return original.call(new ItemStack(PRGearItems.COPPER_SHOVEL), emeraldCost, numberOfItems, maxUses, villagerXp);

        else if (itemStack == new ItemStack(Items.DIAMOND_SWORD)){
            if (emeraldCost < 30)
                return original.call(itemStack, emeraldCost*2, numberOfItems, maxUses, villagerXp);
            else if (emeraldCost < 36)
                return original.call(itemStack, emeraldCost+8, numberOfItems, maxUses, villagerXp);
            else
                return original.call(itemStack, emeraldCost, numberOfItems, maxUses, villagerXp);
        }
        else if (itemStack == new ItemStack(Items.DIAMOND_AXE)){
            if (emeraldCost < 30)
                return original.call(itemStack, emeraldCost*2, numberOfItems, maxUses, villagerXp);
            else if (emeraldCost < 36)
                return original.call(itemStack, emeraldCost+8, numberOfItems, maxUses, villagerXp);
            else
                return original.call(itemStack, emeraldCost, numberOfItems, maxUses, villagerXp);

        }
        else if (itemStack == new ItemStack(Items.DIAMOND_PICKAXE)){
            if (emeraldCost < 30)
                return original.call(itemStack, emeraldCost*2, numberOfItems, maxUses, villagerXp);
            else if (emeraldCost < 36)
                return original.call(itemStack, emeraldCost+8, numberOfItems, maxUses, villagerXp);
            else
                return original.call(itemStack, emeraldCost, numberOfItems, maxUses, villagerXp);
        }
        else if (itemStack == new ItemStack(Items.DIAMOND_SHOVEL)){
            if (emeraldCost < 30)
                return original.call(itemStack, emeraldCost*2, numberOfItems, maxUses, villagerXp);
            else if (emeraldCost < 36)
                return original.call(itemStack, emeraldCost+8, numberOfItems, maxUses, villagerXp);
            else
                return original.call(itemStack, emeraldCost, numberOfItems, maxUses, villagerXp);
        }
        else if (itemStack == new ItemStack(Items.DIAMOND_HOE)){
            if (emeraldCost < 30)
                return original.call(itemStack, emeraldCost*2, numberOfItems, maxUses, villagerXp);
            else if (emeraldCost < 36)
                return original.call(itemStack, emeraldCost+8, numberOfItems, maxUses, villagerXp);
            else
                return original.call(itemStack, emeraldCost, numberOfItems, maxUses, villagerXp);
        }
        else if (itemStack == new ItemStack(Items.DIAMOND_CHESTPLATE)){
            if (emeraldCost < 30)
                return original.call(itemStack, emeraldCost*2, numberOfItems, maxUses, villagerXp);
            else if (emeraldCost < 36)
                return original.call(itemStack, emeraldCost+8, numberOfItems, maxUses, villagerXp);
            else
                return original.call(itemStack, emeraldCost, numberOfItems, maxUses, villagerXp);
        }
        else if (itemStack == new ItemStack(Items.DIAMOND_LEGGINGS)){
            if (emeraldCost < 30)
                return original.call(itemStack, emeraldCost*2, numberOfItems, maxUses, villagerXp);
            else if (emeraldCost < 36)
                return original.call(itemStack, emeraldCost+8, numberOfItems, maxUses, villagerXp);
            else
                return original.call(itemStack, emeraldCost, numberOfItems, maxUses, villagerXp);
        }
        else if (itemStack == new ItemStack(Items.DIAMOND_HELMET)){
            if (emeraldCost < 30)
                return original.call(itemStack, emeraldCost*2, numberOfItems, maxUses, villagerXp);
            else if (emeraldCost < 36)
                return original.call(itemStack, emeraldCost+8, numberOfItems, maxUses, villagerXp);
            else
                return original.call(itemStack, emeraldCost, numberOfItems, maxUses, villagerXp);
        }
        else if (itemStack == new ItemStack(Items.DIAMOND_BOOTS)){
            if (emeraldCost < 30)
                return original.call(itemStack, emeraldCost*2, numberOfItems, maxUses, villagerXp);
            else if (emeraldCost < 36)
                return original.call(itemStack, emeraldCost+8, numberOfItems, maxUses, villagerXp);
            else
                return original.call(itemStack, emeraldCost, numberOfItems, maxUses, villagerXp);
        }

        else {
            return original.call(itemStack, emeraldCost, numberOfItems, maxUses, villagerXp);
        }
    }

}
