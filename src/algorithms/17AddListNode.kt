package algorithms

import java.util.Stack

/**
 * 2. 两数相加
 * https://leetcode.cn/problems/add-two-numbers/description/
 */
fun main(args: Array<String>) {
    val node1 = LinkedNode(4).apply {
        next = LinkedNode(4).apply {
            next = LinkedNode(3).apply {
            }
        }
    }

    val node2 = LinkedNode(5).apply {
        next = LinkedNode(6).apply {
            next = LinkedNode(4).apply {
            }
        }
    }

    printListNode(addTwoNum(node1, node2))
}

private fun addTwoNum(node1: LinkedNode?, node2: LinkedNode?): LinkedNode? {
    var dummy: LinkedNode? = LinkedNode(-1)
    var result: LinkedNode? = dummy

    var list1 = reversedListNode(node1)
    printListNode(list1)

    var list2 = reversedListNode(node2)
    printListNode(list2)

    var carry = 0

    while (list1 != null && list2 != null) {
        val total = list1.value + list2.value + carry
        carry = total / 10

        val temp = LinkedNode(total % 10)
        dummy?.next = temp
        dummy = dummy?.next

        list1 = list1.next
        list2 = list2.next
    }

    if (carry > 0) {
        val temp = LinkedNode(carry)
        dummy?.next = temp
    }


    return result?.next
}


private fun reversedListNode(head: LinkedNode?): LinkedNode? {
    if(head == null || head.next == null) return head

    var cur: LinkedNode? = head
    var pre: LinkedNode? = null
    while (cur != null) {
        val temp = cur.next
        cur.next = pre
        pre = cur
        cur = temp
    }
    return pre
}



