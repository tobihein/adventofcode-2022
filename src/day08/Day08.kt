package day08

import readInput

class Day08 {
    fun part1(): Int {
        val readInput = readInput("day08/input")
        return part1(readInput)
    }

    fun part2(): Int {
        val readInput = readInput("day08/input")
        return part2(readInput)
    }

    fun part1(input: List<String>): Int {
        val visibleTrees = mutableSetOf<Pair<Int, Int>>()

        val trees = toArray(input)
        for (row in 0 until input.size) {
            for (column in 0 until input.size) {
                if (isVisible(row, column, trees)) {
                    visibleTrees.add(Pair(row, column))
                }
            }
        }
        return visibleTrees.size
    }

    fun part2(input: List<String>): Int {
        val scenicScores = mutableSetOf<Int>()
        val trees = toArray(input)
        for (row in 0 until input.size) {
            for (column in 0 until input.size) {
                scenicScores.add(getScenicScore(row, column, trees))
            }
        }
        return scenicScores.max()
    }

    private fun getScenicScore(row: Int, column: Int, trees: Array<IntArray>): Int {
        return scoreRight(row, column, trees) * scoreLeft(row, column, trees) * scoreAbove(
            row,
            column,
            trees
        ) * scoreBelow(row, column, trees)
    }

    private fun scoreRight(row: Int, column: Int, trees: Array<IntArray>): Int {
        var canSeeHeight = trees[row][column] - 1
        var canSeeTrees = 0
        var blocked = false
        for (i in column + 1 until trees.size) {
            val currentTree = trees[row][i]
            if (currentTree > canSeeHeight) {
                canSeeTrees++
                canSeeHeight = currentTree + 1
                blocked = true
            } else if (!blocked) {
                canSeeTrees++
            }
        }
        return canSeeTrees
    }

    private fun scoreLeft(row: Int, column: Int, trees: Array<IntArray>): Int {
        var canSeeHeight = trees[row][column] - 1
        var canSeeTrees = 0
        var blocked = false
        for (i in column - 1 downTo 0) {
            val currentTree = trees[row][i]
            if (currentTree > canSeeHeight) {
                canSeeTrees++
                canSeeHeight = currentTree + 1
                blocked = true
            } else if (!blocked) {
                canSeeTrees++
            }
        }
        return canSeeTrees
    }

    private fun scoreBelow(row: Int, column: Int, trees: Array<IntArray>): Int {
        var canSeeHeight = trees[row][column] - 1
        var canSeeTrees = 0
        var blocked = false
        for (i in row + 1 until trees.size) {
            val currentTree = trees[i][column]
            if (currentTree > canSeeHeight) {
                canSeeTrees++
                canSeeHeight = currentTree + 1
                blocked = true
            } else if (!blocked) {
                canSeeTrees++
            }
        }
        return canSeeTrees
    }

    private fun scoreAbove(row: Int, column: Int, trees: Array<IntArray>): Int {
        var canSeeHeight = trees[row][column] - 1
        var canSeeTrees = 0
        var blocked = false
        for (i in row - 1 downTo 0) {
            val currentTree = trees[i][column]
            if (currentTree > canSeeHeight) {
                canSeeTrees++
                canSeeHeight = currentTree + 1
                blocked = true
            } else if (!blocked) {
                canSeeTrees++
            }
        }
        return canSeeTrees
    }

    private fun isVisible(row: Int, column: Int, trees: Array<IntArray>): Boolean {
        return isVisibleFromLeft(row, column, trees) || isVisibleFromTop(row, column, trees) || isVisibleFromRight(
            row,
            column,
            trees
        ) || isVisibleFromBottom(row, column, trees)
    }

    private fun isVisibleFromLeft(row: Int, column: Int, trees: Array<IntArray>): Boolean {
        val currentTree = trees[row][column]
        for (i in 0 until column) {
            if (trees[row][i] >= currentTree) {
                return false
            }
        }
        return true
    }

    private fun isVisibleFromRight(row: Int, column: Int, trees: Array<IntArray>): Boolean {
        val currentTree = trees[row][column]
        for (i in trees[row].size - 1 downTo column + 1) {
            if (trees[row][i] >= currentTree) {
                return false
            }
        }
        return true
    }

    private fun isVisibleFromTop(row: Int, column: Int, trees: Array<IntArray>): Boolean {
        val currentTree = trees[row][column]
        for (i in 0 until row) {
            if (trees[i][column] >= currentTree) {
                return false
            }
        }
        return true
    }

    private fun isVisibleFromBottom(row: Int, column: Int, trees: Array<IntArray>): Boolean {
        val currentTree = trees[row][column]
        for (i in trees[row].size - 1 downTo row + 1) {
            if (trees[i][column] >= currentTree) {
                return false
            }
        }
        return true
    }

    private fun toArray(input: List<String>): Array<IntArray> {
        val rows = mutableListOf<IntArray>()
        for (trees in input) {
            rows.add(trees.toCharArray().map { it.digitToInt() }.toIntArray())
        }

        return rows.toTypedArray()
    }
}
