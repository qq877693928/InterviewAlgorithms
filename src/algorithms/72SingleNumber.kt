package algorithms

/**
 * 136. 只出现一次的数字
 * https://leetcode.cn/problems/single-number/
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(8,1,2,1,2)
    System.out.println("${singleNumber(nums)}")
}

private fun singleNumber(nums: IntArray): Int {
    var result: Int = 0
    nums.forEach {
        result = result.xor(it)
    }
    return result
}