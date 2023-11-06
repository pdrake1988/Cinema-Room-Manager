import java.util.Collections

fun main() {
    // write your code here
    val numList = mutableListOf<Int>()
    for (i in 1..readln().toInt()) {
        numList.add(readln().toInt())
    }
    Collections.rotate(numList, readln().toInt())
    println(numList.joinToString(" "))
}
