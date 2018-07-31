package com.bobo.mvvmlivedata.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.bobo.mvvmlivedata.R
import com.bobo.mvvmlivedata.adapter.MenuItemAdapter
import com.bobo.mvvmlivedata.data.database.AppDatabase
import com.bobo.mvvmlivedata.model.MenuModel
import com.bobo.mvvmlivedata.viewModel.MenuViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var mAdapter: MenuItemAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuDao = (application as AppDatabase).getMenuModelDao()
        recycleMenu.layoutManager = LinearLayoutManager(this)
        recycleMenu.adapter = mAdapter

        ViewModelProviders.of(this)
                .get(MenuViewModel::class.java)
                .getMenuList(menuDao)
                .observe(this,
                        Observer<List<MenuModel>> { list ->
                            if (mAdapter == null)
                                mAdapter = MenuItemAdapter(list!!, this)
                        }
                )
    }
}
