package com.example.demo23.network

import com.example.demo23.model.Repo
import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubService {

    @GET("/users/{user}/repos")
    suspend fun getRepos(@Path("user") userId: String): List<Repo>


    @GET("/users/{user}")
    suspend fun getUser(@Path("user") userId: String): User
}