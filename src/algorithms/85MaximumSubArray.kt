package algorithms

/**
 * 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/description/
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(-2,-1)
    System.out.println("${maxSubArray(nums)}")
}

private fun maxSubArray(nums: IntArray?): Int {
    nums ?: return 0
    if(nums.size == 1) return nums[0]
    val dp = IntArray(nums.size + 1)
    dp[0] = 0

    nums.forEachIndexed{ index, num ->
        dp[index + 1] = Math.max(dp[index] + num, num)
    }
    System.out.println("${dp.toList().subList(1, dp.size).joinToString()}")
    return dp.toList().subList(1, dp.size).max()
}