package com.rikko.moviecatalogue

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*


class MovieAdapter (
    private val result : List<Result>
) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){
    class MovieViewHolder(view: View) :
        RecyclerView.ViewHolder(view){
        private val IMAGE_BASE =
            "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(result: Result){
            itemView.movie_title.text = result.title
            itemView.vote.text = result.vote_average.toString()
            itemView.popularity.text = result.popularity.toString()
            itemView.movie_release_date.text = result.release_date
            Glide.with(itemView).load(IMAGE_BASE + result.poster_path).into(itemView.movie_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int = result.size
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(result.get(position))
    }
}




