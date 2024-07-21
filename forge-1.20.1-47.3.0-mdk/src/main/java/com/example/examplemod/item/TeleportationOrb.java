package com.example.examplemod.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class TeleportationOrb extends Item {
    public TeleportationOrb(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {

        // get the position of the block the player is looking at
        Vec3 eyePos = player.getEyePosition(1.0f);
        Vec3 lookVec = player.getLookAngle();
        Vec3 targetVec = eyePos.add(lookVec.x * 60, lookVec.y * 60, lookVec.z * 60);
        BlockHitResult location = level.clip(new ClipContext(eyePos, targetVec, ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, player));

        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (location.getType() == BlockHitResult.Type.BLOCK) {

            // teleport the player
            BlockPos blockPos = location.getBlockPos().above();
            player.teleportTo(blockPos.getX() + 0.5, blockPos.getY(), blockPos.getZ() + 0.5); // Teleport to the center of the block

            // use up the item
            itemStack.shrink(1);
            player.setItemInHand(interactionHand, itemStack);

            if (itemStack.isEmpty() && !player.getAbilities().instabuild) {
                return InteractionResultHolder.success(ItemStack.EMPTY);
            }
        }

        // return
        return InteractionResultHolder.success(itemStack);
    }

}
