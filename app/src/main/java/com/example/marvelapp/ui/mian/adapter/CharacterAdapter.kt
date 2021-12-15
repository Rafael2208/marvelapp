package com.example.marvelapp.ui.mian.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.ui.details.DetailsActivity
import com.facebook.drawee.view.SimpleDraweeView

class CharacterAdapter(val context: Context, val characters: List<Character>): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var thumbnail   : SimpleDraweeView  = view.findViewById (R.id.imvThumbRecycler )
        var name        : TextView          = view.findViewById (R.id.txvNameRecycler  )
        var card        : CardView          = view.findViewById (R.id.cdvRecycler      )


    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = characters.size



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.thumbnail.setImageURI(Uri.parse(characters[position].thumbnail.toString()),context)
        holder.name.text = characters[position].name
        holder.card.setOnClickListener {
            val character: Character = characters[position]
            context.startActivity(
                Intent(context, DetailsActivity::class.java).apply {
                    putExtra("character", character)
                }
            )
        }
    }





}