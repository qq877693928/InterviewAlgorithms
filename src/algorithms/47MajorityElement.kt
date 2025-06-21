package algorithms

/**
 * 169. 多数元素
 * https://leetcode.cn/problems/majority-element/description/
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(2,2,1,1,1,2,2)
    System.out.println("${majorityElement(nums)}")
}

private fun majorityElement(nums: IntArray): Int {
    val map: MutableMap<Int, Int> = mutableMapOf<Int, Int>()

    nums.forEach {
        val num = map.get(it) ?: 0
        map.put(it, num + 1)
    }

    var max: Int = Int.MIN_VALUE
    var element: Int = 0
    map.forEach {
        if(it.value > max) {
            max = it.value
            element = it.key
        }
    }
    return element
}