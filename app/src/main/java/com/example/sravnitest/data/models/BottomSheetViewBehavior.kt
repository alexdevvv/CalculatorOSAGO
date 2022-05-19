package com.example.sravnitest.data.models

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import com.example.sravnitest.R
import com.example.sravnitest.data.models.FieldType.*

class BottomSheetViewBehavior(private val view: View, private val context: Context) {

    private val questionsDataMap = mapOf(
        CITY_REGISTRATION to Pair(
            context.resources.getString(R.string.city_of_registaration),
            context.resources.getString(R.string.hint_city_of_registaration)
        ),
        POWER_CAR to Pair(
            context.resources.getString(R.string.power_car),
            context.resources.getString(R.string.hint_power_car)
        ),
        DRIVERS_COUNT to Pair(
            context.resources.getString(R.string.number_of_drivers),
            context.resources.getString(R.string.hint_number_of_drivers)
        ),
        MIN_AGE to Pair(
            context.resources.getString(R.string.age_of_the_youngest_friver),
            context.resources.getString(R.string.hint_age_of_the_youngest_friver)
        ),
        MIN_EXPERIENCE to Pair(
            context.resources.getString(R.string.min_experience_drivers),
            context.resources.getString(R.string.hint_min_experience_drivers)
        ),
        YEARS_NOT_INCIDENT to Pair(
            context.resources.getString(R.string.count_years_no_accidents),
            context.resources.getString(R.string.hint_count_years_no_accidents)
        )
    )

    fun setTitle(fieldType: FieldType) {
        initViews(questionsDataMap[fieldType]!!, context)
    }

    private fun initViews(pair: Pair<String, String>, context: Context) {
        view.findViewById<TextView>(R.id.title_tv).text = pair.first
        val dataEditText =  view.findViewById<EditText>(R.id.enter_user_data_et)
        dataEditText.hint = pair.second
        setCursorInEditTest()
        showKeyboard(context, dataEditText)

    }

    private fun setCursorInEditTest(){
        view.findViewById<EditText>(R.id.enter_user_data_et).requestFocus()

    }

    private fun showKeyboard(context: Context, view: EditText){
        val imm: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view.findViewById(R.id.enter_user_data_et), 0)
    }

}