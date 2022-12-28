package day14

import readInput

class Day14 {
    fun part1(): Int {
        val readInput = readInput("day14/input")
        return part1(readInput)
    }

    fun part2(): Int {
        val readInput = readInput("day14/input")
        return part2(readInput)
    }

    fun part1(input: List<String>): Int {
        val maxColumn = getMaxColumn(input)
        val maxRow = getMaxRow(input)
        val board = Array(maxRow + 2) { Array(maxColumn * maxRow) { '.' } }
        initializeBoard(input, board)
        var sandCounter = 0
        while (pourSand(board, maxRow)) {
            sandCounter++
        }
        return sandCounter
    }

    fun part2(input: List<String>): Int {
        val maxColumn = getMaxColumn(input)
        val maxRow = getMaxRow(input) + 2
        val board = Array(maxRow + 2) { Array(maxColumn * maxRow) { '.' } }
        initializeBoard(input, board)
        for (i in 0 until board[0].size) {
            board[maxRow][i] = '#'
        }
        var sandCounter = 0
        while (pourSand(board)) {
            sandCounter++
        }
        return sandCounter
    }

    private fun pourSand(board: Array<Array<Char>>, maxRow: Int): Boolean {
        var previousPos = Pair(500, 0)
        var nextPos: Pair<Int, Int>? = previousPos
        var finish = false
        while (nextPos != null && !finish) {
            nextPos = getNextPos(board, previousPos)
            if (nextPos != null) {
                finish = (nextPos.second == maxRow)
                previousPos = nextPos
            }
        }
        if (!finish) {
            board[previousPos.second][previousPos.first] = 'o'
        }
        return !finish
    }

    private fun pourSand(board: Array<Array<Char>>): Boolean {
        if (board[0][500] == '.') {
            var previousPos = Pair(500, 0)
            var nextPos: Pair<Int, Int>? = previousPos
            while (nextPos != null) {
                nextPos = getNextPos(board, previousPos)
                if (nextPos != null) {
                    previousPos = nextPos
                }
            }
            board[previousPos.second][previousPos.first] = 'o'
            return true
        }
        return false
    }

    private fun getNextPos(board: Array<Array<Char>>, sandPos: Pair<Int, Int>): Pair<Int, Int>? {
        val nextRow = sandPos.second + 1
        if (board.size > nextRow) {
            val below = board[nextRow][sandPos.first]
            if (below == '.') {
                return Pair(sandPos.first, nextRow)
            }
            val leftPos = sandPos.first - 1
            if (leftPos >= 0) {
                val left = board[nextRow][leftPos]
                if (left == '.')
                    return Pair(leftPos, nextRow)
            }
            val rightpos = sandPos.first + 1
            if (board[0].size > rightpos) {
                val right = board[nextRow][rightpos]
                if (right == '.') {
                    return Pair(rightpos, nextRow)
                }
            }
        }
        return null
    }

    private fun initializeBoard(input: List<String>, board: Array<Array<Char>>) {
        input.forEach {
            val paths = it.split("->").map { it.trim().split(",") }.map { Pair(it[0].toInt(), it[1].toInt()) }
            for (i in 0 until paths.size - 1) {
                drawLine(paths[i], paths[i + 1], board)
            }
        }

    }

    private fun drawLine(from: Pair<Int, Int>, to: Pair<Int, Int>, board: Array<Array<Char>>) {
        if (from.first == to.first) {
            for (i in Math.min(from.second, to.second)..Math.max(from.second, to.second)) {
                board[i][from.first] = '#'
            }
        } else if (from.second == to.second) {
            for (i in Math.min(from.first, to.first)..Math.max(from.first, to.first)) {
                board[from.second][i] = '#'
            }
        }
    }

    private fun getMaxColumn(input: List<String>) = input.map { it.split("->") }.map { maxColumnValue(it) }.max()

    private fun getMaxRow(input: List<String>) = input.map { it.split("->") }.map { maxRowValue(it) }.max()

    private fun maxColumnValue(line: List<String>) = line.map { it.trim() }.map { it.split(",")[0].toInt() }.max()

    private fun maxRowValue(line: List<String>) = line.map { it.trim() }.map { it.split(",")[1].toInt() }.max()
}
