package com.example.myapplication.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.RecyclerViewAdapter
import com.example.myapplication.viewModel.ImagesViewModel

class ImagesActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var progressBar : ProgressBar
    lateinit var imagesViewModel : ImagesViewModel
    lateinit var activityMainBinding : ActivityMainBinding
    lateinit var imageAdapter : RecyclerViewAdapter
    lateinit var context : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        context = this

        recyclerView = activityMainBinding.recyclerView
        progressBar = activityMainBinding.progressBar
        progressBar.visibility = ProgressBar.VISIBLE

        createRecyclerView()

        imagesViewModel = ViewModelProvider(this)[ImagesViewModel::class.java]
        imagesViewModel.getAllImages()
        imagesViewModel.observeImagesLiveData().observe(this, Observer { imageList ->
            imageAdapter.setImageList(imageList)
            progressBar.visibility = ProgressBar.INVISIBLE
        })

    }

    private fun createRecyclerView() {
        imageAdapter = RecyclerViewAdapter()
        activityMainBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = imageAdapter

        }
        recyclerView.hasFixedSize()
    }


}