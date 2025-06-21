fun main(args: Array<String>) {

//    输入：strs = ["flower","flow","flight"]
//    输出："fl"
//    示例 2：
//    输入：strs = ["dog","racecar","car"]
//    输出：""


    val strArray = arrayOf("dog","racecar","car")
    val result = findPreString(strArray)
    System.out.print("$result")
}

fun findPreString(strArray: Array<String>?): String {
    val stringBuilder = StringBuilder("")
    if(strArray.isNullOrEmpty()) {
        return stringBuilder.toString()
    }
    val targetString = strArray.getOrNull(0)
    if(targetString.isNullOrEmpty()) {
        return stringBuilder.toString()
    }
    targetString.toCharArray().forEachIndexed { index, ch ->
        if(continerCharInArray(ch, index,strArray)) {
            stringBuilder.append(ch.toString())
        }
    }
    return stringBuilder.toString()
}

fun continerCharInArray(ch: Char, index: Int, strArray: Array<String>): Boolean {
    var result = true
    strArray.forEach {
        if(it.toCharArray().getOrNull(index) != ch) {
            result = false
        }
    }
    return result
}
