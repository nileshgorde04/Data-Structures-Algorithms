/*
43. Multiply Strings
Solved
Medium

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
 

Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
*/

//Solution 

class Solution {
    public String multiply(String num1, String num2) {
        //Approach 1
        // // return String.valueOf((Integer.parseInt(num1)*Integer.parseInt(num2)));

        //Approach 2
        // long first=0;
        // long second=0;
        // for(char c:num1.toCharArray()){
        //     first=first*10+(c-'0');
        // }
        // for(char c:num2.toCharArray()){
        //     second=second*10+(c-'0');
        // }
        // return String.valueOf(first*second);

        //Approach 3
        if (num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                int product = digit1 * digit2;
                int sum = product + result[i + j + 1];

                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        return sb.toString();
    }
}

