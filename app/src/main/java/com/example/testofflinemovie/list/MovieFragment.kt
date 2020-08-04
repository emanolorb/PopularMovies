package com.example.testofflinemovie.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testofflinemovie.R
import com.example.testofflinemovie.data.MovieViewModel
import com.example.testofflinemovie.models.MovieModel
import java.util.ArrayList

class MovieFragment : Fragment() {
    private lateinit var moviesViewModel: MovieViewModel
    private  lateinit var movieAdapter: MyMovieRecyclerViewAdapter
    private var popularMovies : List<MovieModel> = ArrayList()

    private var columnCount = 2
    var movieList : List<MovieModel> = listOf()
    // private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        // optenemos el viewModel
//        moviesViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
//
//        movieAdapter = MyMovieRecyclerViewAdapter()
//
//        // Set the adapter
//        if (view is RecyclerView) {
//            with(view) {
//                layoutManager = when {
//                    columnCount <= 1 -> LinearLayoutManager(context)
//                    else -> GridLayoutManager(context, columnCount)
//                }
//                adapter = movieAdapter
//            }
//        }
//        // Observer de las peliculas
//        moviesViewModel.getPopularMovies().observe(viewLifecycleOwner, Observer {
//            popularMovies = it
//            movieAdapter.setData(popularMovies)
//        })

        return view
    }

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            MovieFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
