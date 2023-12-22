package com.capston.touventure.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.capston.touventure.data.response.CategoryResponseItem
import com.capston.touventure.databinding.ItemRecommendationBinding


class ListRecommendationAdapter : ListAdapter<CategoryResponseItem, ListRecommendationAdapter.MyViewHolder>(DIFF_CALLBACK) {

    class MyViewHolder(private val binding: ItemRecommendationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dataItem : CategoryResponseItem) {
            binding.tvNama.text = dataItem.name
            binding.tvCategory.text = dataItem.category
            binding.tvRating.text = dataItem.ratingAve

//            itemView.setOnClickListener {
//                val intentDetail = Intent(itemView.context, DetailActivity::class.java)
//                intentDetail.putExtra(DetailActivity.EXTRA_ID, listStory.id )
//                itemView.context.startActivity(intentDetail , ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity).toBundle())
//            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRecommendationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val story = getItem(position)
        holder.bind(story)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CategoryResponseItem>() {
            override fun areItemsTheSame(oldItem: CategoryResponseItem, newItem: CategoryResponseItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: CategoryResponseItem, newItem: CategoryResponseItem): Boolean {
                return oldItem == newItem
            }
        }
    }

}