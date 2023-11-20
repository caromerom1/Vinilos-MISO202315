package com.miso2023equipo2.vinilos

import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until

class PageObject(private val device: UiDevice, private val timeout: Long = 20000L) {
    fun login() {
        val collectorButtonQuery = By.text("Coleccionista")
        val collectorButton = device.findObject(collectorButtonQuery)

        collectorButton.click()
        device.wait(Until.gone(collectorButtonQuery), timeout)
        device.wait(Until.findObject(By.text("Álbumes")), timeout)
    }

    fun navigateToArtists() {
        login()

        device.swipe(100, 500, 1000, 500, 10)

        Thread.sleep(1000)

        val artistsButton = device.wait(
            Until.findObject(
                By.text("Artistas")
            ), timeout
        )

        artistsButton.click()
        device.wait(Until.findObject(By.text("Artistas")), timeout)

    }

    fun navigateToCollectors() {
        login()

        device.swipe(100, 500, 1000, 500, 10)

        Thread.sleep(1000)

        val artistsButton = device.wait(
            Until.findObject(
                By.text("Coleccionistas")
            ), timeout
        )

        artistsButton.click()
        device.wait(Until.findObject(By.text("Coleccionistas")), timeout)

    }
}
