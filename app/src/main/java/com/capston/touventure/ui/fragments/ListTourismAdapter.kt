package com.capston.touventure.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.capston.touventure.data.response.DataItem
import com.capston.touventure.databinding.ItemTourismBinding


class ListTourismAdapter : ListAdapter<DataItem, ListTourismAdapter.MyViewHolder>(DIFF_CALLBACK) {

    class MyViewHolder(private val binding: ItemTourismBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dataItem : DataItem) {
            binding.tvNama.text = dataItem.data?.placeName
            binding.tvCity.text = dataItem.data?.city
            binding.tvDescription.text = dataItem.data?.description

//            itemView.setOnClickListener {
//                val intentDetail = Intent(itemView.context, DetailActivity::class.java)
//                intentDetail.putExtra(DetailActivity.EXTRA_ID, listStory.id )
//                itemView.context.startActivity(intentDetail , ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity).toBundle())
//            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemTourismBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val story = getItem(position)
        holder.bind(story)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }

}