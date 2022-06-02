package com.wainow.greenisland.data.entity

/**
 * Сущность для рекламного сообщения с сервера
 *
 * @property msg сообщение
 * @property url юрл
 */
data class MessageDto(
    val msg: String,
    val url: String
)
