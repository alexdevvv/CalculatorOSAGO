package com.example.sravnitest.data

import com.example.sravnitest.data.models.OffersData
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("mobile/internship/v1/osago/startCalculation")
    fun getOffersFromServer(@Body body: List<Int>): Single<OffersData>
}