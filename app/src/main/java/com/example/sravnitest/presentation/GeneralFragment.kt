package com.example.sravnitest.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.sravnitest.R
import com.example.sravnitest.data.RetrofitClient
import com.example.sravnitest.data.models.OffersData
import com.example.sravnitest.databinding.FragmentGeneralBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import java.util.*
import javax.security.auth.callback.Callback

class GeneralFragment : Fragment(R.layout.fragment_general) {
    private val binding: FragmentGeneralBinding by viewBinding()
    private var isVisibleMenu = false
    lateinit var  viewModel: GeneralFragmentViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GeneralFragmentViewModel::class.java)
        visibilityCalculateMenu()

//        getDataFromServer()

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