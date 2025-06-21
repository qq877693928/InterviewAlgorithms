package algorithms

/**
 * 165. 比较版本号
 * https://leetcode.cn/problems/compare-version-numbers/description/
 */
fun main(args: Array<String>) {
    val version1 = "1.01"
    val version2 = "1.001.2"

    System.out.println("${compareVersion(version1, version2)}")
}

private fun compareVersion(version1: String, version2: String): Int {
    val v1 = version1.split(".")
    val v2 = version2.split(".")

    var index: Int = 0
    while (index < v1.size || index < v2.size) {

        var num1 = 0
        var num2 = 0

        if (index < v1.size) {
            num1 = Integer.parseInt(v1[index])
        }

        if (index < v2.size) {
            num2 = Integer.parseInt(v2[index])
        }

        if (num1 > num2) {
            return 1
        }

        if (num1 < num2) {
            return -1
        }

        index++
    }

    return 0
}

