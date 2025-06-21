package algorithms

/**
 * 128. 最长连续序列
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(0,3,7,2,5,8,4,6,0,1)
    System.out.println("result: ${longestConsecutive(nums)}")
}

private fun longestConsecutive(nums: IntArray): Int {
    val set: Set<Int> = nums.toSet()

    var longestNum = 0
    set.forEachIndexed { i, num->
        if (set.contains(num)) {
            var startLeft = num - 1
            var consecutiveLen = 0

            System.out.println("\nstart = ${startLeft}")
            while (set.contains(startLeft)) {
                consecutiveLen++
                startLeft++
                System.out.print(", ${startLeft}")
            }

            longestNum = Math.max(consecutiveLen, longestNum)
        }

    }
    return longestNum
}