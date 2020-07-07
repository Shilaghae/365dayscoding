package backtracking

/*******************
 *  Combination Sum II

    Add to List

    Share
    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

    Each number in candidates may only be used once in the combination.

    Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
    Example 1:

    Input: candidates = [10,1,2,7,6,1,5], target = 8,
    A solution set is:
    [
        [1, 7],
        [1, 2, 5],
        [2, 6],
        [1, 1, 6]
    ]
    Example 2:

    Input: candidates = [2,5,2,1,2], target = 5,
    A solution set is:
    [
        [1,2,2],
        [5]
    ]
 ******************/


class CombineSumII {

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val thisResult = mutableSetOf<List<Int>>()
        candidates.sort()
        iterateSum(candidates, target, 0, thisResult, mutableListOf())
        return thisResult.toList()
    }


    private fun iterateSum(
        candidates: IntArray,
        target: Int,
        i: Int,
        thisResult: MutableSet<List<Int>>,
        thisPath: MutableList<Int>
    ) {

        if (target == 0) {
            thisResult.add(thisPath.toMutableList())
            return
        }
        if (target < 0) return

        for (j in i..candidates.lastIndex) {
            thisPath.add(candidates[j])
            iterateSum(candidates, target - candidates[j], j + 1, thisResult, thisPath)
            thisPath.remove(candidates[j])
        }
    }
}