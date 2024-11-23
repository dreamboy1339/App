package com.hjw.di

import com.hjw.data.widget.datasource.widget.WidgetRemoteDataSource
import com.hjw.data.widget.datasource.widget.WidgetRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class DataSourceModule {

    @Binds
    abstract fun bindWidgetRemoteDataSource(
        searchRemoteDataSourceImpl: WidgetRemoteDataSourceImpl,
    ): WidgetRemoteDataSource
}
