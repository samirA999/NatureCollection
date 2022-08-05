package com.example.naturecollection.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class PlantItemDecoration : RecyclerView.ItemDecoration() {



    // faire un decalage dans le recyclerview
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = 20
    }
}