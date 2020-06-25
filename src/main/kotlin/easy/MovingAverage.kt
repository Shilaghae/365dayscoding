package easy

/***********************
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * Example:
 *
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
***********************/

class MovingAverage(val size: Int) {

    /** Initialize your data structure here. */

    private var index = 0
    private var max = 1
    private var arr = IntArray(size)
    private var sum = 0.0

    fun next(`val`: Int): Double {
        if (max < size)
            sum = 1.0 * (sum + `val`)
        else
            sum = 1.0 * (sum + `val` - arr[index % size])
        arr[index % size] = `val`
        val r = sum / max
        if(max < size) max++
        index ++
        return r
    }
}