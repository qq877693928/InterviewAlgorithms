package algorithms

/**
 * 141. 环形链表
 */
fun main(args: Array<String>) {
    val endNode = ListNode(-4)
    val pointNode = ListNode(0).apply {
        next = ListNode(4).apply {
            next = endNode
        }
    }
    endNode.next = pointNode
    var node: ListNode? = ListNode(3).apply {
        next = ListNode(2).apply {
            next = pointNode
        }
    }

    System.out.println("${hasCycle(node)}")
}

fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head
    while (true) {
        if (slow == null || fast == null) {
            return false
        }

        slow = slow.next
        fast = fast.next?.next
        if (slow == fast) {
            return true
        }
    }
}