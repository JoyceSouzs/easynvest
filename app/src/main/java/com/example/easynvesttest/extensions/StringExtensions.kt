package com.example.easynvesttest.extensions

import com.example.easynvesttest.util.DateTimeFormat
import org.threeten.bp.LocalDate

fun String.filterDouble(): Double {
    val value = replace("R$","").replace(".", "")
        .replace(",", ".")
    return if (value.isEmpty()) 0.0 else value.toDouble()
}

fun String.getDateOrNull(): LocalDate? {
    return try {
        LocalDate.parse(this, DateTimeFormat.DD_MM_YYYY)
    } catch (e: Exception) {
        null
    }
}

