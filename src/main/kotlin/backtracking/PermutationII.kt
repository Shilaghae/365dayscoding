/************************************************************
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
************************************************************/

package backtracking

class PermutationII {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val thisResult = mutableListOf<List<Int>>()
        permute(nums, thisResult, 0, nums.lastIndex, mutableListOf<List<Int>>())
        return thisResult
    }


    private fun permute(nums: IntArray, thisResult: MutableList<List<Int>>, i: Int, j: Int, inQueueToBeVisited: MutableList<List<Int>>) {
        if(inQueueToBeVisited.contains(nums.toList())) return

        if(i == j) {
            thisResult.add(nums.toList())
            inQueueToBeVisited.add(nums.toList())
        }
        (i..j).forEach { it ->
            swap(i, it, nums)
            permute(nums, thisResult, i+1, j, inQueueToBeVisited)
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

