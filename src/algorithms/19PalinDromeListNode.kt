package algorithms

/**
 * 234. 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/description/
 */
fun main(args: Array<String>) {
    var list: LinkedNode? = LinkedNode(1).apply {
        next = LinkedNode(1).apply {
            next = LinkedNode(2).apply {
                next= LinkedNode(1)
            }
        }
    }

    System.out.println("${isPalindrome(list)}")
}

private fun isPalindrome(head: LinkedNode?): Boolean {
    val mid = findMidLinkedNode(head)
    printListNode(mid)
    var preNode: LinkedNode? = head
    var lastNode: LinkedNode? = reversedLinkedNode(mid)
    printListNode(lastNode)

    var flag = true
    while (preNode != null && lastNode != null) {
        if(preNode?.value != lastNode?.value) {
            flag = false
            break
        }
        preNode = preNode?.next
        lastNode = lastNode?.next
    }

    return flag
}

private fun findMidLinkedNode(head: LinkedNode?): LinkedNode? {
    var slow: LinkedNode? = head
    var fast: LinkedNode? = head

    // 如果是偶数只需要 fast!= null, 如果是奇数还需要加上 fast.next != null
    while (fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    return slow
}

private fun reversedLinkedNode(head: LinkedNode?): LinkedNode? {
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


