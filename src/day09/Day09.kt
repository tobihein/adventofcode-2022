package day09

import readInput

class Day09 {
    fun part1(): Int {
        val readInput = readInput("day09/input")
        return part1(readInput)
    }

    fun part2(): Int {
        val readInput = readInput("day09/input")
        return part2(readInput)
    }

    fun part1(input: List<String>): Int = calculateResult(input, 1)

    fun part2(input: List<String>): Int = calculateResult(input, 9)

    private fun calculateResult(input: List<String>, tailLength: Int): Int {
        var head = Pair(0, 0)
        val tails = initTails(tailLength)
        val result = mutableSetOf<Pair<Int, Int>>(tails[tailLength - 1])
        input.forEach {
            val inputs = it.split(" ")
            val direction = getDirection(inputs[0])
            val times = inputs[1].toInt()
            for (i in 0 until times) {
                head = moveHead(head, direction)
                var predecessor = head
                for (idx in 0 until tails.size) {
                    tails[idx] = moveTail(tails[idx], predecessor)
                    predecessor = tails[idx]
                }
                if (!result.contains(tails[tailLength - 1])) {
                    result.add(tails[tailLength - 1])
                }
            }
        }
        return result.size
    }

    private fun initTails(tailLength: Int): Array<Pair<Int, Int>> {
        return Array<Pair<Int, Int>>(tailLength) { Pair(0, 0) }
    }

    private fun getDirection(input: String): Pair<Int, Int> {
        when (input) {
            "U" -> return Pair(0, 1)
            "D" -> return Pair(0, -1)
            "R" -> return Pair(1, 0)
            "L" -> return Pair(-1, 0)
        }
        throw IllegalArgumentException("Unknown direction $input")
    }

    private fun moveHead(head: Pair<Int, Int>, direction: Pair<Int, Int>): Pair<Int, Int> =
        Pair(head.first + direction.first, head.second + direction.second)

    private fun moveTail(tail: Pair<Int, Int>, head: Pair<Int, Int>): Pair<Int, Int> {
        var newTail = tail
        val distX = head.first - tail.first
        val distY = head.second - tail.second
        if (Math.abs(distX) == 2 || Math.abs(distY) == 2) {
            var newX = tail.first + distX
            var newY = tail.second + distY
            if (distX == 2) {
                newX = tail.first + 1
            } else if (distX == -2) {
                newX = tail.first - 1
            }
            if (distY == 2) {
                newY = tail.second + 1
            } else if (distY == -2) {
                newY = tail.second - 1
            }
            newTail = Pair(newX, newY)
        }
        return newTail
    }
}
