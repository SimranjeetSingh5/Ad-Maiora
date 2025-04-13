package com.my.admaiora.model

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
     var data : List<User> = emptyList()
)

@Serializable
data class User(
    val userName: String?,
    val userNumber: String?,
)
