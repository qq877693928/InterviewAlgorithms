package algorithms

/**
 * 25. K 个一组翻转链表
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 */
fun main(args: Array<String>) {
    var node: ListNode? = ListNode(1).apply {
        next = ListNode(2).apply {
            next= ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5).apply {
                        next = ListNode(6)
                    }
                }
            }
        }
    }
    printListNode(reverseKGroup(node, 3))

}

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if(head == null || head.next == null) return null

    var node = head
    var merge: ListNode = ListNode(null)
    val result = merge
    while (node != null) {
        var dumpyNode = ListNode(null)
        val groupNode = dumpyNode
        for(index in 0 until k) {
            val temp = ListNode(node?.value)
            dumpyNode.next = temp
            dumpyNode = temp
            node = node?.next
        }
//        printListNode(reverseNode(groupNode))
//        addListNodeToResult(reverseNode(groupNode), merge)
        var reverse = reverseNode(groupNode)
        while (reverse != null) {
            if(reverse.value != null) {
                val temp = ListNode(reverse.value)
                merge.next = temp
                merge = temp
                System.out.println("${reverse.value}")
            }
            reverse = reverse.next
        }
//        printListNode(head)
        System.out.println("==========")
    }
    return result
}

fun reverseNode(head: ListNode?): ListNode? {
    if(head == null || head.next == null) return head

    var cur: ListNode? = head
    var pre: ListNode? = null

    while (cur != null) {
        val temp = cur.next
        cur.next = pre
        pre = cur
        cur = temp
    }
    return pre
}
