package algorithms

/**
 * 221. 最大正方形
 * https://leetcode.cn/problems/maximal-square/description/
 */
fun main(args: Array<String>) {
    val matrix = arrayOf(
        charArrayOf('1', '0', '1', '0', '0'),
        charArrayOf('1', '0', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1'),
        charArrayOf('1', '0', '0', '1', '0')
    )

    System.out.println("${maximalSquare(matrix)}")
}

/**
 * 如果该位置的值是 0，则 dp(i,j)=0，因为当前位置不可能在由 1 组成的正方形中；
 *
 * 如果该位置的值是 1，则 dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的 dp 值决定。具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 1，状态转移方程如下：
 *
 * dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
 */
private fun maximalSquare(matrix: Array<CharArray>?): Int {
    var maxSide: Int = 0
    if (matrix == null || matrix.isEmpty() || matrix.first().isEmpty()) {
        return 0
    }

    val rows = matrix.size
    val columns = matrix.first().size
    val dp = Array(rows) { IntArray(columns) }

    for (i in 0 until rows) {
        for (j in 0 until columns) {
            if (matrix[i][j] == '1') {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1
                }
                maxSide = Math.max(maxSide, dp[i][j])
            }
        }
    }

    System.out.println(
        "${
            dp.joinToString(transform = {
                "\n[${it.joinToString()}]"
            })
        }"
    )
    return maxSide * maxSide
}