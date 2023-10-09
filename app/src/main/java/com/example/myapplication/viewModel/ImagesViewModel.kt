package com.example.myapplication.viewModel

import android.util.Log
import android.widget.ProgressBar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.model.ImagesInterface
import com.example.myapplication.model.ImagesModel
import com.example.myapplication.model.RecyclerViewAdapter
import com.example.myapplication.model.Result
import com.example.myapplication.model.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.security.auth.callback.Callback

/**
 * @Author Gaurav Naresh Pandit
 * @Since 07/10/23
 **/

class ImagesViewModel : ViewModel() {  

    private var imageLiveData = MutableLiveData<List<Result>>()

    fun getAllImages() {

        GlobalScope.launch(Dispatchers.IO) {
            try {
                RetrofitInstance.api.getAllImages().enqueue(object : retrofit2.Callback<ImagesModel>{
                    override fun onResponse(call: Call<ImagesModel>, response: Response<ImagesModel>) {
                        if (response.body() != null) {
                            imageLiveData.value = response.body()!!.results
                        } else {
                            return
                        }
                    }

                    override fun onFailure(call: Call<ImagesModel>, t: Throwable) {
                        Log.d("MainActivity2", "getAllImages: ${t.message.toString()}")
                    }

                })
            } catch (e : Exception) {
                Log.d("MainActivity2", "getAllImages: $e")
            }
        }

    }

    fun observeImagesLiveData() : LiveData<List<Result>> {
        return imageLiveData
    }

}