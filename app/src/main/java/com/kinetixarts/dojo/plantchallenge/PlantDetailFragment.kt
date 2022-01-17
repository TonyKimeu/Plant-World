package com.kinetixarts.dojo.plantchallenge

import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.kinetixarts.dojo.plantchallenge.databinding.FragmentHomeBinding
import com.kinetixarts.dojo.plantchallenge.databinding.PlantDetailFragmentBinding

class PlantDetailFragment : Fragment() {

    private var _binding: PlantDetailFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = PlantDetailFragment()
    }

    private lateinit var viewModel: PlantDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().window.statusBarColor = resources.getColor(R.color.primary)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = PlantDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PlantDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        clearToolbarMenu()
    }

    fun clearToolbarMenu() {
        binding.toolbar.menu.clear()
    }

}