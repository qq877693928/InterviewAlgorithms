package algorithms

/**
 * 98. 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/description/
 * 两种解法：
 * 1. 中序遍历看结果是是否为升序链表
 * 2. 递归调用，将min, max传入
 */
fun main(args: Array<String>) {
    val node = TreeNode(4).apply {
        left = TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        }
        right = TreeNode(6).apply {
            left = TreeNode(5)
            right = TreeNode(7)
        }
    }

    System.out.println("${isValidBST1(node)}")

    System.out.println("${isValidBST2(node)}")

}

private fun isValidBST1(root: TreeNode?): Boolean {

    val result = mutableListOf<Int>()
    getInOrderTreeNode(root, result)

    // 判断是否为升序列表
    System.out.println("${result.joinToString(",")}")

    var flag = true
    for (index in 0 until result.lastIndex) {
        if (result.get(index) >= result.get(index + 1)) {
            flag = false
        }
    }
    return flag
}

private fun getInOrderTreeNode(root: TreeNode?, result: MutableList<Int>) {
    if(root == null) {
        return
    }
    getInOrderTreeNode(root.left, result)
    result.add(root.`val`)
    getInOrderTreeNode(root.right, result)
}

private fun isValidBST2(root: TreeNode?): Boolean {
    return isValidBST(root, Int.MIN_VALUE, Int.MAX_VALUE)
}

private fun isValidBST(root: TreeNode?, min: Int, max: Int): Boolean {
    if(root == null) return true
    if (root.`val` <= min || root.`val` >= max) return false

    return isValidBST(root.left, min, root.`val`) && isValidBST(root.right, root.`val`, max)
}
