package com.arifahmadalfian.borutoapp.di

import android.content.Context
import com.arifahmadalfian.borutoapp.data.repository.Repository
import com.arifahmadalfian.borutoapp.data.pref.DataStoreOperation
import com.arifahmadalfian.borutoapp.domain.repository.IDataStoreOperation
import com.arifahmadalfian.borutoapp.domain.use_case.UseCases
import com.arifahmadalfian.borutoapp.domain.use_case.get_all_heroes.GetAllHeroesUseCase
import com.arifahmadalfian.borutoapp.domain.use_case.get_selected_hero.GetSelectedHeroUseCases
import com.arifahmadalfian.borutoapp.domain.use_case.read_onboarding.ReadOnBoarding
import com.arifahmadalfian.borutoapp.domain.use_case.save_onboarding.SaveOnBoarding
import com.arifahmadalfian.borutoapp.domain.use_case.search_heroes.SearchHeroesUseCases
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

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoarding = SaveOnBoarding(repository = repository),
            readOnBoarding = ReadOnBoarding(repository = repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository = repository),
            searchHeroesUseCase = SearchHeroesUseCases(repository = repository),
            getSelectedHeroUseCases = GetSelectedHeroUseCases(repository = repository)
        )
    }
}