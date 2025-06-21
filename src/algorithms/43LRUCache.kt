package algorithms

/**
 * 146. LRU 缓存
 * https://leetcode.cn/problems/lru-cache/description/
 */
fun main(args: Array<String>) {
    val lru: LRUCache<Int, Int> = LRUCache<Int, Int>(2)
    lru.put(2, 1)
    lru.put(2, 2)
    printListNode(lru.head, lru.tail)
    System.out.println("${lru.get(2)}")
    printListNode(lru.head, lru.tail)

//    lru.put(1, 1)
//    lru.put(2, 2)
//    printListNode(lru.head, lru.tail)
//    System.out.println("${lru.get(1)}")
//    printListNode(lru.head, lru.tail)
//    lru.put(3, 3)
//    printListNode(lru.head, lru.tail)
//    System.out.println("${lru.get(2)}")
//    printListNode(lru.head, lru.tail)
//    lru.put(4, 4)
//    printListNode(lru.head, lru.tail)
//    System.out.println("${lru.get(1)}")
//    printListNode(lru.head, lru.tail)
//    System.out.println("${lru.get(3)}")
//    printListNode(lru.head, lru.tail)
//    System.out.println("${lru.get(4)}")
//    printListNode(lru.head, lru.tail)

}

private fun printListNode(head: Node<*, *>?, tail: Node<*, *>?) {
    var node: Node<*, *>? = head
    while (node != tail) {
        System.out.print("(${node?.key}, ${node?.value})")
        if (node?.next != tail) {
            System.out.print(" -> ")
        }
        node = node?.next
    }
    System.out.println("")
}

class Node<K, V>(val key: K? = null, var value: V? = null) {
    var next: Node<K, V>? = null
}

class LRUCache<K, V>(val capacity: Int? = 16) {

    var head: Node<K, V>? = Node<K, V>()
    var tail: Node<K, V>? = Node<K, V>()
    private var size: Int = 0

    init {
        head?.next = tail
        tail?.next = head
    }

    fun get(key: K): V? {
        var pre: Node<K, V>? = Node<K, V>().apply {
            next = head
        }
        var cur: Node<K, V>? = head
        while (cur != null && cur != tail) {
            if(cur.key == key) {
                val target = cur
                pre?.next = pre.next?.next
                target.next = null
                moveToHead(target)
                return cur.value
            }
            pre = pre?.next
            cur = cur?.next
        }
        return null
    }

    private fun moveToHead(target: Node<K, V>) {
        var next: Node<K, V>? = head?.next
        head?.next = target
        target.next = next
    }

    fun put(key: K, v: V) {
        val value: V? = get(key)
        val addNode: Node<K, V> = Node<K, V>(key, v)
        if (value == null) {
            moveToHead(addNode)

            size++
            if (size > (capacity ?: 0)) {
                removeLastNode(size - (capacity ?: 0))
                size = (capacity ?: 0)
            }
        } else {
            var cur: Node<K, V>? = head
            while (cur != null && cur != tail) {
                if (cur.key == key) {
                    cur?.value = v
                    break
                }
                cur = cur?.next
            }
        }
    }

    private fun removeLastNode(removeSize: Int) {
        var slow: Node<K, V>? = Node<K, V>().apply {
            next = head
        }
        var fast: Node<K, V>? = head
        for(i in 1..removeSize) {
            fast = fast?.next
        }
        while (fast != tail) {
            slow = slow?.next
            fast = fast?.next
        }
        slow?.next = tail
    }
}

