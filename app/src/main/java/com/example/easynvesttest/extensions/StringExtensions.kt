package com.example.easynvesttest.extensions

import com.example.easynvesttest.util.DateTimeFormat
import org.threeten.bp.LocalDate

fun String.filterDigits(): Double {
    return replace("R$","").replace(".", "")
        .replace(",", ".").toDouble()
}

fun String.getDateOrNull(): LocalDate? {
    return try {
        LocalDate.parse(this, DateTimeFormat.DD_MM_YYYY)
    } catch (e: Exception) {
        null
    }
}