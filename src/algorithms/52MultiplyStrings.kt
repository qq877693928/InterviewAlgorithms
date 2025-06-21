package algorithms

/**
 * 43. 字符串相乘
 * https://leetcode.cn/problems/multiply-strings/description/
 */
fun main(args: Array<String>) {
    val num1 = "123"
    val num2 = "456"
    System.out.println("${multiply(num1, num2)}")
}

private fun multiply(num1: String, num2: String): String {
    val list: MutableList<String> = mutableListOf()
    num1.reversed().forEachIndexed{ index, ch ->
        list.add(multiply(index, ch, num2.reversed()))
    }

    System.out.println("${list.joinToString()}")

    val maxLength = list.last().length
    var left: Int = 0
    var carry: Int = 0
    val result: MutableList<String> = mutableListOf()
    while (left < maxLength) {
        val sum = getAddNum(list, left) + carry
        result.add(0, "${sum % 10}")
        carry = sum / 10
        left++
    }
    if(carry > 0) {
        result.add(0, "${carry}")
    }

    return result.joinToString("")
}

fun getAddNum(list: List<String>, index: Int): Int {
    var result: Int = 0
    list.forEach {
        val char = it.getOrNull(index) ?: '0'
        result += (char - '0')
    }
    return result
}

private fun multiply(index: Int, target: Char, num2: String): String {
    val stringBuilder: StringBuilder = StringBuilder()

    var carry: Int = 0
    num2.forEachIndexed { index, c ->
        val result = (target - '0') * (c - '0') + carry
        stringBuilder.append("${(result % 10)}")
        carry = result / 10
    }
    if(carry > 0) {
        stringBuilder.append("${carry}")
    }
    val lastZeroString = StringBuilder()
    for(i in 1..index) {
        lastZeroString.append("0")
    }
    return lastZeroString.toString() + stringBuilder.toString()
}