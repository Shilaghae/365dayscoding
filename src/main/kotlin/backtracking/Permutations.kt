
/*************************************************************************************
 * Given a collection of distinct integers, return all possible permutations.
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
*************************************************************************************/
package backtracking

class Permutations {

    fun permute(nums: IntArray): List<List<Int>> {
        var thisResult = mutableListOf<List<Int>>()
        permute(nums, thisResult, 0, nums.lastIndex)
        return thisResult
    }

    private fun permute(nums: IntArray, thisResult: MutableList<List<Int>>, i: Int, j: Int) {
        if(i == j) {
            thisResult.add(nums.toList())
            return
        }

        (i..j).forEach {
            swap(i, it, nums)
            permute(nums, thisResult, i + 1, j)
            swap(it, i, nums)
        }
    }

    private fun swap(i: Int, j: Int, nums: IntArray) : IntArray {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
        return nums
    }
}