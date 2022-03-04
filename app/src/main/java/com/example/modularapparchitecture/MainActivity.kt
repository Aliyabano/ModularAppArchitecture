package com.example.modularapparchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.calculator.MyClass
import com.example.modularapparchitecture.databinding.ActivityCalcButtonBinding
import com.example.modularapparchitecture.databinding.ActivityMainBinding
import com.example.modularapparchitecture.databinding.EditLytBinding
import com.example.modularapparchitecture.databinding.ResultLytBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var edtNumOne: EditLytBinding
    lateinit var edtNumTwo: EditLytBinding
    lateinit var btnAdd: ActivityCalcButtonBinding
    lateinit var btnSub: ActivityCalcButtonBinding
    lateinit var btnMulti: ActivityCalcButtonBinding
    lateinit var txtTotal: ResultLytBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        edtNumOne = EditLytBinding.inflate(layoutInflater)
        edtNumTwo = EditLytBinding.inflate(layoutInflater)
        btnAdd = ActivityCalcButtonBinding.inflate(layoutInflater)
        btnSub = ActivityCalcButtonBinding.inflate(layoutInflater)
        btnMulti = ActivityCalcButtonBinding.inflate(layoutInflater)
        txtTotal = ResultLytBinding.inflate(layoutInflater)

        binding.inputLyt.addView(edtNumOne.inputEdt)
        edtNumOne.inputEdt.hint = "Enter First Number"
        binding.inputLyt.addView(edtNumTwo.inputEdt)
        edtNumTwo.inputEdt.hint = "Enter Second Number"
        binding.inputLyt.addView(txtTotal.txtTotal)
        txtTotal.txtTotal
            .text = "Total Result Here"
        binding.inputLyt.addView(btnAdd.btnAdd)
        btnAdd.btnAdd.text = "Addition"
        binding.inputLyt.addView(btnMulti.btnAdd)
        btnMulti.btnAdd.text = "Multiplication"
        binding.inputLyt.addView(btnSub.btnAdd)
        btnSub.btnAdd.text = "Subtraction"

        val myClass = MyClass()

        btnMulti.btnAdd.setOnClickListener {

            val numA = edtNumOne.inputEdt.text.toString().toInt()
            val numB = edtNumOne.inputEdt.text.toString().toInt()

            val result = myClass.multiNum(numA,numB)
            txtTotal.txtTotal.text ="Total: $result"
        }

        btnAdd.btnAdd.setOnClickListener {

            val numA = edtNumOne.inputEdt.text.toString().toInt()
            val numB = edtNumOne.inputEdt.text.toString().toInt()

            val result = myClass.addNum(numA,numB)
            txtTotal.txtTotal.text ="Total: $result"
        }

        btnSub.btnAdd.setOnClickListener {

            val numA = edtNumOne.inputEdt.text.toString().toInt()
            val numB = edtNumOne.inputEdt.text.toString().toInt()

            val result = myClass.subNum(numA,numB)
            txtTotal.txtTotal.text ="Total: $result"
        }

    }
}