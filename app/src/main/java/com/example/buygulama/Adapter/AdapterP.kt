package com.example.buygulama.Adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.buygulama.Data.PodcastData
import com.example.buygulama.R

class Adapter(private val imageList: ArrayList<PodcastData>, val listener:MyClickListener): RecyclerView.Adapter<Adapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView =itemView.findViewById(R.id.card_img)
        val textView: TextView =itemView.findViewById(R.id.card_text)
        val textview_2:TextView=itemView.findViewById(R.id.card_yapım)

        init {
            itemView.setOnClickListener {
                val position =adapterPosition
                listener.onClick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cardview_podcast,parent,false))
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val ex=imageList[position]
        holder.textView.text=ex.name
        holder.textview_2.text=ex.producer
        holder.image.setImageResource(ex.image)
    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
}