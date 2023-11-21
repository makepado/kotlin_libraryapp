package com.group.libraryapp.calculator

class Calculator(
  var number: Int
) {

    //증가
    fun add(operand: Int) {
        this.number += operand
    }

    //감소
    fun minus(operand: Int) {
        this.number -= operand
    }

    //곱하기
    fun multiply(operand: Int) {
        this.number *= operand
    }

    //나누기
    fun divide(operand: Int) {
        if(operand == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다")
        }

        this.number /= operand
    }
}