package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var number1 = binding.editTextNumber1.text.toString().toInt()
        var number2 = binding.editTextNumber2.text.toString().toInt()


        binding.button.setOnClickListener {
            var res = sumar(number1, number2)
            binding.textViewRes.text = res.toString()
        }


    }

    private fun sumar(number1: Int, number2: Int): Int {
        return number1 + number2
    }
}