package day04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day04Test {
    companion object MultiplyParameters {
        @JvmStatic
        fun part1TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("2-4,6-8"), 0),
                Arguments.of(listOf("6-6,4-6"), 1),
                Arguments.of(listOf("2-8,3-7"), 1),
                Arguments.of(listOf("2-4,6-8", "2-8,3-7", "6-6,4-6", "2-6,4-8"), 2)
            )

        @JvmStatic
        fun part2TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("2-4,6-8"), 0),
                Arguments.of(listOf("6-6,4-6"), 1),
                Arguments.of(listOf("2-8,3-7"), 1),
                Arguments.of(listOf("5-7,7-9"), 1),
                Arguments.of(listOf("2-8,3-7"), 1),
                Arguments.of(listOf("2-4,6-8", "6-6,4-6", "2-8,3-7", "5-7,7-9"), 3)
            )
    }

    @ParameterizedTest
    @MethodSource("part1TestInput")
    fun part1(input: List<String>, expected: Int) {
        assertThat(Day04().part1(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("part2TestInput")
    fun part2(input: List<String>, expected: Int) {
        assertThat(Day04().part2(input)).isEqualTo(expected)
    }

    @Test
    fun part1() {
        println(Day04().part1())
    }

    @Test
    fun part2() {
        println(Day04().part2())
    }
}
