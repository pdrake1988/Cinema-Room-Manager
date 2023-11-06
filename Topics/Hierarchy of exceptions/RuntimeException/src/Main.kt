fun main() {
    try {
    // write your code here, do not touch the lines above
    val nums = arrayListOf(1, 2, 3)
    val num = nums[5]
    // do not touch the lines below    
    } catch(e: RuntimeException) {
        println("Well")
    } catch (e: Exception) {
        println("Wrong")
    }
}
