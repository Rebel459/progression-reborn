package net.legacy.progression_reborn.registry;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.frozenblock.lib.loot.LootTableModifier;
import net.frozenblock.lib.loot.MutableLootTable;
import net.legacy.progression_reborn.PRConstants;
import net.legacy.progression_reborn.config.PRConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import org.jetbrains.annotations.NotNull;

public class PRLootTables {

	public static final ResourceKey<LootTable> DUNGEON_CHEST = registerLegaciesAndLegends("chests/dungeon/chest");

	public static void init() {
		LootTableEvents.MODIFY.register((id, tableBuilder, source, registries) -> {
			LootPool.Builder pool;

			if (PRConfig.get.integrations.legacies_and_legends){
				LootTableModifier.editTable(
						PRLootTables.DUNGEON_CHEST, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.SADDLE),
								(lootPool) -> lootPool.replace(Items.IRON_HORSE_ARMOR, PREquipmentItems.COPPER_HORSE_ARMOR)
						)
				);
				LootTableModifier.editTable(
						PRLootTables.DUNGEON_CHEST, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.SADDLE),
								(lootPool) -> lootPool.replace(Items.GOLDEN_HORSE_ARMOR, Items.IRON_HORSE_ARMOR)
						)
				);
			}
		});
	}

	private static @NotNull ResourceKey<LootTable> register(String path) {
		return ResourceKey.create(Registries.LOOT_TABLE, PRConstants.id(path));
	}

	private static @NotNull ResourceKey<LootTable> registerLegaciesAndLegends(String path) {
		return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("legacies_and_legends", path));
	}
}
