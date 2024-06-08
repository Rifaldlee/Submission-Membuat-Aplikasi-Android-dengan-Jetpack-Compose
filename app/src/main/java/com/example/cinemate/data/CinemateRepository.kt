package com.example.cinemate.data

import com.example.cinemate.model.Movie
import com.example.cinemate.model.MovieDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CinemateRepository {

    private val listMovie = mutableListOf<Movie>()
    init {
        listMovie.addAll(MovieDataSource.dummyMovie)
    }

    fun getMovies(): Flow<List<Movie>> {
        return flowOf(listMovie)
    }

    fun getMoviesById(movieId: Long): Movie {
        return listMovie.first {
            it.id == movieId
        }
    }

    fun searchMovie(query: String): List<Movie>{
        return MovieDataSource.dummyMovie.filter {
            it.title.contains(query, ignoreCase = true)
        }
    }

    companion object {
        @Volatile
        private var instance: CinemateRepository? = null

        fun getInstance(): CinemateRepository =
            instance ?: synchronized(this) {
                CinemateRepository().apply {
                    instance = this
                }
            }
    }
}