package com.rubin.recyclerviewdatabinding.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.rubin.recyclerviewdatabinding.R
import com.rubin.recyclerviewdatabinding.data.network.MoviesApi
import com.rubin.recyclerviewdatabinding.data.repository.MoviesRepository
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment : Fragment() {

    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = MoviesApi()
        val repository = MoviesRepository(api)
        factory = MoviesViewModelFactory(repository)

        viewModel = ViewModelProviders.of(this, factory).get(MoviesViewModel::class.java)

        viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            recyclerViewMovies.run {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = MoviesAdapter(movies)
            }
        })
    }
}
