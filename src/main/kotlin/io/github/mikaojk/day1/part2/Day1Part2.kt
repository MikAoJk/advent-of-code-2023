package io.github.mikaojk.day1.part2

import io.github.mikaojk.day1.part1.CalibrationDigit
import io.github.mikaojk.day1.part1.CalibrationDigits
import io.github.mikaojk.day1.part1.getFileAsString
import io.github.mikaojk.day1.part1.sumAllDigtits

fun day1Part2(): String {
    val calibrationDocument = getFileAsString("src/main/resources/day1/input.txt")

    val calibrationList = calibrationDocument.split("\\n\\n".toRegex())
        .map { it.split("\\n".toRegex()) }.map {
            CalibrationDigits(calibration = findTwoFirstDigtits(it))
        }.first()

    return sumAllDigtits(calibrationList.calibration).toString()
}


fun findTwoFirstDigtits(calibration: List<String>): List<CalibrationDigit> {
    return calibration.map { digit ->

        val updateredDigit = replaceLettersWithDigit(digit)

        val digitsInString = updateredDigit.filter { it.isDigit() }

        val firstDigit = digitsInString.first()
        val secoundDigit = digitsInString.last()

        val digitString = firstDigit.toString() + secoundDigit.toString()

        CalibrationDigit(digit = digitString.toInt())
    }
}

data class WordOrder(
    val word: String,
    val order: Int,
    val digit: String
)

fun replaceLettersWithDigit(calibration: String): String {
    val wordOrderList: List<WordOrder> = mutableListOf(
        WordOrder("one", calibration.indexOf("one"), "1"),
        WordOrder("two", calibration.indexOf("two"), "2"),
        WordOrder("three", calibration.indexOf("three"), "3"),
        WordOrder("four", calibration.indexOf("four"), "4"),
        WordOrder("five", calibration.indexOf("five"), "5"),
        WordOrder("six", calibration.indexOf("six"), "6"),
        WordOrder("seven", calibration.indexOf("seven"), "7"),
        WordOrder("eight", calibration.indexOf("eight"), "8"),
        WordOrder("nine", calibration.indexOf("nine"), "9")
    )

    val wordHits = wordOrderList
        .filter { it.order != -1 }
        .sortedBy { it.order }

    var replaceLettersWithDigit = calibration

    wordHits.forEach {
        replaceLettersWithDigit = replaceLettersWithDigit.replace(it.word, it.digit)
    }

    return replaceLettersWithDigit

}