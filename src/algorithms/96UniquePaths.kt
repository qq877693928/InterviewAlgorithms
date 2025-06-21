package algorithms

/**
 * 62. 不同路径
 * https://leetcode.cn/problems/unique-paths/description/
 */
fun main(args: Array<String>) {
    System.out.println("${uniquePaths(3, 7)}")
}

private fun uniquePaths(m: Int, n: Int): Int {
    val dp = Array(m) { IntArray(n) }

    /**
     * 动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
     *
     * 注意，对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1
     */

    for(i in 0 until n) {
        dp[0][i] = 1
    }

    for(j in 0 until m) {
        dp[j][0] = 1
    }

    for(i in 1 until m) {
        for (j in 1 until n) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        }
    }

    return dp[m - 1][n - 1]
}