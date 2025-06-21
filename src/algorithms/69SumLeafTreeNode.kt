package algorithms

/**
 * 129. 求根节点到叶节点数字之和
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/
 */
fun main(args: Array<String>) {
    val node = TreeNode(4).apply {
        left = TreeNode(9).apply {
            left = TreeNode(5)
            right = TreeNode(1)
        }
        right = TreeNode(0)
    }
    val result = sumNumbers(node)
}

private fun sumNumbers(root: TreeNode?): Int {
    if(root == null) return 0
    return dfs(root, 0)
}

private fun dfs(root: TreeNode?, preNum: Int): Int {
    if(root == null) return 0
    val sum = preNum * 10 + root.`val`
    if (root.left == null && root.right == null) {
        System.out.println(sum)
        return sum
    } else {
        return dfs(root.left, sum) + dfs(root.right, sum)
    }
}