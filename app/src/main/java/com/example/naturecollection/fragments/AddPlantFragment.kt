package com.example.naturecollection.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.naturecollection.R

class AddPlantFragment (
    private val context: MainActivity

        ) : Fragment() {


    private var uploadedImage : ImageView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_add_plant, container, false)

        //recuperer uploadedImage pour lui son composant
        uploadedImage = view.findViewById(R.id.preview_image)

       //recuperer le bouton pour charger limage
        val pickupImageButton = view.findViewById<Button>(R.id.upload_button)

        //lorsqu'on clique dessus ça ouvre les images du telephone
        pickupImageButton.setOnClickListener { pickupImage() }


        return view


    }

    private fun pickupImage() {
        val intent = Intent()
        intent.type = "image/"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 47)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 47 && resultCode == Activity.RESULT_OK){

            //verifier si les données sont nulles
            if(data == null || data.data == null ) return

            //recuperer l'image
            val selectedImage = data.data


            //mettre a jour laperçu de limage
            uploadedImage?.setImageURI(selectedImage)





        }


    }


}

