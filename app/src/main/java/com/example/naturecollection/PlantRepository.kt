package com.example.naturecollection

import android.net.Uri
import com.example.naturecollection.PlantRepository.Singleton.databaseRef
import com.example.naturecollection.PlantRepository.Singleton.plantList
import com.example.naturecollection.PlantRepository.Singleton.storageReference
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.UploadTask
import java.util.*

class PlantRepository {

    object Singleton {


        //le lien pour acceder au bucket
        private val BUCKET_URL: String ="gs://naturecollection-3f987.appspot.com"

        //se connecter à notre espace de stockage
        val storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(BUCKET_URL)
        //se connecter a la reference "plants"
        val databaseRef = FirebaseDatabase.getInstance().getReference("plants")

        //creer une liste qui va contenir nos plantes
        val plantList = arrayListOf<PlantModel>()
    }
    fun updateData(callback: () -> Unit){

        //absorber les données depuis la databaseRef -> liste de plantes
        databaseRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                //retirer les anciennes
                plantList.clear()

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

                //acctionner le callback
                callback()

            }

            override fun onCancelled(error: DatabaseError) {}

        })
    }
    //creer une fonction pour envoyer des fichiers sur le storage
    fun uploadImage(file: Uri) {
        //verifier que ce fichier n'est pas null
        if (file != null) {
            val fileName = UUID.randomUUID().toString() + ".jpg"
            val ref = storageReference.child(fileName)
            val uploadTask = ref.putFile(file)

            //demarrer la tache d'envoi
            uploadTask.continueWithTask(Continuation <UploadTask.TaskSnapshot, Task<Uri>> {task ->

                // si il y a eu un problem lor de lenvoi du fichier
                if(!task.isSuccessful) {
                    task.exception?.let { throw it }

                }
                return@Continuation ref.downloadUrl

            }).addOnCompleteListener{task ->

                //verifier si tout a bien fonctioner
                if(task.isSuccessful){

                    //recuperer l'image
                    val downloadURI = task.result

                    //mettre à jour laperçu de limage


                }

            }

        }
    }

    //mettre a jour un objet plante en Bdd
    fun updatePlant(plant:PlantModel){
        databaseRef.child(plant.id).setValue(plant)

    }
 //supprimer une plante de la base

    fun deletePlant(plant: PlantModel) = databaseRef.child(plant.id).removeValue()
}