package algorithms

/**
 * 23. 合并 K 个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 */
fun main(args: Array<String>) {
    val list = arrayOf<LinkedNode>(
        LinkedNode(1).apply {
            next = LinkedNode(4).apply {
                next = LinkedNode(5)
            }
        },
        LinkedNode(1).apply {
            next = LinkedNode(3).apply {
                next = LinkedNode(4)
            }
        },
        LinkedNode(2).apply {
            next = LinkedNode(6)
        }
    )

    val result = mergeKLinkedNode(list, 0, list.lastIndex)
    printListNode(result)
}

private fun mergeKLinkedNode(list: Array<LinkedNode>, left: Int, right: Int): LinkedNode? {
    if(left == right) return list.get(left)
    val mid = left + (right - left) / 2
    val node1: LinkedNode? = mergeKLinkedNode(list, left, mid)
    val node2: LinkedNode? = mergeKLinkedNode(list, mid + 1, right)
    return mergeLinkedNode2(node1, node2)
}

/**
 * 合并两个已经排序的链表
 */
private fun mergeLinkedNode2(list1: LinkedNode?, list2: LinkedNode?): LinkedNode? {
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
