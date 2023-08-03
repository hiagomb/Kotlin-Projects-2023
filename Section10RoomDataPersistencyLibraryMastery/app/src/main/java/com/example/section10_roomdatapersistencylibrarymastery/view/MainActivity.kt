package com.example.section10_roomdatapersistencylibrarymastery.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.section10_roomdatapersistencylibrarymastery.R
import com.example.section10_roomdatapersistencylibrarymastery.adapter.RecyclerAdapter
import com.example.section10_roomdatapersistencylibrarymastery.databinding.ActivityMainBinding
import com.example.section10_roomdatapersistencylibrarymastery.db.MyDB
import com.example.section10_roomdatapersistencylibrarymastery.db.Subscriber
import com.example.section10_roomdatapersistencylibrarymastery.repository.SubscriberRepository
import com.example.section10_roomdatapersistencylibrarymastery.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var adapter: RecyclerAdapter
    private lateinit var subscriber: Subscriber

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        binding.btnClear.setOnClickListener(this)
        binding.btnSave.setOnClickListener(this)
        setRecyclerView()
        viewModel.getAll()
        setObservers()
    }

    override fun onClick(v: View) {
        if(v.id == R.id.btn_save){
            if(binding.btnSave.text.equals("Save")){
                handleSaveOrUpdate(null)
            }else{
                handleSaveOrUpdate(subscriber)
            }

        }else if(v.id == R.id.btn_clear){
            if(binding.btnClear.text.equals("Clear All")){
                handleClearAllOrDelete(null)
            }else{
                handleClearAllOrDelete(subscriber)
            }

        }
    }

    private fun handleSaveOrUpdate(subscriber: Subscriber?){
        if(subscriber == null){
            viewModel.insert(Subscriber(0, binding.inputName.text.toString(), binding.inputEmail.text.toString()))
        }else{
            viewModel.update(
                Subscriber(subscriber.id, binding.inputName.text.toString(),
                binding.inputEmail.text.toString())
            )
        }
        setFields()
    }

    private fun setFields(){
        binding.inputName.text?.clear()
        binding.inputEmail.text?.clear()
        binding.inputName.requestFocus()
        binding.btnSave.setText("Save")
        binding.btnClear.setText("Clear All")
    }

    private fun handleClearAllOrDelete(subscriber: Subscriber?){
        if(subscriber == null){
            viewModel.clearAll()
        }else{
            viewModel.delete(subscriber)
        }
        setFields()
    }

    private fun setRecyclerView(){
        binding.recyclerSubs.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerAdapter { selectedItem -> listItemClickEvent(selectedItem) }
        binding.recyclerSubs.adapter = adapter
    }

    private fun listItemClickEvent(subscriber: Subscriber){
        binding.inputName.setText(subscriber.name)
        binding.inputEmail.setText(subscriber.email)
        binding.btnSave.setText("Update")
        binding.btnClear.setText("Delete")
        this.subscriber = subscriber
    }

    private fun setObservers(){
        viewModel.subscribers.observe(this){
            adapter.updateData(it)
        }
        viewModel.id_result.observe(this){
            if(it > 0){
                viewModel.getAll()
            }
        }
    }



}