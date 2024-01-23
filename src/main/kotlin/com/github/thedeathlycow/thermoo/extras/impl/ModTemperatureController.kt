package com.github.thedeathlycow.thermoo.extras.impl

import com.github.thedeathlycow.thermoo.api.temperature.EnvironmentController
import com.github.thedeathlycow.thermoo.api.temperature.EnvironmentControllerDecorator
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class ModTemperatureController(
    controller: EnvironmentController
): EnvironmentControllerDecorator(controller) {

    override fun getHeatAtLocation(world: World, pos: BlockPos): Int {
        return super.getHeatAtLocation(world, pos)
    }
}