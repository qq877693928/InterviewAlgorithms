package algorithms

/**
 * 46.全排列
 * https://leetcode.cn/problems/permutations/description/
 * 注意如何设置回溯法的入参和剪枝
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(1, 2, 3)

    // 子集的解法
    subSet(nums)

    // 排列组合方式
    permute(nums)
}

private fun subSet(nums: IntArray) {
    val result: MutableList<List<Int>> = mutableListOf<List<Int>>()
    backtrackSubset(nums, 0, result, mutableListOf())
    System.out.println("${result.joinToString(transform = {
        "[${it.joinToString()}]"
    })}")
}

private fun permute(nums: IntArray) {
    val result: MutableList<List<Int>> = mutableListOf<List<Int>>()
    var usedArray = BooleanArray(nums.size)
    backtrackPermute(nums, usedArray, result, mutableListOf())
    System.out.println("${result.joinToString(transform = {
        "[${it.joinToString()}]"
    })}")
}

private fun backtrackSubset(nums: IntArray, start: Int, result: MutableList<List<Int>>, path: MutableList<Int>) {
    result.add(path.toList())

    // 子集的解法，采用下标递增的方法，将不同组合添加
    for (index in start..nums.lastIndex) {
        path.add(nums[index])
        backtrackSubset(nums, index + 1, result, path)
        path.removeLast()
    }
}

private fun backtrackPermute(
    nums: IntArray,
    usedArray: BooleanArray,
    result: MutableList<List<Int>>,
    path: MutableList<Int>, ) {

    if (path.size == nums.size) {
        result.add(path.toList())
    }

    // 全排列的解法，采用nums全遍历的方法，将标志位记录下来的方式
    for(index in 0..nums.lastIndex) {
        if(usedArray[index]) continue

        usedArray[index] = true
        path.add(nums[index])

        backtrackPermute(nums, usedArray, result, path)

        usedArray[index] = false
        path.removeLast()
    }
}

