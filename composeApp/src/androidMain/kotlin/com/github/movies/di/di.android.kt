package com.github.movies.di

import android.location.Geocoder
import com.github.movies.data.database.getDatabaseBuilder
import com.github.movies.data.remote.RegionDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

actual val nativeModule = module {
    single { getDatabaseBuilder(get()) }
//    factory { Geocoder(get()) }
//    factory { LocationServices.getFusedLocationProviderClient(androidApplication()) }
//    factoryOf(::AndroidRegionDataSource) bind RegionDataSource::class
}