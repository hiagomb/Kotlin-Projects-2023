package com.example.section19_daggerhilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class DataModule {

    @Provides
    fun provideDataSource(): MockDataSource{
        return MockDataSource()
    }
}