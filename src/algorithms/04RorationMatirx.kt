package algorithms

/**
 * 48. 旋转图像
 */
fun main(args: Array<String>) {
    val matrix = arrayOf(
        intArrayOf(5, 1, 9, 11),
        intArrayOf(2, 4, 8, 10),
        intArrayOf(13, 3, 6, 7),
        intArrayOf(15, 14, 12, 16),
    )
    rotate(matrix)
    System.out.print("${matrix.joinToString { "[${it.joinToString(",")}]" }}")
}

fun rotate(matrix: Array<IntArray>): Unit {
    //先按照对角线翻转
    for (i in 0..matrix.lastIndex) {
        for (j in 0..i) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }

    for (i in 0..<matrix.size) {
        val tempArray = matrix.get(i)
        matrix.set(i, reversedIntArray(tempArray))
    }
}

fun reversedIntArray(intArray: IntArray): IntArray {
    val result = mutableListOf<Int>()
    for(index in intArray.lastIndex downTo 0) {
        result.add(intArray.get(index))
    }
    return result.toIntArray()
}