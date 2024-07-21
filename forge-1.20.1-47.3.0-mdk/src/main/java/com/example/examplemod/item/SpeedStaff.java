package com.example.examplemod.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class SpeedStaff extends SwordItem {
    public SpeedStaff(Tier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {

        // give the player speed
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 5));
        player.addEffect(new MobEffectInstance(MobEffects.JUMP, 1000, 1));

        // return
        ItemStack itemStack = player.getItemInHand(interactionHand);
        itemStack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(interactionHand));
        return InteractionResultHolder.success(itemStack);
    }
}
