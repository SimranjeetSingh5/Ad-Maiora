package com.my.admaiora.model

data class CallRequest(
    val phoneNumber: String,
    val timestamp: Long = System.currentTimeMillis() // You can track the time the request was made
)