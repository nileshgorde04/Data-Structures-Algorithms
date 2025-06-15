//Problem Number : 1432. Max Difference You Can Get From Changing an Integer
//Link to Problem : https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/?envType=daily-question&envId=2025-06-15
/*
You are given an integer num. You will apply the following steps to num two separate times:

Pick a digit x (0 <= x <= 9).
Pick another digit y (0 <= y <= 9). Note y can be equal to x.
Replace all the occurrences of x in the decimal representation of num by y.
Let a and b be the two results from applying the operation to num independently.

Return the max difference between a and b.

Note that neither a nor b may have any leading zeros, and must not be 0.

 

Example 1:

Input: num = 555
Output: 888
Explanation: The first time pick x = 5 and y = 9 and store the new integer in a.
The second time pick x = 5 and y = 1 and store the new integer in b.
We have now a = 999 and b = 111 and max difference = 888
Example 2:

Input: num = 9
Output: 8
Explanation: The first time pick x = 9 and y = 9 and store the new integer in a.
The second time pick x = 9 and y = 1 and store the new integer in b.
We have now a = 9 and b = 1 and max difference = 8
 

Constraints:

1 <= num <= 108
 */

    class Solution{
    public int maxDiff(int num) {
        char[] a = Integer.toString(num).toCharArray(), b = a.clone();
        char x = a[0], y = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == x) {
                a[i] = '9';
                b[i] = '1';
            }else if (x == '1' && a[i] > '0' || x == '9' && a[i] < '9') {
                if (y == 0) {
                    y = a[i];
                } 
                if (y == a[i]) {
                    if (x == '1')
                        b[i] = '0';
                    else
                        a[i] = '9';
                }
            }
        }
        return Integer.parseInt(String.valueOf(a)) - Integer.parseInt(String.valueOf(b));
    }
    }
