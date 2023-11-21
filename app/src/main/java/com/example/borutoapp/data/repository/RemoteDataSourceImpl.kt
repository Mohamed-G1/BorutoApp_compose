package com.example.borutoapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.borutoapp.data.local.HeroDatabase
import com.example.borutoapp.data.paging_source.HeroRemoteMediator
import com.example.borutoapp.data.remote.ApiService
import com.example.borutoapp.domain.model.Hero
import com.example.borutoapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalPagingApi::class)
class RemoteDataSourceImpl(
    private val apiService: ApiService,
    private val heroDatabase: HeroDatabase
) : RemoteDataSource {

    private val heroDao = heroDatabase.heroDao()
    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        /**
         * this lambda function to invoke the getAllHeroes() function when we call the factoryPagingSource variable */
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(
                pageSize = 3
            ),
            remoteMediator = HeroRemoteMediator(
                apiService = apiService,
                heroDatabase = heroDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun getSearchedHeroes(): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }
}