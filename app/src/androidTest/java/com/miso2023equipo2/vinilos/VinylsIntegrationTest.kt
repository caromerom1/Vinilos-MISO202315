package com.miso2023equipo2.vinilos


import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Matchers.allOf
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class VinylsIntegrationTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun vinylsIntegrationTest() {
        val textView = onView(
            allOf(
                withText("Coleccionista"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.View::class.java))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Coleccionista")))

        val textView2 = onView(
            allOf(
                withText("Invitado"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.View::class.java))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Invitado")))

    }
}
