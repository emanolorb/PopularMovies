package com.example.testofflinemovie.Respositories


import MovieDetailModel
import com.example.testofflinemovie.models.MoviesPopularModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface MoviesApiService {
    @GET("movie/popular")
    fun getPopularMovies(): Call<MoviesPopularModel>

    @GET("movie/{id}")
    fun getDetailMovie(@Path(value = "id", encoded = true) id: String?): Call<MovieDetailModel>
}
