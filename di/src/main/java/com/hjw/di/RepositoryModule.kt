package com.hjw.di

import com.hjw.data.widget.repository.widget.WidgetRepositoryImpl
import com.hjw.domain.repository.WidgetRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindWidgetRepository(
        widgetRepositoryImpl: WidgetRepositoryImpl,
    ): WidgetRepository
}
