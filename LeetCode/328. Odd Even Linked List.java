/*
328. Odd Even Linked List
Solved
Medium
Topics
Companies
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 

Constraints:

The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode newList= new ListNode(0);
        ListNode newListHead = newList;
        ListNode newList2= new ListNode(0);
        ListNode newList2Head = newList2;
        ListNode temp=head;
        int count = 0;
        while(temp!=null) {
            count++;
            if(count%2!=0){
                newList.next = temp;
                newList = newList.next;
            }
            else {
                newList2.next = temp;
                newList2 = newList2.next;
            }
            temp = temp.next;
        }
        newList2.next=null;
        newList.next = newList2Head.next;
        return newListHead.next;
    }
}
