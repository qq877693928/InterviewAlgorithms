package algorithms

/**
 * 39. 组合总和
 * https://leetcode.cn/problems/combination-sum/description/
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(2,3,6,7)
    val list = combinationSum(nums, 7)
    System.out.println("${list.joinToString(transform = {
        "[${it.joinToString()}]"
    })}")
}

private fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    combinationBacktrack(candidates, 0, target, result, mutableListOf())
    return result.toList()
}

private fun combinationBacktrack(candidates: IntArray, start: Int, sum: Int, result: MutableList<List<Int>>, path: MutableList<Int>) {
    if (sum <= 0) {
        result.add(path.toList())
        return
    }

    for (index in start..candidates.lastIndex) {
        if (sum - candidates[index] < 0) break
        path.add(candidates[index])
        // 这个里的start = index 不是使用 start+ index也不是 index+1, 因为一个数字可以多次使用
        /**
         * combinationBacktrack(candidates, index, sum - candidates[index], result, path)
         * 如果使用index+1,那么就只有【7】一个组合，
         */
        combinationBacktrack(candidates, index, sum - candidates[index], result, path)
        path.removeLast()
    }
}