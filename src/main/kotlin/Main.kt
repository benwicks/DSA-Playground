import java.util.*

fun main(args: Array<String>) {
//    println("Hello World!")
    // Try adding program arguments at Run/Debug configuration
//    println("Program arguments: ${args.joinToString()}")
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