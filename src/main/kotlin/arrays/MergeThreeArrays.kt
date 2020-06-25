package arrays

class MergeThreeArrays {

    fun arraysIntersection(arr1: IntArray, arr2: IntArray, arr3: IntArray): IntArray {
        val thisResult = mergeTwo(arr1, arr2)
        return mergeTwo(arr3, thisResult)
    }

    private fun mergeTwo(arr1: IntArray, arr2: IntArray): IntArray {
        var i = 0
        var j = 0
        var thisResult = mutableListOf<Int>()
        while (i <= arr1.lastIndex && j <= arr2.lastIndex) {
            when {
                arr1[i] == arr2[j] -> {
                    i++
                    j++
                    thisResult.add(arr1[i])
                }
                arr1[i] < arr2[j] -> {
                    thisResult.add(arr1[i])
                    i++
                }
                else -> {
                    thisResult.add(arr1[j])
                    j++
                }
            }
        }
        while (j <= arr2.lastIndex) {
            thisResult.add(arr2[j])
            j++
        }
        while (i < arr1.lastIndex) {
            thisResult.add(arr1[i])
            i++
        }
        return thisResult.toIntArray()
    }
}