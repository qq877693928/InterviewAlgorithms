package algorithms

import java.util.Arrays
import java.util.Collections

fun main(args: Array<String>) {
    val stringArray1 = arrayOf<String>("a", "b", "c", "d", "e")
    val stringArray2 = arrayOf<String>("b", "c", "e")

    val result = getMaxSameLength(stringArray1, stringArray2)
    System.out.println("${result}")
}

fun getMaxSameLength(stringArray1: Array<String>, stringArray2: Array<String>): Int {
//    val len1 = stringArray1.size
//    val len2 = stringArray2.size
//    var ans = 0
//    val sum = Array(len1+1) { IntArray(len2+1) }
//    var endIndexInNums1 = 0
//
//    for(i in 0 until len1) {
//        for(j in 0 until len2) {
//            if (stringArray1[i] == stringArray2[j]) {
//                endIndexInNums1 = i
//                sum.get(i + 1).set(j + 1, (sum.get(i).get(j) + 1))
//            }
//            ans = Math.max(ans, sum.get(i+1).get(j+1))
//        }
//    }
//
//    val start = endIndexInNums1 - ans + 1
//    System.out.println("${stringArray1.sliceArray(start..endIndexInNums1).joinToString(",")}")
//
//    sum.forEach {
//        System.out.println("${it.joinToString(",")}")
//    }
//    return ans


    val len1 = stringArray1.size
    val len2 = stringArray2.size
    var ans = 0
    val sum = Array(len1+1) { IntArray(len2+1) }
    var endIndexInNums1 = 0

    for(i in 0 until len1) {
        for(j in 0 until len2) {
            if (stringArray1[i] == stringArray2[j]) {
                endIndexInNums1 = i
                sum.get(i + 1).set(j + 1, (sum.get(i).get(j) + 1))
            } else {
                sum.get(i + 1).set(j + 1, Math.max(sum.get(i).get(j + 1), sum.get(i + 1).get(j)))
            }
            ans = Math.max(ans, sum.get(i+1).get(j+1))
        }
    }

    val start = endIndexInNums1 - ans + 1
    System.out.println("${stringArray1.sliceArray(start..endIndexInNums1).joinToString(",")}")

    sum.forEach {
        System.out.println("${it.joinToString(",")}")
    }
    return ans
}

