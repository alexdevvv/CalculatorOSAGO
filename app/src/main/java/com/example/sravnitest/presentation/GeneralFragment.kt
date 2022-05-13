package com.example.sravnitest.presentation

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.sravnitest.R
import com.example.sravnitest.databinding.FragmentGeneralBinding

class GeneralFragment : Fragment(R.layout.fragment_general) {
    private val binding: FragmentGeneralBinding by viewBinding()
    private var isVisibleMenu = false
    lateinit var viewModel: GeneralFragmentViewModel
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var genStringArray: Array<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(GeneralFragmentViewModel::class.java)
        visibilityCalculateMenu()
        genStringArray = resources.getStringArray(R.array.string_array_gen_user_dataLayout)
        initAdapter()
        initItemClickListenerForListView()
    }

    private fun initAdapter(){
        adapter = ArrayAdapter(requireContext(), R.layout.item_general_layout, R.id.text_view, genStringArray)
        binding.listViewUserDataLayout.adapter = adapter
    }

    private fun initItemClickListenerForListView(){
        binding.listViewUserDataLayout.setOnItemClickListener { adapterView, view, position, id ->
           val arg =  selectedFun(position)

            findNavController().navigate(
                R.id.action_generalFragment_to_inputDialogFragment, bundleOf(
                    Pair("parameter", arg)))
        }
    }

    private fun selectedFun(position: Int): String{
        var rsl = when(position){
            0 -> "cityRegistration"
            1 -> "powerCar"
            2 -> "driversCount"
            3 -> "minAge"
            4 -> "minExperience"
            5 -> "yearsNotIncident"
            else -> Toast.makeText(requireContext(), "Ошибка выбора элемента", Toast.LENGTH_LONG).show()
        }
        return rsl.toString()
    }

    private fun visibilityCalculateMenu() {
        binding.layout1.outlineExpandIv.setOnClickListener {
            if (isVisibleMenu) {
                binding.layout1.layoutBT.isVisible = false
                binding.layout1.layoutKBC.isVisible = false
                binding.layout1.layoutKBM.isVisible = false
                binding.layout1.layoutKM.isVisible = false
                binding.layout1.layoutKO.isVisible = false
                binding.layout1.layoutKT.isVisible = false
                binding.layout1.outlineExpandIv.setImageResource(R.drawable.outline_expand_more_24)
                isVisibleMenu = false

            } else {
                binding.layout1.layoutBT.isVisible = true
                binding.layout1.layoutKBC.isVisible = true
                binding.layout1.layoutKBM.isVisible = true
                binding.layout1.layoutKM.isVisible = true
                binding.layout1.layoutKO.isVisible = true
                binding.layout1.layoutKT.isVisible = true
                binding.layout1.outlineExpandIv.setImageResource(R.drawable.outline_expand_less_24)
                isVisibleMenu = true
            }
        }
    }


//    fun listenerCityRegistrationButton() {
//        binding.layout2.cityRegistrationLayout.setOnClickListener {
//            findNavController().navigate(
//                R.id.action_generalFragment_to_inputDialogFragment, bundleOf(
//                    Pair("parameter", "cityRegistration")
//                )
//            )
//        }
//    }


}