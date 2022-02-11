import java.io.File

fun main() {
    day2PartOne()
    day2PartTwo()
}

fun day2PartOne() {
    val input = "src/main/resources/day2.input"

    val course = File(input).readLines()
        .map { it.split(" ") }
        .map { it[0] to it[1].toInt() }
        .groupBy({ it.first }, { it.second })
        .map { (command, units) -> command to units.sum() }
        .toMap()

    val horizontal = course.getValue("forward")
    val depth = course.getValue("down") - course.getValue("up")

    println(horizontal * depth)
}

fun day2PartTwo() {
    val input = "src/main/resources/day2.input"

    data class Position(var aim: Int = 0, var horizontal: Int = 0, var depth: Int = 0)

    val (_, horizontal, depth) = File(input).readLines()
        .map { it.split(" ") }
        .map { it[0] to it[1].toInt() }
        .fold(Position()) { position, (command, unit) ->
            when (command) {
                "down" -> position.aim += unit
                "up" -> position.aim -= unit
                "forward" -> {
                    position.horizontal += unit
                    position.depth += (position.aim * unit)
                }
            }
            position
        }

    println(horizontal * depth)
}