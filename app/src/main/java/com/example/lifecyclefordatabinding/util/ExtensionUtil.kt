package com.example.lifecyclefordatabinding.util

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun String.isNotTypedYet() = this.equals("null") || this.isEmpty()

inline fun FragmentManager.inTransaction(
    func: FragmentTransaction.() -> Unit,
    isAddToBack: Boolean
) {
    val fragmentTransaction = beginTransaction()
    if (isAddToBack) {
        fragmentTransaction.addToBackStack(null)
    }
    fragmentTransaction.func()
    fragmentTransaction.commit()
}
