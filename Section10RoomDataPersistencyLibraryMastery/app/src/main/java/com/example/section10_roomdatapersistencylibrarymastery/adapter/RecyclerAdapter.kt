package com.example.section10_roomdatapersistencylibrarymastery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.section10_roomdatapersistencylibrarymastery.R
import com.example.section10_roomdatapersistencylibrarymastery.databinding.ViewHolderSubscriberBinding
import com.example.section10_roomdatapersistencylibrarymastery.db.Subscriber
import com.google.android.material.textfield.TextInputEditText

class RecyclerAdapter(private val clickListener: (subscriber: Subscriber)-> Unit): RecyclerView.Adapter<MyViewHolder>() {

    private var _list: List<Subscriber> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ViewHolderSubscriberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(_list.get(position), clickListener)

    }

    override fun getItemCount(): Int {
        return _list.count()
    }

    fun updateData(list: List<Subscriber>){
        _list = list
        notifyDataSetChanged()
    }

}

class MyViewHolder(val itemBinding: ViewHolderSubscriberBinding) : RecyclerView.ViewHolder(itemBinding.root){

    private val name = itemBinding.txtName
    private val email = itemBinding.txtEmail

    fun bind(subscriber: Subscriber, clickListener: (subscriber: Subscriber) -> Unit){
        name.text = subscriber.name
        email.text = subscriber.email
        itemBinding.root.setOnClickListener{clickListener(subscriber)}
    }
}


