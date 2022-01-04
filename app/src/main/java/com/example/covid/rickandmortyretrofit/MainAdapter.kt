package com.example.covid.rickandmortyretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.example.covid.rickandmortyretrofit.network.Character

class MainAdapter(val characterList: List<Character>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_row_item,
            parent,
            false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    class MainViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val name = view.findViewById<TextView>(R.id.textView_rick)
        val image = view.findViewById<ImageView>(R.id.imageView_rick)

        fun bind(character: Character){
         name.text = character.name

          Picasso.get().load(character.image).into(image)

        }
    }
}