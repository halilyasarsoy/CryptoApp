package com.halil.cryptoapp.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.halil.cryptoapp.databinding.RecyclerLayoutViewBinding
import com.halil.cryptoapp.model.home.Data

class HomeRecyclerAdapter(private val listener: ItemClickListener) :
    RecyclerView.Adapter<HomeRecyclerAdapter.MViewHolder>() {

    private var coins = emptyList<Data>()

    class MViewHolder(private val binding: RecyclerLayoutViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: ItemClickListener, coin: Data) {
            binding.onItemClickListener = listener
            binding.coin = coin
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecyclerLayoutViewBinding.inflate(layoutInflater, parent, false)
                return MViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MViewHolder.from(parent)

    override fun getItemCount() = coins.size

    override fun onBindViewHolder(holder: MViewHolder, position: Int) =
        holder.bind(listener, coins[position])

    @SuppressLint("NotifyDataSetChanged")
    fun setList(newList: List<Data>) {
        coins = newList
        notifyDataSetChanged()
    }
}