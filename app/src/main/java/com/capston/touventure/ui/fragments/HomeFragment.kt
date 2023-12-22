package com.capston.touventure.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.capston.touventure.data.model.ResultState
import com.capston.touventure.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireActivity())
        binding.rvListStory.layoutManager = layoutManager

        val itemDecoration = DividerItemDecoration(requireActivity(), layoutManager.orientation)
        binding.rvListStory.addItemDecoration(itemDecoration)

        viewModel.getTourism().observe(viewLifecycleOwner){ result ->
            if (result != null) {
                            when (result) {
                                is ResultState.Loading -> {
                                    showLoading(true)
                                }
                                is ResultState.Success -> {
                                    showLoading(false)
                                    val adapter = ListTourismAdapter()
                                    val tourismData = result.data.data
                                    adapter.submitList(tourismData)
                                    binding?.rvListStory?.adapter = adapter

//                                    val mFragmentManager = supportFragmentManager
//                                    val mFragmentTransaction = mFragmentManager.beginTransaction()
//                                    val mFragment = DashboardFragment()
//                                    val mBundle = Bundle()
//                                    mBundle.putString("textAqiu",result.data.data.current?.pollution?.aqius.toString())
//                                    mBundle.putString("textCity",result.data.data.city.toString())
//                                    mBundle.putString("textState",result.data.data.state.toString())
//                                    mFragment.arguments = mBundle
//                                    mFragmentTransaction.replace(R.id.frame, mFragment).commit()

                                }
                                is ResultState.Error -> {
                                    showLoading(false)
                                }

                                else -> {}
                            }
                        }
        }
    }

    private fun showLoading(state: Boolean) {
            binding.progressBar.visibility = if (state) View.VISIBLE else View.GONE
        }
}