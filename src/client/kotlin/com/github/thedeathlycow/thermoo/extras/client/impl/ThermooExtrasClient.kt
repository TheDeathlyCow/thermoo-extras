package com.github.thedeathlycow.thermoo.extras.client.impl

import com.github.thedeathlycow.thermoo.extras.impl.ThermooExtras
import net.fabricmc.api.ClientModInitializer

object ThermooExtrasClient: ClientModInitializer {

    override fun onInitializeClient() {
        ThermooExtras.Logger.info("Initialized thermoo extras client")
    }

}