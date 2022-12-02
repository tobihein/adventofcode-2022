package day02

import readInput

class Day02 {
    fun part1(): Int {
        val readInput = readInput("day02/input")
        return part1(readInput)
    }

    fun part2(): Int {
        val readInput = readInput("day02/input")
        return part2(readInput)
    }

    fun part1(input: List<String>): Int = input.map { parse(it) }.map { getScore(it) }.sum()

    fun part2(input: List<String>): Int = input.map { parsePart2(it) }.map { getScore(it) }.sum()

    private fun parse(s: String): Pair<Choice, Choice> {
        val choices = s.split(" ")
        if (choices.size != 2) {
            throw IllegalArgumentException("Unknown input $s")
        }
        return Pair(toChoice(choices[0]), toChoice(choices[1]))
    }

    private fun parsePart2(s: String): Pair<Choice, Choice> {
        val choices = s.split(" ")
        if (choices.size != 2) {
            throw IllegalArgumentException("Unknown input $s")
        }
        val other = toChoice(choices[0])
        val you = calcRequiredChoice(choices, other)
        return Pair(other, you)
    }

    private fun calcRequiredChoice(choices: List<String>, other: Choice): Choice {
        var you = toChoice(choices[1])
        if (you == Choice.ROCK) you = loseAgainst(other)
        else if (you == Choice.PAPER) you = other
        else if (you == Choice.SCISSOR) you = winAgainst(other)
        return you
    }

    private fun winAgainst(other: Choice): Choice {
        when (other) {
            Choice.ROCK -> return Choice.PAPER
            Choice.SCISSOR -> return Choice.ROCK
            else -> return Choice.SCISSOR
        }
    }

    private fun loseAgainst(other: Any): Choice {
        when (other) {
            Choice.ROCK -> return Choice.SCISSOR
            Choice.SCISSOR -> return Choice.PAPER
            else -> return Choice.ROCK
        }
    }

    private fun getScore(choices: Pair<Choice, Choice>) =
        choices.second.score + getRetResultScore(choices.first, choices.second)

    private fun getRetResultScore(other: Choice, you: Choice): Int {
        var score = -1
        if (other == you) {
            score = 3
        } else if (other == Choice.ROCK) {
            score = if (you == Choice.SCISSOR) 0 else 6
        } else if (other == Choice.PAPER) {
            score = if (you == Choice.ROCK) 0 else 6
        } else if (other == Choice.SCISSOR) {
            score = if (you == Choice.PAPER) 0 else 6
        }
        return score
    }

    private fun toChoice(s: String): Choice {
        when (s) {
            "A", "X" -> return Choice.ROCK
            "B", "Y" -> return Choice.PAPER
            "C", "Z" -> return Choice.SCISSOR
            else -> throw RuntimeException("Error on parsing choice $s")
        }
    }

    enum class Choice(val score: Int) {
        ROCK(1),
        PAPER(2),
        SCISSOR(3)
    }
}
