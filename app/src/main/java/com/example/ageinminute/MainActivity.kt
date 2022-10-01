package com.example.ageinminute

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var tViewAge: TextView? = null
    private lateinit var btnSelectDate: Button
    private lateinit var txtDate:TextView
    private lateinit var txtMinute:TextView
    private var name:String ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tViewAge = findViewById(R.id.txt2)




        initz();
        clickListener()

    }

    @SuppressLint("SimpleDateFormat")
    private fun clickListener() {
        var myCalendar = Calendar.getInstance()
        var dayofMonth = myCalendar.get(Calendar.DAY_OF_MONTH)
        var year = myCalendar.get(Calendar.YEAR)
        var month = myCalendar.get(Calendar.MONTH)

        btnSelectDate.setOnClickListener { view->
            var datePicker = DatePickerDialog(this,{ view, i, i2, i3 ->
                val pattern = "dd/MM/yyyy"
                var date = SimpleDateFormat(pattern)
                val newDate = date.format(Date("${i2+1}/$i3/$i"))
                val selectDateInMinute = Date("${i2+1}/$i3/$i").time/60000
                val currentDateInMinute = myCalendar.timeInMillis/60000
                val calculateInMinute = currentDateInMinute-selectDateInMinute

                txtDate.text = newDate
                txtMinute.text = calculateInMinute.toString()
            },year,month,dayofMonth)

            datePicker.datePicker.maxDate = myCalendar.timeInMillis
            datePicker.show()
        }
    }

    fun initz(){
        btnSelectDate = findViewById(R.id.btnSelectDate)
        txtDate = findViewById(R.id.txtDate)
        txtMinute = findViewById(R.id.txtMinute)

    }
}