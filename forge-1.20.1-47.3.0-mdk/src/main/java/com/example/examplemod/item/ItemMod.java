package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemMod {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<Item> CHINESIUM_DUST = ITEMS.register("chinesium_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWER_STAFF = ITEMS.register("power_staff",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWER_BALL = ITEMS.register("power_ball",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TELEPORTATION_ORB = ITEMS.register("teleportation_orb",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIRE_ORB = ITEMS.register("fire_orb",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIGHTNING_ORB = ITEMS.register("lightning_orb",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIGHTNING_FUR = ITEMS.register("lightning_fur",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}