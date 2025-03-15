package com.example.uploadhub.data.di

import android.app.Application
import androidx.work.WorkManager
import com.example.uploadhub.domain.UploadRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideUploadRepo(): UploadRepository {
        return UploadRepository()
    }

    @Singleton
    @Provides
    fun provideWorkManager(@ApplicationContext context:Application): WorkManager {
        return WorkManager.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideSupabaseClient(): SupabaseClient {
        return SupabaseManager.CLIENT
    }
}