package com.example.recyclerviewandroidstudygroup.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewandroidstudygroup.databinding.ActivityMainBinding
import com.example.recyclerviewandroidstudygroup.model.Car

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        adapter = RecyclerAdapter()
        setContentView(binding.root)
        setRecyclerViewSettings()
    }


    private fun setRecyclerViewSettings(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        adapter.updateDataset(getMockList())
    }

    private fun getMockList(): List<Car>{

        val list = mutableListOf<Car>()
        list.add(Car("Chevrolet", "Corsa"))
        list.add(Car("Fiat", "Toro"))
        list.add(Car("Volkswagen", "Gol"))
        list.add(Car("Fiat", "Siena"))
        list.add(Car("Chevrolet", "Celta"))
        list.add(Car("Ford", "Focus"))
        list.add(Car("Chevrolet", "fsadfsdafsdaf"))
        list.add(Car("Ford", "Fiesta"))
        list.add(Car("Fiat", "Uno"))
        list.add(Car("Renault", "Logan"))
        list.add(Car("Chevrolet", "Onix"))
        list.add(Car("Volkswagen", "Saveiro"))
        list.add(Car("Renault", "Kwid"))
        list.add(Car("Fiat", "Idea"))
        list.add(Car("Renault", "Captur"))
        list.add(Car("Hyundai", "HB20"))
        list.add(Car("Chevrolet", "Prisma"))
        list.add(Car("Volkswagen", "Fusca"))
        list.add(Car("Toyota", "Corolla"))
        list.add(Car("Chevrolet", "Agile"))
        list.add(Car("Honda", "Fit"))
        list.add(Car("fsadfsadf", "fsadfsdafsdaf"))
        list.add(Car("fsadfsadf", "fsadfsdafsdaf"))
        list.add(Car("Honda", "Civic"))
        list.add(Car("Nissan", "Kicks"))
        list.add(Car("Peugeot", "207"))
        list.add(Car("Jeep", "Renegade"))
        list.add(Car("Citroen", "Picasso"))
        list.add(Car("Kia", "Picanto"))

        return list
    }


}