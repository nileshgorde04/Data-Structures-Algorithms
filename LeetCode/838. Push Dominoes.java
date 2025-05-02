/*
838. Push Dominoes
Solved
Medium
Topics
Companies
There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.

After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

You are given a string dominoes representing the initial state where:

dominoes[i] = 'L', if the ith domino has been pushed to the left,
dominoes[i] = 'R', if the ith domino has been pushed to the right, and
dominoes[i] = '.', if the ith domino has not been pushed.
Return a string representing the final state.

 

Example 1:

Input: dominoes = "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.
Example 2:


Input: dominoes = ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."
 

Constraints:

n == dominoes.length
1 <= n <= 105
dominoes[i] is either 'L', 'R', or '.'.
*/

//Solution 

class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = dominoes.toCharArray();
        char[] result = new char[n];
        
        int i = 0;
        while (i < n) {
            if (arr[i] == 'L') {
                result[i] = 'L';
                i++;
            } else if (arr[i] == 'R') {
                int j = i + 1;
                while (j < n && arr[j] == '.') {
                    j++;
                }
                if (j < n && arr[j] == 'L') {
                    int left = i;
                    int right = j;
                    while (left < right) {
                        result[left++] = 'R';
                        result[right--] = 'L';
                    }
                    if (left == right) result[left] = '.';
                } else {
                    for (int k = i; k < j; k++) result[k] = 'R';
                }
                i = j;
            } else {
                int j = i;
                while (j < n && arr[j] == '.') j++;
                if (j < n && arr[j] == 'L') {
                    for (int k = i; k < j; k++) result[k] = 'L';
                    result[j] = 'L';
                } else {
                    for (int k = i; k < j; k++) result[k] = '.';
                }
                i = j;
            }
        }

        for (int k = 0; k < n; k++) {
            if (result[k] == 0) result[k] = arr[k];
        }

        return new String(result);
    }
}

