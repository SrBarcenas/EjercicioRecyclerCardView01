package com.example.reclycercardview.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reclycercardview.R
import com.example.reclycercardview.adapters.MyAdapter
import com.example.reclycercardview.models.Movie

class MainActivity : AppCompatActivity() {

    private lateinit var movies: List<Movie>
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter
    private lateinit var mLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movies = getAllMovies()

        mRecyclerView = findViewById(R.id.recyclerView)
        mLayoutManager = LinearLayoutManager(this)

        myAdapter = MyAdapter(movies, R.layout.recycler_view_item, object : MyAdapter.OnItemClickListener{
            override fun onItemClick(movie: Movie, position: Int) {
                Toast.makeText(baseContext, movie.name, Toast.LENGTH_LONG).show()
            }
        })

        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.adapter = myAdapter
    }

    private fun getAllMovies(): List<Movie> {
        return arrayListOf(
            Movie("Ben Hur", R.drawable.benhur),
            Movie("DeadPool", R.drawable.deadpool),
            Movie("Guardianes de la Galaxia", R.drawable.guardians),
            Movie("Warcraft", R.drawable.warcraft)
        )
    }
}