package com.example.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.naturecollection.R
import com.example.naturecollection.adapter.PlantAdapter

class HomeFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {



        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        // recuperer le recyclerview

        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter(R.layout.item_horizontal_plant)



        //recuperer le second recycleview ( vertical)

        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        return view
    }
}