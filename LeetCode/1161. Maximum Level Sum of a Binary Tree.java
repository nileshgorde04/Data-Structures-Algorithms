/*
1161. Maximum Level Sum of a Binary Tree
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

 

Example 1:


Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
Example 2:

Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
*/

//Solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cnt = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            cnt++;
            for(int i=0;i<size;i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            map.put(cnt, sum);
            sum = 0;
        }
        int maxValue = Integer.MIN_VALUE;
        int maxKey = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != null && entry.getValue() > maxValue) {
            maxValue = entry.getValue();
            maxKey = entry.getKey();
            }
        }

    return maxKey;
    }
}