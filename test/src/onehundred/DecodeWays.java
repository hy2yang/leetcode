package onehundred;

public class DecodeWays {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(numDecodings("1101"));
    }
    
    public static int numDecodings(String s) {
        if (s.length()==0 || s.startsWith("0") || s.contains("00")) return 0;
        if (s.length()==1) return 1;
        char[] temp=s.toCharArray();
        int len=temp.length;
        int[] dp= new int[len+1];
        dp[0]= 1;
        dp[1]= temp[0]==48? 0:1;
        for (int i=2;i<=len;i++) {
            if (temp[i-1]!=48 ) dp[i] += dp[i-1];  
            int last2=(temp[i-2]-48)*10+temp[i-1]-48;
            if (last2<=26 && last2>=10) dp[i]+=dp[i-2];
        }
        return dp[len];
    }
 //  too many strange test cases and I deleted my original code
}
