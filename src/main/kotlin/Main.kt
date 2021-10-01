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