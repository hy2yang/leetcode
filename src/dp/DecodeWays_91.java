package dp;

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:
Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

 */

public class DecodeWays_91 {

    public int numDecodings(String s) {
        if (s.length()==0 || s.startsWith("0") || s.contains("00")) return 0;
        if (s.length()==1) return 1;
        char[] temp=s.toCharArray();
        int len=temp.length;
        int[] dp= new int[len+1];
        dp[0]= 1;
        dp[1]= 1;
        for (int i=2;i<=len;i++) {
            if (temp[i-1]!='0') dp[i] += dp[i-1];
            int last2= (int)temp[i-2]-'0';
            if (last2==1 || last2==2){
                last2 = 10*last2 + temp[i-1]-'0';
                if (last2<=26) dp[i]+=dp[i-2];
            }
        }
        return dp[len];
    }

}
