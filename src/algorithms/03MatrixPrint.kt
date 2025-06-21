package algorithms

/**
 * 54. 螺旋矩阵
 */
fun main(args: Array<String>) {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(8, 9, 4),
        intArrayOf(7, 6, 5)
    )

    System.out.print("${spiralOrder(matrix)}")

}

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    var top = 0
    var bottom = matrix.lastIndex
    var left = 0
    var right = matrix.first().lastIndex

    val result = mutableListOf<Int>()

    while (bottom >= top && left <= right) {
        // 左到右
        for(index in left..right) {
            result.add(matrix.get(top).get(index))
        }
        top++

        // 上至下
        for(index in top..bottom) {
            result.add(matrix.get(index).get(right))
        }
        right--

        if(left < right) {
            // 从右到左
            for (index in right downTo left) {
                result.add(matrix.get(bottom).get(index))
            }
            bottom--
        }

        if(top < bottom) {
            for(index in bottom downTo top) {
                result.add(matrix.get(index).get(left))
            }
            left++
        }
    }
    return result
}