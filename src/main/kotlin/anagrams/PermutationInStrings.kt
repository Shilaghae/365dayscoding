package anagrams

class PermutationInStrings {
    fun checkInclusion(s1: String, s2: String): Boolean {
        var i = s1.lastIndex
        var j = s2.lastIndex
        var s = 0
        if(j < i) return false
        while(s + i <= j) {
            if(containsAPermutation(s2.substring(s, s + i + 1), s1)) return true
            s++
        }
        return false
    }

    private fun containsAPermutation(s1: String, s2: String) : Boolean {

        var alphabeth = IntArray(26)

        s1.forEach {
            alphabeth[it - 'a']++
        }

        s2.forEach {
            alphabeth[it - 'a']--
        }

        return alphabeth.filter{ it != 0 }.count() == 0
    }
}