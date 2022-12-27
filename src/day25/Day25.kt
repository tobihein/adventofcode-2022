package day25

import readInput

class Day25 {
    fun part1(): String {
        val readInput = readInput("day25/input")
        return part1(readInput)
    }

    fun part2(): String {
        val readInput = readInput("day25/input")
        return part2(readInput)
    }

    fun part1(input: List<String>): String {
        val sum = input.map { it.toCharArray().reversed() }.map { toIntArray(it) }
            .map { toDecimal(it) }.sum()
        return toSnuf(sum)
    }

    private fun toSnuf(value: Long): String {
        val result = mutableListOf<Char>()
        var rest = value
        while (rest > 0) {
            val mod = myMod(rest)
            rest = myRest(rest, mod)
            result.add(0, toChar(mod))
        }
        return result.joinToString("", "", "")
    }

    private fun myMod(v: Long): Long {
        val result = v % 5
        return (if (result > 2) (result - 5) else result)
    }

    private fun myRest(v: Long, m: Long): Long {
        return (v / 5L) + fix(m)
    }

    private fun fix(v: Long): Long = (if (v < 0) 1 else 0)

    private fun toDecimal(it: LongArray): Long =
        it.mapIndexed { index, i -> Math.pow(5.0, index.toDouble()).toLong() * i }.sum()


    private fun toIntArray(c: List<Char>): LongArray = c.map { toInt(it) }.toLongArray()

    private fun toInt(c: Char): Long = when (c) {
        '1' -> 1L
        '2' -> 2L
        '0' -> 0L
        '-' -> -1L
        '=' -> -2L
        else -> throw IllegalArgumentException("Unknown value $c")
    }

    private fun toChar(l: Long): Char = when (l) {
        1L -> '1'
        2L -> '2'
        0L -> '0'
        -1L -> '-'
        -2L -> '='
        else -> throw IllegalArgumentException("Unknown value $l")
    }

    fun part2(input: List<String>): String = ""

}
