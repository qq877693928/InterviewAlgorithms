package algorithms

import java.util.LinkedList
import java.util.Queue

/**
 * 958. 二叉树的完全性检验
 * https://leetcode.cn/problems/check-completeness-of-a-binary-tree/description/
 */
fun main(args: Array<String>) {
    val node = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(5)
        }
        right = TreeNode(3).apply {
            left = TreeNode(6)
            right = TreeNode(7)
        }
    }

    System.out.println("${isCompleteTree(node)}")

}

private fun isCompleteTree(root: TreeNode?): Boolean {
    root ?: return true
    val res: MutableList<MutableList<Int?>> = mutableListOf()
    val queue: Queue<TreeNode> = LinkedList<TreeNode>()

    var nullOfFlag: Boolean = false
    var result: Boolean = true
    queue.offer(root)
    while (queue.isNotEmpty()) {
        val level: MutableList<Int?> = mutableListOf()
        val node: TreeNode? = queue.poll()
        level.add(node?.`val`)
        // 不使用、val size = queue.size、的for-each遍历让所有的元素单一，判断非空问题
        if (node == null) {
            nullOfFlag = true
        } else {
            if (nullOfFlag) {
                // 若已遇空节点后又出现非空节点，则非完全二叉树，在非空分支判断
                result = false
                break
            }
            queue.offer(node.left)
            queue.offer(node.right)
        }

        res.add(level)
    }
    System.out.println("${res.joinToString("", transform = {
        "[${it.joinToString()}]"
    })}")
    return result
}
