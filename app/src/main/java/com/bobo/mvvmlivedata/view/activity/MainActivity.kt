package com.bobo.mvvmlivedata.view.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bobo.mvvmlivedata.R
import com.bobo.mvvmlivedata.data.remoteData.ApiInterface
import com.bobo.mvvmlivedata.model.MenuModel
import com.bobo.mvvmlivedata.view.adapter.MenuItemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    val TAG: String = "___________"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleMenu.layoutManager = LinearLayoutManager(this)
        recycleMenu.hasFixedSize()

        val apiService = ApiInterface.create().getMenuItemFromServer()
        apiService.enqueue(object : Callback<List<MenuModel>> {
            override fun onResponse(call: Call<List<MenuModel>>?, response: Response<List<MenuModel>>?) {
                recycleMenu.adapter = MenuItemAdapter(response?.body()!!, this@MainActivity)
                MenuItemAdapter(response.body()!!, this@MainActivity).notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<MenuModel>>?, t: Throwable?) {
                t!!.printStackTrace()
                Log.d(TAG, call.toString())
            }
        })
    }
}