package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
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
            () -> new PowerStaff(Tiers.WOOD, 1, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> TELEPORTATION_STAFF = ITEMS.register("teleportation_staff",
            () -> new TeleportationStaff(Tiers.WOOD, 1, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> FIRE_STAFF = ITEMS.register("fire_staff",
            () -> new FireStaff(Tiers.WOOD, 1, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> SPEED_STAFF = ITEMS.register("speed_staff",
            () -> new SpeedStaff(Tiers.WOOD, 1, -2.4F, new Item.Properties()));


    public static final RegistryObject<Item> POWER_BALL = ITEMS.register("power_ball",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TELEPORTATION_ORB = ITEMS.register("teleportation_orb",
            () -> new TeleportationOrb(new Item.Properties()));
    public static final RegistryObject<Item> FIRE_ORB = ITEMS.register("fire_orb",
            () -> new FireOrb(new Item.Properties()));
    public static final RegistryObject<Item> SPEED_ORB = ITEMS.register("speed_orb",
            () -> new SpeedOrb(new Item.Properties()));

    public static final RegistryObject<Item> LIGHTNING_FUR = ITEMS.register("lightning_fur",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIRE_ESSENCE = ITEMS.register("fire_essence",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GUITAR_STRING = ITEMS.register("guitar_string",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}