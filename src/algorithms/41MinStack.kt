package algorithms

import java.util.Stack

/**
 * https://leetcode.cn/problems/implement-queue-using-stacks/description/
 */
fun main(args: Array<String>) {

    val minStack: MinStack = MinStack()
}

class MinStack() {

    private val realStack: Stack<Int> = Stack<Int>()
    private val minStack: Stack<Int> = Stack<Int>()

    fun push(`val`: Int) {
        realStack.push(`val`)
        if(minStack.isEmpty() || minStack.peek() >= `val`) {
            minStack.push(`val`)
        }
    }

    fun pop() {
        val pop = realStack.pop()
        if(minStack.isNotEmpty() && pop.equals(minStack.peek())) {
            minStack.pop()
        }
    }

    fun top(): Int {
        return realStack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }

}