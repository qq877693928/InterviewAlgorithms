package algorithms

/**
 * 反转字符串
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 */
fun main(args: Array<String>) {
    val str = "  the sky is   blue   "

    System.out.println("${reverseWords(str)}")
}

private fun reverseWords(s: String): String {
    var left = 0
    var right = s.lastIndex
    // 去掉字符串开头的空白字符
    while (left <= right && s[left] == ' ') {
        ++left
    }

    // 去掉字符串末尾的空白字符
    while (left <= right && s[right] == ' ') {
        --right
    }

    val list: MutableList<String> = mutableListOf()
    var stringBuilder: StringBuilder = StringBuilder()

    while (left <= right) {
        val ch = s[left]
        if (stringBuilder.isNotEmpty() && ch == ' ') {
            list.add(stringBuilder.toString())
            stringBuilder.setLength(0)
        } else if (ch != ' ') {
            stringBuilder.append(ch)
        }
        left++
    }
    list.add(stringBuilder.toString())

    return list.reversed().joinToString(" ")
}