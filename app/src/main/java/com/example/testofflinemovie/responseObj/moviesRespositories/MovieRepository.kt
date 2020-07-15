package com.example.testofflinemovie.responseObj.moviesRespositories


import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.testofflinemovie.common.MyApp
import com.example.testofflinemovie.responseObj.MovieEntity
import com.example.testofflinemovie.responseObj.MoviesPopular
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {
    var theMoviesApiService: MoviesApiService? = null
    var theMovieClient: MovieClient? =null
    var popularMovies: MutableLiveData<List<MovieEntity>>? = null
    init {
        theMovieClient = MovieClient.instance
        theMoviesApiService = theMovieClient?.getMovieApiService()
        popularMovies = popularMovies()
    }
    fun popularMovies():MutableLiveData<List<MovieEntity>>?{
        if (popularMovies==null){
            popularMovies = MutableLiveData<List<MovieEntity>>()
        }
        val call : Call<MoviesPopular> = theMoviesApiService!!.getPopularMovies()
        call.enqueue(object :Callback<MoviesPopular>{
            override fun onFailure(call: Call<MoviesPopular>, t: Throwable) {
                Toast.makeText(MyApp.instance, "Error en la llamada", Toast.LENGTH_LONG).show()
            }
            override fun onResponse(call: Call<MoviesPopular>, response: Response<MoviesPopular>) {
                Toast.makeText(MyApp.instance, "Exito con el request del servidor", Toast.LENGTH_LONG).show()
                if (response.isSuccessful){
                    println(response.body()?.results?.size)
                    println("===========================================================")
                    println(response.body()?.results)
                    popularMovies?.value = response.body()?.results
                }
            }
        })
        return popularMovies
    }
}