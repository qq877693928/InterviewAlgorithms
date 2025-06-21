package algorithms

/**
 * 3. 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 */
fun main(args: Array<String>) {
    val str = "abcabcfbb"

    System.out.println("${lengthOfLongestSubstring(str)}")
}

private fun lengthOfLongestSubstring(s: String): Int {
    val occ: MutableSet<Char> = mutableSetOf()
    var rk: Int = -1
    var maxLen: Int = 0
    for (index in 0 until s.length) {
        if (index > 0) {
            occ.remove(s[index - 1])
        }
        while (rk + 1 < s.length && !occ.contains(s[rk + 1])) {
            occ.add(s[rk + 1])
            rk++
        }
        System.out.println("${occ.toList().joinToString()}")

        maxLen = Math.max(maxLen, rk - index + 1)
    }

    return maxLen
}

//private fun lengthOfLongestSubstring(s: String): Int {
//    val len = s.length
//    var dp = Array(len + 1) { IntArray(len + 1) }
//
//    // 记录字符最后出现位置
//    val lastOccurrence = mutableMapOf<Char, Int>()
//    for (index in 0 until len) {
//        lastOccurrence[s[index]] = index
//    }
//    System.out.println("${lastOccurrence.map { Pair(it.key, it.value)}.joinToString(",", transform = {
//        "[${it.first}, ${it.second}]"
//    })}")
//
//    for (i in 1..len) {
//        for (j in 1..len) {
//
//            val lastPos = lastOccurrence.getOrDefault(s[j-1],  -1)
//            var subStr: String? = null
//            if (j > i) {
//                subStr = s.substring(i - 1, j - 1)
//            }
//            if (s[i - 1] == s[j - 1] && (j > i && !hasDuplicateCharsUsingGrouping(subStr))) {
//                dp[i][j] = dp[i - 1][j - 1] + 1
//                System.out.println("${dp[i][j]}===>${subStr}")
//            } else {
//                dp[i][j] = 0
//            }
//        }
//    }
//
//    System.out.print("\\, ${s.toCharArray().joinToString()}")
//    System.out.println("${dp.joinToString("", transform = {
//        "\n${it.joinToString()}"
//    })}")
//    return 0
//}
//
//private fun hasDuplicateCharsUsingGrouping(str: String?): Boolean {
//    str ?: return false
//    return str.groupBy { it }.any { it.value.size > 1 }
//}