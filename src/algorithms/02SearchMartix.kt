package algorithms

/**
 * 240. 搜索二维矩阵 II
 */
fun main(args: Array<String>) {
    val matrix = arrayOf(
        intArrayOf(1,4,7,11,15),
        intArrayOf(2,5,8,12,19),
        intArrayOf(3,6,9,16,22),
        intArrayOf(10,13,14,17,24)
    )
    System.out.print("${searchMatrix(matrix, target = 5)}")
}

//fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
//    var result = false
//    for(row in 0..matrix.lastIndex) {
//        for(low in 0..matrix.get(row).lastIndex) {
//            if(matrix.get(row).getOrNull(low) == target) {
//                result = true
//            }
//        }
//    }
//    return result
//}

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    var result = false
    for(row in 0..matrix.lastIndex) {
        if(binearSearch(matrix.get(row), target)) {
            result = true
        }
    }
    return result
}

fun binearSearch(array: IntArray, target: Int): Boolean {
    var left = 0
    var right = array.lastIndex
    while (left <= right) {
        val mid = (left + right) / 2
        if (array.get(mid) == target) {
            return true
        } else if (array.get(mid) > target) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return false
}
