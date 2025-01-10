package net.legacy.progression_reborn;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;

public class PRVillagerTrades {
    public static void init() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 1,
                factories -> {
                    factories.add((entity, random) -> new MerchantOffer(
                            new ItemCost(Items.COPPER_INGOT, 8),
                            new ItemStack(Items.EMERALD, 1),
                            12, 2, 0.05f));
                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 1,
                factories -> {
                    factories.add((entity, random) -> new MerchantOffer(
                            new ItemCost(Items.COPPER_INGOT, 8),
                            new ItemStack(Items.EMERALD, 1),
                            12, 2, 0.05f));
                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1,
                factories -> {
                    factories.add((entity, random) -> new MerchantOffer(
                            new ItemCost(Items.COPPER_INGOT, 8),
                            new ItemStack(Items.EMERALD, 1),
                            12, 2, 0.05f));
                });

    }
}
