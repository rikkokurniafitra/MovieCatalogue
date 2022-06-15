package com.rikko.moviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { result : List<Result> ->
            rv_movies_list.adapter = MovieAdapter(result)
        }
    }

    private fun getMovieData(callback: (List<Result>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: retrofit2.Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse( call: retrofit2.Call<MovieResponse>, response: Response<MovieResponse>)     {
                return callback(response.body()!!.result)
            }
        })
    }
}

