/**********************************************************************
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
**********************************************************************/

package backtracking

class LetterCombinationOfAPhoneNumber {
    private val mapToLetters = hashMapOf<Char, String> (
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()) return emptyList()
        val thisResult = mutableListOf<String>()
        combination(digits, thisResult, "", digits.length, 0)
        return thisResult
    }

    private fun combination(digits: String, thisResult: MutableList<String>, combined: String, n: Int, currentDigitIndex: Int) {

        if(combined.length == n) {
            thisResult.add(combined)
            return
        }

        if(currentDigitIndex < n) {
            mapToLetters[digits[currentDigitIndex]]!!.forEach {
                combination(digits, thisResult, combined + it, n, currentDigitIndex + 1)
            }
        }
    }
}

