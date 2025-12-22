package com.akkay.extraberries.item;

import com.akkay.extraberries.ExtraBerries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    private static final Item BLACKBERRY = registerItem("blackberry", new Item(new Item.Settings().registryKey(itemKey("blackberry"))));

    private static RegistryKey<Item> itemKey(String name) {
        return RegistryKey.of(
                RegistryKeys.ITEM,
                Identifier.of(ExtraBerries.MOD_ID, name)
        );
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ExtraBerries.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ExtraBerries.LOGGER.info("Registering Mod Items for " + ExtraBerries.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(BLACKBERRY);
        });
    }
}
