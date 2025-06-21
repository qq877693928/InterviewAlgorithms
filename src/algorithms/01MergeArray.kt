package algorithms

import java.util.PriorityQueue

/**
 * 88. 合并两个有序数组
 */
fun main(args: Array<String>) {
    val nums1 = intArrayOf(2,0)
    val m = 1
    val nums2 = intArrayOf(1)
    val n = 1
    System.out.println("${nums1.joinToString(",")}")
    merge(nums1, m, nums2, n)
    System.out.println("${nums1.joinToString(",")}")

//    PriorityQueue(Comparator<String> { o1, o2->
//        return@Comparator o1.compareTo(o2)
//    })
}

//fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
//    var index = 0
//    if (n <= 0) {
//        return
//    }
//    for(i in 0 .. nums1.lastIndex) {
//        val num2Value = nums2.get(index.coerceAtMost(n - 1))
//        if((num2Value >= nums1.get(i) && num2Value < nums1.get((i + 1).coerceAtMost(nums1.lastIndex))) || nums1.get(i) == 0 || (i == 0 && num2Value <= nums1.get(i))) {
//            removeLastValues(i, nums1)
//            nums1.set(i, num2Value)
//            index++
//        }
//    }
//}
//
//fun removeLastValues(start: Int, nums1: IntArray) {
//    for (i in nums1.lastIndex downTo Math.max(start, 1)) {
//        nums1[i] = nums1[i - 1]
//    }
//}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    if(n <= 0) return
    var len1 = m -1
    var len2 = n -1
    var length = m + n - 1
    while (len2 >= 0 && len1 >= 0) {
        nums1[length--] = if (nums1[len1] > nums2[len2]) {
            nums1[len1--]
        } else {
            nums2[len2--]
        }
    }
    System.arraycopy(nums2, 0, nums1, 0, len2 + 1)
}
