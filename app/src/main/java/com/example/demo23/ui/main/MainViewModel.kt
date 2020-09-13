package com.example.demo23.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo23.model.Repo
import com.example.demo23.network.GitHubService
import com.example.demo23.network.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    fun getRepos() : List<Repo> {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val gitHubService = retrofit.create(GitHubService::class.java)
        var firstRepoName = ""
        var listRepos: List<Repo> = emptyList()
        viewModelScope.launch() {
            try {
                listRepos = gitHubService.getRepos("neiljaywarner")
                Log.e("NJW", "user = ${listRepos.first().name}")
                Log.e("NJW", "user = ${listRepos.size}")
                firstRepoName = listRepos.first().name
            } catch (httpException: HttpException) {
                Log.e("NJW", "error code = ${httpException.code()}; ${httpException.message()}")
            } catch (exception: Exception) {
                Log.e("NJW", "error code =${exception.message}}")
            }
        }
        return listRepos
    }
}