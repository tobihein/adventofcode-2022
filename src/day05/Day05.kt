package day05

import readInput
import java.util.*

class Day05 {
    fun part1(): String {
        val readInput = readInput("day05/input")
        return part1(readInput)
    }

    fun part2(): String {
        val readInput = readInput("day05/input")
        return part2(readInput)
    }

    fun part1(input: List<String>): String {
        val stacks = readStacks(input)
        val moves = readMoves(input)
        doMoves(stacks, moves)
        return getTops(stacks)
    }

    fun part2(input: List<String>): String {
        val stacks = readStacks(input)
        val moves = readMoves(input)
        doMovesPart2(stacks, moves)
        return getTops(stacks)
    }

    private fun readStacks(input: List<String>): Map<Int, Stack<String>> {
        val stackInput = input.takeWhile { it.contains("[") }.map { it.chunked(4) }

        val stacks = mutableMapOf<Int, Stack<String>>()
        stackInput.reversed().forEach {
            for ((idx, s) in it.withIndex()) {
//                it.forEachIndexed { idx, s ->
//                {
                if (s.isNotBlank()) {
                    val stack = stacks.getOrDefault(idx, Stack())
                    stack.push(s.substring(1, 2))
                    stacks.put(idx, stack)
                }
//                }
            }
        }
        return stacks
    }

    private fun readMoves(input: List<String>): List<Triple<Int, Int, Int>> {
        return input.takeLastWhile { it != "" }.map { it.split(" ") }
            .map { Triple(it[1].toInt(), it[3].toInt() - 1, it[5].toInt() - 1) }
    }

    private fun doMoves(stacks: Map<Int, Stack<String>>, moves: List<Triple<Int, Int, Int>>) {
        moves.forEach {
            for (i in 0 until it.first) {
                stacks.get(it.third)?.push(stacks.get(it.second)?.pop())
            }
        }

    }

    private fun doMovesPart2(stacks: Map<Int, Stack<String>>, moves: List<Triple<Int, Int, Int>>) {
        moves.forEach {
            val tempStack = Stack<String>()
            for (i in 0 until it.first) {
                tempStack.push(stacks.get(it.second)?.pop())
            }
            while (tempStack.isNotEmpty()) {
                stacks.get(it.third)?.push(tempStack.pop())
            }
        }

    }

    private fun getTops(stacks: Map<Int, Stack<String>>): String {
        return stacks.values.map { it.pop() }.joinToString("")
    }
}
