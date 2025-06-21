private val array = listOf(
    listOf(1, 2, 3),
    listOf(8, 9, 4),
    listOf(7, 6, 5)
)


fun main() {
    val result = mutableListOf<Int>()
    var left = 0
    var right = array.get(0).size - 1
    var top = 0
    var bottom = array.size - 1

    while (left <= right && top <= bottom) {
        // 最上一层遍历 1、2、3
        for (i in left..right) {
            result.add(array.get(top).get(i))
        }
        top++

        //最右侧遍历 3，4，5
        for (i in top..bottom) {
            result.add(array.get(i).get(right))
        }
        right--

        if (top <= bottom) {
            // 底部处理
            for (i in right downTo left) {
                result.add(array.get(bottom).get(i))
            }
            bottom--
        }

        if (left <= right) {
            // 左侧处理
            for (i in bottom downTo top) {
                result.add(array.get(i).get(left))
            }
            left++
        }
    }

    System.out.print(result.joinToString(","))

}
