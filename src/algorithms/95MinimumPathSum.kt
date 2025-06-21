package algorithms

/**
 * 64. 最小路径和
 * https://leetcode.cn/problems/minimum-path-sum/description/
 */
fun main(args: Array<String>) {
    val gird = Array(3) {
        intArrayOf(1,3,1)
        intArrayOf(1,5,1)
        intArrayOf(4,2,1)
    }

    System.out.println("${minPathSum(gird)}")
}

private fun minPathSum(grid: Array<IntArray>?): Int {
    if(grid == null || grid.isEmpty() || grid.first().isEmpty()) {
        return 0
    }

    val rows = grid.size
    val columns = grid.first().size
    val dp = Array(rows) { IntArray(columns) }
    dp[0][0] = grid[0][0]

    /**
     * 创建二维数组 dp，与原始网格的大小相同，dp[i][j] 表示从左上角出发到 (i,j) 位置的最小路径和。显然，dp[0][0]=grid[0][0]。对于 dp 中的其余元素，通过以下状态转移方程计算元素值。
     *
     * 当 i>0 且 j=0 时，dp[i][0]=dp[i−1][0]+grid[i][0]
     *
     * 当 i=0 且 j>0 时，dp[0][j]=dp[0][j−1]+grid[0][j]
     *
     * 当 i>0 且 j>0 时，dp[i][j]=min(dp[i−1][j],dp[i][j−1])+grid[i][j]
     */

    for(i in 1 until rows) {
        dp[i][0] = dp[i - 1][0] + grid[i][0]
    }

    for(j in 1 until columns) {
        dp[0][j] = dp[0][j - 1] + grid[0][j]
    }

    for(i in 1 until rows) {
        for(j in 1 until columns) {
            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        }
    }

    return dp[rows - 1][columns - 1]
}