package com.capston.touventure.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.capston.touventure.R
import com.capston.touventure.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {
    private lateinit var binding : FragmentCategoryBinding
    private val viewModel by viewModels<CategoryViewModel>()
    private var isTwenty = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ratingCount.setOnClickListener {
            // Toggle the state
            isTwenty = !isTwenty

            // Set the text based on the state
            binding.tvRatingCount.text = if (isTwenty) "20" else "0"
        }

        binding.ratingRave.setOnClickListener {
            // Toggle the state
            isTwenty = !isTwenty

            // Set the text based on the state
            binding.tvRatingEve.text = if (isTwenty) "20" else "0"
        }

        binding.nautical.setOnClickListener {
            // Toggle the state
            isTwenty = !isTwenty

            // Set the text based on the state
            binding.tvNautical.text = if (isTwenty) "20" else "0"
        }

        binding.culture.setOnClickListener {
            // Toggle the state
            isTwenty = !isTwenty

            // Set the text based on the state
            binding.tvCulture.text = if (isTwenty) "20" else "0"
        }

        binding.natureReserve.setOnClickListener {
            // Toggle the state
            isTwenty = !isTwenty

            // Set the text based on the state
            binding.tvNatureReserve.text = if (isTwenty) "20" else "0"
        }

        binding.shoppingCenter.setOnClickListener {
            // Toggle the state
            isTwenty = !isTwenty

            // Set the text based on the state
            binding.tvShopping.text = if (isTwenty) "20" else "0"
        }

        binding.placeOfWorship.setOnClickListener {
            // Toggle the state
            isTwenty = !isTwenty

            // Set the text based on the state
            binding.tvPlaceOfWorkship.text = if (isTwenty) "20" else "0"
        }

        binding.amusementPark.setOnClickListener {
            // Toggle the state
            isTwenty = !isTwenty

            // Set the text based on the state
            binding.tvAmusement.text = if (isTwenty) "20" else "0"
        }

        binding.predict.setOnClickListener {
            val id = 100.0
            val ratingCount = binding.tvRatingCount.text.toString()
            val ratingEve = binding.tvRatingEve.text.toString()
            val nautical = binding.tvNautical.text.toString()
            val culture = binding.tvCulture.text.toString()
            val natureReserve = binding.tvNatureReserve.text.toString()
            val shoppingCenter = binding.tvShopping.text.toString()
            val placeOfWorkship = binding.tvPlaceOfWorkship.text.toString()
            val amusement = binding.tvAmusement.text.toString()

            val mFragmentManager = parentFragmentManager
            val mFragmentTransaction = mFragmentManager.beginTransaction()
            val mFragment = RecommendationFragment()
            val mBundle = Bundle()
            mBundle.putDouble("id", 100.0)
            mBundle.putDouble("ratingCount",ratingCount.toDouble())
            mBundle.putDouble("ratingEve",ratingEve.toDouble())
            mBundle.putDouble("nautical",nautical.toDouble())
            mBundle.putDouble("culture",culture.toDouble())
            mBundle.putDouble("natureReserve",natureReserve.toDouble())
            mBundle.putDouble("shoppingCenter",shoppingCenter.toDouble())
            mBundle.putDouble("placeOfWorkship",placeOfWorkship.toDouble())
            mBundle.putDouble("amusement",amusement.toDouble())
            mFragment.arguments = mBundle
            mFragmentTransaction.replace(R.id.frame, mFragment).commit()
        }
    }
}