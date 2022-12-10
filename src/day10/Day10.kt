package day10

import readInput

class Day10 {
    fun part1(): Int {
        val readInput = readInput("day10/input")
        return part1(readInput)
    }

    fun part2(): List<String> {
        val readInput = readInput("day10/input")
        return part2(readInput)
    }

    fun part1(input: List<String>): Int {
        val cycleValues = getCycleValues(input)
        return valuesFrom(cycleValues, 20, 60, 100, 140, 180, 220)
    }

    fun part2(input: List<String>): List<String> {
        val cycleValues = getCycleValues(input)
        val result = mutableListOf<String>()
        for (cycle in 1..cycleValues.size) {
            val x = cycleValues.get(cycle)?.first
            if (x == null) {
                throw RuntimeException("No value found for cycle cycle")
            }
            result.add(output(cycle, x))

        }
        return result.chunked(40).map { it.joinToString("", "", "") }
    }

    private fun getCycleValues(input: List<String>): Map<Int, Pair<Int, Int>> {
        val cycleValues = mutableMapOf<Int, Pair<Int, Int>>()
        var cycle = 0
        var x = 1
        input.forEach {
            cycle++
            if (it == "noop") {
                cycleValues.put(cycle, Pair(x, x))
            } else if (it.startsWith("addx")) {
                val addValue = it.split(" ")[1].toInt()
                cycleValues.put(cycle, Pair(x, x))
                cycle++
                cycleValues.put(cycle, Pair(x, x + addValue))
                x = x + addValue
            }
        }
        return cycleValues
    }

    private fun output(cycle: Int, x: Int): String = (if (pixelPos(cycle) in (x - 1)..(x + 1)) "#" else ".")

    private fun pixelPos(cycle: Int): Int = ((cycle - 1) % 40)

    private fun valuesFrom(cycleValues: Map<Int, Pair<Int, Int>>, vararg cycles: Int): Int =
        cycleValues.filter { cycles.contains(it.key) }.map { it.key * it.value.first }.sum()


}
