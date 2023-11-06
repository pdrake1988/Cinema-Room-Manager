fun main() {
    // write your code here
    val density = readln().toDouble()
    val columnHeight = readln().toDouble()
    val gravityConstant: Double = 9.8
    println(density * gravityConstant * columnHeight)
}
