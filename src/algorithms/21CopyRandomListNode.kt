package algorithms

/**
 * 138. 随机链表的复制
 * https://leetcode.cn/problems/copy-list-with-random-pointer/description/
 */
fun main(args: Array<String>) {

    val endRandomLinkNode = null

    val randomNode5 = RandomLinkNode(1).apply {
        next = endRandomLinkNode
    }

    val randomNode4 = RandomLinkNode(10).apply {
        next = randomNode5
    }

    val randomNode3 = RandomLinkNode(11).apply {
        next = randomNode4
    }

    val randomNode2 = RandomLinkNode(13).apply {
        next = randomNode3
    }

    val randomNode1 = RandomLinkNode(7).apply {
        next = randomNode2
    }
    randomNode1.random = randomNode3
    randomNode2.random = randomNode1
    randomNode3.random = randomNode5
    randomNode4.random = endRandomLinkNode
    randomNode5.random = randomNode1

    printRandomListNode(randomNode1)

    printRandomListNode(copyRandomLinkNode(randomNode1))
}


private fun copyRandomLinkNode(head: RandomLinkNode?): RandomLinkNode? {
    var cur: RandomLinkNode? = head

    val map: MutableMap<Int, RandomLinkNode> = mutableMapOf<Int, RandomLinkNode>()

    while (cur != null) {
        map.put(cur.value, RandomLinkNode(cur.value))
        cur = cur.next
    }

    var temp: RandomLinkNode? = map.get(head?.value)
    var pre: RandomLinkNode? = temp
    cur = head
    while (cur != null) {
        val next = map.get(cur.next?.value)
        temp?.next = next

        val random = map.get(cur.random?.value)
        temp?.random = random

        temp = temp?.next
        cur = cur.next
    }
    return pre
}

private fun printRandomListNode(head: RandomLinkNode?) {
    var cur: RandomLinkNode? = head

    var list = mutableListOf<Pair<Int, Int?>>()
    while (cur != null) {
        list.add(Pair(cur.value, cur.random?.value))
        cur = cur.next
    }

    System.out.println("${list.joinToString(",", transform = {
        "[${it.first}, ${it.second}]"
    })}")
}

class RandomLinkNode(val value: Int) {
    var next: RandomLinkNode? = null
    var random: RandomLinkNode? = null
}


