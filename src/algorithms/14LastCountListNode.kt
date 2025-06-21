package algorithms

/**
 * LCR 140. 训练计划 II
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/description/
 * 链表中倒数第k个节点
 */
fun main(args: Array<String>) {
    val node = LinkedNode(1).apply {
        next = LinkedNode(2).apply {
            next = LinkedNode(3).apply {
                next = LinkedNode(4).apply {
                    next = LinkedNode(5).apply {
                        next = LinkedNode(6)
                    }
                }
            }
        }
    }

    printListNode(findLastKLinkedNode(node, 2))
}

private fun findLastKLinkedNode(head: LinkedNode?, count: Int): LinkedNode? {
    // todo 下一个算法更优
    var slow: LinkedNode? = head
    var fast: LinkedNode? = head
    for(i in 1..count) {
        fast = fast?.next
    }
    while (fast != null) {
        slow = slow?.next
        fast = fast?.next
    }
    return slow
}


