package days

import java.io.File

class Day3(fileName: String) {
    init {
        println(dayThree(fileName))
    }

    private fun dayThree(fileName: String): String {
        val lines: List<String> = File(fileName).readLines()
        var pointsPartOne = 0
        var pointsPartTwo = 0
        val arr = ArrayList<String>()

        // Part 1
        lines.forEach { line ->
            val mid: Int = line.length / 2
            val parts = listOf(line.substring(0, mid), line.substring(mid))
            val char = findChar(parts)
            pointsPartOne += pointSystem(char)
        }

        // Part 2
        lines.forEach { line ->
            arr.add(line)
            if (arr.size == 3) {
                val char = findChar(arr)
                pointsPartTwo += pointSystem(char)
                arr.clear()
            }
        }

        return "Total points part one are: $pointsPartOne \nTotal points part two are: $pointsPartTwo"
    }

    private fun findChar(arr: List<String>): Char {
        val commonChars = arr.map { it.toSet() }.reduce { acc, set -> acc.intersect(set) }

        return commonChars.first()
    }

    private fun pointSystem(letter: Char): Int {
        return when (letter) {
            in 'a'..'z' -> (letter - 'a') + 1
            in 'A'..'Z' -> (letter - 'A') + 27
            else -> throw IllegalArgumentException("Letter not in range: $letter")
        }
    }
}

