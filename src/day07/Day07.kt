package template

import readInput
import java.util.*

class Day07 {
    fun part1(): Int {
        val readInput = readInput("day07/input")
        return part1(readInput)
    }

    fun part2(): Int {
        val readInput = readInput("day07/input")
        return part2(readInput)
    }

    fun part1(input: List<String>): Int {
        val folders = getFoldersWithSize(input)
        return folders.map { it.value }.filter { it <= 100000 }.sum()
    }

    private fun getFoldersWithSize(input: List<String>): MutableMap<String, Int> {
        val folders = mutableMapOf<String, Int>()
        val stack = Stack<String>()
        var currentDir: String? = null
        input.forEach { it ->
            when {
                goToParentFolder(it) -> currentDir = stack.pop()
                goToFolder(it) -> {
                    val dirName = it.split(" ")[2]
                    if (currentDir != null) {
                        stack.push(currentDir)
                        currentDir = currentDir + "_" + dirName
                    } else {
                        currentDir = dirName
                    }
                    folders.putIfAbsent(dirName, 0)
                }

                isDir(it) -> folders.putIfAbsent(it.split(" ")[1], 0)
                isFile(it) -> {
                    val previousSize = folders.getOrDefault(currentDir, 0)
                    val currentSize = it.split(" ")[0].toInt()
                    val curDir = currentDir
                    if (curDir != null) {
                        folders.put(curDir, previousSize + currentSize)
                    }
                    stack.forEach {
                        val newSize = folders.getOrDefault(it, 0) + currentSize
                        folders.put(it, newSize)
                    }
                }
            }
        }
        return folders
    }

    fun part2(input: List<String>): Int {
        val folders = getFoldersWithSize(input)
        val usedSize = folders.getOrDefault("/", 0)
        val unsedSize = 70000000 - usedSize
        val sizeToDelete = 30000000 - unsedSize
        return folders.toList().sortedBy { (_, v) -> v }.map { it.second }.filter { it > sizeToDelete }.first()
    }

    private fun goToParentFolder(s: String) = (s == "$ cd ..")
    private fun goToFolder(s: String) = (s.startsWith("$ cd ") && !s.endsWith(".."))
    private fun isDir(s: String) = s.startsWith("dir ")
    private fun isFile(s: String) = s.split(" ")[0].matches("\\d+".toRegex())
}
