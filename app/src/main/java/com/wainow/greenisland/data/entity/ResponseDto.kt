package com.wainow.greenisland.data.entity

/**
 * Сущность для ответа сервера
 *
 * @property motd рекламное сообщение сервера
 * @property success флаг успешности/неуспешности ответа
 * @property historical ваще хз в
 * @property base валюта акции
 * @property date дата стоимости
 * @property rates курсы акций, Map<Название_акции, Стоимость_акции>
 */
data class ResponseDto(
    val motd: MessageDto,
    val success: Boolean,
    val historical: Boolean,
    val base: String,
    val date: String,
    val rates: Map<String, Double>
)
