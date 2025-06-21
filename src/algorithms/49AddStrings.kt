package algorithms

/**
 * 415. 字符串相加
 * https://leetcode.cn/problems/add-strings/
 */
fun main(args: Array<String>) {
    val num1 = "456"
    val num2 = "77"
    System.out.println("result: ${addStrings(num1, num2)}")
}

private fun addStrings(num1: String, num2: String): String {
    val array1: CharArray = num1.toCharArray()
    val array2: CharArray = num2.toCharArray()

    var index1 = num1.lastIndex
    var index2 = num2.lastIndex
    val stringBuilder = StringBuilder()

    var carry: Int = 0
    while(index1 >= 0 || index2 >= 0) {
        val sum1 = if(index1 >= 0) {
            array1.get(index1) - '0'
        }else {
            0
        }

        val sum2 = if(index2 >= 0) {
            array2.get(index2) - '0'
        }else {
            0
        }

        val result = sum1 + sum2 + carry

        stringBuilder.append((result % 10).toString())
        carry = (result / 10).toInt()

        index1--
        index2--
    }

    if (carry != 0) {
        stringBuilder.append(carry.toString())
    }
    return stringBuilder.toString().reversed()
}