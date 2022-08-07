package com.fcy.calculator_x

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val elements =
        mutableListOf(
            "=",
            "×",
            "÷",
            "",
            "7",
            "8",
            "9",
            "-",
            "4",
            "5",
            "6",
            "+",//11
            "1",
            "2",
            "3",
            "c",
            "%",
            "0",
            ".",
            "AC"//19
        )
    val currentText = mutableStateOf("")

    /**
     * 0:填写第一个数
     * 1：填写第二个数
     * 2：填写=号
     */
    private var currentState = 0
    private var ele1 = ""
    private var operator = ""
    private var ele2 = ""
    private var res = ""

    /**
     * @param index Int 被点击的按钮索引
     */
    fun onElementClick(index: Int) {
        println("$index 按钮被点击")
        process(elements[index - 1])
        currentText.value = ele1 + operator + ele2 + res
    }

    private fun clear() {
        currentState = 0
        ele1 = ""
        operator = ""
        ele2 = ""
        res = ""
    }

    private fun process(ext: String) {
        if (ext == elements[19])
            clear()
        when (currentState) {
            0 -> {
                if (isOperator(ext) && ele1.isNotBlank()) {
                    operator = ext
                    currentState++
                } else processA(ext)
            }
            1 -> {
                if (ext == elements[0] && ele2.isNotBlank()) calculate().also {
                    res = if (it.toInt().toDouble() == it) {
                        "= \n ${it.toInt()}"
                    } else "= \n $it"
                    currentState++
                }
                else processB(ext)
            }
            2 -> {
                clear()
                process(ext)
            }
        }
    }

    private fun calculate(): Double {
        val a = ele1.toDouble()
        val b = ele2.toDouble()

        return when (operator) {
            elements[1] -> {
                a * b
            }
            elements[2] -> {
                a / b
            }
            elements[7] -> {
                a - b
            }
            elements[11] -> {
                a + b
            }
            elements[16] -> {
                a % b
            }
            else -> {
                throw IllegalStateException("计算发生未知错误")
            }
        }

    }

    private fun processA(ext: String) {
        if ((ele1 + ext).toDoubleOrNull() != null)
            ele1 += ext
    }

    private fun processB(ext: String) {
        if ((ele2 + ext).toDoubleOrNull() != null)
            ele2 += ext
    }


    private fun isOperator(data: String): Boolean {
        return data == elements[1] || data == elements[2] || data == elements[7] || data == elements[16] || data == elements[11]
    }
}