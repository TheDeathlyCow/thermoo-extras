package com.github.thedeathlycow.thermoo.extras.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import net.minecraft.block.BlockState
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import java.io.FileWriter

open class TemperatureWorld(
    val world: World
) {

    private val posMap: MutableMap<BlockPos, Int> = mutableMapOf()

    fun setTemperature(pos: BlockPos, temp: Int) {
        posMap[pos] = temp
        runBlocking {
            withContext(Dispatchers.IO) {
                FileWriter("outputs.txt", true).use {
                    ThermooExtras.Logger.info("saving temp")
                    it.appendLine("$pos: $temp")
                }
            }
        }
        ThermooExtras.Logger.info("updating temp")
    }

    fun getTemperature(pos: BlockPos): Int {
        return posMap[pos] ?: 0
    }

    fun onBlockChanged(pos: BlockPos, newState: BlockState) {
        setTemperature(pos, ThermooExtras.heatStates[newState.block] ?: 0)
    }
}