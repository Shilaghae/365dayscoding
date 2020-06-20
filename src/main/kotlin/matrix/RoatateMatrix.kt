package matrix

import kotlin.math.ceil

/***********************
 * Rotate in place clockwise
 ***********************/

class RoatateMatrix {

    fun solution(matrix: List<List<Long>>): List<List<Long>> {

        val n = matrix.size - 1

        val mm = mutableListOf<MutableList<Long>>()
        (0..n).forEach {
            mm.add(it, matrix[it].toMutableList())
        }

        (0 .. ceil((n / 2).toDouble()).toInt()).forEach {
            swap(mm, it, n - it)
        }

        // Print Matrix
        mm.forEachIndexed { i, it ->
            println()
            it.forEachIndexed { j, it2 ->
                print("${mm[i][j]} ")
            }
        }
        return mm
    }

    private fun swap(matrix: MutableList<MutableList<Long>>, i: Int, n: Int) {

        (i until n).forEach {
            val temp = matrix[it][i]

            matrix[it][i] = matrix[n][it]

            matrix[n][it] = matrix[n - it][n]

            matrix[n - it][n] = matrix[i][n - it]

            matrix[i][n - it] = temp
        }
    }
}

fun main() {
    val s = RoatateMatrix()
    val a = arrayListOf<List<Long>>()
    val a1 = arrayListOf(1L, 2L, 3L, 4L)
    val a2 = arrayListOf(5L, 6L, 7L, 8L)
    val a3 = arrayListOf(9L, 10L, 11L, 12L)
    val a4 = arrayListOf(13L, 14L, 15L, 16L)
    a.add(a1)
    a.add(a2)
    a.add(a3)
    a.add(a4)
    s.solution(a)
}