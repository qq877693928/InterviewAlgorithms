package algorithms

import kotlin.collections.joinToString

/**
 * 93. 复原 IP 地址
 * https://leetcode.cn/problems/restore-ip-addresses/description/
 * 可以参考：53ValidateIpAddress.kt
 */
fun main(args: Array<String>) {
    val str = "0000"

    restoreIpAddresses(str)
}

private fun restoreIpAddresses(s: String): List<String> {
    val result: MutableList<List<String>> = mutableListOf()
    backIpTrack(s, 0, result, mutableListOf())
    System.out.println("${result.joinToString(transform = {
        "[${it.joinToString()}]"
    })}")
    return result.map { it.joinToString(".") }
}

private fun backIpTrack(s: String, start: Int, result: MutableList<List<String>>, path: MutableList<String>) {

    if (path.size == 4 && path.toList().joinToString("").length == s.length) {
        result.add(path.toList())
        return
    }

    for (len in 1..3) {
        if (start + len > s.length) break
        if (path.size > 4) break
        val segment = s.substring(start, start + len)
        if (Integer.valueOf(segment) > 255) continue

        path.add(segment)
        backIpTrack(s, start + len, result, path)

        path.removeLast()
    }
}