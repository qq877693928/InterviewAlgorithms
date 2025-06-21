package algorithms

/**
 * 110. 平衡二叉树
 * https://leetcode.cn/problems/balanced-binary-tree/
 * 左右枝的最大深度不超过 1
 */
fun main(args: Array<String>) {
    val node = TreeNode(4).apply {
        left = TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        }
        right = TreeNode(6).apply {
            left = TreeNode(5)
            right = TreeNode(7).apply {
                left = TreeNode(9).apply {
                    left = TreeNode(10)
                }
            }
        }
    }

    System.out.println("${isBalanced(node)}")
}

private fun isBalanced(root: TreeNode?): Boolean {
    root ?: return true
    val left = depthTreeNode(root.left)
    val right = depthTreeNode(root.right)
    return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right)
}

private fun depthTreeNode(root: TreeNode?): Int {
    root ?: return 0

    val left = depthTreeNode(root.left)
    val right = depthTreeNode(root.right)

    return Math.max(left, right) + 1
}