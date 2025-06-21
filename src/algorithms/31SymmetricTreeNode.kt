package algorithms

import java.util.LinkedList
import java.util.Queue

/**
 * 101. 对称二叉树
 * https://leetcode.cn/problems/symmetric-tree/description/
 */
fun main(args: Array<String>) {
    val node = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3)
            right = TreeNode(4)
        }
        right = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(3)
        }
    }

    // 解法一：使用层序遍历，判断每层反转后是否相同
    System.out.println("${isSymmetric(node)}")

    // 解法二：递归调用
    System.out.println("${isSymmetric2(node)}")
}

private fun isSymmetric2(root: TreeNode?): Boolean {
    return isSymmetric2(root?.left, root?.right)
}

private fun isSymmetric2(left: TreeNode?, right: TreeNode?): Boolean {
    if(left == null && right == null) return true
    if(left?.`val` != right?.`val`) return false
    return isSymmetric2(left?.left, right?.right) && isSymmetric2(left?.right, right?.left)
}

private fun isSymmetric(root: TreeNode?): Boolean {
    val list: MutableList<MutableList<Int?>> = mutableListOf()
    levelOrderTreeNode(root, list)

    var flag = true
    list.forEach {
        if(it.joinToString() != it.reversed().joinToString()) {
            flag = false
        }
    }
    System.out.println("${list.joinToString(",", transform = {
        "[${it.joinToString(",")}]"
    })}")
    return flag
}

private fun levelOrderTreeNode(root: TreeNode?, list: MutableList<MutableList<Int?>>) {
    val queue: Queue<TreeNode?> = LinkedList<TreeNode?>()

    root?.let {
        queue.offer(it)
    }

    while (queue.isNotEmpty()) {
        val level = mutableListOf<Int?>()
        val size = queue.size
        for(index in 1..size) {
            val node = queue.poll()
            level.add(node?.`val`)
            node?.left?.let {
                queue.offer(it)
            }
            node?.right?.let {
                queue.offer(it)
            }
        }
        list.add(level)
    }
}
