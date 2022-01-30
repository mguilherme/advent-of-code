import java.io.File

fun main() {
    day1PartOne()
    day1PartTwo()
}

fun day1PartOne() {
    val input = "src/main/resources/day1.input"

    val count = File(input).readLines()
        .map { it.toInt() }
        .zipWithNext { a, b -> b - a > 0 }
        .count { it }

    println(count)
}

fun day1PartTwo() {
    val input = "src/main/resources/day1.input"

    val count = File(input).readLines()
        .map { it.toInt() }
        .windowed(size = 3) { it.sum() }
        .zipWithNext { a, b -> b - a > 0 }
        .count { it }

    println(count)
}