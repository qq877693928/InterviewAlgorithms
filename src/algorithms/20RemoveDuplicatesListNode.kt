package algorithms

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 */
fun main(args: Array<String>) {
    var list: LinkedNode? = LinkedNode(1).apply {
        next = LinkedNode(1).apply {
            next = LinkedNode(2).apply {
                next= LinkedNode(3).apply {
                    next = LinkedNode(3).apply {
                        next = LinkedNode(4)
                    }
                }
            }
        }
    }

    printListNode(removeDuplicates(list))
}

private fun removeDuplicates(head: LinkedNode?): LinkedNode? {
    val map: MutableMap<Int, Int> = LinkedHashMap<Int, Int>()
    var cur: LinkedNode? = head

    while (cur != null) {
        val sum = map.get(cur.value) ?: 0
        map.put(cur.value, sum + 1)
        cur = cur.next
    }

    var pre: LinkedNode? = LinkedNode(-1).apply {
        next = head
    }
    var list: LinkedNode? = pre
    map.forEach {
        val temp = LinkedNode(it.key)
        pre?.next = temp
        pre = pre?.next
    }
    return list?.next
}


