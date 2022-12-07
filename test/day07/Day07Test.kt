package template

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import readTestInput
import java.util.stream.Stream

class Day07Test {
    companion object MultiplyParameters {
        @JvmStatic
        fun part1TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("$ cd /", "$ ls"), 0),
                Arguments.of(listOf("$ cd /", "$ ls", "35 a.txt"), 35),
                Arguments.of(listOf("$ cd /", "$ ls", "dir a", "35 a.txt"), 35),
                Arguments.of(listOf("$ cd /", "$ ls", "dir a", "dir b", "35 a.txt"), 35),
                Arguments.of(listOf("$ cd /", "$ ls", "dir a", "dir b", "35 a.txt", "$ cd a", "$ ls", "40 b.txt"), 115),
                Arguments.of(
                    listOf(
                        "$ cd /",
                        "$ ls",
                        "dir a",
                        "dir b",
                        "35 a.txt",
                        "$ cd a",
                        "$ ls",
                        "40 b.txt",
                        "50 c.txt"
                    ), 215
                ),
                Arguments.of(
                    listOf(
                        "$ cd /",
                        "$ ls",
                        "dir a",
                        "dir b",
                        "dir c",
                        "35 a.txt",
                        "$ cd a",
                        "$ ls",
                        "40 b.txt",
                        "50 c.txt",
                        "$ cd ..",
                        "$ cd b",
                        "$ ls",
                        "20 d.txt"
                    ), 255
                ),
                Arguments.of(
                    listOf(
                        "$ cd /",
                        "$ ls",
                        "dir a",
                        "dir b",
                        "$ cd a",
                        "$ ls",
                        "50 a_file.txt",
                        "dir b",
                        "$ cd b",
                        "$ ls",
                        "60 b_file.txt",
                        "$ cd ..",
                        "$ cd ..",
                        "$ ls",
                        "20 b.txt"
                    ), 300
                ),
                Arguments.of(readTestInput("day07/testInput1"), 95437)
            )

        @JvmStatic
        fun part2TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(readTestInput("day07/testInput1"), 24933642)
            )
    }

    @ParameterizedTest
    @MethodSource("part1TestInput")
    fun part1(input: List<String>, expected: Int) {
        assertThat(Day07().part1(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("part2TestInput")
    fun part2(input: List<String>, expected: Int) {
        assertThat(Day07().part2(input)).isEqualTo(expected)
    }

    @Test
    fun part1() {
        println(Day07().part1())
    }

    @Test
    fun part2() {
        println(Day07().part2())
    }
}
