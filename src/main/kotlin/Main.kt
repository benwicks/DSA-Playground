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