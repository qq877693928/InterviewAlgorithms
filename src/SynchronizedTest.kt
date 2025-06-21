import java.util.Collections

fun main() {
    val list1 = listOf<String>("a", "b", "c", "d")
    val list2 = listOf<String>("a", "b", "d", "c")
    val result = ('a'.toInt()) xor ('b'.toInt()) xor ('a'.toInt()) xor ('b'.toInt())
    System.out.print("$result")
}