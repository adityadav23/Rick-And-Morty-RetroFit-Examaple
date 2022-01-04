package com.example.covid.rickandmortyretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.covid.rickandmortyretrofit.network.ApiClient
import com.example.covid.rickandmortyretrofit.network.CharacterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = ApiClient.apiService.fetchCharacters("1")

        client.enqueue(object: Callback<CharacterResponse>{
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if (response.isSuccessful){
                    val result = response.body()?.result
                    result?.let {
                        val adapter = MainAdapter(result)
                        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_main)
                        recyclerView.adapter = adapter
                    }
                }
            }
            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
               Toast.makeText(applicationContext,"${t.message}", Toast.LENGTH_LONG).show()
            }
        })



    }
}