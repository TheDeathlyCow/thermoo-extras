package com.github.thedeathlycow.thermoo.extras.impl

import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object ThermooExtras: ModInitializer {

    const val ModID: String = "thermoo-extras"

    val Logger: Logger = LoggerFactory.getLogger(ModID)


    override fun onInitialize() {
        Logger.info("Initialized thermoo extras")
    }

    fun id(path: String): Identifier = Identifier(ModID, path)

}