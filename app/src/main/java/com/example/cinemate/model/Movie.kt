package com.example.cinemate.model

data class Movie(
    val id: Long,
    val poster: Int,
    val release: String,
    val rating: String,
    val country: String,
    val duration: String,
    val title: String,
    val genre1: String,
    val genre2: String,
    val synopsys: String,
)