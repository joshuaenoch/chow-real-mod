package com.example.examplemod.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FireStaff extends SwordItem {
    public FireStaff(Tier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {

        // make it so the player doesn't die by the fireball
        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 10, 10));
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 10));

        // position and direction initialization
        double x = player.getX();
        double y = player.getY();
        double z = player.getZ();
        Vec3 look = player.getViewVector(1.0F);

        // initialize and summon fireball
        double speed = 5;
        LargeFireball fireball = new LargeFireball(level, player, look.x, look.y, look.z, 5);
        fireball.setPos(x, y, z);
        fireball.setDeltaMovement(look.x * speed, look.y * speed, look.z * speed);
        level.addFreshEntity(fireball);

        //return
        ItemStack itemStack = player.getItemInHand(interactionHand);
        itemStack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(interactionHand));
        return InteractionResultHolder.success(itemStack);
    }
}
