package algorithms

import java.util.LinkedList
import java.util.Queue


/**
 * 102. 二叉树的层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
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

    var list: MutableList<MutableList<Int?>> = mutableListOf()
    list.add(mutableListOf(node.`val`))
    levelTreeNode(node, list)
    System.out.println("${list.joinToString(",", transform = {
        "[${it.joinToString(",")}]"
    })}")


    levelTreeNode2(node)
}

private fun levelTreeNode(node: TreeNode?, list: MutableList<MutableList<Int?>>) {
    if(node == null) {
        return
    }

    val temp = mutableListOf<Int?>()
    if (node.left != null) {
        temp.add(node.left?.`val`)
    }
    if (node.right != null) {
        temp.add(node.right?.`val`)
    }

    levelTreeNode(node.left, list)
    levelTreeNode(node.right, list)

    if(temp.isNotEmpty()) {
        list.add(1, temp)
    }
}

fun levelTreeNode2(node: TreeNode?) {
    var list: MutableList<MutableList<Int?>> = mutableListOf()
    val queue: Queue<TreeNode?> = LinkedList()

    if (node != null) {
        queue.offer(node)
    }

    while (queue.isNotEmpty()) {
        val size = queue.size
        val level = mutableListOf<Int?>()
        for (index in 1..size) {
            val node = queue.poll()
            level.add(node?.`val`)
            if (node?.left != null) {
                queue.offer(node.left)
            }

            if (node?.right != null) {
                queue.offer(node.right)
            }
        }
        list.add(level)
    }
    System.out.println("${list.joinToString(",", transform = {
        "[${it.joinToString(",")}]"
    })}")
}
