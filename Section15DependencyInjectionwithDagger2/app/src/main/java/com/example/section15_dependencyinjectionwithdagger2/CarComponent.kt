package com.example.section15_dependencyinjectionwithdagger2

import dagger.Component

@Component
interface CarComponent {

    fun getCar(): Car


}