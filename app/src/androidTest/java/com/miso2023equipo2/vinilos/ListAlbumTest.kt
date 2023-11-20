package com.miso2023equipo2.vinilos

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.ui.res.stringResource
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import junit.framework.TestCase.assertEquals
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

private const val BASIC_SAMPLE_PACKAGE = "com.miso2023equipo2.vinilos"
private const val LAUNCH_TIMEOUT = 6000L
private const val STRING_TO_BE_TYPED = "UiAutomator"
@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
 class ListAlbumTest {

    private lateinit var device: UiDevice

    @Before
    fun startMainActivityFromHomeScreen(){
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        // Start from the home screen
        device.pressHome()
        val launcherPackage: String = device.launcherPackageName
        ViewMatchers.assertThat(launcherPackage, CoreMatchers.notNullValue())
        device.wait(
            Until.hasObject(By.pkg(launcherPackage).depth(0)),
            LAUNCH_TIMEOUT
        )
        val context = ApplicationProvider.getApplicationContext<Context>()

        val intent = context.packageManager.getLaunchIntentForPackage(
            BASIC_SAMPLE_PACKAGE
        )?.apply {
            // Clear out any previous instances
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        context.startActivity(intent)
        // Wait for the app to appear
        device.wait(
            Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
            LAUNCH_TIMEOUT
        )
    }

    @Test
    fun CheckAlbumList() {
        val collectionistButton =device.wait(Until.findObject(By.text("Coleccionista")),2000)
        collectionistButton.click()
        val albumsTittle = device.wait(Until.findObject(By.text("Álbumes")),2000)
        val album1=device.findObject(By.text("Con arena nueva"))
        assertEquals("Con arena nueva",album1.text)
    }

    /**
     * Run after each method with @Test annotation
     */
    @After
    fun after() {
        Log.d(ContentValues.TAG, "After")
    }

}