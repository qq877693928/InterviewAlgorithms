fun main() {
    val x = 34211
    val result = swapInt(x)
    System.out.print("$result")
}

fun swapInt(x: Int): Int {
    var num = x
    var result = 0
    while (num != 0) {
        val digit = num % 10
        val temp = result * 10L + digit
        Int.MAX_VALUE
        result = temp.toInt()
        num /= 10
    }
    return result
}



//fun swapInt(x: Int): Int {
//    var num = x
//    var result = 0
//    while (num != 0) {
//        val digit = num % 10
//        val temp = result * 10L + digit // 使用Long防止溢出
//        if (temp > Int.MAX_VALUE || temp < Int.MIN_VALUE) return 0
//        result = temp.toInt()
//        num /= 10
//    }
//    return result
//}