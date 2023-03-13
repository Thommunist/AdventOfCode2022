package days

import java.io.File
import java.io.InputStream

class Day1 (fileName: String) {
    init {
        println("Most Calories: " + mostCalories(fileName))
        println("Top three most Calories: " + thirdMostCalories(fileName))
    }
}

private fun mostCalories(fileName: String): Int {
    var calories = 0
    var currentCalories = 0

    val inputStream: InputStream = File(fileName).inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().forEachLine { lineList.add(it) }
    lineList.forEach {
        if (it != "") {
            currentCalories += it.toInt()

        } else {
            if (calories < currentCalories) calories = currentCalories
            currentCalories = 0
        }
    }
    return calories
}

private fun thirdMostCalories(fileName: String): Int {
    var firstCalories = 0
    var secondCalories = 0
    var thirdCalories = 0
    var currentCalories = 0

    val inputStream: InputStream = File(fileName).inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().forEachLine { lineList.add(it) }
    lineList.forEach {
        if (it != "") {
            currentCalories += it.toInt()
        } else {
            if (firstCalories < currentCalories) firstCalories = currentCalories
            currentCalories = 0
        }
    }
    currentCalories = 0

    lineList.forEach {
        if (it != "") {
            currentCalories += it.toInt()
        } else {
            if (secondCalories < currentCalories && currentCalories != firstCalories) secondCalories = currentCalories
            currentCalories = 0
        }
    }
    currentCalories = 0

    lineList.forEach {
        if (it != "") {
            currentCalories += it.toInt()
        } else {
            if (thirdCalories < currentCalories && currentCalories != firstCalories && currentCalories != secondCalories) thirdCalories =
                currentCalories
            currentCalories = 0
        }
    }

    return firstCalories + secondCalories + thirdCalories
}