/*
2561. Rearranging Fruits
Solved
Hard
Topics
premium lock icon
Companies
Hint
You have two fruit baskets containing n fruits each. You are given two 0-indexed integer arrays basket1 and basket2 representing the cost of fruit in each basket. You want to make both baskets equal. To do so, you can use the following operation as many times as you want:

Chose two indices i and j, and swap the ith fruit of basket1 with the jth fruit of basket2.
The cost of the swap is min(basket1[i],basket2[j]).
Two baskets are considered equal if sorting them according to the fruit cost makes them exactly the same baskets.

Return the minimum cost to make both the baskets equal or -1 if impossible.

 

Example 1:

Input: basket1 = [4,2,2,2], basket2 = [1,4,1,2]
Output: 1
Explanation: Swap index 1 of basket1 with index 0 of basket2, which has cost 1. Now basket1 = [4,1,2,2] and basket2 = [2,4,1,2]. Rearranging both the arrays makes them equal.
Example 2:

Input: basket1 = [2,3,4,1], basket2 = [3,2,5,1]
Output: -1
Explanation: It can be shown that it is impossible to make both the baskets equal.
 

Constraints:

basket1.length == basket2.length
1 <= basket1.length <= 105
1 <= basket1[i],basket2[i] <= 109
*/

//Solution

import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int b : basket1) freq.put(b, freq.getOrDefault(b, 0) + 1);
        for (int b : basket2) freq.put(b, freq.getOrDefault(b, 0) + 1);

        for (int count : freq.values()) {
            if (count % 2 != 0) return -1;
        }

        Map<Integer, Integer> count1 = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();

        for (int b : basket1) count1.put(b, count1.getOrDefault(b, 0) + 1);
        for (int b : basket2) count2.put(b, count2.getOrDefault(b, 0) + 1);

        List<Integer> extras = new ArrayList<>();

        for (int fruit : freq.keySet()) {
            int ideal = freq.get(fruit) / 2;
            int extraIn1 = count1.getOrDefault(fruit, 0) - ideal;
            if (extraIn1 > 0) {
                for (int i = 0; i < extraIn1; i++) {
                    extras.add(fruit);
                }
            }
        }

        for (int fruit : freq.keySet()) {
            int ideal = freq.get(fruit) / 2;
            int extraIn2 = count2.getOrDefault(fruit, 0) - ideal;
            if (extraIn2 > 0) {
                for (int i = 0; i < extraIn2; i++) {
                    extras.add(fruit);
                }
            }
        }

        Collections.sort(extras);
        long minFruit = Collections.min(freq.keySet());
        long cost = 0;

        for (int i = 0; i < extras.size() / 2; i++) {
            cost += Math.min(extras.get(i), minFruit * 2);
        }

        return cost;
    }
}
