package day25

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day25Test {
    companion object MultiplyParameters {
        @JvmStatic
        fun part1TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("1"), "1"),
                Arguments.of(listOf("2"), "2"),
                Arguments.of(listOf("1="), "1="),
                Arguments.of(listOf("1-"), "1-"),
                Arguments.of(listOf("10"), "10"),
                Arguments.of(listOf("11"), "11"),
                Arguments.of(listOf("12"), "12"),
                Arguments.of(listOf("1=="), "1=="),
                Arguments.of(listOf("1=0"), "1=0"),
                Arguments.of(listOf("1==="), "1==="),
                Arguments.of(listOf("1===="), "1===="),
                Arguments.of(listOf("1====="), "1====="),
                Arguments.of(listOf("1=11-2"), "1=11-2"),
                Arguments.of(listOf("1121-1110-1=0"), "1121-1110-1=0"),
                Arguments.of(
                    listOf(
                        "1=-0-2",
                        "12111",
                        "2=0=",
                        "21",
                        "2=01",
                        "111",
                        "20012",
                        "112",
                        "1=-1=",
                        "1-12",
                        "12",
                        "1=",
                        "122"
                    ), "2=-1=0"
                )
            )

        @JvmStatic
        fun part2TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf(""), "")
            )
    }

    @ParameterizedTest
    @MethodSource("part1TestInput")
    fun part1(input: List<String>, expected: String) {
        assertThat(Day25().part1(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("part2TestInput")
    fun part2(input: List<String>, expected: String) {
        assertThat(Day25().part2(input)).isEqualTo(expected)
    }

    @Test
    fun part1() {
        println(Day25().part1())
    }

    @Test
    fun part2() {
        println(Day25().part2())
    }
}
