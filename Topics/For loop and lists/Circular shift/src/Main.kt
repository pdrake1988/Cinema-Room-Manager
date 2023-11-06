import java.util.Collections

fun main() {
    // write your code here
    val listSize = readln().toInt()
    var list = mutableListOf<Int>()
    for (num in 1 .. listSize) {
        list.add(readln().toInt())
    }
//    val lastNum = list.last()
//    for (i in 0 until list.lastIndex) {
//        list[i] = list[i + 1]
//    }
//    list[0] = lastNum
    Collections.rotate(list, 1)
   println(list.joinToString(" "))
}
