package general;
/*
Given a non-negative integer num represented as a string, remove k digits from the number
so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */


public class RemoveKDigits_402 {

    public String removeKdigits(String num, int k) {
        if (k==num.length()) return "0";

        char[] cs = num.toCharArray();      // find and remove first k elements that are greater than right neighbor
        char[] res = new char[cs.length];
        int p = 0, len = cs.length-k;

        for (char c : cs) {
            while (k > 0 && p > 0 && c < res[p - 1]) {
                --p;
                --k;
            }
            res[p++] = c;
        }

        p=0;
        while (p<len && res[p]=='0') ++p;

        return p==len? "0": new String(res, p, len-p);
    }
}
