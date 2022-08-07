package com.example.naturecollection

import com.example.naturecollection.PlantRepository.Singleton.databaseRef
import com.example.naturecollection.PlantRepository.Singleton.plantList
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class PlantRepository {

    object Singleton {
        //se connecter a la reference "plants"
        val databaseRef = FirebaseDatabase.getInstance().getReference("plants")

        //creer une liste qui va contenir nos plantes
        val plantList = arrayListOf<PlantModel>()
    }
    fun updateData(){

        //absorber les données depuis la databaseRef -> liste de plantes
        databaseRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                //recolter la liste

                for (ds in snapshot.children) {
                    //construire un objet plante
                    val plant = ds.getValue(PlantModel::class.java)
                    //verifier que la plante n'est pas null
                    if (plant != null) {
                        //ajouter la plante à notre liste
                        plantList.add(plant)
                    }

                }

            }

            override fun onCancelled(error: DatabaseError) {}

        })
    }
}