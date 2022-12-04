package day04

import readInput

class Day04 {
    fun part1(): Int {
        val readInput = readInput("day04/input")
        return part1(readInput)
    }

    fun part2(): Int {
        val readInput = readInput("day04/input")
        return part2(readInput)
    }

    fun part1(input: List<String>): Int =
        input.map { parse(it) }.filter { overlappedComplete(it) }.count()

    fun part2(input: List<String>): Int =
        input.map { parse(it) }.filter { overlapped(it) }.count()

    private fun parse(input: String): Pair<Pair<Int, Int>, Pair<Int, Int>> {
        val tokens = input.split(",", "-")
        return Pair(Pair(tokens[0].toInt(), tokens[1].toInt()), Pair(tokens[2].toInt(), tokens[3].toInt()))
    }

    private fun overlappedComplete(input: Pair<Pair<Int, Int>, Pair<Int, Int>>): Boolean {
        val first = input.first
        val second = input.second
        return isIn(first, second) || isIn(second, first)
    }

    private fun overlapped(input: Pair<Pair<Int, Int>, Pair<Int, Int>>): Boolean {
        val first = input.first
        val second = input.second
        return (between(second.first, first) || between(second.second, first) || (between(
            first.first,
            second
        ) || between(first.second, second)))
    }

    private fun between(number: Int, range: Pair<Int, Int>): Boolean {
        return (number in range.first..range.second)
    }

    private fun isIn(first: Pair<Int, Int>, second: Pair<Int, Int>): Boolean {
        return first.first <= second.first && first.second >= second.second
    }
}
