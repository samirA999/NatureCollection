package com.example.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.naturecollection.PlantRepository.Singleton.plantList
import com.example.naturecollection.R
import com.example.naturecollection.adapter.PlantAdapter
import com.example.naturecollection.adapter.PlantItemDecoration

class HomeFragment (

    private val context: MainActivity
        ): Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater?.inflate(R.layout.fragment_home, container, false)




        // recuperer le recyclerview

        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter(context, plantList.filter { !it.liked }, R.layout.item_horizontal_plant)



        //recuperer le second recycleview ( vertical)

        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = PlantAdapter(context, plantList, R.layout.item_vertical_plante)
        verticalRecyclerView.addItemDecoration(PlantItemDecoration())


        return view
    }
}