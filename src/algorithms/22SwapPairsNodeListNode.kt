package algorithms

/**
 * 24. 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 * 两种解法：
 * 1. 递归法
 * 2. 分治法
 */
fun main(args: Array<String>) {
    var list: LinkedNode? = LinkedNode(1).apply {
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

    // 递归法, 不支持k值的传入，默认是2
    printListNode(swapPairsNode(list))


    list = LinkedNode(1).apply {
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
    // 分治法
    printListNode(swapPairsNode(list, 2))
}

private fun swapPairsNode(head: LinkedNode?): LinkedNode? {
    if(head == null || head.next == null) return head

    val next = head.next
    head.next = swapPairsNode(head.next?.next)
    next?.next = head

    return next
}


private fun swapPairsNode(head: LinkedNode?, k: Int): LinkedNode? {
    if(head == null || head.next == null) return head
    var cur: LinkedNode? = head
    var pre: LinkedNode? = LinkedNode(-1).apply {
        next = head
    }

    val result = mutableListOf<LinkedNode?>()

    while (cur != null) {
        val dummy = LinkedNode(-1).apply {
            next = cur
        }
        var index = 1
        while (index < k && cur?.next != null) {
            cur = cur?.next
            index++
        }

        val next = cur?.next
        cur?.next = null

        result.add(reservedLinkedNode(dummy.next))

        cur = next
    }

    return mergeLinkedNode(result.toTypedArray())
}

private fun mergeLinkedNode(array: Array<LinkedNode?>): LinkedNode? {
    val pre : LinkedNode = LinkedNode(-1)
    var cur: LinkedNode? = pre
    array.forEach {
        cur?.next = it
        printListNode(it)
        while (cur?.next != null) {
            cur = cur?.next
        }
    }
    return pre.next
}


private fun reservedLinkedNode(head: LinkedNode?): LinkedNode? {
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


