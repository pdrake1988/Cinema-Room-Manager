fun main() {
    // write your code here
    val numList = mutableListOf<Int>()
    for (i in 1 .. readln().toInt()) {
        numList.add(readln().toInt())
    }
    val lastLine = readln().split(" ").map { it.toInt() }
    if (numList.contains(lastLine[0]) && numList.contains(lastLine[1])) {
        println("YES")
    } else {
        println("NO")
    }
}
