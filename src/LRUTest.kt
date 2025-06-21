class LRUTest {

    fun main(args: IntArray) {

    }
}

class Node<K, V> {
    var key: K? = null
    var value: V? = null
    var pre: Node<K, V>? = null
    var next: Node<K, V>? = null
}

class LRUCache<K, V>(private val initSize: Int = 16) {

    private val head = Node<K, V>()
    private val tail = Node<K, V>()
    private val cacheMap = HashMap<K, Node<K, V>>()

//    init {
    // TODO
//        head.next =
//    }




    fun put(key: K, value: V) {
        val node = cacheMap.get(key)
            if(node == null) {
                val newNode = Node<K, V>().apply {
                    this.key = key
                    this.value = value
                }
                cacheMap.put(key, newNode)
                if(cacheMap.size > initSize) {
                    val tailNode = removeTail()
                    cacheMap.remove(tailNode?.key)
                }
            }else {
                node.value = value
                moveNodeToHead(node)
            }


    }


    fun get(key: K): V? {
            val node = cacheMap.get(key) ?: return null
            // 移动至表头
            moveNodeToHead(node)
            return node.value

    }

    fun moveNodeToHead(node: Node<K, V>) {
        removeNode(node)
        addToHead(node)
    }

    fun addToHead(node: Node<K, V>) {
        node.pre = head
        node.next = head.next
        head.next?.pre = node
        head.next = node
    }

    fun removeNode(node: Node<K, V>?) {
        node?.pre?.next = node.next
        node?.next?.pre = node.pre
    }

    fun removeTail(): Node<K, V>? {
        val tailNode = tail.pre
        removeNode(tailNode)
        return tailNode
    }
}