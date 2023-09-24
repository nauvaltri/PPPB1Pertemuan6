package com.example.latihanmandiri

import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.latihanmandiri.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var JenisTiket: Array<String>
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        JenisTiket = resources.getStringArray(R.array.kelas)

        with(binding){
            val adapterType = ArrayAdapter(this@MainActivity2, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,JenisTiket)
            spinnerTicketType.adapter = adapterType

            val selectedDate = "${datePicker.dayOfMonth}-${datePicker.month+1}-${datePicker.year}"

            var selectedTime = ""
            timePicker.setOnTimeChangedListener{
                    view, hourOfDay, minute ->
                selectedTime = "$hourOfDay : $minute"
            }
            btnBookTicket.setOnClickListener{
                Toast.makeText(this@MainActivity2," Selamat Tiket Pesawat Sudah Terpesan ! ", android.widget.Toast.LENGTH_LONG).show()
                Toast.makeText(this@MainActivity2," Kelas ${spinnerTicketType.selectedItem.toString()} pada $selectedDate pukul $selectedTime" , android.widget.Toast.LENGTH_LONG).show()

            }



        }
    }
}