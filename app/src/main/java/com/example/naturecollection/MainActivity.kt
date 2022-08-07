package com.example.naturecollection.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.naturecollection.PlantRepository
import com.example.naturecollection.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //charger notre plante repository
        val repo = PlantRepository()


        //mettre a jour la liste de plantes
        repo.updateData{

            //injecter le fragment dans notre boite ( fragment_container)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, HomeFragment(this))
            transaction.addToBackStack(null)
            transaction.commit()

        }


    }
}