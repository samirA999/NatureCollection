package com.example.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.naturecollection.PlantModel
import com.example.naturecollection.R
import com.example.naturecollection.adapter.PlantAdapter
import com.example.naturecollection.adapter.PlantItemDecoration

class HomeFragment (

    private val context: MainActivity
        ): Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        //creer une liste qui va stocker ces plantes
        val plantList = arrayListOf<PlantModel>()

        //enregistrer une première plante dans notre liste (pissenli)
        plantList.add(
            PlantModel(
            "Pissenlit",
            "jaune soleil",
                "https://www.plantes-et-sante.fr/images/pissenlit.jpg_720_1000_2",
                false
        ))


        //enregistrer une seconde plante dans notre liste (rose)
        plantList.add(
            PlantModel(
                "Rose",
                "ça pique",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Rose_Papa_Meilland.jpg/800px-Rose_Papa_Meilland.jpg",
                false
            ))



        //enregistrer une 3 plante dans notre liste (cactus)
        plantList.add(
            PlantModel(
                "Cactus",
                "ça pique BEAUCOUP",
                "https://media.istockphoto.com/photos/blooming-prickly-pear-cactus-on-the-island-of-hvar-croatia-picture-id1326892451",
                false
            ))


        //enregistrer une 4 plante dans notre liste (tulipe)
        plantList.add(
            PlantModel(
                "Tulipe",
                "c'est beau",
                "https://media.istockphoto.com/photos/tulips-spring-flowers-tulip-field-in-the-sunlight-picture-id1355093980",
                false
            ))



        // recuperer le recyclerview

        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter(context, plantList, R.layout.item_horizontal_plant)



        //recuperer le second recycleview ( vertical)

        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = PlantAdapter(context, plantList, R.layout.item_vertical_plante)
        verticalRecyclerView.addItemDecoration(PlantItemDecoration())


        return view
    }
}