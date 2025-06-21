package algorithms

/**
 * 中位数
 */
fun main(args: Array<String>) {
    val num1 = intArrayOf(2)
    val num2 = intArrayOf(1)

    System.out.println("${findMedianSortedArrays(num1, num2)}")
}

private fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

    val result = IntArray(nums1.size + nums2.size)
    System.arraycopy(nums1, 0, result, 0, nums1.size)

    System.out.println("${result.joinToString()}")

    var len1 = nums1.lastIndex
    var len2 = nums2.lastIndex
    var length = nums1.size + nums2.size - 1

    while (len1 >= 0 && len2 >= 0) {
        result[length--] = if (result[len1] < nums2[len2]) nums2[len2--] else result[len1--]
    }
    System.arraycopy(nums2, 0, result, 0, len2 + 1)

    System.out.println("${result.joinToString()}")


    return 0.0
}