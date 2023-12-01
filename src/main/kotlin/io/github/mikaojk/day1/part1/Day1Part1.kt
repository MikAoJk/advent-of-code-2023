package io.github.mikaojk.day1.part1

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

fun day1Part1(): String {
    val calibrationDocument = getFileAsString("src/main/resources/day1/input.txt")

    val calibrationList = calibrationDocument.split("\\n\\n".toRegex())
        .map { it.split("\\n".toRegex()) }.map {
            CalibrationDigits(calibration = findTwoFirstDigtits(it))
        }.first()

    return sumAllDigtits(calibrationList.calibration).toString()
}


data class CalibrationDigits(
    val calibration: List<CalibrationDigit>
)

data class CalibrationDigit(
    val digit: Int
)

fun sumAllDigtits(calibration: List<CalibrationDigit>): Int {

    return calibration.sumOf {
        it.digit
    }

}


fun findTwoFirstDigtits(calibration: List<String>): List<CalibrationDigit> {
    return calibration.map { digit ->
        val digitsInString = digit.filter { it.isDigit() }
        val firstDigit = digitsInString.first()
        val secoundDigit = digitsInString.last()

        val digitString = firstDigit.toString() + secoundDigit.toString()
        CalibrationDigit(digit = digitString.toInt())

    }
}


fun getFileAsString(filePath: String): String {
    try {
        return String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8)
    } catch (exception: Exception) {
        throw Exception("Could not get file content as string", exception)
    }
}