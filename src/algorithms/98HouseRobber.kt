package algorithms

/**
 * 198. 打家劫舍
 * https://leetcode.cn/problems/house-robber/description/
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(2,7,9,3,1)

    System.out.println("${rob(nums)}")
}

private fun rob(nums: IntArray?): Int {
    nums ?: return 0
    if (nums.isEmpty()) return 0

    val dp = IntArray(nums.size + 1)
    dp[0] = 0
    dp[1] = nums[0]

    // f(k)=max{f(k−1),H(k−1)+f(k−2)}
    for(index in 2..nums.size) {
        // nums的index-1原因是dp比nums的长度多1，所以偏移只需-1就行，而不是-2
        dp[index] = Math.max(dp[index -1], dp[index-2] + nums[index-1])
    }
    return dp[nums.size]
}