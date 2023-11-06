import kotlin.math.pow

fun main() {
    // put your code here
    val a = readln().toDouble()
    val b = readln().toDouble()
    val c = readln().toDouble()
    val d = readln().toDouble()
    for (i in 0..1000) {
        val ans = a * i.toDouble().pow(3) + b * i.toDouble().pow(2) + c * i + d
        if (ans == 0.0) {
            println(i)
        }
    }
}
