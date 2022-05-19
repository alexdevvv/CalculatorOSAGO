package com.example.sravnitest.data.models
import com.example.sravnitest.data.models.FieldType.*

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

    // Метод для проверки заполненности полей
    fun fieldList(): List<Pair<FieldType, String>> {
        val list = mutableListOf<Pair<FieldType, String>>()
        list.add(Pair(CITY_REGISTRATION, cityRegistration))
        list.add(Pair(POWER_CAR, powerCar))
        list.add(Pair(DRIVERS_COUNT, driversCount))
        list.add(Pair(MIN_AGE, minAge))
        list.add(Pair(MIN_EXPERIENCE, minExperience))
        list.add(Pair(YEARS_NOT_INCIDENT, yearsNotIncident))
        return list
    }


}