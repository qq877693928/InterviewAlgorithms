package algorithms

/**
 * 14. 最长公共前缀
 * https://leetcode.cn/problems/longest-common-prefix/description/
 */
fun main(args: Array<String>) {
    val strs = arrayOf("flower","flow","flight")
    System.out.println("${longestCommonPrefix(strs)}")
}

private fun longestCommonPrefix(strs: Array<String>): String {
    if(strs.isEmpty()) return ""
    if(strs.size == 1) return strs.get(0)

    val prefixString = strs.get(0)

    val stringBuilder = StringBuilder("")

    for(i in 0 until prefixString.length) {
        var charStr = prefixString.get(i)
        var flag = true
        for(j in 1..strs.lastIndex) {
            val compareString = strs.get(j).getOrNull(i)
            if(compareString == null || compareString != charStr) {
                flag = false
                break
            }
        }
        if(flag) {
            stringBuilder.append(charStr)
        }else {
            return stringBuilder.toString()
        }
    }
    return stringBuilder.toString()
}