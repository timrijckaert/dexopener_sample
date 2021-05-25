package com.example.dexopener

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MeaningOfLifeFragmentTest {

    @Test
    fun meaningOfLifeShouldBeDisplayed() {
        val userInteraction = mockk<() -> Unit>(relaxed = true)
        val stringToDisplay = "Hello World"

        launchMeaningOfLifeFragment(stringToDisplay, userInteraction)
        onView(withText(stringToDisplay)).check(ViewAssertions.matches(isCompletelyDisplayed()))
        onView(withText("User interaction")).perform(ViewActions.click())
        verify { userInteraction.invoke() }
    }

    private fun launchMeaningOfLifeFragment(
        stringToDisplay: String,
        userInteraction: () -> Unit
    ) {
        launchFragmentInContainer {
            MeaningOfLifeFragment(object : MeaningOfLifeViewModel() {
                override val meaningOfLife: LiveData<String> = liveData { emit(stringToDisplay) }

                override fun onUserInteraction() {
                    userInteraction()
                }
            })
        }
    }
}
