import day01.Day01
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day01Test {
    @Test
    fun firstTest() {
        assertThat(Day01().part1(listOf("a", "b", "c"))).isEqualTo(3)

    }
}