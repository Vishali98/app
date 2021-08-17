package com.example.dictionary

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.database.FavoriteListData
import kotlinx.android.synthetic.main.activity_recycler_adapter.view.*

class RecyclerAdapter(val context: Context,val userList:List<RecyclerData>,val listener:OnItemClick):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview) {

        var title: TextView
        var btn:Button


        init {
            title = itemview.title
            btn=itemview.fav_Btn
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }

        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemview=
            LayoutInflater.from(context).inflate(R.layout.activity_recycler_adapter,parent,false)
        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text= userList[position].word

        val user_list:RecyclerData=userList[position]
        if (SearchFragment.favoriteDatabase.favoriteDao().isFavorite(user_list.id)==1){
            holder.btn.setBackgroundResource(R.drawable.heart_selected)
        }
        else {
            holder.btn.setBackgroundResource(R.drawable.heart_notselected)
        }
        holder.btn.setOnClickListener(View.OnClickListener {
            @Override
             fun onClick(view: View) {
                val favoriteListData = FavoriteListData()


                if (SearchFragment.favoriteDatabase.favoriteDao().isFavorite(user_list.id) != 1) {
                    holder.btn.setBackgroundResource(R.drawable.heart_notselected)
                    SearchFragment.favoriteDatabase.favoriteDao().addData(favoriteListData)

                } else {
                    holder.btn.setBackgroundResource(R.drawable.heart_selected)
                    SearchFragment.favoriteDatabase.favoriteDao().delete(favoriteListData)

                }

            }
        })

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    interface OnItemClick {
        fun onClick(position: Int) {

        }
    }


}





