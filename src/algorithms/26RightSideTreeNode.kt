package algorithms

import java.util.LinkedList
import java.util.Queue
import kotlin.collections.joinToString

/**
 * 199. 二叉树的右视图
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/
 */
fun main(args: Array<String>) {
    val node = TreeNode(1).apply {
        left = TreeNode(2).apply {
            right = TreeNode(5)
        }
        right = TreeNode(3).apply {
            left = TreeNode(8)
            right = TreeNode(4)
        }
    }

    // 先层序遍历，然后找数组最右边
    val result = rightSideViewList(node)
    System.out.println("${result.joinToString(",")}")
}

private fun rightSideViewList(root: TreeNode?): List<Int> {
    val result: MutableList<MutableList<Int>> = mutableListOf()
    val queue: Queue<TreeNode> = LinkedList<TreeNode>()

    root?.let {
        queue.offer(it)
    }

    while (queue.isNotEmpty()) {
        val level = mutableListOf<Int>()
        val size = queue.size
        for(i in 1..size) {
            val node = queue.poll()
            level.add(node.`val`)
            node.right?.let { queue.offer(it)}
            node.left?.let { queue.offer(it)}
        }
        result.add(level)
    }
    return result.map { it.first() }
}
