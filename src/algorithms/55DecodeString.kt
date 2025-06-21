package algorithms

import java.util.LinkedList
import java.util.Stack

/**
 * 394. 字符串解码
 * https://leetcode.cn/problems/decode-string/description/
 */
fun main(args: Array<String>) {
    val str = "100[leetcode]"

    System.out.println("${decodeString(str)}")
}

private fun decodeString(s: String): String {
    val stack: Stack<String> = Stack<String>()

    var index: Int = 0

    while (index < s.length) {
        val ch = s[index]
        if (ch.isDigit()) {
            var times: Int = 0
            // 获取第一数字，第一个数字不一定是一位数，有可能是“100”，所以index++不能统一处理
            while (s[index].isDigit()) {
                times = times * 10 + (s[index] - '0')
                index++
            }
            stack.push(times.toString())
        }else if (ch.isLetter() || ch == '[') {
            stack.push(ch.toString())
            index++
        } else {
            val stringList: LinkedList<String> = LinkedList<String>()
            while (stack.peek() != "[") {
                stringList.addFirst(stack.pop())
            }
            if (stack.peek() == "[") {
                // 将'['左括号弹出栈
                stack.pop()
            }

            val sub: String = stringList.joinToString("")
            // 左括号之前肯定是数字
            var preTimes: Int = Integer.parseInt(stack.pop().toString())
            val stringBuilder: StringBuilder = StringBuilder()
            while (preTimes-- > 0) {
                stringBuilder.append(sub)
            }
            stack.push(stringBuilder.toString())

            index++
        }
    }
    return stack.joinToString("")
}

private fun printStack(stack: Stack<*>) {
    if (stack.isEmpty())  println("空栈")
    else {
        System.out.println("=====================")
        System.out.print("{ ")
        // 使用 descendingIterator 实现栈顶→栈底遍历
        stack.listIterator().forEach  { print(" ($it)") }
        System.out.print(" }")
        System.out.println("=====================")
    }
}