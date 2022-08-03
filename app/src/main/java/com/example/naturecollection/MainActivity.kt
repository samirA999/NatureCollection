package com.example.naturecollection

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.naturecollection.fragments.HomeFragment


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContenView(R.layout.activity_main)

       
    //injecter le fragment dans notre boite ( fragment_container)

    }

    private fun setContenView(activityMain: Int) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,HomeFragment())
        transaction.addToBackStack(null)

    }
}

