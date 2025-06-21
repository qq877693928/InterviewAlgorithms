package algorithms

import java.util.Stack

/**
 * 20. 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/description/
 */
fun main(args: Array<String>) {
    val str: String = "()[]{}"
    System.out.println("${isValid(str)}")
}

val map: Map<Char, Char> = mapOf(
    '}' to '{',
    ')' to '(',
    ']' to '[',
)

private fun isValid(s: String): Boolean {
    if(s.length % 2 == 1) return false

    val charArray: CharArray = s.toCharArray()
    val stack: Stack<Char> = Stack<Char>()

    var flag: Boolean = true

    charArray.forEach {
        when(it) {
            '(', '[', '{' -> {
                stack.push(it)
            }
            ')', '}', ']' -> {
                if (stack.isNotEmpty() && stack.peek() == map.get(it)) {
                    stack.pop()
                } else {
                    flag = false
                }
            }
        }
    }

    return flag && stack.isEmpty()
}