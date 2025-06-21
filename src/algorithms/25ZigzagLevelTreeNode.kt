package algorithms

import java.util.LinkedList
import java.util.Queue

/**
 * 103. 二叉树的锯齿形层序遍历
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/
 */
fun main(args: Array<String>) {
    val node = TreeNode(3).apply {
        left = TreeNode(9).apply {
            right = TreeNode(8)
        }
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }

    zigzagLevelTreeNode(node)
}

private fun zigzagLevelTreeNode(node: TreeNode) {
    val result: MutableList<MutableList<Int>> = mutableListOf<MutableList<Int>>()
    val arrayQueue: Queue<TreeNode> = LinkedList<TreeNode>()

    var level = 0

    if (node != null) {
        arrayQueue.offer(node)
    }

    while (arrayQueue.isNotEmpty()) {
        val levelList = mutableListOf<Int>()
        val size = arrayQueue.size
        for(index in 1..size) {
            val curNode = arrayQueue.poll()
            if (level % 2 == 0) {
                levelList.add(0, curNode.`val`)
            } else {
                levelList.add(curNode.`val`)
            }
            if (curNode.left != null) {
                arrayQueue.offer(curNode.left)
            }
            if (curNode.right != null) {
                arrayQueue.offer(curNode.right)
            }
        }

        level++
        result.add(levelList)
    }

    System.out.println("${result.joinToString(",", transform = {
        "[${it.joinToString(",")}]"
    })}")
}
