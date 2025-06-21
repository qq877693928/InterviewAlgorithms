package algorithms

/**
 * 124. 二叉树中的最大路径和
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/
 */
fun main(args: Array<String>) {
    val node = TreeNode(-10).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }

    System.out.println("${diameterOfBinaryTree(node)}")
}

private var sum: Int = Int.MIN_VALUE

private fun diameterOfBinaryTree(root: TreeNode?): Int {
    depthBinaryTreeNode(root)
    return sum
}

private fun depthBinaryTreeNode(root: TreeNode?): Int {
    root ?: return 0

    val left = Math.max(depthBinaryTreeNode(root.left), 0)
    val right = Math.max(depthBinaryTreeNode(root.right), 0)

    val depthSum = left + right + root.`val`

    sum = Math.max(sum, Math.max(depthSum, 0))

    return Math.max(left, right) + root.`val`
}

