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
import com.example.naturecollection.PlantPopup
import com.example.naturecollection.PlantRepository
import com.example.naturecollection.R
import com.example.naturecollection.fragments.MainActivity

class PlantAdapter (


    val context : MainActivity,

    private val plantList: List<PlantModel>,

    private val layoutId: Int): RecyclerView.Adapter<PlantAdapter.ViewHolder>() {


    //boite pour ranger tout les composants à controler

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        //image de la plante ?

        val plantImage = view.findViewById<ImageView>(R.id.image_item)
        val plantName:TextView? = view.findViewById(R.id.name_item)
        val PlantDescription:TextView? = view.findViewById(R.id.description_item)
        val starIcon = view.findViewById<ImageView>(R.id.star_icon)


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

    //recuperer le repository

    val repo = PlantRepository()

    //utiliser glide pour recuperer l'image à partir de sont  lien  -> composant

    Glide.with(context).load(Uri.parse(currentPlant.imageUrl)).into(holder.plantImage)

    //mettre a jour le nom de la plante

    holder.plantName?.text = currentPlant.name

    //mettre a jour la description
    holder.PlantDescription?.text = currentPlant.description

    //verifier si la palnte et liker?

    if (currentPlant.liked){
        holder.starIcon.setImageResource(R.drawable.ic_star)
    }
    else {
        holder.starIcon.setImageResource(R.drawable.ic_unstar)
    }


    //rajouter une interaction sur cette etoile
    holder.starIcon.setOnClickListener {
        //inverse si le bouton est like ou non
        currentPlant.liked = !currentPlant.liked

        //mettre a jour l'objet plante
        repo.updatePlant(currentPlant)
      }

    // interacton lors du clic sur une plante
    holder.itemView.setOnClickListener {
        //affichez la poppup
        PlantPopup(this).show()
    }
    }


    //renvoyer commebien item a afficher
    override fun getItemCount(): Int = plantList.size


}