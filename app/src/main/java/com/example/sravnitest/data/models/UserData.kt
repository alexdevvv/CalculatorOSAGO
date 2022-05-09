package com.example.sravnitest.data.models

object UserData {
    var cityRegistration: String = ""
    var powerCar: String = ""
    var driversCount: String = ""
    var minAge: String = ""
    var minExperience: String = ""
    var yearsNotIncident: String = ""

    fun clear() {
        cityRegistration = ""
        powerCar = ""
        driversCount = ""
        minAge = ""
        minExperience = ""
        yearsNotIncident = ""
    }

    fun fieldList(): List<Pair<String, String>>{
        val list = mutableListOf<Pair<String, String>>()
        list.add(Pair("cityRegistration", cityRegistration))
        list.add(Pair("powerCar", powerCar))
        list.add(Pair("driversCount", driversCount))
        list.add(Pair("minAge", minAge))
        list.add(Pair("minExperience", minExperience))
        list.add(Pair("yearsNotIncident", yearsNotIncident))
        return list
    }
}