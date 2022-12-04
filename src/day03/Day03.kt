package day03

import readInput

class Day03 {
    fun part1(): Int {
        val readInput = readInput("day03/input")
        return part1(readInput)
    }

    fun part2(): Int {
        val readInput = readInput("day03/input")
        return part2(readInput)
    }

    fun part1(input: List<String>): Int = input.map { toPair(it) }.map { intersect(it) }.map { toValue(it) }.sum()

    private fun intersect(pair: Pair<String, String>): Set<Char> {
        val left = pair.first.toCharArray().toSet()
        val right = pair.second.toCharArray().toSet()
        val intersect = left.intersect(right)
        return intersect
    }

    private fun toValue(set: Set<Char>): Int {
        val char = set.first().code
        return toValue(char)
    }

    private fun toValue(char: Int): Int {
        if ('a'.code <= char && char <= 'z'.code) {
            return char - 'a'.code + 1
        }
        if ('A'.code <= char && char <= 'Z'.code) {
            return char - 'A'.code + 27
        }
        return 0
    }

    private fun toPair(s: String): Pair<String, String> {
        val middle = s.length / 2
        val left = s.substring(0, middle)
        val right = s.substring(middle)
        return Pair(left, right)
    }

    fun part2(input: List<String>): Int {
        val groups = input.chunked(3)

        var sum = 0
        groups.forEach {
            sum += it.map { it.toCharArray().toSet() }
                .reduce { accumulator, chars -> accumulator.intersect(chars) }
                .map { toValue(it.code) }.first()
        }
        return sum
    }

}
