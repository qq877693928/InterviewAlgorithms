package algorithms

/**
 * 72. 编辑距离
 * https://leetcode.cn/problems/edit-distance/description/
 * 若 A 和 B 的最后一个字母相同：
 * D[i][j]=min(D[i][j−1]+1,D[i−1][j]+1,D[i−1][j−1])=1+min(D[i][j−1],D[i−1][j],D[i−1][j−1]−1)
 *
 * 若 A 和 B 的最后一个字母不同：
 * D[i][j]=1+min(D[i][j−1],D[i−1][j],D[i−1][j−1])
 */
fun main(args: Array<String>) {
    val word1 = "horse"
    val word2 = "ros"
    System.out.println("${minDistance(word1, word2)}")
}

fun minDistance(word1: String, word2: String): Int {
    val m = word1.length
    val n = word2.length
    // 创建二维数组 dp，大小为 (m+1) x (n+1)
    val dp = Array(m + 1) { IntArray(n + 1) }

    // 初始化边界条件
    for (i in 0..m) {
        dp[i][0] = i
    }
    for (j in 0..n) {
        dp[0][j] = j
    }

    // 动态规划填表
    for (i in 1..m) {
        for (j in 1..n) {
            if (word1[i - 1] == word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = minOf(
                    dp[i][j - 1] + 1,  // 插入
                    dp[i - 1][j] + 1,  // 删除
                    dp[i - 1][j - 1] + 1 // 替换
                )
            }
        }
    }

    return dp[m][n]
}