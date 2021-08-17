package com.example.dictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.database.FavoriteListData
import kotlinx.android.synthetic.main.fragment_favourite.*


class FavouriteFragment : Fragment() {
    private var rv: RecyclerView? = null
    private var adapter: FavoriteAdapter? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        onCreate(savedInstanceState)
        return inflater.inflate(R.layout.favorite_adapter, container, false)
        rv = fav_recyclerview as RecyclerView
        rv!!.setHasFixedSize(true)
        rv!!.layoutManager = LinearLayoutManager(requireActivity())
        getfavData()
    }

    private fun getfavData(){
            val favoriteListData: List<FavoriteListData> =
                SearchFragment.favoriteDatabase.favoriteDao().getFavoriteData() as List<FavoriteListData>
            adapter = FavoriteAdapter(requireActivity(), favoriteListData)
            rv!!.adapter = adapter
        }
}





