package com.akkay.extraberries.item;

import com.akkay.extraberries.ExtraBerries;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;

public class ModItems {
    // Blackberry item
    public static final Item BLACKBERRY = registerItem("blackberry", new Item(new Item
            .Properties()
            .setId(itemKey("blackberry"))
            .food(addFoodProperties(2, 0.5f))));

    // White grapes item
    public static final Item WHITE_GRAPES = registerItem("white_grapes", new Item(new Item
            .Properties()
            .setId(itemKey("white_grapes"))
            .food(addFoodProperties(3, 0.5f))));

    // A pie? TODO
    public static final Item BLACKBERYY_PIE = registerItem("blackberry_pie", new Item(new Item
            .Properties()
            .setId(itemKey("blackberry_pie"))
            .food(addFoodProperties(5, 0.8f))));

    // Creative Tab Key
    private static final ResourceKey<CreativeModeTab> extraBerriesCreativeTabKey = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(),
            Identifier.fromNamespaceAndPath("extraberries", "extraberries")
    );

    // Creative Tab
    private static final CreativeModeTab extraBerriesCreativeTab = FabricItemGroup.builder()
            .title(Component.literal("Extra Berries").withColor(0x160909))
            .icon(() -> new ItemStack(ModItems.BLACKBERRY))
            .build();

    // Helper methods
    // FoodProperties method
    private static FoodProperties addFoodProperties(int nutrition, float saturationModifier) {
        return new FoodProperties.Builder()
                .nutrition(nutrition)
                .saturationModifier(saturationModifier)
                .build();
    }

    // Set ID method
    private static ResourceKey<Item> itemKey(String name) {
        return ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(ExtraBerries.MOD_ID, name)
        );
    }

    // Item register method
    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(ExtraBerries.MOD_ID, name), item);
    }

    // Public
    public static void registerModItems() {
        ExtraBerries.LOGGER.info("Registering Mod Items for " + ExtraBerries.MOD_ID);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, extraBerriesCreativeTabKey, extraBerriesCreativeTab);

        ItemGroupEvents.modifyEntriesEvent(extraBerriesCreativeTabKey).register(item -> {
            item.accept(BLACKBERRY);
            item.accept(WHITE_GRAPES);
            item.accept(BLACKBERYY_PIE);
        });
    }
}
