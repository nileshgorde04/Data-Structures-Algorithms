/*
1007. Minimum Domino Rotations For Equal Row
Solved
Medium
Topics
Companies
In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.

Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.

If it cannot be done, return -1.

 

Example 1:


Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
Example 2:

Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
 

Constraints:

2 <= tops.length <= 2 * 104
bottoms.length == tops.length
1 <= tops[i], bottoms[i] <= 6
*/

//Solution

// class Solution {
//     public int minDominoRotations(int[] tops, int[] bottoms) {
//         Set<Integer> top = new HashSet<>();
//         Set<Integer> bottom = new HashSet<>();
//         for(int num:tops) {
//             top.add(num);
//         }
//         for(int num:bottoms) {
//             bottom.add(num);
//         }
//         int min=Integer.MAX_VALUE;
//         if(top.size()<bottom.size()){
//             Map<Integer, Integer> map=new HashMap<>();
//             for(int a:tops){
//                 map.put(a,map.getOrDefault(a,0)+1);
//             }
//             int maxKey=-1;
//             int maxFreq=0;
//             for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
//                 if (entry.getValue() > maxFreq) {
//                     maxFreq = entry.getValue();
//                     maxKey = entry.getKey();
//                 }
//             }
//             int cnt=0;
//             for(int i=0;i<tops.length;i++){
//                 if(tops[i]!=maxKey){
//                     int temp=tops[i];
//                     tops[i]=bottoms[i];
//                     bottoms[i]=temp;
//                     cnt++;
//                 }
//             }
//             for(int i=1;i<tops.length;i++){
//                 if(tops[i]!=tops[i-1]) min=-1;
//             }
//             min=Integer.min(min,cnt);
//         }
//         else{
//             Map<Integer, Integer> map=new HashMap<>();
//             for(int a:bottoms){
//                 map.put(a,map.getOrDefault(a,0)+1);
//             }
//             int maxKey = -1;
//             int maxFreq = 0;
//             for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                 if (entry.getValue() > maxFreq) {
//                     maxFreq = entry.getValue();
//                     maxKey = entry.getKey();
//                 }
//             }
//             int cnt=0;
//             for(int i=0;i<bottoms.length;i++){
//                 if(bottoms[i]!=maxKey){
//                     int temp=bottoms[i];
//                     bottoms[i]=tops[i];
//                     tops[i]=temp;
//                     cnt++;
//                 }
//             }
//             for(int i=1;i<bottoms.length;i++){
//                 if(bottoms[i]!=bottoms[i-1]) min=-1;
//             }
//             min=Integer.min(min,cnt);
//         }
//         return min;
//     }
// }

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int candidate1 = tops[0];
        int candidate2 = bottoms[0];
        
        int rotations = check(tops, bottoms, candidate1);
        if (rotations != -1) return rotations;
        
        return check(tops, bottoms, candidate2);
    }

    private int check(int[] tops, int[] bottoms, int target) {
        int rotationsTop = 0;
        int rotationsBottom = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1; 
            } else if (tops[i] != target) {
                rotationsTop++;
            } else if (bottoms[i] != target) {
                rotationsBottom++;
            }
        }
        return Math.min(rotationsTop, rotationsBottom);
    }
}

