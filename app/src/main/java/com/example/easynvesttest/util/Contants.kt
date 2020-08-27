package com.example.easynvesttest.util

import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.ResolverStyle
import java.math.RoundingMode
import java.text.DecimalFormat


object DateTimeFormat {
    val DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")

    val DD_MM_YYYY: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu")
        .withResolverStyle(ResolverStyle.STRICT)

    val YYYY_MM_DD: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
}

object Format {

    val CURRENCY_REAL = (DecimalFormat.getNumberInstance(Locale.PT_BR) as DecimalFormat).apply {
        applyPattern("R$ #,##0.00")
        roundingMode = RoundingMode.HALF_UP
    }

    val NUMBER_PERCENT_PT_BR = (DecimalFormat.getNumberInstance(Locale.PT_BR) as DecimalFormat).apply {
        applyPattern("#,##0'%'")
        roundingMode = RoundingMode.HALF_UP
    }

    val DECIMAL_PERCENT_PT_BR = (DecimalFormat.getNumberInstance(Locale.PT_BR) as DecimalFormat).apply {
        applyPattern("#,##0.00'%'")
        roundingMode = RoundingMode.HALF_UP
    }
}

object Locale {

    val PT_BR = java.util.Locale("pt", "BR")
}
