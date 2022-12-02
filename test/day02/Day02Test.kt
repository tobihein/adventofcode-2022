package day02

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day02Test {
    companion object MultiplyParameters {
        @JvmStatic
        fun part1TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("A Y"), 8),
                Arguments.of(listOf("B X"), 1),
                Arguments.of(listOf("C Z"), 6)
            )

        @JvmStatic
        fun part2TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("A Y"), 4),
                Arguments.of(listOf("B X"), 1),
                Arguments.of(listOf("C Z"), 7)
            )
    }

    @ParameterizedTest
    @MethodSource("part1TestInput")
    fun part1(input: List<String>, expected: Int) {
        assertThat(Day02().part1(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("part2TestInput")
    fun part2(input: List<String>, expected: Int) {
        assertThat(Day02().part2(input)).isEqualTo(expected)
    }

    @Test
    fun part1() {
        println(Day02().part1())
    }

    @Test
    fun part2() {
        println(Day02().part2())
    }
}
