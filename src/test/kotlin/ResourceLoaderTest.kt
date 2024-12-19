import org.junit.Test
import kotlin.test.assertEquals

internal class ResourceLoaderTest {
    @Test
    fun testResourceLoader(){
        val result = readResource("test.txt")

        assertEquals("Veryelaboratetest", result)
    }
}