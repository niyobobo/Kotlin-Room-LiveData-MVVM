package com.bobo.mvvmlivedata.data.remoteData

import com.bobo.mvvmlivedata.model.MenuModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiInterface {

    @GET("json/menu.json")
    fun getMenuItemFromServer(): Call<List<MenuModel>>

    /**
     * Creating companion object that will return instance of API interface.
     * to be accessed into another classes.
     */

    companion object Factory {

        private const val BASE_URL: String = "https://api.androidhive.info/"

        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }

}