package algorithms

/**
 * 200. 岛屿数量
 * https://leetcode.cn/problems/number-of-islands/description/
 */
fun main(args: Array<String>) {
    val grid = arrayOf(
        arrayOf("1", "1", "0", "0", "0"),
        arrayOf("1", "1", "0", "0", "0"),
        arrayOf("0", "0", "1", "0", "0"),
        arrayOf("0", "0", "0", "1", "1")
    )
    System.out.println(numIslands(grid))
}

private fun numIslands(grid: Array<Array<String>>?): Int {
    if (grid == null || grid.first().isEmpty()) {
        return 0
    }

    var islandNum: Int = 0
    for (r in 0..grid.lastIndex) {
        for (c in 0..grid.first().lastIndex) {
            if (grid[r][c] == "1") {
                islandNum++
                dfs(grid, r, c)

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
    return islandNum
}

private fun dfs(grid: Array<Array<String>>, row: Int, column: Int) {
    val nr: Int = grid.size
    val nc: Int = grid.first().size
    if (row < 0 || column < 0 || row >= nr || column >= nc || grid[row][column] == "0") {
        return
    }

    grid[row][column] = "0"

    dfs(grid, row - 1, column)
    dfs(grid, row + 1, column)
    dfs(grid, row, column - 1)
    dfs(grid, row, column + 1)
}