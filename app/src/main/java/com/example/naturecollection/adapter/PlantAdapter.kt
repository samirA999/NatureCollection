package com.example.naturecollection.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.naturecollection.PlantModel
import com.example.naturecollection.R
import com.example.naturecollection.fragments.MainActivity

class PlantAdapter (


    private val context : MainActivity,

    private val plantList: List<PlantModel>,

    private val layoutId: Int): RecyclerView.Adapter<PlantAdapter.ViewHolder>() {


    //boite pour ranger tout les composants à controler

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        //image de la plante ?

        val plantImage = view.findViewById<ImageView>(R.id.image_item)
        val plantName:TextView? = view.findViewById(R.id.name_item)
        val PlantDescription:TextView? = view.findViewById(R.id.description_item)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId,parent,false)
        return ViewHolder(view)
    }
//metre ajour chaqueplante
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        //recuperer les informations de la plante

        val currentPlant = plantList[position]

    //utiliser glide pour recuperer l'image à partir de sont  lien  -> composant

    Glide.with(context).load(Uri.parse(currentPlant.imageUrl)).into(holder.plantImage)

    //mettre a jour le nom de la plante

    holder.plantName?.text = currentPlant.name

    //mettre a jour la description
    holder.PlantDescription?.text = currentPlant.description


    }


    //renvoyer commebien item a afficher
    override fun getItemCount(): Int = plantList.size


}