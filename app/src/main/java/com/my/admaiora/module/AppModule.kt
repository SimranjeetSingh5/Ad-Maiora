package com.my.admaiora.module
import com.my.admaiora.repositories.FirebaseRepository
import com.my.admaiora.repositories.UserDataUseCase
import com.my.admaiora.usecase.CallUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserDataUseCase(): UserDataUseCase {
        return UserDataUseCase()
    }
    @Provides
    @Singleton
    fun provideFirebaseRepo(): FirebaseRepository {
        return FirebaseRepository()
    }
    @Provides
    @Singleton
    fun provideCallUseCase(): CallUseCase {
        return CallUseCase(provideFirebaseRepo())
    }

}