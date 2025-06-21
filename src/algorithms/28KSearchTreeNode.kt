package algorithms

/**
 * LCR 174. 寻找二叉搜索树中的目标节点
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/description/
 */
fun main(args: Array<String>) {
    val node = TreeNode(4).apply {
        left = TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        }
        right = TreeNode(6).apply {
            left = TreeNode(5)
        }
    }

    System.out.println("${findTargetNode(node, 4)}")

}

private fun findTargetNode(root: TreeNode?, cnt: Int): Int {
    val list = mutableListOf<Int>()
    inOrderTreeNode(root, list)
    System.out.println("${list.joinToString(",")}")
    return list.get(cnt - 1)
}

private fun inOrderTreeNode(root: TreeNode?, list: MutableList<Int>) {
    root ?: return
    inOrderTreeNode(root.left, list)
    list.add(0, root.`val`)
    inOrderTreeNode(root.right, list)
}
