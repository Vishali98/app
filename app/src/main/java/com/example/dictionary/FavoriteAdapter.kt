package com.example.dictionary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.database.FavoriteListData
import kotlinx.android.synthetic.main.favorite_adapter.view.*


class FavoriteAdapter(val context: Context,var favlist:List<FavoriteListData>):RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    inner class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview) {
        var title_word:TextView

        init {
            title_word=itemview.fav_title
        }

    }
    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): FavoriteAdapter.ViewHolder {
        val itemview=LayoutInflater.from(context).inflate(com.example.dictionary.R.layout.favorite_adapter,parent,false)
        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title_word.text= favlist[position].word.toString()

    }

    override fun getItemCount(): Int {
        return favlist.size
    }



}