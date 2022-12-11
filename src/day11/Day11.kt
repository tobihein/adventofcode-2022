package day11

import readInput

class Day11 {
    fun part1(): Long {
        val readInput = readInput("day11/input")
        return part1(readInput)
    }

    fun part2(): Long {
        val readInput = readInput("day11/input")
        return part2(readInput)
    }

    fun part1(input: List<String>): Long {
        val monkeys = input.chunked(7).map { toMonkey(it) }
        letMonkeysWork(monkeys, 20) { it.floorDiv(3) }
        println(monkeys.map { it.getThrownItems() })
        return monkeys.map { it.getThrownItems() }.sortedDescending().take(2).reduce { acc, next -> acc * next }
    }

    fun part2(input: List<String>): Long {
        val monkeys = input.chunked(7).map { toMonkey(it) }
        val lcm = monkeys.map { it.getDivisibleBy() }.fold(1L) { acc, divisibleBy -> acc * divisibleBy }
        letMonkeysWork(monkeys, 10000) { it.mod(lcm) }
        return monkeys.map { it.getThrownItems() }.sortedDescending().take(2).reduce { acc, next -> acc * next }
    }

    private fun toMonkey(input: List<String>): Monkey {
        val monkey = Monkey()
        for ((index, line) in input.withIndex()) {
            if (index == 0) {
                monkey.setId(line)
            }
            if (index == 1) {
                monkey.addItems(line)
            }
            if (index == 2) {
                monkey.setOperation(line)
            }
            if (index == 3) {
                monkey.setDivideBy(line)
            }
            if (index == 4) {
                monkey.setThrowToIfTrue(line)
            }
            if (index == 5) {
                monkey.setThrowToIfFalse(line)
            }
        }
        return monkey
    }

    private fun letMonkeysWork(monkeys: List<Monkey>, times: Int, post: (Long) -> Long) {
        for (i in 0 until times) {
            monkeys.forEach { monkey ->
                val throwItemsTo = monkey.throwItemsTo(post)
                throwItemsTo.forEach { throwTo ->
                    monkeys[throwTo.first].addItem(throwTo.second)
                }
            }
        }
    }
}
