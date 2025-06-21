package algorithms

/**
 * 104. 二叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
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

    System.out.println("${maxTreeNodeDepth(node)}")
}

private fun maxTreeNodeDepth(root: TreeNode?): Int {
    root ?: return 0

    return Math.max(maxTreeNodeDepth(root.left), maxTreeNodeDepth(root.right)) + 1
}