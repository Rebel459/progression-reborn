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
        if (itemStack.toString() == "iron_boots")
            return original.call(new ItemStack(PRGearItems.COPPER_BOOTS), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack.toString() == "iron_chestplate")
            return original.call(new ItemStack(PRGearItems.COPPER_CHESTPLATE), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack.toString() == "iron_leggings")
            return original.call(new ItemStack(PRGearItems.COPPER_LEGGINGS), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack.toString() == "iron_helmet")
            return original.call(new ItemStack(PRGearItems.COPPER_HELMET), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack.toString() == "iron_hoe")
            return original.call(new ItemStack(PRGearItems.COPPER_HOE), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack.toString() == "iron_sword")
            return original.call(new ItemStack(PRGearItems.COPPER_SWORD), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack.toString() == "iron_pickaxe")
            return original.call(new ItemStack(PRGearItems.COPPER_PICKAXE), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack.toString() == "iron_axe")
            return original.call(new ItemStack(PRGearItems.COPPER_AXE), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack.toString() == "iron_shovel")
            return original.call(new ItemStack(PRGearItems.COPPER_SHOVEL), emeraldCost, numberOfItems, maxUses, villagerXp);
        else {
            return original.call(itemStack, emeraldCost, numberOfItems, maxUses, villagerXp);
        }
    }

    @Inject
            (
                    method = "<clinit>",
                    at = @At
                            (
                                    value = "NEW",
                                    target = "(Lnet/minecraft/world/item/trading/ItemCost;III)Lnet/minecraft/world/entity/npc/VillagerTrades$EmeraldForItems;"
                            )
            )
    private static void addVillagerTrades(CallbackInfo ci){
        if (itemStack.toString() == "iron_boots")
            return original.call(new ItemStack(PRGearItems.COPPER_BOOTS), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack.toString() == "iron_chestplate")
            return original.call(new ItemStack(PRGearItems.COPPER_CHESTPLATE), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack.toString() == "iron_leggings")
            return original.call(new ItemStack(PRGearItems.COPPER_LEGGINGS), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack.toString() == "iron_helmet")
            return original.call(new ItemStack(PRGearItems.COPPER_HELMET), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack.toString() == "iron_hoe")
            return original.call(new ItemStack(PRGearItems.COPPER_HOE), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack.toString() == "iron_sword")
            return original.call(new ItemStack(PRGearItems.COPPER_SWORD), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack.toString() == "iron_pickaxe")
            return original.call(new ItemStack(PRGearItems.COPPER_PICKAXE), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack.toString() == "iron_axe")
            return original.call(new ItemStack(PRGearItems.COPPER_AXE), emeraldCost, numberOfItems, maxUses, villagerXp);
        else if (itemStack.toString() == "iron_shovel")
            return original.call(new ItemStack(PRGearItems.COPPER_SHOVEL), emeraldCost, numberOfItems, maxUses, villagerXp);
        else {
            return original.call(itemStack, emeraldCost, numberOfItems, maxUses, villagerXp);
        }
    }

}