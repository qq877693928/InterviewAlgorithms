package algorithms

/**
 * 160. 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 */
fun main(args: Array<String>) {
    val node = LinkedNode(8).apply {
        next = LinkedNode(4).apply {
            next = LinkedNode(5)
        }
    }
    val node1 = LinkedNode(4).apply {
        next = LinkedNode(1).apply {
            next = node
        }
    }
    val node2 = LinkedNode(5).apply {
        next = LinkedNode(6).apply {
            next = LinkedNode(1).apply {
                next = node
            }
        }
    }

    printListNode(getIntersectionNode(node1, node2))

}

//fun getIntersectionNode(headA:LinkedNode, headB:LinkedNode):LinkedNode? {
//    val sett = mutableSetOf<ListNode>()
//    var length1 = 0
//    var head1:LinkedNode? = headA
//    while (head1 != null) {
//        head1 = head1.next
//        length1++
//    }
//
//    var length2 = 0
//    var head2:LinkedNode? = headB
//    while (head2 != null) {
//        head2 = head2.next
//        length2++
//    }
//
//    head1 = headA
//    head2 = headB
//    if (length1 > length2) {
//        for (index in 0 until (length1 - length2)) {
//            head1 = head1?.next
//        }
//    } else {
//        for (index in 0 until (length2 - length1)) {
//            head2 = head2?.next
//        }
//    }
//
//    printListNode(head1)
//    printListNode(head2)
//
//    var result: LinkedNode? = null
//    while (head2 != null && head1 != null) {
//        if (head1 == head2) {
//            result = head1
//            break
//        }
//        head1 = head1.next
//        head2 = head2.next
//    }
//
//    return result
//}

fun getIntersectionNode(headA: LinkedNode?, headB: LinkedNode?): LinkedNode? {
    val visitedSet = mutableSetOf<LinkedNode>()
    var temp: LinkedNode? = headA
    while (temp != null) {
        visitedSet.add(temp)
        temp = temp.next
    }
    temp = headB
    while (temp != null) {
        if (visitedSet.contains(temp)) {
            return temp
        }
        temp = temp.next
    }
    return null
}