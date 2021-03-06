package com.example.moviedb.ui.screen.latestmovielist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviedb.data.model.Movie
import com.example.moviedb.data.remote.ApiParams
import com.example.moviedb.data.repository.MovieRepository
import com.example.moviedb.ui.base.BaseLoadMoreRefreshViewModel
import kotlinx.coroutines.launch


class LatestMovieViewModel(
    private val movieRepository: MovieRepository
) : BaseLoadMoreRefreshViewModel<Movie>() {

    val isRecentVisible = MutableLiveData<Boolean>().apply { value = false }


    override fun loadData(page: Int) {
        val hashMap = HashMap<String, String>()
        hashMap[ApiParams.PAGE] = page.toString()

        viewModelScope.launch {
            try {
                movieRepository.getMovieList(hashMap).results?.let { movieRepository.insertDB(it) }
               // onLoadSuccess(page, movieRepository.getMovieList(hashMap).results)
                onLoadSuccess(page, movieRepository.getMovieListLocal())
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
}