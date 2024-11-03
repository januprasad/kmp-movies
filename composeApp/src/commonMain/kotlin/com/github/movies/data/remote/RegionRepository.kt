package com.github.movies.data.remote

const val DEFAULT_REGION = "IN"

interface RegionDataSource {
    suspend fun fetchRegion(): String
}

class RegionRepository(private val regionDataSource: RegionDataSource) {

    suspend fun fetchRegion(): String {
        return regionDataSource.fetchRegion()
    }
}