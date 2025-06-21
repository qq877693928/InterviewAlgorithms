package algorithms

/**
 * 70. 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/description/
 */
fun main(args: Array<String>) {
    val n = 5
    System.out.println("${climbStairs(n)}")
}

private fun climbStairs(n: Int): Int {
    if(n == 0) return 0
    if(n == 1) return 1
    if(n == 2) return 2
    val dp: IntArray = IntArray(n+1)
    dp[1] = 1
    dp[2] = 2
    for(index in 3..n) {
        dp[index] = dp[index-1] + dp[index-2]
    }
    return dp[n]
}