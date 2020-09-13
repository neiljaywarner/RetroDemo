package com.example.demo23.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demo23.model.Repo
import kotlinx.android.synthetic.main.item_repo.view.*

class RepoAdapter(private val repos: List<Repo> )
    : RecyclerView.Adapter<RepoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(view)
    }

    // https://antonioleiva.com/recyclerview-adapter-kotlin/
    // todo: Change to databinding
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(repos[position])

    override fun getItemCount(): Int = repos.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(repo: Repo) = with(itemView) {
            text1.text = repo.name

        }
    }
}
