package com.example.retrofitt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitt.databinding.ItemlayoutBinding
import com.example.retrofitt.models.UsersItem
import java.nio.file.attribute.UserDefinedFileAttributeView

class RvAdapter(private val userList: List<UsersItem>):RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemlayoutBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemlayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
       return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem=userList[position]
        holder.binding.apply {
            tvId.text = "Id: ${currentItem.id}"
            tvUserId.text = "User Id: ${currentItem.userId}"
            tvTitle.text = "Title: ${currentItem.title}"
            tvBody.text = "Body: ${currentItem.body}"
        }
    }


}