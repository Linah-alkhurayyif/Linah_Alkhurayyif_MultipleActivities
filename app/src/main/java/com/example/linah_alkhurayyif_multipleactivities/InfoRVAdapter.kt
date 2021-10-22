package com.example.linah_alkhurayyif_multipleactivities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

class InfoRVAdapter( private val infoList: List<UserInfo>):  RecyclerView.Adapter<InfoRVAdapter.ItemViewHolder>(){
    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var info = infoList[position]

        holder.itemView.apply {
            var star = ""
            for(i in info.password){
                star+="*"
            }
            name_tv.text = "Name: "+info.name
            location_tv.text = "Location: "+ info.location
            phoneNumber_tv.text = "Phone Number: "+info.phone
            password_tv.text = "Password: "+star

            show_pw.setOnClickListener(View.OnClickListener {
                password_tv.text = "password: "+ info.password
                hidden_pw.isVisible=true
                show_pw.isVisible=false
            })
            hidden_pw.setOnClickListener(View.OnClickListener {
                password_tv.text = "password: "+ star
                hidden_pw.isVisible=false
                show_pw.isVisible=true
            })
        }
    }
    override fun getItemCount() = infoList.size
}