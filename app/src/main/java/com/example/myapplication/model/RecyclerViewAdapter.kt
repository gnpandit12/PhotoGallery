package com.example.myapplication.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.R
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL


/**
 * Copyright (c) 2021 Pegadroid IQ Solutions Pvt. Ltd.
 * @Author Gaurav Naresh Pandit
 * @Since 03/10/23
 **/

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    private var imageList = ArrayList<Result>()

    class RecyclerViewHolder(itemView: View) : ViewHolder(itemView) {
        val dataImageView : ImageView

        init {
            dataImageView =  itemView.findViewById(R.id.data_image_view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.images_card_view, parent, false)
        return RecyclerViewHolder(view)
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {

        val url : String = imageList[position].image

        var bitmap : Bitmap

        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                val imageUrl = URL(url)
                bitmap = BitmapFactory.decodeStream(imageUrl.openConnection().getInputStream())
                Thread.sleep(1000)
            }
            holder.dataImageView.setImageBitmap(bitmap)
        }

    }

    fun setImageList(imagesList: List<Result>) {
        this.imageList = imagesList as ArrayList<Result>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

}