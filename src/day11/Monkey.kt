package day11

class Monkey {
    private val items = mutableListOf<Long>()
    private var id = 0
    private var operation = ""
    private var divisibleBy = 0
    private var throwTo = Pair(0, 0)
    private var thrownItems = 0L

    fun addItems(line: String) {
        items.addAll(line.split(":")[1].trim().split(",").map { it.trim().toLong() })
    }

    fun getDivisibleBy(): Int {
        return divisibleBy
    }

    fun addItem(item: Long) {
        items.add(item)
    }

    fun setId(input: String) {
        id = input.split(" ")[1].replace(":", "").toInt()
    }

    fun setOperation(line: String) {
        operation = line.split("=")[1].trim()
    }

    fun setDivideBy(line: String) {
        divisibleBy = line.trim().split(" ")[3].trim().toInt()
    }

    fun setThrowToIfTrue(line: String) {
        val value = line.trim().split(" ")[5].trim().toInt()
        throwTo = Pair(value, throwTo.second)
    }

    fun setThrowToIfFalse(line: String) {
        val value = line.trim().split(" ")[5].trim().toInt()
        throwTo = Pair(throwTo.first, value)
    }

    fun getThrownItems(): Long {
        return thrownItems
    }

    fun throwItemsTo(post: (Long) -> Long): List<Pair<Int, Long>> {
        val throwToMonkeys = mutableListOf<Pair<Int, Long>>()
        items.forEach {
            val newWorryLevel = post(calc(it))
            if (newWorryLevel % divisibleBy == 0L) {
                throwToMonkeys.add(Pair(throwTo.first, newWorryLevel))
            } else {
                throwToMonkeys.add(Pair(throwTo.second, newWorryLevel))
            }
        }
        thrownItems += items.size
        items.clear()

        return throwToMonkeys
    }

    private fun calc(it: Long): Long {
        val operationParts = operation.trim().split(" ")
        val first = getValue(operationParts[0], it)
        val second = getValue(operationParts[2], it)
        return when (operationParts[1]) {
            "+" -> first + second
            "-" -> first - second
            "/" -> first / second
            "*" -> first * second
            else -> throw RuntimeException("Unknown operation $operationParts[1]")
        }
    }

    private fun getValue(operationPart: String, oldValue: Long): Long {
        return if (operationPart == "old") {
            oldValue
        } else {
            operationPart.toLong()
        }
    }
}