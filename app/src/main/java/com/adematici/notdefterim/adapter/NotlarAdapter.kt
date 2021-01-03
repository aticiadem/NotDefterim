package com.adematici.notdefterim.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adematici.notdefterim.view.NotDetayActivity
import com.adematici.notdefterim.databinding.RecyclerViewRowBinding
import com.adematici.notdefterim.model.NotlarModel

class NotlarAdapter(private val mContext: Context, private val notListesi: ArrayList<NotlarModel>) : RecyclerView.Adapter<NotlarAdapter.NotlarViewHolder>() {

    val intent = Intent(mContext.applicationContext, NotDetayActivity::class.java)

    class NotlarViewHolder(val itemBinding: RecyclerViewRowBinding) : RecyclerView.ViewHolder(itemBinding.root){
    }

    override fun getItemCount(): Int {
        return notListesi.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotlarViewHolder {
        val binding = RecyclerViewRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotlarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotlarViewHolder, position: Int) {
        holder.itemBinding.tvBaslik.text = notListesi[position].not_baslik
        holder.itemBinding.tvBaslik.setOnClickListener {
            intent.putExtra("pozisyon",notListesi[position].not_id)
            mContext.startActivity(intent)
        }
    }

}