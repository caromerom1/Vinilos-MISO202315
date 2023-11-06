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

        val textView3 = onView(
            allOf(
                withText("Invitado"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.View::class.java))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("Invitado")))

        val textView4 = onView(
            allOf(
                withText(R.string.catalogue_album_title),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.View::class.java))),
                isDisplayed()
            )
        )
        textView4.check(matches(withText(R.string.catalogue_album_title)))

        val textView5 = onView(
            allOf(
                withText("Buscando Am�rica"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.View::class.java))),
                isDisplayed()
            )
        )


        val textView7 = onView(
            allOf(
                withText("Description"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.View::class.java))),
                isDisplayed()
            )
        )
        textView7.check(matches(withText("Description")))

        val textView8 = onView(
            allOf(
                withText("Fecha de lanzamiento"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.View::class.java))),
                isDisplayed()
            )
        )
        textView8.check(matches(withText("Fecha de lanzamiento")))

        val textView9 = onView(
            allOf(
                withText(R.string.detail_album_label_genre),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.View::class.java))),
                isDisplayed()
            )
        )
        textView9.check(matches(withText(R.string.detail_album_label_genre)))
    }
}
