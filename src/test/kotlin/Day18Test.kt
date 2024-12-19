import org.junit.Test
import kotlin.test.assertEquals

internal class Day18Test{
    private val day = Day18("Day18Test1Star.txt", 7, 12)

    @Test
    fun test1StarInputData() {
        val result = day.solveStarOne()
        assertEquals(22, result)
    }

    @Test
    fun test2StarInputData() {
        val result = day.solveStarTwo()
        assertEquals(6, result.first)
        assertEquals(1, result.second)
    }
}