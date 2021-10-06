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

    @Test
    fun willRobotVacuumReturnToOriginalPosition() {
        assertTrue(willRobotVacuumReturnToOriginalPosition("LR"))
        assertFalse(willRobotVacuumReturnToOriginalPosition("URURD"))
        assertTrue(willRobotVacuumReturnToOriginalPosition("RUULLDRD"))
    }

    @Test
    fun doesUseCapitalizationCorrectly() {
        assertTrue(doesUseCapitalizationCorrectly("USA"))
        assertTrue(doesUseCapitalizationCorrectly("Calvin"))
        assertFalse(doesUseCapitalizationCorrectly("compUter"))
        assertTrue(doesUseCapitalizationCorrectly("coding"))
    }

    @Test
    fun addBinaryStrings() {
        assertEquals("101", addBinaryStrings("100", "1"))
        assertEquals("100", addBinaryStrings("11", "1"))
        assertEquals("101", addBinaryStrings("100", "1"))
    }

    @Test
    fun getLongestCommonPrefix() {
        assertEquals("col", getLongestCommonPrefix(listOf("colorado", "color", "cold")))
        assertEquals("", getLongestCommonPrefix(listOf("a", "b", "c")))
        assertEquals("spot", getLongestCommonPrefix(listOf("spot", "spotty", "spotted")))
    }

    @Test
    fun findDuplicateOptimizedForSpace() {
        assertEquals(4, findDuplicateOptimizedForSpace(listOf(1, 2, 3, 4, 4)))
        assertEquals(3, findDuplicateOptimizedForSpace(listOf(1, 2, 3, 3, 4)))
        assertEquals(3, findDuplicateOptimizedForSpace(listOf(1, 1, 3, 3, 4)))
        assertEquals(3, findDuplicateOptimizedForSpace(listOf(3, 3, 1, 2, 4)))
    }
}