package com.example.lifecyclefordatabinding

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert
import org.junit.Test
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
@Config(application = Application::class)
class MainViewModelUnitTest {

    val application = RuntimeEnvironment.application
    val viewModel = MainActivityViewModel(application)

    @Test
    @Throws(Exception::class)
    fun spinnerValueWrongTest() {
        // given
        viewModel.firstName.value = "hello"
        viewModel.selectedDay.value = 0

        // when
        viewModel.onNext()

        // then
        Assert.assertEquals(true, viewModel.visibleSpinner.value)
    }

    @Test
    @Throws(Exception::class)
    fun NameValueWrongTest() {
        // given
        viewModel.firstName.value = ""
        viewModel.selectedDay.value = 0

        // when
        viewModel.onNext()

        // then
        Assert.assertEquals(true, viewModel.visibleFirstName.value)
        Assert.assertEquals(false, viewModel.visibleSpinner.value)
    }
}
