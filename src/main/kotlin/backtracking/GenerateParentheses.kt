/************************************************************
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"]
 *
 ***********************************************************/

package backtracking

class GenerateParentheses {

    fun generateParenthesis(n: Int): List<String> {
        val theAnswer = mutableListOf<String>()
        generate(theAnswer, "", 0, 0, n)
        return theAnswer
    }

    private fun generate(theAnswer: MutableList<String>, combine: String, opened: Int, closed: Int, max: Int) {
        if(combine.length == max * 2) {
            theAnswer.add(combine)
            return
        }

        if(opened < max) {
            generate(theAnswer, "$combine(", opened + 1, closed, max)
        }
        if(closed < opened) {
            generate(theAnswer, "$combine)", opened, closed + 1, max)
        }
    }
}
