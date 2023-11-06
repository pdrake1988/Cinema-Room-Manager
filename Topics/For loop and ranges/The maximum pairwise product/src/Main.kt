fun main() {
    // write your code here
    val numElm = readln().toInt()
    var nums = mutableListOf<Int>()
    for (i in 1..numElm) {
        nums.add(readln().toInt())
    }
    if (nums.size == 1) {
        println(nums.first())
    } else {
        var maxProd = 0
        for ((firstIndex, i) in nums.withIndex()) {
            for ((secondIndex, j) in nums.withIndex()) {
                val currProd = i * j
                if (currProd > maxProd && firstIndex != secondIndex) {
                    maxProd = currProd
                }
            }
        }
        println(maxProd)
    }

}
