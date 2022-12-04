package day01

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day01Test {
    companion object MultiplyParameters {
        @JvmStatic
        fun part1TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("1000"), 1000),
                Arguments.of(listOf("1000", "2000", "3000"), 6000),
                Arguments.of(listOf("1000", "2000", "", "1000", "4000"), 5000)
            )

        @JvmStatic
        fun part2TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("1000"), 1000),
                Arguments.of(listOf("1000", "2000", "3000"), 6000),
                Arguments.of(listOf("1000", "2000", "", "1000", "4000"), 8000),
                Arguments.of(
                    listOf(
                        "1000",
                        "2000",
                        "3000",
                        "",
                        "4000",
                        "",
                        "5000",
                        "6000",
                        "",
                        "7000",
                        "8000",
                        "9000",
                        "",
                        "10000"
                    ), 45000
                )
            )
    }

    @ParameterizedTest
    @MethodSource("part1TestInput")
    fun part1(input: List<String>, expected: Int) {
        assertThat(Day01().part1(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("part2TestInput")
    fun part2(input: List<String>, expected: Int) {
        assertThat(Day01().part2(input)).isEqualTo(expected)
    }

    @Test
    fun part1() {
        println(Day01().part1())
    }

    @Test
    fun part2() {
        println(Day01().part2())
    }
}
