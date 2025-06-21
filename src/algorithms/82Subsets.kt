package algorithms

/**
 * 78. 子集
 * https://leetcode.cn/problems/subsets/description/
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(1, 2, 3)

    subsets2(nums)
}

private fun subsets2(nums: IntArray): List<List<Int>> {
    val result: MutableList<List<Int>> = mutableListOf()
    backTrackSubSet(nums, 0, result, mutableListOf<Int>())

    System.out.println("${result.joinToString(transform = {
        "[${it.joinToString()}]"
    })}")
    return result.toList()
}

private fun backTrackSubSet(
    nums: IntArray,
    start: Int,
    result: MutableList<List<Int>>,
    path: MutableList<Int>
) {
    result.add(path.toList())

    for(index in start..nums.lastIndex) {
        path.add(nums[index])

        backTrackSubSet(nums, index + 1, result, path)

        path.removeLast()
    }
}
