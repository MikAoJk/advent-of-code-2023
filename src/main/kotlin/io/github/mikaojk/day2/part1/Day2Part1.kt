package io.github.mikaojk.day2.part1

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

fun day2Part1(): String {

    val bagStrig = getFileAsString("src/main/resources/day2/test.txt")

    val bag = bagStrig.split("\\n\\n".toRegex())
        .map { it.split("\\n".toRegex()) }.map {
            Bag(games = toGames(it))
        }.first()

    val maxRedCubes = 12
    val maxGreenCubes = 13
    val maxBlueeCubes = 14

    bag.games.forEach { game ->
        var sumRedCubes = 0
        var sumGreenCubes = 0
        var sumBlueeCubes = 0
        game.sets.forEach { set ->
            var sumRedCubes = 0
            var sumGreenCubes = 0
            var sumBlueeCubes = 0
            set.cubes.forEach { cube ->
                when (cube.color) {
                    Color.red -> {
                        sumRedCubes += 1
                    }
                    Color.green -> {
                        sumGreenCubes += 1
                    }
                    Color.blue -> {
                        sumBlueeCubes += 1
                    }
                }
            }



        }

    }

    return "lol2k"
}

fun toGames(games: List<String>): List<Game> {
    return games.map { game ->
        Game(
            number = game.substringBefore(":").find { it.isDigit() }!!.code,
            sets = toSet(game.substringAfter(":").split(";".toRegex()))
        )
    }
}

fun toSet(sets: List<String>): List<Set> {
    return sets.map { set ->
        Set(
            set.split(",").map { cubes ->
                Cube(
                    color = Color.valueOf(cubes.filter { !it.isDigit() }.trim()),
                    number = cubes.find { it.isDigit() }?.code
                )
            }
        )
    }
}

data class Bag(
    val games: List<Game>,
)

data class Game(
    val number: Int,
    val sets: List<Set>
)

data class Set(
    val cubes: List<Cube>
)

data class Cube(
    val color: Color,
    val number: Int?
)

enum class Color {
    blue,
    red,
    green
}

fun getFileAsString(filePath: String): String {
    try {
        return String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8)
    } catch (exception: Exception) {
        throw Exception("Could not get file content as string", exception)
    }
}