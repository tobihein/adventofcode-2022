package day11

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import readTestInput
import java.util.stream.Stream

class Day11Test {
    companion object MultiplyParameters {
        @JvmStatic
        fun part1TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(readTestInput("day11/testInput1"), 10605L)
            )

        @JvmStatic
        fun part2TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(readTestInput("day11/testInput1"), 2713310158L)
            )
    }

    @ParameterizedTest
    @MethodSource("part1TestInput")
    fun part1(input: List<String>, expected: Long) {
        assertThat(Day11().part1(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("part2TestInput")
    fun part2(input: List<String>, expected: Long) {
        assertThat(Day11().part2(input)).isEqualTo(expected)
    }

    @Test
    fun part1() {
        println(Day11().part1())
    }

    @Test
    fun part2() {
        println(Day11().part2())
    }
}
