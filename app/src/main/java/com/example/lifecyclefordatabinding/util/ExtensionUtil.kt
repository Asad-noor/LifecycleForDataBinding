package com.example.lifecyclefordatabinding.util

fun String.isNotTypedYet() = this.equals("null") || this.isEmpty()
