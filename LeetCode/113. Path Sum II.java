/*
113. Path Sum II
Solved
Medium
Topics
premium lock icon
Companies
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> currentPath = new ArrayList();
        List<List<Integer>> allPaths = new ArrayList();
        findPathsRecursive(root,targetSum,currentPath,allPaths);
        return allPaths;
    }
    private static void findPathsRecursive(TreeNode currentNode, int sum, List<Integer> currentPath,List<List<Integer>> allPaths){
         if(currentNode==null)return;
         // add the current node to the path
         currentPath.add(currentNode.val);
         // if the current node is a leaf and its value is equal to sum, save the current path
         if(currentNode.val==sum && currentNode.left==null && currentNode.right==null)
             allPaths.add(new ArrayList<Integer>(currentPath));
         else{
             // traverse the left sub-tree
             findPathsRecursive(currentNode.left,sum-currentNode.val,currentPath,allPaths);
             // traverse the right sub-tree
             findPathsRecursive(currentNode.right,sum-currentNode.val,currentPath,allPaths);
         }
         // remove the current node from the path to backtrack, 
         // we need to remove the current node while we are going up the recursive call stack.
         currentPath.remove(currentPath.size()-1);
      }

}