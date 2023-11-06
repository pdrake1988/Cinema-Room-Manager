package cinema


fun main() {
    // write your code here
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seatsPerRow = readln().toInt()
    val seats = mutableListOf<MutableList<String>>()
    for (row in 0..rows) {
        val rowOfSeats = mutableListOf<String>()
        for (seat in 0..seatsPerRow) {
            if (row == 0 && seat == 0) {
                rowOfSeats.add(" ")
            } else if (row == 0) {
                rowOfSeats.add(seat.toString())
            } else {
                if (seat == 0) {
                    rowOfSeats.add(row.toString())
                } else {
                    rowOfSeats.add("S")
                }
            }
        }
        seats.add(rowOfSeats)
    }
    printSeats(seats)
    do {
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        val answer = readln().toInt()
        when (answer) {
            1 -> printSeats(seats)
            2 -> {
                val selectedRow = selectSeat(seats)
                println("Ticket price: ${getTicketPrice(rows, seatsPerRow, selectedRow)}")
            }

            3 -> printStatistics(seats, rows, seatsPerRow)
        }
    } while (answer != 0)
}

fun printSeats(seats: MutableList<MutableList<String>>) {
    println("Cinema:")
    for (rowOfSeats in seats) {
        println(rowOfSeats.joinToString(" "))
    }
}

fun selectSeat(seats: MutableList<MutableList<String>>): Int {
    var selectedRow: Int?
    var selectedColumn: Int
    do {
        println("Enter a row number:")
        selectedRow = readln().toInt()
        println("Enter a seat number in that row:")
        selectedColumn = readln().toInt()
        try {
            if (seats[selectedRow][selectedColumn] == "S") {
                seats[selectedRow][selectedColumn] = "B"
            } else {
                println("That ticket has already been purchased!")
                selectedRow = null
            }
        } catch (ex: IndexOutOfBoundsException) {
            selectedRow = null
            println("Wrong input!")
        }
    } while (selectedRow == null)
    return selectedRow
}

fun getTicketPrice(rows: Int, seatsPerRow: Int, selectedRow: Int): String {
    val ticketPrice: String
    if (rows * seatsPerRow <= 60) {
        ticketPrice = "\$10"
    } else {
        ticketPrice = if (rows % 2 == 0) {
            if (selectedRow < (rows / 2)) {
                "\$10"
            } else {
                "\$8"
            }
        } else {
            if (selectedRow < (rows / 2 + 1)) {
                "\$10"
            } else {
                "\$8"
            }
        }
    }
    return ticketPrice
}

fun printStatistics(seats: MutableList<MutableList<String>>, rows: Int, seatsPerRow: Int) {
    var seatsPurchased = 0
    val percentPurchased: Double
    val totalSeats = rows * seatsPerRow
    var currentIncome = 0
    val totalEven = rows % 2 == 0
    var totalIncome = 0
    for ((index, rowOfSeats) in seats.withIndex()) {
        for (seat in 1 until rowOfSeats.size) {
            if (index == 0) continue
            val seatPrice = if (totalEven) {
                if (index < rows / 2) {
                    10
                } else {
                    8
                }
            } else {
                if (index < rows / 2 + 1) {
                    10
                } else {
                    8
                }
            }
            totalIncome += seatPrice
            if (rowOfSeats[seat] == "B") {
                seatsPurchased++
                currentIncome += seatPrice
            }
        }
    }
    percentPurchased = (seatsPurchased / totalSeats.toDouble()) * 100.0
    val percentageFormatted = String.format("%.2f", percentPurchased)
    println("Number of purchased tickets: $seatsPurchased")
    println("Percentage: $percentageFormatted%")
    println("Current income: \$$currentIncome")
    println("Total income: \$$totalIncome")
}
