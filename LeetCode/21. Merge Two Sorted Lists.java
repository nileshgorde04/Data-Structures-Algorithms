*/
21. Merge Two Sorted Lists
Solved
Easy
Topics
Companies
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList=new ListNode(0);
        ListNode head=newList;
        ListNode temp=list1;
        ListNode temp2=list2;
        while(temp!=null && temp2!=null){
            if(temp.val<=temp2.val) {
                newList.next=temp;
                temp=temp.next;
                newList=newList.next;
            }
            else {
                newList.next=temp2;
                temp2=temp2.next;
                newList=newList.next;
            }
        }
        while(temp!=null){
            newList.next=temp;
            temp=temp.next;
            newList=newList.next;
        }
        while(temp2!=null) {
            newList.next=temp2;
            temp2=temp2.next;
            newList=newList.next;
        }
        return head.next;
    }
}
