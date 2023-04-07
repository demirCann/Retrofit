package com.demircandemir.retrofitkotlin.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.demircandemir.retrofitkotlin.R
import com.demircandemir.retrofitkotlin.databinding.RecyclerRowBinding
import com.demircandemir.retrofitkotlin.model.CryptoModel

class RecyclerViewAdapter(private val cryptoList : ArrayList<CryptoModel>, private val listener : Listener) :
    RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    interface Listener {
        fun onItemClick(crytpoModel: CryptoModel)
    }

    private val colors : Array<String> = arrayOf("#f8db5e", "#ee5727", "#572735", "#004440", "#f1cbff")

    class RowHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(crytpoModel: CryptoModel, colors : Array<String>, position: Int, listener: Listener){

            itemView.setOnClickListener {
                listener.onItemClick(crytpoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 5]))
            binding.textName.text = crytpoModel.currency
            binding.textPrice.text = crytpoModel.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position], colors, position, listener)
    }
}