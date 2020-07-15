package com.example.testofflinemovie.responseObj.moviesRespositories


import com.example.testofflinemovie.responseObj.MoviesPopular
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {
    @GET("movie/popular")
    fun getPopularMovies(): Call<MoviesPopular>
}
