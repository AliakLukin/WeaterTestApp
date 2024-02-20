package com.example.data.model

data class CityResposne(
    val coord: CoordResponse,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val timezone: Int
)