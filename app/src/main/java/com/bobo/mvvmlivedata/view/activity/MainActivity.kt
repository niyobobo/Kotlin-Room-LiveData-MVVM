package com.bobo.mvvmlivedata.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.bobo.mvvmlivedata.R
import com.bobo.mvvmlivedata.data.remoteData.ApiInterface
import com.bobo.mvvmlivedata.model.MenuModel
import com.bobo.mvvmlivedata.view.adapter.MenuItemAdapter
import com.bobo.mvvmlivedata.viewModel.MenuViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    val TAG: String = "___________"

    private lateinit var menuViewModel: MenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val userId = UUID.randomUUID().toString()
//        menuViewModel = ViewModelProviders.of(this).get(MenuViewModel::class.java)
//        menuViewModel.init(userId)
//        menuViewModel.getMenuList()?.observe(this, Observer { menuModel: MenuModel? ->
//
//        })

        recycleMenu.layoutManager = LinearLayoutManager(this)
        recycleMenu.hasFixedSize()

        val apiService = ApiInterface.create().getMenuItemFromServer()
        apiService.enqueue(object : Callback<List<MenuModel>> {
            override fun onResponse(call: Call<List<MenuModel>>?, response: Response<List<MenuModel>>?) {
                recycleMenu.adapter = MenuItemAdapter(response?.body()!!, this@MainActivity)
                recycleMenu.adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<MenuModel>>?, t: Throwable?) {
                t!!.printStackTrace()
                Log.d(TAG, call.toString())
            }
        })
    }
}