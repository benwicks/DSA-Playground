import java.lang.Integer.max
import java.util.*

fun main(@Suppress("UNUSED_PARAMETER") args: Array<String>) {

}

fun reverseString(input: String): String {
    val stack = Stack<Char>()
    for (c in input) {
        stack.push(c)
    }
    val sb = StringBuilder()
    while (!stack.empty()) {
        sb.append(stack.pop())
    }
    return sb.toString()
}

fun isValidPalindrome(input: String, shouldIgnoreNonAlphabeticalCharactersAndCase: Boolean = false): Boolean {
    if (shouldIgnoreNonAlphabeticalCharactersAndCase) {
        return (isValidPalindrome(input.filter { it.isLetter() }.lowercase()))
    }
    for (i in 0..input.length / 2) {
        if (input[i] != input[input.length - i - 1]) {
            return false
        }
    }
    return true
}

fun willRobotVacuumReturnToOriginalPosition(input: String): Boolean {
    var xTravel = 0
    var yTravel = 0

    for (c in input) {
        when (c) {
            'L' -> xTravel--
            'R' -> xTravel++
            'U' -> yTravel++
            'D' -> yTravel--
        }
    }

    return xTravel == 0 && yTravel == 0
}

/**
 * A string correctly uses capitalization if all letters are capitalized, no letters are capitalized, or only the first letter is capitalized.
 */
fun doesUseCapitalizationCorrectly(input: String): Boolean {
    val areAllFollowingCharsLowerCase = input.substring(1 until input.length).all { it.isLowerCase() }
    return (input[0].isLowerCase() && areAllFollowingCharsLowerCase) ||
            areAllFollowingCharsLowerCase || input.substring(1 until input.length).all { it.isUpperCase() }
}

fun addBinaryStrings(string1: String, string2: String): String {
    val sumList = mutableListOf<Boolean>()
    var carryOver = false
    val maxBinaryDigits = max(string1.length, string2.length)
    for (x in 1..maxBinaryDigits) {
        val string1CharIsOn = if (x > string1.length) carryOver else string1[string1.length - x] == '1'
        val string2CharIsOn = if (x > string2.length) carryOver else string2[string2.length - x] == '1'
        sumList.add(string1CharIsOn != string2CharIsOn)
        carryOver = string1CharIsOn && string2CharIsOn
    }
    if (carryOver) {
        sumList.add(true)
    }
    return sumList.joinToString("") { if (it) "1" else "0" }.reversed()
}

fun getLongestCommonPrefix(input: List<String>): String {
    var longestCommonPrefix = input.minByOrNull { it.length } ?: return ""
    while (longestCommonPrefix.isNotEmpty()) {
        if (input.map { it.substring(longestCommonPrefix.indices) }.all { it == longestCommonPrefix }) {
            break
        } else {
            longestCommonPrefix = longestCommonPrefix.substring(0..longestCommonPrefix.length - 2)
        }
    }
    return longestCommonPrefix
}

/**
 * Where n = {input.size} - 1 and all numbers in input are in the range 1..n. There must be at least one duplicate.
 * Use binary search to bring time complexity down to O(n log n). Not sorting the input out of place keeps space complexity at O(1).
 */
fun findDuplicateOptimizedForSpace(input: List<Int>): Int {
    var floor = 1
    var ceiling = input.size - 1

    while (floor < ceiling) {
        val midpoint = floor + ((ceiling - floor) / 2)

        // Count number of items in lower range.
        if (input.count { it in floor..midpoint } > midpoint - floor + 1) {
            // A duplicate must be in this lower range.
            ceiling = midpoint
        } else {
            // A duplicate must be in this upper range.
            floor = midpoint + 1
        }
    }

    return floor
}

fun canFormPalindromeByDeletingAtMostOneChar(input: String): Boolean {
    for (i in 0..input.length / 2) {
        val end = input.length - 1 - i
        if (i < end - 1 && input[i] != input[end]) {
            // try removing char at i or j and re-testing resulting inner string.
            return isValidPalindrome(input.substring(i + 2, end)) || isValidPalindrome(input.substring(i + 1, end - 1))
        }
    }
    return true
}

fun doTwoNumbersSumToTarget(input: IntArray, target: Int): Boolean {
    val set = mutableSetOf<Int>()
    for (i in input.indices) {
        val difference = target - input[i]
        if (difference in set) {
            return true
        }
        set.add(input[i])
    }
    return false
}

fun stonesThatAreAlsoJewels(jewels: String, stones: String): Int {
    val jewelSet = jewels.toSet()
    return stones.count { it in jewelSet }
}

fun String.isAnagram(other: String): Boolean {
    if (length == other.length) {
        val map = mutableMapOf<Char, Int>()
        toCharArray().forEachIndexed { index, char ->
            val otherChar = other[index]
            if (otherChar != char) {
                if (char in map) {
                    map[char] = map[char]!! + 1
                } else {
                    map += char to 1
                }
                if (otherChar in map) {
                    map[otherChar] = map[otherChar]!! - 1
                } else {
                    map += otherChar to -1
                }
            }
        }
        return map.all { it.value == 0 }
    }
    return false
}

fun indexOfFirstUniqueCharacter(input: String): Int {
    val seenChars = mutableSetOf<Char>()
    for (i in input.indices) {
        val currentChar = input[i]
        if (currentChar in seenChars) {
            continue
        }
        seenChars.add(currentChar)
        for (j in i + 1 until input.length) {
            if (currentChar == input[j]) {
                break
            }
            if (j == input.length - 1) {
                return i
            }
        }
        if (i == input.length - 1) {
            return i
        }
    }
    return -1
}

fun findRandomAddedLetter(s: String, t: String): Char {
    return if (s.length < t.length) {
        t.first { it !in s }
    } else {
        ' '
    }
}

fun IntArray.getIntersection(other: IntArray): IntArray {
    return filter { it in other }.toSet().toIntArray()
}

fun getUncommonWords(sentence1: String, sentence2: String): List<String> {
    val uniqueWords = mutableSetOf<String>()

    val words1 = sentence1.split(" ")
    val words2 = sentence2.split(" ").toSet()

    uniqueWords.addAll(words1)

    words2.forEach {
        if (it in uniqueWords) {
            uniqueWords.remove(it)
        } else {
            uniqueWords.add(it)
        }
    }

    return uniqueWords.toList().sorted()
}

fun <T : Comparable<T>> mergeLinkedLists(l1: LinkedList<T?>, l2: LinkedList<T?>): List<T?> {
    val resultantSortedList = LinkedList<T?>()

    var l1Index = 0
    var l2Index = 0

    while (l1Index < l1.size || l2Index < l2.size) {
        if (l1Index == l1.size) {
            resultantSortedList += l2[l2Index]
            l2Index++
        } else if (l2Index == l2.size) {
            resultantSortedList += l1[l1Index]
            l1Index++
        } else {
            val nextFromL1 = l1[l1Index]
            val nextFromL2 = l2[l2Index]

            val nextSmallestElement = if (nextFromL1 != null && nextFromL2 != null) {
                if (nextFromL1 <= nextFromL2) {
                    l1Index++
                    nextFromL1
                } else {
                    l2Index++
                    nextFromL2
                }
            } else {
                if (nextFromL1 == null) {
                    l2Index++
                    nextFromL2
                } else {
                    l1Index++
                    nextFromL1
                }
            }

            resultantSortedList += nextSmallestElement
        }
    }

    return resultantSortedList
}