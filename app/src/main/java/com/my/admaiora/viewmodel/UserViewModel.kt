package com.my.admaiora.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.my.admaiora.model.User
import com.my.admaiora.repositories.UserDataUseCase
import com.my.admaiora.usecase.CallUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository : UserDataUseCase, private val callUseCase:CallUseCase) :ViewModel(){

    private val allUsersData = MutableSharedFlow<UserState>()
    fun getUser():SharedFlow<UserState> = allUsersData

    fun fetchAllUsers() {
        viewModelScope.launch {
            try {
                val users = userRepository.getUser()
                allUsersData.emit(UserState.ShowData(users.data))
            } catch (e: Exception) {
                allUsersData.emit(UserState.ShowError(e.message ?: "Unknown Error"))
            }
        }
    }
    fun startCall(phone: String) {
        viewModelScope.launch {
            var callStarted = false
            callUseCase.startCall(phone) { success ->
                callStarted = success
            }
            allUsersData.emit(UserState.ShowError(if (callStarted) "Call started" else "Failed to start call"))
        }
    }

    sealed class UserState{
        data class ShowData(val userList:List<User>): UserState()
        data class ShowError(val errorMsg:String): UserState()
    }
}