package com.example.testofflinemovie.data

import MovieDetailModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.testofflinemovie.models.MovieModel
import com.example.testofflinemovie.Respositories.MovieRepository

class MovieViewModel: ViewModel() {
    private  var theMovieRepository: MovieRepository
    private  var popularMovies: LiveData<List<MovieModel>>
    private lateinit var movieDetailLiveData: LiveData<MovieDetailModel>

    init {
        theMovieRepository = MovieRepository()
        popularMovies = theMovieRepository.popularMovies()!!
    }

    fun getPopularMovies(): LiveData<List<MovieModel>>{
        return popularMovies
    }
}