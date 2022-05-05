package com.example.sravnitest.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.sravnitest.R
import com.example.sravnitest.databinding.FragmentGeneralBinding

class GeneralFragment : Fragment(R.layout.fragment_general) {
    private val binding: FragmentGeneralBinding by viewBinding()
    private var isVisibleMenu = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        visibilityCalculateMenu()

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
}