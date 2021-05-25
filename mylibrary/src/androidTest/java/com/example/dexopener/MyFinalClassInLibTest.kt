package com.example.dexopener

import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MyFinalClassInLibTest {
    @Test
    fun name() {
        val final = mockk<MyFinalClassInLib> {
            every { meaningOfLife() } returns 1
        }
        assert(final.meaningOfLife() == 1)
    }
}
