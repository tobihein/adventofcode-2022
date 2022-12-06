package day06

import readInput

class Day06 {
    fun part1(): Int {
        val readInput = readInput("day06/input")
        return part1(readInput)
    }

    fun part2(): Int {
        val readInput = readInput("day06/input")
        return part2(readInput)
    }

    fun part1(input: List<String>): Int = calc(input.first(), 4)

    fun part2(input: List<String>): Int = calc(input.first(), 14)

    private fun calc(input: String, length: Int): Int {
        for (i in length..input.length) {
            if (input.substring(i - length, i).toCharArray().toSet().size == length) {
                return i
            }
        }
        return -1

    }
}
