package com.example.testofflinemovie.data

import MovieDetailModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testofflinemovie.Respositories.MovieRepository

class MovieDetailViewModel : ViewModel(){
    private  var theMovieRepository: MovieRepository = MovieRepository()
    var movieDetail: MutableLiveData<MovieDetailModel>? = MutableLiveData()
    fun setMovieDetail(id: String){
        movieDetail = theMovieRepository.getMovieDetail(id)
    }
}