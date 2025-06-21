package algorithms

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
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

    printListNode(deleteLastNLinkedNode(node, 1))
}

fun deleteLastNLinkedNode(head: LinkedNode, lastN: Int): LinkedNode? {
    var pre: LinkedNode? = LinkedNode(-1).apply {
        next = head
    }
    var slow: LinkedNode? = pre
    var fast: LinkedNode? = pre

    for(i in 1..lastN) {
        fast = fast?.next
    }

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast?.next
    }

    slow?.next = slow.next?.next
    return pre?.next
}



