package algorithms

/**
 * 148. 排序链表
 * https://leetcode.cn/problems/sort-list/description/
 * 两种思路：
 * 1. 递归调用二分拆解成列表，然后再合并
 * 2. 将链表拆成Array，循环合并
 */
fun main(args: Array<String>) {
    var list: LinkedNode? = LinkedNode(5).apply {
        next = LinkedNode(3).apply {
            next= LinkedNode(2).apply {
                next = LinkedNode(4).apply {
                    next= LinkedNode(7).apply {
                        next = LinkedNode(1)
                    }
                }
            }
        }
    }

/*    // 方案一：
    printListNode(sortList(list))*/

    // 方案二：
    val array = splitListNodeArray(list)
    val mergeList = mergeNLinkedNode(array, 0, array.lastIndex)
    printListNode(mergeList)
}

//private fun sortList(head: LinkedNode?): LinkedNode? {
//    if(head?.next == null) return head
//
//    printListNode(head)
//    val midNode = findMidNode(head)
//    val rightNode = midNode?.next
//    midNode?.next = null
//
//    val left = sortList(head)
//    val right = sortList(rightNode)
//
//    return mergeLists(left, right)
//}
//
//private fun findMidNode(node: LinkedNode?): LinkedNode? {
//    var slow: LinkedNode? = node
//    var fast: LinkedNode? = node?.next
//    while (fast?.next != null) {
//        slow = slow?.next
//        fast = fast?.next?.next
//    }
//    return slow
//}

fun splitListNodeArray(list: LinkedNode?): Array<LinkedNode> {
    if (list == null) return arrayOf()

    val result: MutableList<LinkedNode> = mutableListOf()

    var cur: LinkedNode? = list
    while (cur != null) {
        val temp: LinkedNode = cur
        cur = cur.next
        temp.next = null
        result.add(temp)
    }
    return result.toTypedArray()
}

fun mergeNLinkedNode(array: Array<LinkedNode>, left: Int, right: Int): LinkedNode? {
    if(left == right) return array.get(left)
    val mid = left + (right - left) / 2
    val leftNode = mergeNLinkedNode(array, left, mid)
    val rightNode = mergeNLinkedNode(array, mid+1, right)
    return mergeLists(leftNode, rightNode)
}

private fun mergeLists(list1: LinkedNode?, list2: LinkedNode?): LinkedNode? {
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