fun main() {
    val list1 = listOf<Int>(2, 4, 6)
    val list2 = listOf<Int>(1, 3, 5)
    val result = merge(list1, list2)
    System.out.print("${result.joinToString(",")}")
}

fun merge(list1: List<Int>, list2: List<Int>): List<Int> {
    var index1 = 0
    var index2 = 0
    val result = mutableListOf<Int>()
    while (index1 < list1.size && index2 < list2.size) {
        if (list1.get(index1) <= list2.get(index2)) {
            index1 = appendElementToList(result, list1, index1)
        } else {
            index2 = appendElementToList(result, list2, index2)
        }
    }
    while (index1 < list1.size) {
        index1 = appendElementToList(result, list1, index1)
    }
    while (index2 < list2.size) {
        index2 = appendElementToList(result, list2, index2)
    }
    return result
}

private fun appendElementToList(
    result: MutableList<Int>,
    list: List<Int>,
    index: Int
): Int {
    var i = index
    result.add(list.get(index))
    i++
    return i
}