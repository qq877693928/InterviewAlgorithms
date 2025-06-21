package algorithms

/**
 * 143. 重排链表
 * https://leetcode.cn/problems/reorder-list/description/
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

    var lastNode = findMidLastLinkedNode(head = node)
    printListNode(node)
    lastNode = reversedLinkedNode(lastNode)

    printListNode(lastNode)

    printListNode(mergeLikedNode3(node, lastNode, 0))

    printListNode(node)
}

private fun findMidLastLinkedNode(head: LinkedNode): LinkedNode? {
    var pre: LinkedNode? = LinkedNode(-1).apply {
        next = head
    }
    var slow: LinkedNode? = head
    var fast: LinkedNode? = head
    while (fast != null) {
        slow = slow?.next
        pre = pre?.next
        fast = fast?.next?.next
    }

    pre?.next = null

    return slow
}

private fun reversedLinkedNode(head: LinkedNode?): LinkedNode? {
    if(head == null) return head
    var pre: LinkedNode? = null
    var cur: LinkedNode? = head
    while (cur != null) {
        val temp = cur.next
        cur.next = pre
        pre = cur
        cur = temp
    }
    return pre
}

//private fun mergeLikedNode3(node1: LinkedNode?, node2: LinkedNode?) {
//    var l1: LinkedNode? = node1
//    var l2: LinkedNode? = node2
//    var tempL1: LinkedNode? = null
//    var tempL2: LinkedNode? = null
//    while (l1 != null && l2 != null) {
//        tempL1 = l1
//        tempL2 = l2
//
//        l1 = l1.next
//        l2 = l2.next
//
//        tempL1.next = tempL2
//        tempL2.next = l1
//    }
//}

private fun mergeLikedNode3(node1: LinkedNode?, node2: LinkedNode?, start: Int): LinkedNode? {
    if(node1 == null || node2 ==null) {
        return node1 ?: node2
    }

    if (start % 2 == 0) {
        node1.next = mergeLikedNode3(node1.next, node2, start + 1)
        return node1
    } else {
        node2.next = mergeLikedNode3(node1, node2.next, start + 1)
        return node2
    }
}
