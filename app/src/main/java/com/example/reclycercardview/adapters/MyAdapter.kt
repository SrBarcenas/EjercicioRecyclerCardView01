package com.example.reclycercardview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reclycercardview.R
import com.example.reclycercardview.models.Movie
import com.squareup.picasso.Picasso

class MyAdapter(
    private val movies: List<Movie>,
    private val layout: Int,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        private var imageViewPoster: ImageView = itemView.findViewById(R.id.imageViewPoster)

        fun bind(movie: Movie, listener: OnItemClickListener) {
            textViewTitle.text = movie.name
            Picasso.get().load(movie.poster).fit().into(imageViewPoster)

            itemView.setOnClickListener {
                listener.onItemClick(movie, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        context = parent.context
        return  ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        holder.bind(movies[position], itemClickListener)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    interface OnItemClickListener {
        fun onItemClick(movie: Movie, position: Int)
    }
}