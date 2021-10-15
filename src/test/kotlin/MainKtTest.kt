import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

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

    @Test
    fun findRandomAddedLetter() {
        assertEquals('t', findRandomAddedLetter("foobar", "barfoot"))
        assertEquals('a', findRandomAddedLetter("ide", "idea"))
        assertEquals(' ', findRandomAddedLetter("coding", "ingcod"))
    }

    @Test
    fun getIntersection() {
        assertContentEquals(intArrayOf(2, 4), intArrayOf(2, 4, 4, 2).getIntersection(intArrayOf(2, 4)))
        assertContentEquals(intArrayOf(3), intArrayOf(1, 2, 3, 3).getIntersection(intArrayOf(3, 3)))
        assertContentEquals(intArrayOf(), intArrayOf(2, 4, 6, 8).getIntersection(intArrayOf(1, 3, 5, 7)))
    }

    @Test
    fun getUncommonWords() {
        // todo fix order-insensitive comparison/assertion. https://stackoverflow.com/questions/21624592/hamcrest-compare-collections/38262680#38262680
        // https://stackoverflow.com/questions/22807328/assertequals-2-lists-ignore-order
        assertContentEquals(listOf("brown", "fox", "quick", "the"), getUncommonWords("the quick", "brown fox"))
        assertContentEquals(
            listOf("beat", "lost", "to"),
            getUncommonWords("the tortoise beat the haire", "the tortoise lost to the haire")
        )
        assertContentEquals(listOf("copper", "hot"), getUncommonWords("copper coffee pot", "hot coffee pot"))
    }
}