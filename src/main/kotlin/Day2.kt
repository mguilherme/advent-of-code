import java.io.File

fun main() {
    day2PartOne()
}

fun day2PartOne() {

//    val commands = listOf(
//        "forward 5",
//        "down 5",
//        "forward 8",
//        "up 3",
//        "down 8",
//        "forward 2",
//    )

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