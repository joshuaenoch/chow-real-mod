package com.example.examplemod;

import com.example.examplemod.block.BlockMod;
import com.example.examplemod.item.ItemMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TabMod {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MODID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("example_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemMod.CHINESIUM_DUST.get()))
                    .title(Component.translatable("creativetab.example_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ItemMod.CHINESIUM_DUST.get());

                        pOutput.accept(ItemMod.POWER_STAFF.get());
                        pOutput.accept(ItemMod.TELEPORTATION_STAFF.get());
                        pOutput.accept(ItemMod.FIRE_STAFF.get());
                        //pOutput.accept(ItemMod.SPEED_STAFF.get());

                        pOutput.accept(ItemMod.POWER_BALL.get());
                        pOutput.accept(ItemMod.TELEPORTATION_ORB.get());
                        pOutput.accept(ItemMod.FIRE_ORB.get());
                        //pOutput.accept(ItemMod.SPEED_ORB.get());

                        pOutput.accept(ItemMod.LIGHTNING_FUR.get());
                        pOutput.accept(ItemMod.FIRE_ESSENCE.get());
                        pOutput.accept(ItemMod.GUITAR_STRING.get());

                        pOutput.accept(BlockMod.SHIFTED_OAK.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}