package com.example.calculator_v2

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator_v2.databinding.ActivityMainBinding
import com.example.calculator_v2.Display
import com.example.calculator_v2.Calculate

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view = binding.root
        setContentView(view)
    }
    enum class Operation {
        ONE, TWO, THREE, FOUR, FIVE,
        SIX, SEVEN, EIGHT, NINE, DEL,
        AC, PLUS, MINUS, MULT, DIV,
        BRACKET_L, BRACKET_R, DOT, EQUAL, ZERO
    }
    fun getButton(value: View){
        val buttons = mapOf(
            binding.buttonOne to Operation.ONE,
            binding.buttonTwo to Operation.TWO,
            binding.buttonThree to Operation.THREE,
            binding.buttonFour to Operation.FOUR,
            binding.buttonFive to Operation.FIVE,
            binding.buttonSix to Operation.SIX,
            binding.buttonSeven to Operation.SEVEN,
            binding.buttonEight to Operation.EIGHT,
            binding.buttonNine to Operation.NINE,
            binding.buttonDel to Operation.DEL,
            binding.buttonAC to Operation.AC,
            binding.buttonPlus to Operation.PLUS,
            binding.buttonMinus to Operation.MINUS,
            binding.buttonMult to Operation.MULT,
            binding.buttonDiv to Operation.DIV,
            binding.buttonLBracket to Operation.BRACKET_L,
            binding.buttonRBracket to Operation.BRACKET_R,
            binding.buttonDot to Operation.DOT,
            binding.buttonEqual to Operation.EQUAL,
            binding.buttonZero to Operation.ZERO,
        )
        buttons[value]?.let { handleOperation(it) }
    }
    fun handleOperation(value: Operation){

        when(value){
            Operation.ONE -> handleOne()
            Operation.TWO -> handleTwo()
            Operation.THREE -> handleThree()
            Operation.FOUR -> handleFour()
            Operation.FIVE -> handleFive()
            Operation.SIX -> handleSix()
            Operation.SEVEN -> handleSeven()
            Operation.EIGHT -> handleEight()
            Operation.NINE -> handleNine()
            Operation.DEL -> handleDel()
            Operation.AC -> handleAC()
            Operation.PLUS -> handlePlus()
            Operation.MINUS -> handleMinus()
            Operation.MULT -> handleMult()
            Operation.DIV -> handleDiv()
            Operation.BRACKET_L -> handleBracketL()
            Operation.BRACKET_R -> handleBracketR()
            Operation.DOT -> handleDot()
            Operation.EQUAL -> handleEqual()
            Operation.ZERO -> handleZero()
        }
    }

    private fun handleZero() {
        binding.editTextText2.setText(Display.getZero())
    }

    private fun handleEqual() {
        var res = Calculate().calculate(Display.getEqual())
        binding.editTextText2.setText(res)
        Display.change_res(res)

    }

    private fun handleDot() {
        binding.editTextText2.setText(Display.getDot())
    }

    private fun handleBracketR() {
        binding.editTextText2.setText(Display.getBracketR())
    }

    private fun handleBracketL() {
        binding.editTextText2.setText(Display.getBracketL())
    }

    private fun handleDiv() {
        binding.editTextText2.setText(Display.getDiv())
    }

    private fun handleMult() {
        binding.editTextText2.setText(Display.getMult())
    }

    private fun handleMinus() {
        binding.editTextText2.setText(Display.getMinus())
    }

    private fun handlePlus() {
        binding.editTextText2.setText(Display.getPlus())
    }

    private fun handleAC() {
        binding.editTextText2.setText(Display.getAC())
    }

    private fun handleDel() {
        binding.editTextText2.setText(Display.getDel())
    }

    private fun handleNine() {
        binding.editTextText2.setText(Display.getNine())
    }

    private fun handleEight() {
        binding.editTextText2.setText(Display.getEight())
    }

    private fun handleSeven() {
        binding.editTextText2.setText(Display.getSeven())
    }

    private fun handleSix() {
        binding.editTextText2.setText(Display.getSix())
    }

    private fun handleFive() {
        binding.editTextText2.setText(Display.getFive())
    }

    private fun handleFour() {
        binding.editTextText2.setText(Display.getFour())
    }

    private fun handleThree() {
        binding.editTextText2.setText(Display.getThree())
    }

    private fun handleTwo() {
        binding.editTextText2.setText(Display.getTwo())
    }

    private fun handleOne(){
            binding.editTextText2.setText(Display.getOne())
        }


}