fun main() {
    fun part1(input: List<String>): Int {
        var first: Int? = null
        var raises = 0
        input.forEach { line ->
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
        // Compare Sliding window of width 3
        var last: Int? = null
        var raises = 0
        input.windowed(3, 1, false) { window ->
            val actual = window.sumOf { Integer.parseInt(it) }
            last?.let {
                if (actual > it) raises++
            }
            last = actual
        }
        return raises
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
