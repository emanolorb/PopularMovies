package com.example.testofflinemovie.data.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.testofflinemovie.responseObj.MovieEntity
import com.example.testofflinemovie.responseObj.moviesRespositories.MovieRepository

class MovieViewModel: ViewModel() {
    private  var theMovieRepository: MovieRepository
    private  var popularMovies: LiveData<List<MovieEntity>>

    init {
        theMovieRepository = MovieRepository()
        popularMovies = theMovieRepository.popularMovies()!!
    }

    fun getPopularMovies(): LiveData<List<MovieEntity>>{
        return popularMovies
    }
}