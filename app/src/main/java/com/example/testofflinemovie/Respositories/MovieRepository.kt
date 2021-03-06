package com.example.testofflinemovie.Respositories


import MovieDetailModel
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.testofflinemovie.common.MyApp
import com.example.testofflinemovie.common.tools.debug_print
import com.example.testofflinemovie.models.MovieModel
import com.example.testofflinemovie.models.MoviesPopularModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository{
    var theMoviesApiService: MoviesApiService? = null
    var theMovieClient: MovieClient? =null
    var popularMovies: MutableLiveData<List<MovieModel>>? = null
    var movieDetailMutable: MutableLiveData<MovieDetailModel> = MutableLiveData<MovieDetailModel>()
    init {
        theMovieClient = MovieClient.instance
        theMoviesApiService = theMovieClient?.getMovieApiService()
        popularMovies = popularMovies()
    }
    fun popularMovies():MutableLiveData<List<MovieModel>>?{
        if (popularMovies==null){
            popularMovies = MutableLiveData<List<MovieModel>>()
        }
        val call : Call<MoviesPopularModel> = theMoviesApiService!!.getPopularMovies()
        call.enqueue(object :Callback<MoviesPopularModel>{
            override fun onFailure(call: Call<MoviesPopularModel>, t: Throwable) {
                debug_print("error----------------------------------")
                debug_print(call.toString())
                debug_print(t.toString())            }
            override fun onResponse(call: Call<MoviesPopularModel>, response: Response<MoviesPopularModel>) {
                if (response.isSuccessful){
                    popularMovies?.value = response.body()?.results
                }
            }
        })
        return popularMovies
    }
    fun getMovieDetail(idPath:String):MutableLiveData<MovieDetailModel>?{
        debug_print("entra")
        val call : Call<MovieDetailModel> = theMoviesApiService!!.getDetailMovie(idPath.toString())
        debug_print(call.toString(),"se crea call")
        call.enqueue(object : Callback<MovieDetailModel>{
            override fun onFailure(call: Call<MovieDetailModel>, t: Throwable) {
                debug_print("error----------------------------------")
                debug_print(call.toString())
                debug_print(t.toString())
            }
            override fun onResponse(call: Call<MovieDetailModel>, response: Response<MovieDetailModel>) {
                if (response.isSuccessful){
                    movieDetailMutable.value = response.body()
                }
            }
        })
        return movieDetailMutable
    }
}