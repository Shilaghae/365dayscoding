package easy

/***
 *
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 * Example:
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 */
class MostCommonWord {

    fun mostCommonWord(paragraph: String, banned: Array<String>): String {

        val words = paragraph.split(Regex("[\\s@&.?$+-,]+"))
        val map: MutableMap<String, Int> = mutableMapOf()
        var max = Int.MIN_VALUE
        var thisResult = ""

        val t = words.map{ it-> Regex("[^A-Za-z0-9]").replace(it, "").toLowerCase() }
            .filter { !banned.contains(it) }
            .forEach{ k ->
                map.put(k, (map.get(k) ?: 0) + 1)
                map.get(k)?.let {
                    if(it > max) {
                        max = it
                        thisResult = k
                    }
                }
            }

        return thisResult
    }
}