package algorithms

/**
 *
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(4,5,6,7,0,1,2)

    System.out.println("${search(nums, 3, 0, nums.lastIndex)}")
}

private fun search(nums: IntArray, target: Int, left: Int, right: Int): Int {
    if (left >= right) {
        if (nums[left] == target) {
            return left
        } else {
            return -1
        }
    }

    val mid = left + (right - left) / 2
    if (nums[mid] == target) {
        return mid
    }

    var l: Int = 0
    var r: Int = right

    if (nums[0] <= nums[mid]) {
        if (nums[0] <= target && target < nums[mid]) {
            r = mid - 1
        } else {
            l = mid + 1
        }
    } else {
        if (nums[mid] < target && target <= nums[nums.lastIndex]) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return search(nums, target, l, r)
}