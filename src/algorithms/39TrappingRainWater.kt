package algorithms

/**
 * 42. 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/
 */
fun main(args: Array<String>) {
    val height = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)

    System.out.println("${trap(height)}")
}

fun trap(height: IntArray): Int {
    val maxHeight = height.max()
    val result: MutableList<List<Int>> = mutableListOf()

    for(row in 1..maxHeight) {
        val level: MutableList<Int> = mutableListOf()
        height.forEachIndexed { index, value ->
            level.add(if(value >= row) 1 else 0)
        }
        result.add(level.toList())
    }

    System.out.println("${result.joinToString("\n", transform = {
        "[${it.joinToString()}]"
    })}")

    var sum: Int = 0

    result.forEach {
        sum += rainWaterSum(it)
    }

    return sum
}

fun rainWaterSum(it: List<Int>): Int {
    var result: Int = 0
    var left: Int = 0
    var right: Int = it.lastIndex
    while(left <= it.lastIndex) {
        if(it.get(left) == 1) {
            break
        }
        left++
    }

    while(right >= 0) {
        if(it.get(right) == 1) {
            break
        }
        right--
    }
    if(right <= left) {
        return 0
    }

    for(index in left..right) {
        if(it.get(index) == 0) {
            result += 1
        }
    }

    return result
}
