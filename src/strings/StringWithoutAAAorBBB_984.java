package strings;
/*
Given two integers A and B, return any string S such that:

S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
The substring 'aaa' does not occur in S;
The substring 'bbb' does not occur in S.
 

Example 1:

Input: A = 1, B = 2
Output: "abb"
Explanation: "abb", "bab" and "bba" are all correct answers.
Example 2:

Input: A = 4, B = 1
Output: "aabaa"
 

Note:

0 <= A <= 100
0 <= B <= 100
It is guaranteed such an S exists for the given A and B.
*/

class StringWithoutAAAorBBB_984 {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        
        char max = A>B? 'a':'b';
        char min = A>B? 'b':'a';
        
        while (A>0 && B>0){
            sb.append(max).append(min);
            --A;
            --B;
        }
        
        int sur = A==0? B:A;
        
        int pos = 0;
        while (sur>0){
            if (pos>=sb.length()) sb.append(max);
            else sb.insert(pos, max);
            pos+=3;
            --sur;
        }
        
        return sb.toString();
    }
}