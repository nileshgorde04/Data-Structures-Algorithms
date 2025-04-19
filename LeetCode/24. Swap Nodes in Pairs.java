/*
24. Swap Nodes in Pairs
Solved
Medium

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:

Input: head = [1,2,3,4]

Output: [2,1,4,3]

Explanation:



Example 2:

Input: head = []

Output: []

Example 3:

Input: head = [1]

Output: [1]

Example 4:

Input: head = [1,2,3]

Output: [2,1,3]

 

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
*/
//Solution 

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
    public ListNode swapPairs(ListNode head) {
        ListNode temp=head;
        while(temp!=null && temp.next!=null){
                int swap=temp.val;
                temp.val=temp.next.val;
                temp.next.val=swap;

            temp=temp.next.next;
        }
        return head;
    }
}
// public class Solution {
//     public ListNode swapPairs(ListNode head) {
//         if ((head == null)||(head.next == null))
//             return head;
//         ListNode n = head.next;
//         head.next = swapPairs(head.next.next);
//         n.next = head;
//         return n;
//     }
// }