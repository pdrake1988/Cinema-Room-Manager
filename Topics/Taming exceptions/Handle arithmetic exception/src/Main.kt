fun main() {
    // put your code here
    try {
        val num1 = readln().toInt()
        val num2 = readln().toInt()
        println(num1 / num2)
    } catch (ex: ArithmeticException) {
        println("Division by zero, please fix the second argument!")
    }

}
