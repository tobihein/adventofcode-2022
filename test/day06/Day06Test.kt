package day06

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day06Test {
    companion object MultiplyParameters {
        @JvmStatic
        fun part1TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("mjqjpqmgbljsphdztnvjfqwrcgsmlb"), 7),
                Arguments.of(listOf("bvwbjplbgvbhsrlpgdmjqwftvncz"), 5),
                Arguments.of(listOf("nppdvjthqldpwncqszvftbrmjlhg"), 6),
                Arguments.of(listOf("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"), 10),
                Arguments.of(listOf("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"), 11)
            )

        @JvmStatic
        fun part2TestInput(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("mjqjpqmgbljsphdztnvjfqwrcgsmlb"), 19),
                Arguments.of(listOf("bvwbjplbgvbhsrlpgdmjqwftvncz"), 23),
                Arguments.of(listOf("nppdvjthqldpwncqszvftbrmjlhg"), 23),
                Arguments.of(listOf("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"), 29),
                Arguments.of(listOf("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"), 26)
            )
    }

    @ParameterizedTest
    @MethodSource("part1TestInput")
    fun part1(input: List<String>, expected: Int) {
        assertThat(Day06().part1(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("part2TestInput")
    fun part2(input: List<String>, expected: Int) {
        assertThat(Day06().part2(input)).isEqualTo(expected)
    }

    @Test
    fun part1() {
        println(Day06().part1())
    }

    @Test
    fun part2() {
        println(Day06().part2())
    }
}
