package com.example.section15_dependencyinjectionwithdagger2

import javax.inject.Inject


class Car @Inject constructor(val engineInstance: Engine){

    init {
        startCar()
    }


     fun startCar(){

    }




}