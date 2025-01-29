package via.rider.interview.ridercodinginterview

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import via.rider.interview.ridercodinginterview.prime.isPrime

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun `when guessing prime, we get the right results`(): Unit = runBlocking {
        assertTrue(2.isPrime)
        assertTrue(3.isPrime)
        assertFalse(4.isPrime)
        assertTrue(5.isPrime)
        assertFalse(6.isPrime)
        assertTrue(7.isPrime)
        assertFalse(8.isPrime)
        assertFalse(9.isPrime)
        assertFalse(10.isPrime)
        assertTrue(11.isPrime)
        assertFalse(12.isPrime)
        assertTrue(13.isPrime)
        assertFalse(14.isPrime)
        assertFalse(15.isPrime)
        assertFalse(16.isPrime)
        assertTrue(17.isPrime)
    }
}