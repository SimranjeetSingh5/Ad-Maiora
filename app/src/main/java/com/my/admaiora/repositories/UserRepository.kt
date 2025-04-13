package com.my.admaiora.repositories
import com.my.admaiora.Constants
import com.my.admaiora.network.NetworkClient
import com.my.admaiora.model.UserResponse
import io.ktor.client.request.*

class UserDataUseCase {
    private val client = NetworkClient.client

    suspend fun getUser(): UserResponse {
        return client.get(Constants.URL)
    }

}