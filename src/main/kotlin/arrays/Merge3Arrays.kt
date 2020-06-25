package arrays

import java.lang.Math.*

class Merge3Arrays {

    fun arraysIntersection(arr1: IntArray, arr2: IntArray, arr3: IntArray): IntArray {

        var i = 0
        var j = 0
        var k = 0

        var thisResult = mutableListOf<Int>()
        while (i<=arr1.lastIndex && j<=arr2.lastIndex && k<=arr3.lastIndex) {
            if(arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                i++
                j++
                k++
                thisResult.add(arr1[i])
            } else {
                val min = min(min(arr1[i], arr2[j]), arr3[k])
                if(arr1[i] == min) {
                    thisResult.add(arr1[i])
                    i++
                }
                if(arr2[j] == min) {
                    thisResult.add(arr2[j])
                    j++
                }
                if(arr2[k] == min) {
                    thisResult.add(arr3[k])
                    k++
                }
            }
        }

        if((i < arr1.lastIndex || j < arr2.lastIndex) && k > arr3.lastIndex) {

            while (i <= arr1.lastIndex && j <= arr2.lastIndex) {
                if(arr1[i] == arr2[j]) {
                    thisResult.add(arr1[i])
                    i++
                    j++
                } else if(arr1[i] < arr2[j]) {
                    thisResult.add(arr1[i])
                    i++
                } else {
                    thisResult.add(arr2[j])
                    j++
                }
            }
            while (j <= arr2.lastIndex) {
                thisResult.add(arr2[j])
                j++
            }
            while (i <= arr1.lastIndex) {
                thisResult.add(arr1[i])
                i++
            }
        }

        if((i > arr1.lastIndex && (j < arr2.lastIndex) || k < arr3.lastIndex)) {

            while (j <= arr2.lastIndex && k <= arr3.lastIndex) {
                if(arr2[j] == arr3[k]) {
                    thisResult.add(arr2[j])
                    j++
                    k++
                } else if(arr2[j] < arr3[k]) {
                    thisResult.add(arr2[j])
                    j++
                } else {
                    thisResult.add(arr3[k])
                    k++
                }
            }
            while (j <= arr2.lastIndex) {
                thisResult.add(arr2[j])
                j++
            }
            while (k <= arr3.lastIndex) {
                thisResult.add(arr3[k])
                k++
            }
        }
        return thisResult.toIntArray()
    }
}