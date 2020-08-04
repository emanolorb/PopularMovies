package com.example.testofflinemovie.Respositories

import com.example.testofflinemovie.common.ApiConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieClient {
    private val moviesApiService:MoviesApiService
    private val retrofit:Retrofit
    // este companion es para regresar una instancia del mismo si no existe la crea y si existe regresa la existente
    companion object{
        var instance : MovieClient? = null
            get() {
                if (field==null){
                    instance = MovieClient()
                }
                return field
            }
    }
    init {
        // se inicia la clase por priemra vez
        // monta el request inteceptor con las apis que authoriza al usuario
        var builderOKHTTP = OkHttpClient.Builder()
        builderOKHTTP.addInterceptor(ResquestInterceptor())
        var clientOK = builderOKHTTP.build()

        // constrimos el objeto retrofit
        retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.TMDB_API_URL)
            .client(clientOK)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // instanciamos el servicio retrofit a partir del objeto reftrofit
        moviesApiService = retrofit.create(MoviesApiService::class.java)
    }
    fun getMovieApiService() = moviesApiService
}