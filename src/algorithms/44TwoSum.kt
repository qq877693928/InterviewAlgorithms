package algorithms

/**
 * 1. 两数之和
 * https://leetcode.cn/problems/two-sum/description/
 */
fun main(args: Array<String>) {
    val nums: IntArray = intArrayOf(2,7,11,15)
    val target = 9

//    System.out.println("${twoSum1(nums, target).joinToString()}")
    System.out.println("${twoSum2(nums, target).joinToString()}")
}

private fun twoSum1(nums: IntArray, target: Int): IntArray {
    for(i in 0..nums.lastIndex) {
        for(j in (i+1)..nums.lastIndex) {
            if(nums.get(i) + nums.get(j) == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf()
}

private fun twoSum2(nums: IntArray, target: Int): IntArray {
    val map: MutableMap<Int, Int> = mutableMapOf()

    var left = 0
    while (left <= nums.lastIndex) {
        val index = target - nums[left]
        val value = map.get(index)
        if (value != null && value >= 0) {
            return intArrayOf(value, left)
        } else {
            map.put(nums[left], left)
        }
        left++
    }
    return intArrayOf()
}