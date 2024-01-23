package com.github.thedeathlycow.thermoo.extras.impl

import com.github.thedeathlycow.thermoo.api.temperature.EnvironmentController
import com.github.thedeathlycow.thermoo.api.temperature.EnvironmentControllerDecorator
import net.minecraft.block.BlockState
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class ModTemperatureController(
    controller: EnvironmentController
): EnvironmentControllerDecorator(controller) {


    override fun getHeatAtLocation(world: World, pos: BlockPos): Int {
        val tWorld: TemperatureWorld = ThermooExtras.worlds.getOrPut(world) { TemperatureWorld(world) }
        return tWorld.getTemperature(pos)
    }

    override fun getHeatFromBlockState(state: BlockState): Int {
        return ThermooExtras.heatStates[state.block] ?: 0
    }
}