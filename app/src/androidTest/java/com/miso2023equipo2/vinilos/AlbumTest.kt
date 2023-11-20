package com.miso2023equipo2.vinilos

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import okhttp3.internal.wait
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
 class AlbumTest {

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
    @Test
    fun CheckAlbumDetail(){
        val collectionistButton =device.wait(Until.findObject(By.text("Coleccionista")),2000)
        collectionistButton.click()
        val albumsTittle = device.wait(Until.findObject(By.text("Álbumes")),2000)
        val album1=device.wait(Until.findObject(By.text("Con arena nueva")),2000)
        album1.click()
        val detailTitle=device.wait(Until.findObject(By.text("Detalle Álbum")),2000)
        val scrollView =device.findObject(By.clazz("android.widget.ScrollView"))
        //Se espera recibir 9 elementos del detalle contando la portada del album
        assertEquals(9,scrollView.childCount)

    }

    /**
     * Run after each method with @Test annotation
     */
    @After
    fun after() {
        Log.d(ContentValues.TAG, "After")
    }

}