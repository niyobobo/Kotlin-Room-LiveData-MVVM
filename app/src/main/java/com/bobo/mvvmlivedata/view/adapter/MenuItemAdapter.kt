package com.bobo.mvvmlivedata.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bobo.mvvmlivedata.R
import com.bobo.mvvmlivedata.model.MenuModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.custom_menu_item.view.*

class MenuItemAdapter(private val menuList: List<MenuModel>, private val context: Context) : androidx.recyclerview.widget.RecyclerView.Adapter<MenuItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_menu_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menuModel = menuList[position]
        holder.name.text = menuModel.name
        holder.description.text = menuModel.description
        holder.price.text = context.getString(R.string.currency, menuModel.price)
        Glide.with(context)
                .load(menuModel.thumbnail)
                .into(holder.image)
    }

    class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        var name = itemView.name!!
        var description = itemView.description!!
        var price = itemView.price!!
        var image = itemView.thumbnail!!
    }
}