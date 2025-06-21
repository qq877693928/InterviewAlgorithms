package algorithms

/**
 * 543. 二叉树的直径
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/
 */
fun main(args: Array<String>) {
    val node = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(5)
        }
        right = TreeNode(3)
    }

    System.out.println("${diameterOfBinaryTree(node)}")
}

var ans: Int = Int.MIN_VALUE

private fun diameterOfBinaryTree(root: TreeNode?): Int {
    depthBinaryTreeNode(root)
    return ans
}

private fun depthBinaryTreeNode(root: TreeNode?): Int {
    root ?: return 0

    val left = depthBinaryTreeNode(root.left)
    val right = depthBinaryTreeNode(root.right)

    ans = Math.max(ans, left + right)

    return Math.max(left, right) + 1
}

