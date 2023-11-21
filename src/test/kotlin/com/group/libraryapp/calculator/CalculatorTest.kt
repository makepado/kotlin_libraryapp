package com.group.libraryapp.calculator

import java.lang.Exception
import java.lang.IllegalStateException

fun main() {
    val calculatorTest = CalculatorTest()
    calculatorTest.addTest()
    calculatorTest.minusTest()
    calculatorTest.multiplyTest()
    calculatorTest.divideTest()
    calculatorTest.divideExceptionTest()
}

class CalculatorTest {

    //덧셈 테스트
    fun addTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.add(3)

        //예상값
        val expectedCalculator = Calculator(8)

        //then
        //일치하지 않으면 실패
        if(calculator.number != expectedCalculator.number) {
            throw IllegalArgumentException()
        }
    }

    //뺄셈 테스트
    fun minusTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.minus(3)

        //예상값
        val expectedCalculator = Calculator(2)

        //then
        //일치하지 않으면 실패
        if(calculator.number != expectedCalculator.number) {
            throw IllegalArgumentException()
        }
    }

    //곱셈 테스트
    fun multiplyTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.multiply(3)

        //예상값
        val expectedCalculator = Calculator(15)

        //then
        //일치하지 않으면 실패
        if(calculator.number != expectedCalculator.number) {
            throw IllegalArgumentException()
        }
    }

    //나눗셈 테스트
    fun divideTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.divide(2)

        //예상값
        val expectedCalculator = Calculator(2)

        //then
        //일치하지 않으면 실패
        if(calculator.number != expectedCalculator.number) {
            throw IllegalArgumentException()
        }
    }

    fun divideExceptionTest() {
        // given
        val calculator = Calculator(5)

        // when

        try {
            calculator.divide(0)
        } catch(e: IllegalArgumentException) {
            //메세지가 다를 경우에도 실패
            if(e.message != "0으로 나눌 수 없습니다") {
                throw IllegalStateException("메시지가 다릅니다.")
            }
            //테스트 성공!!
            return
        } catch (e: Exception) {
            throw  IllegalStateException()
        }

        throw IllegalStateException("기대하는 예외가 발생하지 않았습니다.")
    }
}