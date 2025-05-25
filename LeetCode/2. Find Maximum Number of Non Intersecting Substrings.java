/*
2. Find Maximum Number of Non Intersecting Substrings
Solved
Medium
4 pt.
You are given a string word.

Return the maximum number of non-intersecting substrings of word that are at least four characters long and start and end with the same letter.

A substring is a contiguous non-empty sequence of characters within a string.

 

Example 1:

Input: word = "abcdeafdef"

Output: 2

Explanation:

The two substrings are "abcdea" and "fdef".

Example 2:

Input: word = "bcdaaaab"

Output: 1

Explanation:

The only substring is "aaaa". Note that we cannot also choose "bcdaaaab" since it intersects with the other substring.

 

Constraints:

1 <= word.length <= 2 * 105
word consists only of lowercase English letters.
*/

//Solution

import java.util.*;
class Solution{
    public int maxSubstrings(String a){
        int n=a.length();
        List<int[]> v=new ArrayList<>();
        List<List<Integer>> pos=new ArrayList<>();
        for(int i=0;i<26;i++) pos.add(new ArrayList<>());
        for(int i=0;i<n;i++) pos.get(a.charAt(i)-'a').add(i);
        for(int c=0;c<26;c++){
            List<Integer> p=pos.get(c);
            int m=p.size();
            int j=0;
            for(int i=0;i<m;i++){
                while(j<m && p.get(j)-p.get(i)+1<4) j++;
                if(j<m) v.add(new int[]{p.get(i), p.get(j)});
            }
        }
        v.sort(Comparator.comparingInt(x->x[1]));
        int count=0, lastEnd=-1;
        for(int[] x:v){
            if(x[0]>lastEnd){
                count++;
                lastEnd=x[1];
            }
        }
        return count;
    }
}
