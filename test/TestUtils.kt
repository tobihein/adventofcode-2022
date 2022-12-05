import java.io.File

/**
 * Reads lines from the given input txt file.
 */
fun readTestInput(name: String) = File("test", "$name.txt").readLines()
