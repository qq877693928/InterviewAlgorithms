package algorithms

/**
 * 468. 验证IP地址（校验一个字符串有几种合法的IP的组合）
 * https://leetcode.cn/problems/validate-ip-address/description/
 * 熟悉回溯法的流程，一通百通
 */
fun main(args: Array<String>) {
    val ipAddressStr = "25519216081"
    val n = 8

    System.out.println("${getIpIndex(ipAddressStr, n).joinToString(transform = {
        "[${it.joinToString()}]"
    })}")
}

private var res: MutableList<List<String>> = mutableListOf()

private fun getIpIndex(ipAddressStr: String, size: Int): List<List<String>> {
    backTrack(ipAddressStr, 0, size, mutableListOf<String>())
    return res
}

private fun backTrack(ipAddressStr: String, start: Int, size: Int, path: MutableList<String>) {
    if (path.size == 4) {
        // 关键剪枝
        if (start == ipAddressStr.length) {
            res.add(path.toList())
        }
        return
    }

    for (len in 1..3) {
        if (start + len > ipAddressStr.length) break
        if (path.size >= 4) break
        val segment = ipAddressStr.substring(start, start + len)
        if (segment.startsWith("0") || segment.toInt() > 255) continue
        path.add(segment)
        backTrack(ipAddressStr, start + len, size, path)
        path.removeLast()
    }
}
