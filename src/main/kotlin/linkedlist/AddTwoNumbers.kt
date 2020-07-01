package linkedlist
/**************************************************************************************************
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

Algorithm

Just like how you would sum two numbers on a piece of paper, we begin by summing the least-significant digits, which is the head of l1l1 and l2l2. Since each digit is in the range of 0 \ldots 90…9, summing two digits may "overflow". For example 5 + 7 = 125+7=12. In this case, we set the current digit to 22 and bring over the carry = 1carry=1 to the next iteration. carrycarry must be either 00 or 11 because the largest possible sum of two digits (including the carry) is 9 + 9 + 1 = 199+9+1=19.

The pseudocode is as following:

- Initialize current node to dummy head of the returning list.
- Initialize carry to 00.
- Initialize pp and qq to head of l1l1 and l2l2 respectively.
- Loop through lists l1l1 and l2l2 until you reach both ends.
- Set xx to node pp's value. If pp has reached the end of l1l1, set to 00.
- Set yy to node qq's value. If qq has reached the end of l2l2, set to 00.
- Set sum = x + y + carrysum=x+y+carry.
- Update carry = sum / 10carry=sum/10.
Create a new node with the digit value of (sum \bmod 10)(summod10) and set it to current node's next, then advance current node to next.
Advance both pp and qq.
Check if carry = 1 carry=1, if so append a new node with digit 11 to the returning list.
Return dummy head's next node.
 **************************************************************************************************/

 class ListNode(var `val`: Int) {
    var next: ListNode? = null
 }

class Solution {

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
            thisPointer = node
        }

        return thisResult?.`next`
    }
}