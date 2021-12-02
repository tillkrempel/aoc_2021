fun main() {
    fun part1(input: List<String>): Int {
        var first: Int? = null
        var raises = 0
        input.forEach { line->
            (Integer.parseInt(line)).let { number ->
                first?.let {
                    if (number > it) raises++
                }
                first = number
            }
        }
        return raises
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
