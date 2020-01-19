package com.mindorks.kotlinFlowMVVM.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.kotlinFlowMVVM.R
import com.mindorks.kotlinFlowMVVM.model.DataItem
import com.mindorks.kotlinFlowMVVM.util.inflate
import com.mindorks.kotlinFlowMVVM.util.loadUrl
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