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


    fun fieldList(): List<Pair<String, String>> {
        val list = mutableListOf<Pair<String, String>>()
        list.add(Pair("cityRegistration", cityRegistration))
        list.add(Pair("powerCar", powerCar))
        list.add(Pair("driversCount", driversCount))
        list.add(Pair("minAge", minAge))
        list.add(Pair("minExperience", minExperience))
        list.add(Pair("yearsNotIncident", yearsNotIncident))
        return list
    }

    fun getQuestionsDataMap(): Map<String, Pair<String, String>> {
        val questionsDataMap = mapOf(
            "cityRegistration" to Pair("Город регистрации собственника", "Введите город регистрации"),
            "powerCar" to Pair("Мощность автомобиля", "Введите мощность авто"),
            "driversCount" to Pair("Количество водителей", "Введите к-во водителей"),
            "minAge" to Pair("Возраст мдладшего из водителей", "Введите возраст младшего воителя"),
            "minExperience" to Pair("Минимальный стаж вождения", "Введите минимальный стаж"),
            "yearsNotIncident" to Pair("Сколько лет не было аварий", "Введите сколько лет не было аварий"),
        )
        return questionsDataMap
    }
}