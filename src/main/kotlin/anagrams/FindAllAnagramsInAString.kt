/***************************************************************************************************************
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 ***************************************************************************************************************/

package anagrams

class FindAllAnagramsInAString {

    private val map = mutableMapOf<Char, Int>()

    fun findAnagrams(s: String, p: String): List<Int> {

        var i = 0
        var j = p.lastIndex
        if (s.lastIndex < j) return emptyList()
        val thisResult = mutableListOf<Int>()
        while (i <= s.lastIndex - p.lastIndex) {
            if (isAnagram(s, p, i, j)) {
                thisResult.add(i)
                map.clear()
                i++
                j++
            } else {
                p.forEach { map.remove(it) }
                map.values.min()?.let {
                    i = it + 1
                    j = i + p.lastIndex
                } ?: run {
                    i++
                    j++
                }
                map.clear()
            }
        }
        return thisResult
    }

    private fun isAnagram(s: String, p: String, i: Int, j: Int): Boolean {

        val arr = IntArray(26)

        (i..j).forEach {
            map[s[it]] = it
            arr[s[it] - 'a']++
        }

        p.forEach {
            arr[it - 'a']--
        }

        return arr.filter { it != 0 }.count() == 0
    }
}

