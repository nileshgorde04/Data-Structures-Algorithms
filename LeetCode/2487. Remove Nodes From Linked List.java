/*
2487. Remove Nodes From Linked List
Solved
Medium
Topics
Companies
Hint
You are given the head of a linked list.

Remove every node which has a node with a greater value anywhere to the right side of it.

Return the head of the modified linked list.

 

Example 1:


Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.
Example 2:

Input: head = [1,1,1,1]
Output: [1,1,1,1]
Explanation: Every node has value 1, so no nodes are removed.
 

Constraints:

The number of the nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105
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
    public ListNode reverseLinkedList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while( temp!= null){
            ListNode nextTemp = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextTemp;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack =  new Stack<>();
        int max = Integer.MIN_VALUE;
        head = reverseLinkedList(head);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val >= max) {
                max = curr.val;
                tail.next = curr;
                tail = curr;
            }
            curr = curr.next;
        }
        tail.next = null;
        return reverseLinkedList(dummy.next);
    }
}
