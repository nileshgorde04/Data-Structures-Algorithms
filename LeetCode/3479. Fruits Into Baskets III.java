/*
3479. Fruits Into Baskets III
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given two arrays of integers, fruits and baskets, each of length n, where fruits[i] represents the quantity of the ith type of fruit, and baskets[j] represents the capacity of the jth basket.

From left to right, place the fruits according to these rules:

Each fruit type must be placed in the leftmost available basket with a capacity greater than or equal to the quantity of that fruit type.
Each basket can hold only one type of fruit.
If a fruit type cannot be placed in any basket, it remains unplaced.
Return the number of fruit types that remain unplaced after all possible allocations are made.

 

Example 1:

Input: fruits = [4,2,5], baskets = [3,5,4]

Output: 1

Explanation:

fruits[0] = 4 is placed in baskets[1] = 5.
fruits[1] = 2 is placed in baskets[0] = 3.
fruits[2] = 5 cannot be placed in baskets[2] = 4.
Since one fruit type remains unplaced, we return 1.

Example 2:

Input: fruits = [3,6,1], baskets = [6,4,7]

Output: 0

Explanation:

fruits[0] = 3 is placed in baskets[0] = 6.
fruits[1] = 6 cannot be placed in baskets[1] = 4 (insufficient capacity) but can be placed in the next available basket, baskets[2] = 7.
fruits[2] = 1 is placed in baskets[1] = 4.
Since all fruits are successfully placed, we return 0.

 

Constraints:

n == fruits.length == baskets.length
1 <= n <= 105
*/

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        List<Integer> sect_mx = new ArrayList<>();
        int m = baskets.length;
        int a = (int) Math.sqrt(m); // size of one array

        int cnt = 0, mx = 0;
        for (int i = 0; i < m; i++) {
            if (cnt == a) {
                // creating sector of size a
                sect_mx.add(mx);
                mx = baskets[i];
                cnt = 1;
            } else {
                cnt++;
                mx = Math.max(mx, baskets[i]);
            }
        }

        // last sector
        sect_mx.add(mx);

        int remain = 0;

        // start allocating
        for (int i = 0; i < fruits.length; i++) {
            int k = 0, set = 1;

            for (int j = 0; j < m; j += a) {
                if (sect_mx.get(k) < fruits[i]) {
                    // skip this segment
                    k++;
                    continue;
                }

                // find place to allocate
                for (int r = j; r < Math.min(j + a, m); r++) {
                    if (baskets[r] >= fruits[i]) {
                        set = 0;
                        baskets[r] = 0;
                        break;
                    }
                }

                // if fruit is allocated in a sector
                if (set == 0) {
                    sect_mx.set(k, 0); // find new mx
                    // update new sector mx
                    for (int r = j; r < Math.min(j + a, m); r++) {
                        sect_mx.set(k, Math.max(baskets[r], sect_mx.get(k)));
                    }
                    break;
                }
            }

            remain += set;
        }

        return remain;
    }
}
1 <= fruits[i], baskets[i] <= 109
