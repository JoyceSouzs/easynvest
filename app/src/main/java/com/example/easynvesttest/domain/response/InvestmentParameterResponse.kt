package com.example.easynvesttest.domain.response

import com.example.easynvesttest.presentation.model.InvestmentParameter
import com.example.easynvesttest.util.DateTimeFormat.DATE_TIME_FORMATTER
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.threeten.bp.LocalDateTime


@JsonClass(generateAdapter = true)
class InvestmentParameterResponse(
    @Json(name = "investedAmount") val investedAmount: Double? = null,
    @Json(name = "yearlyInterestRate") val yearlyInterestRate: Double? = null,
    @Json(name = "maturityTotalDays") val maturityTotalDays: Int? = null,
    @Json(name = "maturityBusinessDays") val maturityBusinessDays: Int? = null,
    @Json(name = "maturityDate") val maturityDate: String? = null,
    @Json(name = "rate") val rate: Double? = null,
    @Json(name = "isTaxFree") val isTaxFree: Boolean? = null,
) {
    fun toInvestmentParameter() : InvestmentParameter {
        return InvestmentParameter(
            investedAmount = investedAmount ?: 0.0,
            yearlyInterestRate = yearlyInterestRate ?: 0.0,
            maturityTotalDays = maturityTotalDays ?: 0,
            maturityBusinessDays = maturityBusinessDays ?: 0,
            maturityDate =  LocalDateTime.parse(maturityDate, DATE_TIME_FORMATTER),
            rate = rate ?: 0.0,
            isTaxFree = isTaxFree ?: false
        )
    }
}