package com.mindorks.coroutinesWithRetrofit.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.coroutinesWithRetrofit.R
import com.mindorks.coroutinesWithRetrofit.model.DataItem
import com.mindorks.coroutinesWithRetrofit.util.inflate
import com.mindorks.coroutinesWithRetrofit.util.loadUrl
import kotlinx.android.synthetic.main.item_layout.view.*

class RecyclerViewAdapter(
    private val objects: ArrayList<DataItem>,
    private val listener: (DataItem) -> Unit
) :
    RecyclerView.Adapter<RecyclerViewAdapter.DataViewHolder>() {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: DataItem, listener: (DataItem) -> Unit) {
            itemView.container.setOnClickListener { listener(data) }
            itemView.textViewUserName.text = "${data.firstName} ${data.lastName}"
            itemView.imageViewAvatar.loadUrl(data.avatar)
            itemView.textViewUserEmail.text = data.email
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(parent.inflate(R.layout.item_layout))


    override fun getItemCount(): Int = objects.size
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(objects[position], listener)

    fun addData(list: ArrayList<DataItem>) {
        objects.addAll(list)
    }
}