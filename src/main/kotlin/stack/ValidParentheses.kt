/***************************************************************************************************
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
***************************************************************************************************/
package stack

import java.util.*

class ValidParentheses {
    private val map = hashMapOf( '(' to ')','{' to '}','[' to ']')

    fun isValid(s: String): Boolean {
        val parentheses = Stack<Char>()

        s.forEach { it ->
            if(map.contains(it)) parentheses.push(it)
            else {
                if(parentheses.isEmpty()) return false

                val last = parentheses.pop()
                if(map[last] != it) return false
            }
        }
        return parentheses.isEmpty()
    }
}