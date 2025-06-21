package algorithms

/**
 * 112. 路径总和
 * https://leetcode.cn/problems/path-sum/
 */
fun main(args: Array<String>) {
    val node = TreeNode(5).apply {
        left = TreeNode(4).apply {
            left = TreeNode(11).apply {
                left = TreeNode(7)
                right = TreeNode(2)
            }
        }
        right = TreeNode(8).apply {
            left = TreeNode(13)
            right = TreeNode(4).apply {
                right = TreeNode(1)
            }
        }
    }


    System.out.println("${hasPathSum(node, 22)}")
}

private fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return true
    if (root.left == null && root.right == null) {
        return root.`val` == targetSum
    } else {
        return hasPathSum(root?.left, targetSum - root.`val`) || hasPathSum(root?.right, targetSum - root.`val`)
    }
}