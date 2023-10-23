package com.example.borutoapp.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.borutoapp.data.local.HeroDatabase
import com.example.borutoapp.data.remote.ApiService
import com.example.borutoapp.domain.model.Hero
import com.example.borutoapp.domain.model.HeroRemoteKeys

@OptIn(ExperimentalPagingApi::class)
class HeroRemoteMediator(
    private val apiService: ApiService,
    private val heroDatabase: HeroDatabase
) : RemoteMediator<Int, Hero>() {

    private val heroDao = heroDatabase.heroDao()
    private val remoteKeysDao = heroDatabase.heroRemoteKey()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Hero>
    ): MediatorResult {
        return try {
            /**
             * calculating the page size */
            val page = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKey = getRemoteKeyClosetRecentPosition(state)
                    remoteKey?.nextPage?.minus(1) ?: 1
                }

                LoadType.PREPEND -> {
                    val remoteKey = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKey?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKey != null
                        )
                    prevPage
                }

                LoadType.APPEND -> {
                    val remoteKey = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKey?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKey != null
                        )
                    nextPage
                }

            }


            val response = apiService.getAllHeroes(page = page)
            if (response.heroes.isNotEmpty()) {
                /**
                 * since is this the first state that paging with enter through so we delete the tables
                 * just to make sure that the tables is clean
                 * */
                if (loadType == LoadType.REFRESH) {
                    heroDatabase.withTransaction {
                        heroDao.getAllHeroes()
                        remoteKeysDao.deleteAllRemoteKeys()
                    }
                }

                val prevPage = response.prevPage
                val nextPage = response.nextPage
                val keys = response.heroes.map { hero ->
                    HeroRemoteKeys(
                        id = hero.id,
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }

                heroDao.addHeroes(heroes = response.heroes)
                remoteKeysDao.addAllRemoteKeys(heroRemoteKeys = keys)
            }
            MediatorResult.Success(endOfPaginationReached = response.nextPage != null)

        } catch (e: Exception) {
            MediatorResult.Error(e)
        }


    }

    private suspend fun getRemoteKeyClosetRecentPosition(state: PagingState<Int, Hero>): HeroRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(anchorPosition = position)?.id?.let { id ->
                heroDatabase.heroRemoteKey().getRemoteKeys(heroId = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, Hero>): HeroRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()?.let { hero ->
            remoteKeysDao.getRemoteKeys(heroId = hero.id)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, Hero>): HeroRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let { hero ->
            heroDatabase.heroRemoteKey().getRemoteKeys(heroId = hero.id)
        }
    }
}