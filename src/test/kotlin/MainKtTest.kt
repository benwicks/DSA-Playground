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

    @Test
    fun canFormPalindromeByDeletingAtMostOneChar() {
        assertTrue(canFormPalindromeByDeletingAtMostOneChar("abcba"))
        assertTrue(canFormPalindromeByDeletingAtMostOneChar("foobof"))
        assertFalse(canFormPalindromeByDeletingAtMostOneChar("abccab"))
    }

    @Test
    fun doTwoNumbersSumToTarget() {
        assertTrue(doTwoNumbersSumToTarget(intArrayOf(1, 3, 8, 2), 10))
        assertFalse(doTwoNumbersSumToTarget(intArrayOf(3, 9, 13, 7), 8))
        assertTrue(doTwoNumbersSumToTarget(intArrayOf(4, 2, 6, 5, 2), 4))
    }

    @Test
    fun returnStonesThatAreAlsoJewels() {
        assertEquals(2, stonesThatAreAlsoJewels("abc", "ac"))
        assertEquals(3, stonesThatAreAlsoJewels("Af", "AaaddfFf"))
        assertEquals(0, stonesThatAreAlsoJewels("AYOPD", "ayopd"))
    }

    @Test
    fun isAnagram() {
        assertTrue("cat".isAnagram("tac"))
        assertTrue("listen".isAnagram("silent"))
        assertFalse("program".isAnagram("function"))
        assertFalse("functioo".isAnagram("function"))
    }

    @Test
    fun indexOfFirstUniqueCharacter() {
        assertEquals(2, indexOfFirstUniqueCharacter("abcabd"))
        assertEquals(1, indexOfFirstUniqueCharacter("thedailybyte"))
        assertEquals(0, indexOfFirstUniqueCharacter("developer"))
        assertEquals(2, indexOfFirstUniqueCharacter("eer"))
        assertEquals(-1, indexOfFirstUniqueCharacter("ee"))
    }
}