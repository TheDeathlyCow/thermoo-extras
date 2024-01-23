package com.github.thedeathlycow.thermoo.extras.impl

import com.github.thedeathlycow.thermoo.api.temperature.event.EnvironmentControllerInitializeEvent
import kotlinx.coroutines.*
import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.FileWriter

object ThermooExtras: ModInitializer {

    const val ModID: String = "thermoo-extras"

    val Logger: Logger = LoggerFactory.getLogger(ModID)


    override fun onInitialize() {
        EnvironmentControllerInitializeEvent.EVENT
            .register(EnvironmentControllerInitializeEvent.OVERRIDE_PHASE) {
                ModTemperatureController(it)
            }


        runBlocking {
            launch(Dispatchers.IO) {
                FileWriter("test.txt").use {
                    it.append("Test")
                }
            }
        }

        Logger.info("Initialized thermoo extras")
    }

    fun id(path: String): Identifier = Identifier(ModID, path)

}