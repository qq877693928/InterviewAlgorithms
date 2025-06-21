package algorithms

/**
 * 144. 二叉树的前序遍历, 94. 二叉树的中序遍历
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 */
fun main(args: Array<String>) {
    val node = TreeNode(1).apply {
        right = TreeNode(2).apply {
            left = TreeNode(3)
        }
    }


    val list = mutableListOf<Int?>()
    preOrderTreeNode(node, list)
    System.out.println("${list.joinToString(",")}")
}

fun preOrderTreeNode(node: TreeNode?, list: MutableList<Int?>) {
    if(node == null) return

    list.add(node.`val`)
    preOrderTreeNode(node.left, list)
    preOrderTreeNode(node.right, list)
}

class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}