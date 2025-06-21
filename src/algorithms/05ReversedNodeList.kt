package algorithms

/**
 * 206. 反转链表
 */
fun main(args: Array<String>) {
    var node: ListNode? = ListNode(1).apply {
        next = ListNode(2).apply {
            next= ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }
    printListNode( reverseList(node))

}

fun reverseList(head: ListNode?): ListNode? {
    if(head == null) return head

    var pre: ListNode? = null
    var cur = head

    while (cur != null) {
        val temp = cur.next
        cur.next = pre
        pre = cur
        cur = temp
    }

    return pre
}

fun printListNode(node: ListNode?) {
    var listNode: ListNode? = node
    while (listNode != null) {
        System.out.print("${listNode?.value} -> ")
        listNode = listNode.next
    }
}

class ListNode(var value: Int? =null) {
    var next: ListNode? = null
}