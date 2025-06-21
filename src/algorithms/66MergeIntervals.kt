package algorithms

/**
 * 56. 合并区间
 * https://leetcode.cn/problems/merge-intervals/description/
 */
fun main(args: Array<String>) {
    val nums = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))

    System.out.println(
        "${
            merge(nums).joinToString(",", transform = {
                "[${it.first()}, ${it.last()}]"
            })
        }"
    )
}

private fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.size <= 1) return intervals

    intervals.sortBy { it[0] }

    val result: MutableList<IntArray> = mutableListOf<IntArray>(intervals[0])
    for (index in 1..intervals.lastIndex) {
        val last = result.last()
        if (last.max() < intervals[index].min()) {
            result.add(intervals[index])
        } else {
            last[0] = Math.min(last[0], intervals[index].min())
            last[1] = Math.max(last[1], intervals[index].max())
        }
    }
    return result.toTypedArray()
}