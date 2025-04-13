package com.my.admaiora.usecase

import com.my.admaiora.repositories.FirebaseRepository


class CallUseCase(private val repo: FirebaseRepository) {
    // Use case to start a call by passing the phone number
    suspend fun startCall(phone: String, onResult: (Boolean) -> Unit) {
        repo.triggerCall(phone, onResult)
    }
}
