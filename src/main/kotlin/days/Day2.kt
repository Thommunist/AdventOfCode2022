package days

import java.io.File

class Day2(fileName: String) {

    init {
        val lines: List<String> = File(fileName).readLines()
        var totalPoints = 0
        var totalPointstwo = 0

        lines.forEach { line ->
            val parts = line.split(" ")

            totalPoints += addPoints(parts[0], parts[1])
            totalPointstwo += addPointsTwo(parts[0], parts[1])
        }

        println("Total points part one are: $totalPoints")
        println("Total points part two are: $totalPointstwo")
    }

    private fun addPoints(oponent: String, myTurn: String): Int {
        var turnpoints = 0

        if (myTurn.equals("X", ignoreCase = true)) turnpoints++
        if (myTurn.equals("Y", ignoreCase = true)) turnpoints += 2
        if (myTurn.equals("Z", ignoreCase = true)) turnpoints += 3

        if (oponent.equals("A", ignoreCase = true) && myTurn.equals("X", ignoreCase = true)) turnpoints += 3
        if (oponent.equals("B", ignoreCase = true) && myTurn.equals("Y", ignoreCase = true)) turnpoints += 3
        if (oponent.equals("C", ignoreCase = true) && myTurn.equals("Z", ignoreCase = true)) turnpoints += 3

        if (oponent.equals("A", ignoreCase = true) && myTurn.equals("Y", ignoreCase = true)) turnpoints += 6
        if (oponent.equals("B", ignoreCase = true) && myTurn.equals("Z", ignoreCase = true)) turnpoints += 6
        if (oponent.equals("C", ignoreCase = true) && myTurn.equals("X", ignoreCase = true)) turnpoints += 6

        return turnpoints
    }

    private fun addPointsTwo(oponent: String, myTurn: String): Int {
        var turnpoints = 0

        if (oponent.equals("A", ignoreCase = true) && myTurn.equals("X", ignoreCase = true)) turnpoints += 3
        if (oponent.equals("A", ignoreCase = true) && myTurn.equals("Y", ignoreCase = true)) turnpoints += 4
        if (oponent.equals("A", ignoreCase = true) && myTurn.equals("Z", ignoreCase = true)) turnpoints += 8

        if (oponent.equals("B", ignoreCase = true) && myTurn.equals("X", ignoreCase = true)) turnpoints += 1
        if (oponent.equals("B", ignoreCase = true) && myTurn.equals("Y", ignoreCase = true)) turnpoints += 5
        if (oponent.equals("B", ignoreCase = true) && myTurn.equals("Z", ignoreCase = true)) turnpoints += 9

        if (oponent.equals("C", ignoreCase = true) && myTurn.equals("X", ignoreCase = true)) turnpoints += 2
        if (oponent.equals("C", ignoreCase = true) && myTurn.equals("Y", ignoreCase = true)) turnpoints += 6
        if (oponent.equals("C", ignoreCase = true) && myTurn.equals("Z", ignoreCase = true)) turnpoints += 7

        return turnpoints
    }
}




