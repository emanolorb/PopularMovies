package com.example.testofflinemovie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testofflinemovie.common.tools.debug_print
import com.example.testofflinemovie.data.MovieViewModel
import com.example.testofflinemovie.list.MyMovieRecyclerViewAdapter
import com.example.testofflinemovie.models.MovieModel
import com.example.testofflinemovie.ui.MovieDetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var moviesViewModel: MovieViewModel
    var popularMovies:List<MovieModel>? = null
    var toolbar : Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setToolBar()
        setUpView()

    }

    // set toolMenu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu) // set Tool menu
        return super.onCreateOptionsMenu(menu)
    }

    // setOptions ToolMEnu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when ( item?.itemId){
            R.id.miGeneralMenu -> {
                debug_print("menu itemclick")
                Toast.makeText(this,"You are beatifull!!", Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun setToolBar(){
        // Toolbar settings
        toolbar = findViewById(R.id.tbMainActivity)
        toolbar?.title = "This title"
        setSupportActionBar(toolbar)
    }

    fun setUpView(){
        moviesViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        // Create the observer which updates the UI.
        val moviePopularListObserver = Observer<List<MovieModel>> {
            popularMovies = it
            if (popularMovies != null){
                setList(popularMovies!!)
            }
        }
        // Observer de las peliculas
        moviesViewModel.getPopularMovies().observe(this, moviePopularListObserver)
    }

    fun setList(movieList:List<MovieModel>){
        debug_print(movieList.toString(), " MovieList")

        rvListPopularMoviesTest.layoutManager = LinearLayoutManager(this)

        rvListPopularMoviesTest.setHasFixedSize(true)

        val adaptador = MyMovieRecyclerViewAdapter( movieList, { partItem : MovieModel -> partItemClicked(partItem) })
        rvListPopularMoviesTest.adapter = adaptador
    }

    private fun partItemClicked(partItem : MovieModel) {
        debug_print(partItem.toString(), "item")
        // Launch second activity, pass part ID as string parameter
        val showDetailActivityIntent = Intent(this, MovieDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, partItem.id.toString())
        startActivity(showDetailActivityIntent)
    }

}
