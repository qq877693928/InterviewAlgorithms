package others

/**
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element/description/
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(3, 2, 2, 3)
    val result = removeElement(nums, 3)
    System.out.println("${result}")
    System.out.println("[${nums.toMutableList().subList(0, result).joinToString()}]")
}

private fun removeElement(nums: IntArray, `val`: Int): Int {
    var slow: Int = 0
    for (fast in 0 until nums.size) {
        if (nums[fast] != `val`) {
            nums[slow] = nums[fast]
            slow++
        }
    }
    return slow
}