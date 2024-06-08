package com.example.cinemate.di

import com.example.cinemate.data.CinemateRepository

object Injection {
    fun provideRepository(): CinemateRepository {
        return CinemateRepository.getInstance()
    }
}