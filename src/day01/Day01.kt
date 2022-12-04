package day01

import readInput

class Day01 {
    fun part1(): Int {
        val readInput = readInput("day01/input")
        return part1(readInput)
    }

    fun part2(): Int {
        val readInput = readInput("day01/input")
        return part2(readInput)
    }

    fun part1(input: List<String>): Int {
        val sums = getSums(input)
        return sums.max()
    }

    fun part2(input: List<String>): Int {
        val sums = getSums(input)
        sums.sortDescending()
        return sums.take(3).sum()
    }

    private fun getSums(input: List<String>): MutableList<Int> {
        var sum = 0
        val sums = mutableListOf<Int>()
        input.forEach {
            if (it == "") {
                sums.add(sum)
                sum = 0

            } else {
                sum += it.toInt()
            }
        }
        sums.add(sum)
        return sums
    }
}
