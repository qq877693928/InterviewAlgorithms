package algorithms

/**
 * 226. 翻转二叉树
 * https://leetcode.cn/problems/invert-binary-tree/description/
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

    levelTreeNode2(node)

    levelTreeNode2(invertTree(root = node))
}

fun invertTree(root: TreeNode?): TreeNode? {
    root ?: return root

    val temp = root.left
    root.left = root.right
    root.right = temp

    invertTree(root.left)
    invertTree(root.right)

    return root
}