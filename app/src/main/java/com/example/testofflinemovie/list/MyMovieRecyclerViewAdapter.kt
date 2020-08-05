package com.example.testofflinemovie.list

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load
import com.example.testofflinemovie.R
import com.example.testofflinemovie.common.ApiConstants
import com.example.testofflinemovie.models.MovieModel

import kotlinx.android.synthetic.main.fragment_movie.view.*


open class MyMovieRecyclerViewAdapter(movieList: List<MovieModel>, val clickListener: (MovieModel) -> Unit) : RecyclerView.Adapter<MyMovieRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener
    private var movies: List<MovieModel> = ArrayList()

    init {
        this.movies = movieList
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as MovieModel
        }
    }
    // Fragment Movie es el xml de un objeto de la lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_movie, parent, false)
        return ViewHolder(view)
    }
    // setear el fragment item con el item real
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ViewHolder).bind(movies[position], clickListener)
    }

    override fun getItemCount(): Int = movies.size
    fun setData(popularMovies: List<MovieModel>?){
        movies =   popularMovies!!
        notifyDataSetChanged()
    }
    class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        fun bind(part: MovieModel, clickListener: (MovieModel) -> Unit) {
            mView.Average.text = part.vote_average.toString()
            mView.tvDescription.text = part.overview
            mView.tvMovieTitle.text = part.original_title
            mView.imageViewCover.load(ApiConstants.IMAGE_API_URL.plus(part.poster_path)){
                //crossfade(true)
                placeholder(R.drawable.ic_cinema_color)
            }
            mView.setOnClickListener { clickListener(part)}
        }
    }
}

