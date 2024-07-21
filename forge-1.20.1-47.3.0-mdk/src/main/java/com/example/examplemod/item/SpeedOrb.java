package com.example.examplemod.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SpeedOrb extends Item {
    public SpeedOrb(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {

        // give the player speed
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 5));

        player.addEffect(new MobEffectInstance(MobEffects.JUMP, 1000, 1));

        // delete item on use
        ItemStack itemStack = player.getItemInHand(interactionHand);
        itemStack.shrink(1);
        player.setItemInHand(interactionHand, itemStack);


        // return
        if (itemStack.isEmpty() && !player.getAbilities().instabuild) {
            return InteractionResultHolder.success(ItemStack.EMPTY);
        } else {
            return InteractionResultHolder.success(itemStack);
        }
    }
}
