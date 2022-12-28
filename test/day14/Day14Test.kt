package day14

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day14Test {
    companion object MultiplyParameters {
        @JvmStatic
        fun part1TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("498,4 -> 498,6 -> 496,6", "503,4 -> 502,4 -> 502,9 -> 494,9"), 24)
            )

        @JvmStatic
        fun part2TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("498,4 -> 498,6 -> 496,6", "503,4 -> 502,4 -> 502,9 -> 494,9"), 93)
            )
    }

    @ParameterizedTest
    @MethodSource("part1TestInput")
    fun part1(input: List<String>, expected: Int) {
        assertThat(Day14().part1(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("part2TestInput")
    fun part2(input: List<String>, expected: Int) {
        assertThat(Day14().part2(input)).isEqualTo(expected)
    }

    @Test
    fun part1() {
        println(Day14().part1())
    }

    @Test
    fun part2() {
        println(Day14().part2())
    }
}
