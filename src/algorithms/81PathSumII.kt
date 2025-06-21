package algorithms

/**
 * 113. 路径总和 II
 * https://leetcode.cn/problems/path-sum-ii/
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
                left = TreeNode(5)
                right = TreeNode(1)
            }
        }
    }

    pathSum(node, 22)
}

private fun pathSum(root: TreeNode?, targetSum: Int): List<Int> {
    val result: MutableList<List<Int>> = mutableListOf()
    backTrackPathSum(root, targetSum, mutableListOf(), result)

    System.out.println("${result.joinToString(transform = {
        "[${it.joinToString()}]"
    })}")

    return emptyList()
}


private fun backTrackPathSum(root: TreeNode?, targetSum: Int, path: MutableList<Int>, result: MutableList<List<Int>>) {
    if (root == null) {
        return
    }

    if (root.`val` == targetSum) {
        // 最后一个元素缺失，那么在这里终止，那么就在下一次终止，条件为targetSum <= 0
        result.add(path.apply {
            add(targetSum)
        }.toList())
        return
    }
//    if (targetSum == 0) {
//        result.add(path.toList())
//        return
//    }


    // 这里不需要for-each循环，因为只有一种情况
    if (targetSum < 0) return

    path.add(root.`val`)
    backTrackPathSum(root.left, targetSum - root.`val`, path, result)
    backTrackPathSum(root.right, targetSum - root.`val`, path, result)

    path.removeLast()
}