package com.github.movies.di

import com.github.movies.data.database.getDatabaseBuilder
import org.koin.dsl.module

actual val nativeModule = module {
    single { getDatabaseBuilder() }
//    factoryOf(::IosRegionDataSource) bind RegionDataSource::class
}