package algorithms

/**
 * 1143. 最长公共子序列
 * https://leetcode.cn/problems/longest-common-subsequence/description/
 */
fun main(args: Array<String>) {
    val text1 = "abcde"
    val text2 = "ac"
    System.out.println("${longestCommonSubsequence(text1, text2)}")
}

private fun longestCommonSubsequence(text1: String, text2: String): Int {
    val n = text1.length
    val m = text2.length

    val dp = Array(n + 1) { IntArray(m + 1) }
    dp[0][0] = 0

    for (i in 1..n) {
        for (j in 1..m) {
            if (text1[i - 1] == text2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                // 非连续的子序列使用max, 否则dp[i][j] = 0
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    return dp[n][m]
}