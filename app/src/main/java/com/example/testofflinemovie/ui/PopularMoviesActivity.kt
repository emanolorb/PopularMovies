package com.example.testofflinemovie.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testofflinemovie.R
import com.example.testofflinemovie.Respositories.MovieRepository
import com.example.testofflinemovie.common.tools.debug_print
import com.example.testofflinemovie.data.MovieViewModel

class PopularMoviesActivity : AppCompatActivity() {
    // list vars
    lateinit  var listaPopularMovies: RecyclerView
    lateinit var modelviewlista: MovieViewModel
    //var listaPopularMoviesAdapter
    lateinit var popularMoviesModelView: MovieRepository
    var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_movies)

        setUpView()



    }
    fun setUpView(){

    }
}
