package com.example.moviedb.ui.screen.latestmovielist

import androidx.recyclerview.widget.DiffUtil
import com.example.moviedb.R
import com.example.moviedb.data.model.Cast
import com.example.moviedb.databinding.ItemCastBinding
import com.example.moviedb.ui.base.BaseListAdapter

class RecentMovieAdapter(): BaseListAdapter<Cast, ItemCastBinding>(object : DiffUtil.ItemCallback<Cast>() {
    override fun areItemsTheSame(oldItem: Cast, newItem: Cast): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Cast, newItem: Cast): Boolean {
        return oldItem == newItem
    }
}) {

    override fun getLayoutRes(viewType: Int): Int {
        return R.layout.item_cast
    }

}