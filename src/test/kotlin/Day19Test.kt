import org.junit.Test
import kotlin.test.assertEquals

internal class Day19Test{
    val day = Day19("Day19Test.txt")

    @Test
    fun testInputData1Star(){
        assertEquals(6, day.solveStarOne())
    }
}