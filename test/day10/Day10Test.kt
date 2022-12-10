package day10

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import readTestInput
import java.util.stream.Stream

class Day10Test {
    companion object MultiplyParameters {
        @JvmStatic
        fun part1TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(readTestInput("day10/testInput1"), 13140)
            )

        @JvmStatic
        fun part2TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(readTestInput("day10/testInput1"), readTestInput("day10/expectedPart2"))
            )
    }

    @ParameterizedTest
    @MethodSource("part1TestInput")
    fun part1(input: List<String>, expected: Int) {
        assertThat(Day10().part1(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("part2TestInput")
    fun part2(input: List<String>, expected: List<String>) {
        assertThat(Day10().part2(input)).isEqualTo(expected)
    }

    @Test
    fun part1() {
        println(Day10().part1())
    }

    @Test
    fun part2() {
        (Day10().part2()).forEach {
            println(it)
        }
    }
}
