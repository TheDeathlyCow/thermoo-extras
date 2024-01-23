package com.github.thedeathlycow.thermoo.extras.mixin;

import com.github.thedeathlycow.thermoo.extras.impl.ThermooExtras;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {

    @Inject(
            method = "onBlockChanged",
            at = @At("HEAD")
    )
    private void onBlockChange(BlockPos pos, BlockState oldBlock, BlockState newBlock, CallbackInfo ci) {
        ThermooExtras.INSTANCE.onBlockChanged((ServerWorld) (Object) this, pos, newBlock);
    }


}
