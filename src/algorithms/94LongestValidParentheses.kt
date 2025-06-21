package algorithms

import java.util.LinkedList

/**
 * 32. 最长有效括号
 * https://leetcode.cn/problems/longest-valid-parentheses/description/\
 * 解法一：动态规划
 * 解法二：栈元素匹配
 */
fun main(args: Array<String>) {
    val s = ")()())"

    System.out.println("${longestValidParentheses1(s)}")
    System.out.println("${longestValidParentheses2(s)}")
}

private fun longestValidParentheses1(s: String): Int {
    if (s.isEmpty())  return 0
    val dp = IntArray(s.length)  { 0 }
    var maxLen = 0


    /**
     * 定义 dp[i] 表示以字符 s[i] 结尾的最长有效括号子串长度。状态转移分两种情况：
     *
     * 1. 当 s[i] = ')' 且 s[i-1] = '('
     * 形如 ...()：
     *
     * 2. dp[i] = dp[i-2] + 2   // 加上前面子串长度
     * 当 s[i] = ')' 且 s[i-1] = ')'
     * 形如 ...))：
     *
     * 检查 i - dp[i-1] - 1 位置是否为 '('：
     * if (s[i - dp[i-1] - 1] == '(') {
     *     dp[i] = dp[i-1] + 2 + dp[i - dp[i-1] - 2]
     *     // 新增匹配长度 + 前方连续有效长度
     * }
     */

    for (i in 1 until s.length)  {
        if (s[i] == ')') {
            if (s[i - 1] == '(') {
                dp[i] = 2 + (if (i >= 2) dp[i - 2] else 0)
            } else if (i - dp[i - 1] > 0 && s[i - dp[i - 1] - 1] == '(') {
                val prevLen = if (i - dp[i - 1] >= 2) dp[i - dp[i - 1] - 2] else 0
                dp[i] = dp[i - 1] + 2 + prevLen
            }
            maxLen = Math.max(maxLen, dp[i])
        }
    }
    return maxLen
}

private fun longestValidParentheses2(s: String): Int {
    val stack = LinkedList<Int>().apply { push(-1) } // 初始化栈底
    var maxLen = 0

    for (i in s.indices)  {
        when (s[i]) {
            '(' -> stack.push(i)  // 左括号下标入栈
            ')' -> {
                stack.pop()       // 弹出栈顶（尝试匹配）
                if (stack.isEmpty())  {
                    stack.push(i)  // 栈空说明当前')'未匹配，成为新栈底
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek())
                }
            }
        }
    }
    return maxLen
}