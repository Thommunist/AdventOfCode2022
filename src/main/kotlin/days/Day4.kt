package days

import java.io.File

class Day4(fileName: String) {

    init {
        println("Part one: " + partOne(fileName))
        println("Part two: " + partTwo(fileName))
    }

    private fun partOne(fileName: String): String {
        val lines: List<String> = File(fileName).readLines()
        var pairs = 0

        lines.forEach { line ->
            val parts = line.split(',')
            val partOne = parts[0].split("-")
            val partTwo = parts[1].split("-")
            val firstArray = mutableListOf<Int>()
            val secondArray = mutableListOf<Int>()

            for (i in partOne.first().toInt()..partOne.last().toInt()) {
                firstArray += i
            }

            for (i in partTwo.first().toInt()..partTwo.last().toInt()) {
                secondArray += i
            }

            if (firstArray.containsAll(secondArray) || secondArray.containsAll(firstArray)) {
                pairs++
            }
        }

        return "Total pairs that fully contain each other: $pairs"
    }

    private fun partTwo(fileName: String): String {
        val lines: List<String> = File(fileName).readLines()
        var pairs = 0

        lines.forEach { line ->
            val parts = line.split(',')
            val partOne = parts[0].split("-")
            val partTwo = parts[1].split("-")
            val firstArray = mutableListOf<Int>()
            val secondArray = mutableListOf<Int>()

            for (i in partOne.first().toInt()..partOne.last().toInt()) {
                firstArray += i
            }

            for (i in partTwo.first().toInt()..partTwo.last().toInt()) {
                secondArray += i
            }

            val overlap = firstArray.intersect(secondArray.toSet())

            if (overlap.isNotEmpty()) pairs++
        }

        return "Total pairs that fully contain each other: $pairs"
    }


}