package algorithms


/**
 * 31. 下一个排列
 * https://leetcode.cn/problems/next-permutation/description/
 *
 * ⚙️ 核心规则与步骤
 * 1. 定位关键位置
 * 从右向左扫描，找到第一个左邻小于右邻的位置 i-1，即满足 nums[i-1] < nums[i]。
 * 例如：[6,8,7,4,3,2] 中，6 < 8 → 定位到索引 0（值 6）。
 * 2. 寻找交换目标
 * 从右向左扫描，找到第一个大于 nums[i-1] 的元素 nums[j]。
 * 接上例：比 6 大的最右元素是 7（索引 2）。
 * 3. 交换元素
 * 交换 nums[i-1] 和 nums[j]。
 * 结果：[6,8,7,4,3,2] → [7,8,6,4,3,2] 。
 * 4. 反转右侧子序列
 * 将位置 i 到末尾的子序列反转（变为升序）。
 * 反转 [8,6,4,3,2] → [2,3,4,6,8]，最终结果：[7,2,3,4,6,8]
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(1, 5, 8, 4, 7, 6, 5, 3, 1)
    nextPermutation(nums)
    System.out.println("${nums.joinToString()}")
}

private fun nextPermutation(nums: IntArray) {
    var i: Int = nums.lastIndex
    while (i >= 0 && nums[i] <= nums[i - 1]) {
        // 合并代码 nums[i] <= nums[i - 1], 否则写一下代码
//        if(nums[i] > nums[i-1]) {
//            break
//        }
        i--
    }
    System.out.println(i-1)
    // 目标值
    val pivot = nums[i - 1]
    if ((i - 1) > 0) {
        var j: Int = nums.lastIndex
        while (j >= 0 && pivot >= nums[j]) {
            j--
        }
        System.out.println(j)
        swap(nums, i - 1, j)
    }
    reverse(nums, i)
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}

private fun reverse(nums: IntArray, start: Int) {
    var left = start
    var right = nums.lastIndex
    while (left < right) {
        swap(nums, left, right)
        left++
        right--
    }
}