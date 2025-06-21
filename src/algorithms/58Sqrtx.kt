package algorithms

/**
 * 69. x 的平方根
 * https://leetcode.cn/problems/sqrtx/description/
 */
fun main(args: Array<String>) {
    val x = 4
    System.out.println("${sqarts(x, x.toDouble())}")
}

private fun sqarts(a: Int, x: Double): Double {
    val res: Double = (x + a/x) / 2
    if(Math.abs(res - x) < 1) {
        return res
    }else {
        return sqarts(a, res)
    }
}