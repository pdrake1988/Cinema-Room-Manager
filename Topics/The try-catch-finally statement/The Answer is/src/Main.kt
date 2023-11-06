fun main() {
    val answer : Int = try { readLine()!!.toInt() } catch(ex: NumberFormatException) { 42 }
    println("The answer is a number")
    println(answer)
}
