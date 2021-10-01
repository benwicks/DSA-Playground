import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun reverseString() {
        assertEquals("etyB yliaD ehT", reverseString("The Daily Byte"))
        assertEquals("civic", reverseString("civic"))
    }

    @Test
    fun isValidPalindrome() {
        assertTrue(isValidPalindrome("madam"))
        assertFalse(isValidPalindrome("ben"))
        assertTrue(isValidPalindrome("A man, a plan, a canal: Panama.", true))
    }
}