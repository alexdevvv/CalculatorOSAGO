package com.example.sravnitest.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.sravnitest.R

class InputDialogFragment : Fragment(R.layout.fragment_input_dialog) {

    val navArgs by navArgs<InputDialogFragmentArgs>()
    var currentParameter = ""
    val titlesMap = mapOf<String, Pair<String, String>>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         currentParameter =  navArgs.parameter

    }

    private fun initTitlesMap(){

    }





}