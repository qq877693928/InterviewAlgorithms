package algorithms

/**
 * 5. 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 */
fun main(args: Array<String>) {
    val str = "fdsbabadfds"
    System.out.println("${longestPalindrome(str)}")
}

private fun longestPalindrome(s: String): String {
    val n = s.length
    if (n < 2) return s

    // 创建动态规划表，dp[i][j] 表示 s[i..j] 是否为回文子串
    val dp = Array(n) { BooleanArray(n) }
    var maxLen = 1
    var start = 0

    // 初始化：所有长度为1的子串都是回文串
    for (i in 0 until n) {
        dp[i][i] = true
    }

    // 从长度为2的子串开始
    for (len in 2..n) { // len 表示当前考虑的子串长度
        for (i in 0..n - len) { // i 为起始索引
            val j = i + len - 1 // j 为结束索引

            if (s[i] != s[j]) {
                dp[i][j] = false
            } else {
                if (len == 2) {
                    dp[i][j] = true
                } else {
                    dp[i][j] = dp[i + 1][j - 1]
                }
            }

            // 如果当前子串是回文，并且长度大于记录的最大长度，更新记录
            if (dp[i][j] && len > maxLen) {
                maxLen = len
                start = i
            }
        }
    }

    return s.substring(start, start + maxLen)
}