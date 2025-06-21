package algorithms

/**
 * 718. 最长重复子数组
 * https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description/
 */
fun main(args: Array<String>) {
    val nums1 = intArrayOf(1,2,3,2,1)
    val nums2 = intArrayOf(3,2,1,4,7)
    System.out.println("${findLength(nums1, nums2)}")
}

private fun findLength(nums1: IntArray, nums2: IntArray): Int {
    val n = nums1.size
    val m = nums2.size

    val dp = Array(n + 1) { IntArray(m + 1) }
    dp[0][0] = 0

    var ans: Int = 0

    for (i in 1..n) {
        for (j in 1..m) {
            if (nums1[i - 1] == nums2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
                ans = Math.max(ans, dp[i][j]);
            } else {
                dp[i][j] = 0
            }
        }
    }

    return ans

}