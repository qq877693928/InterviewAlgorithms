package algorithms

/**
 * 21. 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 */
fun main(args: Array<String>) {
    var node1: LinkedNode? = LinkedNode(1).apply {
        next = LinkedNode(2).apply {
            next= LinkedNode(4)
        }
    }
    var node2: LinkedNode? = LinkedNode(1).apply {
        next = LinkedNode(3).apply {
            next= LinkedNode(4)
        }
    }

    printListNode(mergeTwoLists(node1, node2))
}

fun mergeTwoLists(list1: LinkedNode?, list2: LinkedNode?): LinkedNode? {
    if (list1 == null || list2 == null) {
        return list1 ?: list2
    }
    if (list1.value < list2.value) {
        list1.next = mergeTwoLists(list1.next, list2)
        return list1
    } else {
        list2.next = mergeTwoLists(list1, list2.next)
        return list2
    }
}

class LinkedNode(val value: Int) {
    var next: LinkedNode? = null
    fun getElement() = value
}

fun printListNode(node: LinkedNode?) {
    var listNode: LinkedNode? = node
    while (listNode != null) {
        System.out.print("${listNode?.value}")
        if (listNode.next != null) {
            System.out.print(" -> ")
        }
        listNode = listNode.next
    }
    System.out.println("")
}