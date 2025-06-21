package algorithms

/**
 * 41. 缺失的第一个正数
 * https://leetcode.cn/problems/first-missing-positive/
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(1)
    System.out.println("${firstMissingPositive(nums)}")
}

private fun firstMissingPositive(nums: IntArray): Int {
    val len = nums.size
    if (!nums.contains(1)) return 1

    val list = nums.map { if (it <= 0) 1 else it }.toMutableList()
    System.out.println("${list.joinToString(",")}")
    for(index in 0 until len) {
        val value = Math.abs(list[index])
        System.out.println("index = $index, ${value}")
        if (value <= len) {
            list[value - 1] = -Math.abs(list[value - 1])
        }
    }
    System.out.println("${list.joinToString(",")}")
    var index: Int = 0
    while (index < len) {
        if(list[index] < 0) {
            index++
        }else {
            break
        }
    }
    return index+1
}