/*
20. Valid Parentheses
Solved
Easy
Topics
Companies
Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

//Solution

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        if(s.length()<=1) return false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='[' || s.charAt(i)=='(' || s.charAt(i)=='{')
            stack.push(s.charAt(i));
            if(s.charAt(i)==']'){
                if(stack.isEmpty()) return false;
                char temp=stack.pop();
                if(temp!='[') return false;
            }
            if(s.charAt(i)==')'){
                if(stack.isEmpty()) return false;
                char temp=stack.pop();
                if(temp!='(') return false;
            }
            if(s.charAt(i)=='}'){
                if(stack.isEmpty()) return false;
                char temp=stack.pop();
                if(temp!='{') return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
