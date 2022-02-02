package com.example.hcacodingchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hcacodingchallenge.api.ApiInterface
import com.example.hcacodingchallenge.models.Item
import com.example.hcacodingchallenge.models.MyData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var adapter: StackExchangeAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this@MainActivity)
        getMyData()

    }
    private fun initRecyclerView(){
        R.id.recycler_view.apply {
            linearLayoutManager = LinearLayoutManager(this@MainActivity)


        }
    }
    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://stackoverflow.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        //control+shift+ space
        retrofitData.enqueue(object : Callback<List<Item>?> {
            override fun onResponse(call: Call<List<Item>?>, response: Response<List<Item>?>) {
                val responseBody = response.body()!!
                adapter = StackExchangeAdapter(baseContext, responseBody)
                adapter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<List<Item>?>, t: Throwable) {
                d("MainActivity", "onFailure" + t.message)
            }
        })
    }
}