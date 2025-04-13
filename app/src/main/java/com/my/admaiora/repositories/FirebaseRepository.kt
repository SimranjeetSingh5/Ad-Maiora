package com.my.admaiora.repositories

import com.google.firebase.database.FirebaseDatabase
import com.my.admaiora.model.CallRequest

class FirebaseRepository {
    private val db = FirebaseDatabase.getInstance().getReference("calls")

    // Trigger a call request by adding phone number to Firebase
    suspend fun triggerCall(phone: String, onComplete: (Boolean) -> Unit) {
        val callId = db.push().key ?: return onComplete(false)
        val callRequest = CallRequest(phone) // Create a call request with phone number
        db.child(callId).setValue(callRequest)
            .addOnCompleteListener { onComplete(it.isSuccessful) }
    }
}