import org.junit.Test
import kotlin.test.assertEquals

internal class Day18Test{
    private val day = Day18("Day18Test1Star.txt", 7, 12)

    @Test
    fun test1StarInputData() {
        val result = day.solveOneStar()
        assertEquals(22, result)
    }
}