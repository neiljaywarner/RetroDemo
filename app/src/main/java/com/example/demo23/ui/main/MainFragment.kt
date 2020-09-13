package com.example.demo23.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demo23.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view =  inflater.inflate(R.layout.main_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        text_message.text = "hi"
        // TODO: Don't commit to repo a todo like this


        val list = viewModel.getRepos()
        val firstName = list.first().name
        Log.e("NJW", "FirstName")
        Log.e("NJW", "num items: ${list.size}")

        recyclerview.adapter = RepoAdapter(viewModel.getRepos())
        return view
    }



}