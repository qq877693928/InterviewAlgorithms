package algorithms

import java.util.Stack

/**
 * 使用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/description/
 */
fun main(args: Array<String>) {

    val myQueue: MyQueue = MyQueue()


}

class MyQueue() {

    private val stackA: Stack<Int> = Stack<Int>()
    private val stackB: Stack<Int> = Stack<Int>()

    fun push(x: Int) {
        stackA.push(x)
    }

    fun pop(): Int {
        val peek = peek()
        stackB.pop()
        return peek
    }

    fun peek(): Int {
        if(stackB.isNotEmpty()) return stackB.peek()
        if(stackA.isEmpty) return -1
        while (stackA.isNotEmpty()) {
            stackB.push(stackA.pop())
        }
        return stackB.peek()
    }

    fun empty(): Boolean {
        return stackA.isEmpty && stackB.isEmpty
    }
}