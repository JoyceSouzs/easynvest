package com.example.easynvesttest.extensions

fun String.filterDigits(): Double {
    return replace("R$","").replace(".", "")
        .replace(",", ".").toDouble()
}