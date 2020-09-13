package com.example.demo23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.example.demo23.ui.main.MainFragment
import com.example.demo23.ui.main.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_fragment)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        text_message.text = "hi"
        // TODO: Don't commit to repo a todo like this


        Log.e("NJW", "num items")

        val nameString = viewModel.getFirstRepoName()
        text_message.text = nameString
    }
}