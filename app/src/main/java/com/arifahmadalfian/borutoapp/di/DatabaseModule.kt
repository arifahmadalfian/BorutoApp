package com.arifahmadalfian.borutoapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arifahmadalfian.borutoapp.data.local.BorutoDatabase
import com.arifahmadalfian.borutoapp.data.repository.LocalDataSource
import com.arifahmadalfian.borutoapp.domain.repository.ILocalDataSource
import com.arifahmadalfian.borutoapp.util.Constants.BORUTO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): BorutoDatabase = Room.databaseBuilder(
        context,
        BorutoDatabase::class.java,
        BORUTO_DATABASE
    ).build()

    @Provides
    @Singleton
    fun provideLocalDataSource(
        borutoDatabase: BorutoDatabase
    ): ILocalDataSource {
        return LocalDataSource(borutoDatabase = borutoDatabase)
    }
}