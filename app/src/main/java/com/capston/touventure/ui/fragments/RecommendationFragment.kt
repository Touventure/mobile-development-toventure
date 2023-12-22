package com.capston.touventure.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.capston.touventure.data.model.ResultState
import com.capston.touventure.databinding.FragmentRecommendationBinding
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody

class RecommendationFragment : Fragment() {


    private lateinit var binding : FragmentRecommendationBinding

    private val viewModel by viewModels<HomeViewModel>()

    private val viewModelCategory by viewModels<CategoryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecommendationBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireActivity())
        binding.rvListStory.layoutManager = layoutManager

        val itemDecoration = DividerItemDecoration(requireActivity(), layoutManager.orientation)
        binding.rvListStory.addItemDecoration(itemDecoration)

        val bundle = arguments
        val id = bundle!!.getDouble("id")
        val ratingCount = bundle!!.getDouble("ratingCount")
        val ratingEve = bundle!!.getDouble("ratingEve")
        val nautical = bundle!!.getDouble("nautical")
        val culture = bundle!!.getDouble("culture")
        val nature = bundle!!.getDouble("natureReserve")
        val shopping = bundle!!.getDouble("shoppingCenter")
        val place = bundle!!.getDouble("placeOfWorkship")
        val amusement = bundle!!.getDouble("amusement")

//        Create a JSON string from the gathered values
        val jsonString = """
        {
            "id": ${id.toDouble()},
            "rating_count": ${ratingCount.toDouble()},
            "rating_ave": ${ratingEve.toDouble()},
            "bahari": ${nautical.toDouble()},
            "budaya": ${culture.toDouble()},
            "cagar_alam": ${nature.toDouble()},
            "pusat_perbelanjaan": ${shopping.toDouble()},
            "taman_hiburan": ${amusement.toDouble()},
            "tempat_ibadah": ${place.toDouble()}
        }
    """.trimIndent()

        // Create a RequestBody from the JSON string
        val requestBody = jsonString.toRequestBody("application/json".toMediaType())


        // Call the ViewModel method with the constructed RequestBody
        viewModelCategory.postPredict(requestBody).observe(viewLifecycleOwner){result ->
            if (result != null) {
                when (result) {
                    is ResultState.Loading -> {
//                                    showLoading(true)
                    }
                    is ResultState.Success -> {
                            val adapter = ListRecommendationAdapter()
                            val tourismData = result.data
                            adapter.submitList(tourismData)
                            binding?.rvListStory?.adapter = adapter



                    }
                    is ResultState.Error -> {
//                                    showLoading(false)
                    }

                    else -> {}
                }
            }

        }
    }
}