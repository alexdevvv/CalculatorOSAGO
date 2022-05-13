package com.example.sravnitest.presentation

import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.sravnitest.R
import com.example.sravnitest.data.models.UserData
import com.example.sravnitest.databinding.FragmentInputDialogBinding

class InputDialogFragment : Fragment(R.layout.fragment_input_dialog) {

    private val binding: FragmentInputDialogBinding by viewBinding()
    val navArgs by navArgs<InputDialogFragmentArgs>()
    var currentParameter = ""
    var idFragment = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentParameter = navArgs.parameter
        initDataFragment(currentParameter)
        initNextButton()

    }

    private fun initNextButton(){
        binding.nextBt.setOnClickListener{
            saveUserDataToModel(currentParameter)

            Log.e("cityRegistration", UserData.cityRegistration)
            Log.e("powerCar", UserData.powerCar)
            Log.e("minAge", UserData.minAge)
        }
    }

    private fun saveUserDataToModel(args: String){
        when(args){
            "cityRegistration" -> UserData.cityRegistration = binding.enterUserDataEt.text.toString()
            "powerCar" -> UserData.powerCar = binding.enterUserDataEt.text.toString()
            "driversCount" -> UserData.driversCount = binding.enterUserDataEt.text.toString()
            "minAge" -> UserData.minAge = binding.enterUserDataEt.text.toString()
            "minExperience" -> UserData.minExperience = binding.enterUserDataEt.text.toString()
            "yearsNotIncident" -> UserData.yearsNotIncident = binding.enterUserDataEt.text.toString()
        }
    }

    private fun initDataFragment(args: String) {
        val data = UserData.getQuestionsDataMap().filter {
            it.key == args
        }
        binding.infoTv.text = data.get(args)?.first
        binding.enterUserDataEt.hint = data.get(args)?.second
        definingDataTypesForInput(args)

    }

    private fun definingDataTypesForInput(args: String) {
        with(binding.enterUserDataEt) {
            inputType = if (args == "cityRegistration") {
                InputType.TYPE_TEXT_FLAG_CAP_WORDS
            } else {
                InputType.TYPE_CLASS_NUMBER
            }
        }
    }

}