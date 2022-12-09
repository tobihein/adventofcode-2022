package day09

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import readTestInput
import java.util.stream.Stream

class Day09Test {
    companion object MultiplyParameters {
        @JvmStatic
        fun part1TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("U 1"), 1),
                Arguments.of(listOf("D 1"), 1),
                Arguments.of(listOf("L 1"), 1),
                Arguments.of(listOf("R 1"), 1),
                Arguments.of(listOf("R 1", "R 1"), 2),
                Arguments.of(listOf("R 1", "U 1"), 1),
                Arguments.of(listOf("R 1", "L 1"), 1),
                Arguments.of(listOf("R 1", "D 1"), 1),
                Arguments.of(listOf("R 1", "R 1", "U 1"), 2),
                Arguments.of(listOf("R 1", "R 1", "U 1", "U 1"), 3),
                Arguments.of(readTestInput("day09/testInput1"), 13)
            )

        @JvmStatic
        fun part2TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(readTestInput("day09/testInput1"), 1),
                Arguments.of(readTestInput("day09/testInput2"), 36)
            )
    }

    @ParameterizedTest
    @MethodSource("part1TestInput")
    fun part1(input: List<String>, expected: Int) {
        assertThat(Day09().part1(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("part2TestInput")
    fun part2(input: List<String>, expected: Int) {
        assertThat(Day09().part2(input)).isEqualTo(expected)
    }

    @Test
    fun part1() {
        println(Day09().part1())
    }

    @Test
    fun part2() {
        println(Day09().part2())
    }
}
