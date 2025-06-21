package algorithms

/**
 * 695. 岛屿的最大面积
 * https://leetcode.cn/problems/max-area-of-island/description/
 */
fun main(args: Array<String>) {
    val grid = arrayOf(
        arrayOf(0,0,1,0,0,0,0,1,0,0,0,0,0),
        arrayOf(0,0,0,0,0,0,0,1,1,1,0,0,0),
        arrayOf(0,1,1,0,1,0,0,0,0,0,0,0,0),
        arrayOf(0,1,0,0,1,1,0,0,1,0,1,0,0),
        arrayOf(0,1,0,0,1,1,0,0,1,1,1,0,0),
        arrayOf(0,0,0,0,0,0,0,0,0,0,1,0,0),
        arrayOf(0,0,0,0,0,0,0,1,1,1,0,0,0),
        arrayOf(0,0,0,0,0,0,0,1,1,0,0,0,0)
    )
    System.out.println(maxAreaIslands(grid))
}

private fun maxAreaIslands(grid: Array<Array<Int>>?): Int {
    if (grid == null || grid.first().isEmpty()) {
        return 0
    }

    var max: Int = 0

    for (r in 0..grid.lastIndex) {
        for (c in 0..grid.first().lastIndex) {
            if (grid[r][c] == 1) {
                max = Math.max(max, dfs(grid, r, c))

                System.out.println(
                    "\n${
                        grid.joinToString("\n", transform = {
                            "${it.joinToString()}"
                        })
                    }"
                )
            }
        }
    }
    return max
}

private fun dfs(grid: Array<Array<Int>>, row: Int, column: Int): Int {
    val nr: Int = grid.size
    val nc: Int = grid.first().size
    if (row < 0 || column < 0 || row >= nr || column >= nc || grid[row][column] == 0) {
        return 0
    }

    grid[row][column] = 0

    var ans = 1

    ans += dfs(grid, row - 1, column)
    ans += dfs(grid, row + 1, column)
    ans += dfs(grid, row, column - 1)
    ans += dfs(grid, row, column + 1)

    return ans
}