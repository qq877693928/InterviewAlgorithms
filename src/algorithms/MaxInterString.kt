package algorithms

import java.util.Arrays
import java.util.Collections

fun main(args: Array<String>) {
    val intArray = intArrayOf(3, 30, 34, 5, 9, 10)

    val strArray = arrayOfNulls<String>(6)
    Arrays.fill(strArray, "1")

//    val stringArray = intArray.map { it.toString() }
//    System.out.println("${stringArray.joinToString(",")}")
//
//    Collections.sort<String>(stringArray, object : Comparator<String> {
//        override fun compare(o1: String?, o2: String?): Int {
//            return (o2 + o1).compareTo(o1 + o2)
//        }
//    })
//
////    Arrays.sort<String>(stringArray, object : Comparator<String> {
////        override fun compare(o1: String?, o2: String?): Int {
////            return (o2 + o1).compareTo(o1+o2)
////        }
////    })
//    reverse(intArray, 0, intArray.lastIndex)
    System.out.println("${strArray.joinToString(",")}")
}

private fun reverse(intArray: IntArray, start: Int, end: Int) {
    var i = start
    var j = end
    while (i < j) {
        swapIntElement(intArray, i++, j--)
    }
}

private fun swapIntElement(intArray: IntArray, start: Int, end: Int) {
    val temp = intArray.get(start)
    intArray.set(start, intArray.get(end))
    intArray.set(end, temp)
}
