import java.util.*

fun main(@Suppress("UNUSED_PARAMETER") args: Array<String>) {
    println(reverseString("The Daily Byte"))
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
            areAllFollowingCharsLowerCase || input.substring(1 until input.length).all { it.isUpperCase()}
}