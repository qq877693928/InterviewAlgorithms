package algorithms

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 */
fun main(args: Array<String>) {

    val p = TreeNode(3)
    val q = TreeNode(1)

    val node = TreeNode(4).apply {
        left = TreeNode(2).apply {
            left = q
            right = p
        }
        right = TreeNode(6).apply {
            left = TreeNode(5)
            right = TreeNode(7)
        }
    }

    val result = lowestCommonAncestor(node, p, q)
    System.out.println("${result?.`val`}")
}

private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || root == p || root == q) return root

    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)

    if (left == null) return right
    if (right == null) return left

    return root

}