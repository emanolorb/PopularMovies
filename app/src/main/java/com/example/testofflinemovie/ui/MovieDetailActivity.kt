package com.example.testofflinemovie.ui

import MovieDetailModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.api.load
import com.example.testofflinemovie.R
import com.example.testofflinemovie.common.ApiConstants
import com.example.testofflinemovie.common.tools.debug_print
import com.example.testofflinemovie.data.MovieDetailViewModel
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {
    lateinit var moviesViewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        supportActionBar?.hide() // hide toolbar
        setUpView()
    }
    fun setUpView(){
        val intentThatStartedThisActivity = intent
        moviesViewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)
        // Create the observer which updates the UI.
        val moviePopularListObserver = Observer<MovieDetailModel> {
            if (it != null){
                setdetails(it)
            }
        }

        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            val movieId  = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
            if (movieId != null) {
                // Observer de las peliculas
                debug_print(movieId.toString(),"movieId")
                moviesViewModel.setMovieDetail(movieId.toString())?.observe(this, moviePopularListObserver)
            }
        }
    }
    fun setdetails(detail:MovieDetailModel){
        debug_print(detail.toString(),"Detail String")
        rbMovieDetail.rating = (detail.vote_average / 2).toFloat()
        tvAverageDetail.text = detail.vote_average.toString()
        tvTitleMovieDetail.text = detail.title
        tvReleaseDate.text = getString(R.string.release_date).plus(": ${detail.release_date}")
        tvTagLine.text =detail.tagline
        tvDescription.text = getString(R.string.description).plus(":\n${detail.overview}")
        tvHomePage.text = getString(R.string.home_page).plus(":\n${detail.homepage}")
        tvOriginalTitleDetal.text = "Titulo original :  ".plus( detail.original_title)
        ivDetailMovie.load(ApiConstants.IMAGE_API_URL.plus(detail.poster_path)){
            //crossfade(true)
            placeholder(R.drawable.ic_cinema_color)
        }
    }
}
