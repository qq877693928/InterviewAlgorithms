package algorithms

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
fun main(args: Array<String>) {

    val preorder = intArrayOf(3,9,20,15,7)
    val inorder = intArrayOf(9,3,15,20,7)

    levelTreeNode2(buildTree(preorder, inorder))

}

private fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    val preLastIndex = preorder.lastIndex
    val inLastIndex = inorder.lastIndex

    if(preLastIndex != inLastIndex) {
        return null
    }

    // 中序遍历的下标信息
    val map: MutableMap<Int, Int> = mutableMapOf()
    inorder.forEachIndexed { index, value ->
        map.put(value, index)
    }

    return buildTree(preorder, map, 0, preLastIndex, 0, inLastIndex)
}

private fun buildTree(preorder: IntArray, map: Map<Int, Int>, preIndex: Int, preLastIndex: Int, inIndex: Int, inLastIndex: Int): TreeNode? {
    if(preIndex > preLastIndex || inIndex > inLastIndex) {
        return null
    }

    val rootValue = preorder.get(preIndex)
    val inRootIndex = map.get(rootValue) ?: 0
    val node = TreeNode(rootValue)
    node.left = buildTree(preorder, map, preIndex + 1, (inRootIndex - inIndex + preIndex), inIndex, inRootIndex - 1)
    node.right =
        buildTree(preorder, map, (inRootIndex - inIndex + preIndex) + 1, preLastIndex, inRootIndex + 1, inLastIndex)
    return node
}

