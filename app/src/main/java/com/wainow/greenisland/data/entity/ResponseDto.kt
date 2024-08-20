package com.wainow.greenisland.data.entity

/**
 * Entity for the server response
 *
 * @property motd the server's promotional message
 * @property success flag indicating success or failure of the response
 * @property historical unclear field
 * @property base the currency of the stocks
 * @property date the date of the stock values
 * @property rates stock rates, Map<Stock_Name, Stock_Value>
 */
data class ResponseDto(
    val motd: MessageDto,
    val success: Boolean,
    val historical: Boolean,
    val base: String,
    val date: String,
    val rates: Map<String, Double>
)