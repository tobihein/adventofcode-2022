package day08

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import readTestInput
import java.util.stream.Stream

class Day08Test {
    companion object MultiplyParameters {
        @JvmStatic
        fun part1TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("5"), 1),
                Arguments.of(listOf("12", "34"), 4),
                Arguments.of(listOf("123", "456", "789"), 9),
                Arguments.of(readTestInput("day08/testInput1"), 21)
            )

        @JvmStatic
        fun part2TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("5"), 0),
                Arguments.of(listOf("12", "34"), 0),
                Arguments.of(listOf("123", "456", "789"), 1),
                Arguments.of(readTestInput("day08/testInput1"), 8)
            )
    }

    @ParameterizedTest
    @MethodSource("part1TestInput")
    fun part1(input: List<String>, expected: Int) {
        assertThat(Day08().part1(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("part2TestInput")
    fun part2(input: List<String>, expected: Int) {
        assertThat(Day08().part2(input)).isEqualTo(expected)
    }

    @Test
    fun part1() {
        println(Day08().part1())
    }

    @Test
    fun part2() {
        println(Day08().part2())
    }
}
