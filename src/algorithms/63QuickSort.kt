package algorithms

/**
 * 912. 排序数组
 * https://leetcode.cn/problems/sort-an-array/description/
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(5, 1, 1, 2, 0, 0)

    // 快速排序
    quickSort(nums, 0, nums.lastIndex)
    System.out.println("${nums.joinToString()}")
}

private fun quickSort(nums: IntArray, left: Int, right: Int) {
    if (left < right) {
        val part: Int = getPartIndex(nums, left, right)
        quickSort(nums, left, part - 1)
        quickSort(nums, part + 1, right)
    }
}

private fun getPartIndex(nums: IntArray, left: Int, right: Int): Int {
    val pivot = nums[left]
    var l: Int = left + 1
    var r: Int = right

    while (l <= r) {
        // 从左向右找第一个大于等于pivot的元素
        while (l <= r && nums[l] <= pivot) l++
        // 从右向左找第一个小于pivot的元素
        while (l <= r && nums[r] > pivot) r--

        if (l < r) {
            swap(nums, l, r)
            l++
            r--
        }
    }
    // 将基准元素交换到正确的位置（此时j指向的是最后一个小于等于pivot的元素）
    swap(nums, left, r)
    return r
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}