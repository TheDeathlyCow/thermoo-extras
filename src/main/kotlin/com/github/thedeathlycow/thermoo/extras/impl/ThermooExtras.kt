package com.github.thedeathlycow.thermoo.extras.impl

import com.github.thedeathlycow.thermoo.api.temperature.event.EnvironmentControllerInitializeEvent
import net.fabricmc.api.ModInitializer
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object ThermooExtras : ModInitializer {

    const val ModID: String = "thermoo-extras"

    val Logger: Logger = LoggerFactory.getLogger(ModID)

    val worlds: MutableMap<World, TemperatureWorld> = mutableMapOf()

    val heatStates: Map<Block, Int> = mapOf(
        Blocks.TORCH to 7,
        Blocks.LAVA to 15
    )

    fun onBlockChanged(serverWorld: ServerWorld, pos: BlockPos, newState: BlockState) {
        val temperatureWorld: TemperatureWorld = worlds.getOrPut(serverWorld) {
            TemperatureWorld(serverWorld)
        }
        temperatureWorld.onBlockChanged(pos, newState)
    }

    override fun onInitialize() {
        EnvironmentControllerInitializeEvent.EVENT
            .register(EnvironmentControllerInitializeEvent.OVERRIDE_PHASE) {
                ModTemperatureController(it)
            }


        Logger.info("Initialized thermoo extras")
    }

    fun id(path: String): Identifier = Identifier(ModID, path)

}