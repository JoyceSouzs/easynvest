package com.example.easynvesttest.util

import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.ResolverStyle


object DateTimeFormat {
    val DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")

    val DD_MM_YYYY: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu")
        .withResolverStyle(ResolverStyle.STRICT)

    val YYYY_MM_DD: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
}
