package algorithms

/**
 * 22. 括号生成
 * https://leetcode.cn/problems/generate-parentheses/description/
 */
fun main(args: Array<String>) {
    val list = generateParenthesis(3)
    System.out.println("${list.joinToString()}")
}

private fun generateParenthesis(n: Int): List<String> {
    val result = mutableListOf<String>()
    parenthesisBacktrack(n, n, result, mutableListOf())
    return result.toList()
}

private fun parenthesisBacktrack(left: Int, right: Int, result: MutableList<String>, path: MutableList<String>) {

    if (left == 0 && right == 0) {
        result.add(path.joinToString(""))
        return
    }

    if (left > 0) {
        path.add("(")
        parenthesisBacktrack(left - 1, right, result, path)
        path.removeLast()
    }

    //右括号个数没有左括号多，所以需要加上条件 left < right
    if (right > 0 && left < right) {
        path.add(")")
        parenthesisBacktrack(left, right - 1, result, path)
        path.removeLast()
    }

//    }
}