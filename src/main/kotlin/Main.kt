import days.Day1
import days.Day2
import days.Day3
import days.Day4
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    while (true) {
        println("Choose a day to execute, 0 for exit")
        val input = scanner.nextInt()

        val startTime = System.currentTimeMillis()
        when (input) {
            1 -> Day1("src/main/resources/day1input.txt")
            2 -> Day2("src/main/resources/day2input.txt")
            3 -> Day3("src/main/resources/day3input.txt")
            3 -> Day4("src/main/resources/day4input.txt")

            0 -> {
                println("Bye")
                break
            }

            else -> {
                println("Not a valid option")
            }
        }
        val endTime = System.currentTimeMillis() - startTime

        println()
        println("Duration of programm in ms: $endTime")

    }
}









