package algorithms

/**
 * 92. 反转链表 II
 * https://leetcode.cn/problems/reverse-linked-list-ii/description/
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

    printListNode(reverseBetween(node, 2, 4))
//    printListNode(reverseNode(node))


}

fun reverseBetween(head: LinkedNode?, left: Int, right: Int): LinkedNode? {

    var pre: LinkedNode? = head
    for(index in 0 until (left - 2)) {
        pre = pre?.next
    }

    var leftNode: LinkedNode? = pre?.next
    var rightNode: LinkedNode? = pre?.next
    for (index in 0 until (right - left)) {
        rightNode = rightNode?.next
    }

    pre?.next = null
    printListNode(pre)
    val cur = rightNode?.next
    rightNode?.next = null

    val next = reverseNode(leftNode)
    pre?.next = next
    leftNode?.next = cur

    return head

}

private fun reverseNode(head: LinkedNode?): LinkedNode? {
    if (head == null) return head

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