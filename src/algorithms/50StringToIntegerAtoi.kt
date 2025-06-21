package algorithms

/**
 * 字符串转数字（Atoi）
 */
fun main(args: Array<String>) {
    val str = "0-1"
    System.out.println("result: ${myAtoi(str)}")
}

private fun myAtoi(s: String): Int {
    if(s.trim().length == 0) return 0
    val charArray: CharArray = s.toCharArray()
    var result: Int = 0
    var sigal: Int = 1
    val bndry = Integer.MAX_VALUE / 10

    var index: Int = 0
    while (index <= charArray.lastIndex) {
        if (charArray[index] == ' ') {
            index++
        } else {
            break
        }
    }

    if (charArray[index] == '-' || charArray[index] == '+') {
        sigal = if (charArray[index] == '-') -1 else +1
        index++
    }

    while (index <= charArray.lastIndex) {
        val c = charArray[index]
        if (!c.isDigit()) break

        if (result > bndry || result == bndry && c > '7') {
            return if(sigal == 1) Integer.MAX_VALUE else Integer.MIN_VALUE
        }

        result = result * 10 + (c - '0')

        index++
    }
    return result * sigal
}