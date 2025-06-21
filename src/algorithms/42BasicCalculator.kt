package algorithms

import java.util.Stack

/**
 * 227. 基本计算器 II
 * https://leetcode.cn/problems/basic-calculator-ii/description/
 */
fun main(args: Array<String>) {

//    val str: String = "3+2*2"
    val str: String = " 3+5 / 2 "

    System.out.println("${calculate(str)}")

}

private fun calculate(s: String): Int {
    val charArray = s.toCharArray()
    var preCalculateSign: Char = '+'
    var num: Int = 0
    val stack: Stack<Int> = Stack<Int>()

    charArray.forEachIndexed { index, ch ->
        if (ch.isDigit()) {
            num = num * 10 + (ch - '0')
        }
        if (!ch.isDigit() && ch != ' ' || index == charArray.lastIndex) {
            when (preCalculateSign) {
                '+' -> {
                    stack.push(num)
                }

                '-' -> {
                    stack.push(-num)
                }

                '*' -> {
                    stack.push(stack.pop() * num)
                }

                '/' -> {
                    stack.push(stack.pop() / num)
                }
            }
            preCalculateSign = ch
            num = 0
        }
    }
    var ans: Int = 0
    while (stack.isNotEmpty()) {
        ans += stack.pop()
    }
    return ans
}