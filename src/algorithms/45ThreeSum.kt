package algorithms

/**
 * 15. 三数之和
 *
 */
fun main(args: Array<String>) {

    val nums = intArrayOf(-1,0,1,2,-1,-4)
    val list = subsets(nums)
    System.out.println(
        "${
            list.filter { it.size == 3 && it.sum() == 0 }.joinToString(",", transform = {
                "[${it.joinToString(",")}]"
            })
        }"
    )
}

private val res = mutableListOf<List<Int>>()

private fun subsets(nums: IntArray): List<List<Int>> {
    backtrack(0, nums, mutableListOf())
    return res
}

// 回溯法，穷举所有组合的可能，并剪支path.size == 3
private fun backtrack(start: Int, nums: IntArray, path: MutableList<Int>) {
    if (path.size == 3 && path.toList().sum() == 0) {
        res.add(path.toList())
    }
    for (i in start until nums.size)  {
        if (path.size > 3) break
        path.add(nums[i])
        backtrack(i + 1, nums, path) // 下一层从 i+1 开始
        path.removeLast()
    }
}