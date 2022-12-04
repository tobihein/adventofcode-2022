package day03

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day03Test {
    companion object MultiplyParameters {
        @JvmStatic
        fun part1TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("vJrwpWtwJgWrhcsFMMfFFhFp"), 16),
                Arguments.of(listOf("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"), 38),
                Arguments.of(listOf("PmmdzqPrVvPwwTWBwg"), 42),
                Arguments.of(listOf("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"), 22),
                Arguments.of(listOf("ttgJtRGJQctTZtZT"), 20),
                Arguments.of(listOf("CrZsJsPPZsGzwwsLwLmpwMDw"), 19)
            )

        @JvmStatic
        fun part2TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    listOf(
                        "vJrwpWtwJgWrhcsFMMfFFhFp",
                        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                        "PmmdzqPrVvPwwTWBwg"
                    ), 18
                ),
                Arguments.of(
                    listOf("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw"),
                    52
                )
            )
    }

    @ParameterizedTest
    @MethodSource("part1TestInput")
    fun part1(input: List<String>, expected: Int) {
        assertThat(Day03().part1(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("part2TestInput")
    fun part2(input: List<String>, expected: Int) {
        assertThat(Day03().part2(input)).isEqualTo(expected)
    }

    @Test
    fun part1() {
        println(Day03().part1())
    }

    @Test
    fun part2() {
        println(Day03().part2())
    }
}
