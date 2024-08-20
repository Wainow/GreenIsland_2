package com.wainow.greenisland.data.entity

/**
 * Entity for a promotional message from the server
 *
 * @property msg the message
 * @property url the URL
 */
data class MessageDto(
    val msg: String,
    val url: String
)