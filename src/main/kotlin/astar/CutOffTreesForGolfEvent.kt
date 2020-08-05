package astar

import java.util.*
import kotlin.Comparator
import kotlin.math.abs

class CutOffTreesForGolfEvent {

    private val closed = mutableListOf<Pair<Int, Int>>()

    private val open = TreeMap<Pair<Int, Int>, Int>()

    private val start = Pair(0, 0)

    private lateinit var target: Pair<Int, Int>


    fun cutOffTree(forest: List<List<Int>>): Int {

        forest.mapIndexed { i, it1 ->
            it1.mapIndexed { j, it2 ->
                if (it2 == forest.flatten().max())
                    target = Pair(i, j)
            }
        }

        open[start] = forest[0][0] + manhattanDistance(start)

        while (open.isNotEmpty()) {
            var min = open.minBy { it.value }!!
            closed.add(min.key)
            open.remove(min.key)

        }
    }

    private fun manhattanDistance(start: Pair<Int, Int>): Int {
        return abs(n = start.first - target.first) + abs(start.second - target.second)
    }
    
}