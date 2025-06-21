fun main() {
    val list = listOf(1, 1, 2, 3, 5, 6)
    val result = findMaxNumList(list)
    val minValue = result.get(2)
    print(minValue)
}

fun findMaxNumList(list: List<Int>): List<Int> {
    if(list.isEmpty()) {
        return emptyList()
    }
    val result = mutableListOf<Int>()
    list.forEach {
        if(result.isEmpty()) {
            result.add(it)
        }
        if(it > result.max()) {
            result.add(0, it)
        }else if(it < result.min())(
            result.add(it)
        )
    }
    return result
}