package com.example.newarchitecture.utils.validation

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateValidation {
    fun getDateFromString(stringDate: String): String {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        var date: Date? = null
        try {
            date = format.parse(stringDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return SimpleDateFormat("dd-MMM-yyyy").format(date)
    }

    fun getDateAndDayFromString(stringDate: String): String {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        var date: Date? = null
        try {
            date = format.parse(stringDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return SimpleDateFormat("dd-MMM EEEE").format(date)
    }

    fun getStartEndDate(stringStartDate: String, stringEndDate: String): String {
        val formate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())

        var startDate: Date? = null
        var endDate: Date? = null
        var startEndDate: String? = null

        try {
            startDate = formate.parse(stringStartDate)
            endDate = formate.parse(stringEndDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        startEndDate = SimpleDateFormat("dd MMM").format(startDate) + " - " + SimpleDateFormat("dd MMM yyyy").format(endDate)

        return startEndDate
    }

    fun getDDMMFromTString(stringDate: String): String {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        var date: Date? = null
        try {
            date = format.parse(stringDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return SimpleDateFormat("dd-MMM").format(date)
    }

    fun getTDateFromDDMMMYYYY(stringDate: String): String {
        val format = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
        var date: Date? = null
        try {
            date = format.parse(stringDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date)
    }

    fun getDateCurrentTimeZone(): String {
        try {
            val sdf = SimpleDateFormat("dd-MMM-yyyy HH:mm:ss")
            val currentDateandTime = sdf.format(Date())
            return currentDateandTime
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }

    fun getDAYFromTodayDATE(stringDate: String): String {
        return SimpleDateFormat("EEEE").format(Calendar.getInstance().time)
    }

    fun getDateFromTimeStamp(timeStamp: String): String {
        val formatter = SimpleDateFormat("dd - MMM - yyyy HH:mm");
        val dateString = formatter.format(Date((timeStamp.toLong())))
        return dateString
    }
}