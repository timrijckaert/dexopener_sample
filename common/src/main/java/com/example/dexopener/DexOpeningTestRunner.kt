// If you want to share your test runner between multiple modules, make sure the package name is overlapping with the other modules.
// In this case both :lib and :app use the `com.example.dexopener` package name
package com.example.dexopener

import android.app.Application
import android.content.Context
import android.os.Build
import androidx.test.runner.AndroidJUnitRunner
import com.github.tmurakami.dexopener.DexOpener

class DexOpeningTestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        // We only need to enable DexOpener for < 28
        // MockK supports for mocking final classes on Android 9+.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
            DexOpener.install(this)
        }
        return super.newApplication(cl, className, context)
    }
}
