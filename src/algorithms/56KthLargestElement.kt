package algorithms

import java.util.PriorityQueue

/**
 *
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 */
fun main(args: Array<String>) {

    val array = intArrayOf(3,2,3,1,2,4,5,5,6)

    System.out.println("${findKthLargest(array, 4)}")

}

private fun findKthLargest(nums: IntArray, k: Int): Int {
    val queue: PriorityQueue<Int> = PriorityQueue<Int>(k, Comparator<Int> { e1, e2 ->
        return@Comparator e1 - e2
    })

    nums.forEach {
        queue.offer(it)
        if (queue.size > k) {
            queue.poll()
        }
    }
    return queue.peek()
}