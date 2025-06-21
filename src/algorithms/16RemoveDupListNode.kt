package algorithms

import java.util.Stack

/**
 * 82. 删除排序链表中的重复元素 II
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/
 */
fun main(args: Array<String>) {
    val node = LinkedNode(1).apply {
        next = LinkedNode(1).apply {
            next = LinkedNode(1).apply {
                next = LinkedNode(4).apply {
                    next = LinkedNode(5).apply {
                        next = LinkedNode(5).apply {
                            next = LinkedNode(6)
                        }
                    }
                }
            }
        }
    }

    printListNode(removeDupLinkedNode(node))
}

private fun removeDupLinkedNode(head: LinkedNode): LinkedNode? {
    val map: LinkedHashMap<Int, Int> = LinkedHashMap<Int, Int>()

    var cur: LinkedNode? = head
    while (cur != null) {
        val sum = map.get(cur.value) ?: 0
        map.put(cur.value, sum + 1)
        cur = cur.next
    }

    System.out.println("${map.toList().joinToString(",", transform = { "[${it.first}, ${it.second}]"})}")

    var dummy:LinkedNode? = LinkedNode(-1)
    var pre:LinkedNode? = dummy
    map.forEach {
        if (it.value == 1) {
            val temp = LinkedNode(it.key)
            dummy?.next = temp
            dummy = dummy?.next
        }
    }
    return pre?.next
}



