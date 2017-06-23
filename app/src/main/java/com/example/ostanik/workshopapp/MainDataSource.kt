package com.example.ostanik.workshopapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_main.view.*

/**
 * Created by ostanik on 2017-06-22.
 */
class MainAdapter(val listener: MainItemListener): RecyclerView.Adapter<MainViewHolder>() {
    var mockedList: List<String> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mockedList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        holder?.bind(mockedList[position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_main, parent, false)
        return MainViewHolder(view)
    }

}

class MainViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bind(content: String, listener: MainItemListener) {
        itemView.textView.text = content
        itemView.setOnClickListener {
            listener.onItemClicked(content)
        }
    }

}

interface MainItemListener {
    fun onItemClicked(content: String)
}