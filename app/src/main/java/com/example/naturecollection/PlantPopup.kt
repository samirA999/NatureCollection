package com.example.naturecollection

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.naturecollection.adapter.PlantAdapter

class PlantPopup (
    private val adapter: PlantAdapter,
    private val currentPlant: PlantModel

) : Dialog(adapter.context ) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popop_plants_details)
        setupComponents()
    }

    private fun setupComponents() {
     // actualiser l'image de la plante
        val plantImage = findViewById<ImageView>(R.id.image_item)
        Glide.with(adapter.context).load(Uri.parse(currentPlant.imageUrl)).into(plantImage)
    }
}