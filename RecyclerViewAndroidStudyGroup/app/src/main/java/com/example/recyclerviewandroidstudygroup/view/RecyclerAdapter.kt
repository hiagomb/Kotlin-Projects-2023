package com.example.recyclerviewandroidstudygroup.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewandroidstudygroup.R
import com.example.recyclerviewandroidstudygroup.databinding.ViewHolderBinding
import com.example.recyclerviewandroidstudygroup.model.Car

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    private var _list: List<Car> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item_binding = ViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(item_binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(_list.get(position))
    }

    override fun getItemCount(): Int {
        return _list.count()
    }

    fun updateDataset(list: List<Car>){
        _list = list
        notifyDataSetChanged()
    }



    class MyViewHolder(itembinding: ViewHolderBinding) : RecyclerView.ViewHolder(itembinding.root){
        private val name = itembinding.textName
        private val brand = itembinding.textBrand

        fun bind(car: Car){
            name.text = car.name
            brand.text = car.brand
        }
    }

}