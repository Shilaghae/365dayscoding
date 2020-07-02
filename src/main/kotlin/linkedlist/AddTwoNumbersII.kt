package linkedlist

/**************************************************************************************************
You are given two non-empty linked lists representing two non-negative integers.
The most significant digit comes first and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

 **************************************************************************************************/

class AddTwoNumbersII {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var pointerList1 = l1
        var pointerList2 = l2
        var thisResult: ListNode? = ListNode(0)
        var thisPointer = thisResult

        var carry: Int = 0
        while(pointerList1 != null || pointerList2 != null) {
            val t1 = pointerList1?.`val` ?: 0
            val t2 = pointerList2?.`val` ?: 0
            var temp = t1 + t2 + carry
            carry = temp / 10
            if(temp >= 10) temp = temp % 10

            val node = ListNode(temp)
            thisPointer?.`next` = node
            thisPointer = node

            pointerList1 = pointerList1?.`next`
            pointerList2 = pointerList2?.`next`
        }

        if(carry >= 1) {
            val node = ListNode(carry)
            thisPointer?.`next` = node
        }

        return thisResult?.`next`
    }
}