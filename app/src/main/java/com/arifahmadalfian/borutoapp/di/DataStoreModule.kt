package com.arifahmadalfian.borutoapp.di

import android.content.Context
import com.arifahmadalfian.borutoapp.data.pref.DataStoreOperation
import com.arifahmadalfian.borutoapp.domain.repository.IDataStoreOperation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideDataStoreOperation(
        @ApplicationContext context: Context
    ): IDataStoreOperation {
        return DataStoreOperation(context = context)
    }
}