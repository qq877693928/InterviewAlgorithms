package algorithms

/**
 * 179. 最大数
 * https://leetcode.cn/problems/largest-number/description/
 */
fun main(args: Array<String>) {
    val nums = arrayOf("3","30","34","5","9")

    for (i in 0..nums.lastIndex) {
        for(j in i..nums.lastIndex) {
            if((nums[i] + nums[j]) < (nums[j] + nums[i])) {
                swapString(nums, i, j)
            }
        }
    }
    System.out.println("${nums.joinToString()}")
}

private fun swapString(nums: Array<String>, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}