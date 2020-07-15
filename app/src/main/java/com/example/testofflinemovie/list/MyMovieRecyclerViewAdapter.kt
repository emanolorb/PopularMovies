package com.example.testofflinemovie.list

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.api.load
import coil.transform.CircleCropTransformation
import com.bumptech.glide.Glide
import com.example.testofflinemovie.R
import com.example.testofflinemovie.common.ApiConstants
import com.example.testofflinemovie.common.MyApp
import com.example.testofflinemovie.responseObj.MovieEntity

import kotlinx.android.synthetic.main.fragment_movie.view.*


class MyMovieRecyclerViewAdapter() : RecyclerView.Adapter<MyMovieRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener
    val contextGlobal: Context = MyApp.instance
    private var movies: List<MovieEntity> = ArrayList()

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as MovieEntity
            println("onClickListener MyMovieReciclerView")
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            // mListener?.onListFragmentInteraction(item)
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
        val item = movies[position]
        holder.ranking.text = item.vote_average.toString()
        holder.title.text = item.original_title.toString()
        //Glide.with(contextGlobal).load(ApiConstants.IMAGE_API_URL.plus(item.poster_path)).into(holder.coverImgView)
        holder.coverImgView.load(ApiConstants.IMAGE_API_URL.plus(item.poster_path)){
            crossfade(true)
            placeholder(R.drawable.ic_cinema_color)
            transformations(CircleCropTransformation())
        }
        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = movies.size
    fun setData(popularMovies: List<MovieEntity>?){
        movies =   popularMovies!!
        notifyDataSetChanged()
    }
    // se inicializan los objetos del adapter
    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val coverImgView : ImageView = mView.imageViewCover
        val ranking: TextView = mView.Average
        val title: TextView = mView.tvMovieTitle

//        override fun toString(): String {
//            return super.toString() + " '" + mContentView.text + "'"
//        }
    }
}
