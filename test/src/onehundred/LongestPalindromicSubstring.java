package onehundred;


public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
        System.out.println(7/2);
    }
    
    static public String longestPalindrome(String s) {
        if (s.length()<2) return s;
        char[] arr=s.toCharArray();
        int maxlength=0;
        int finalleft=0;
        int finalright=arr.length-1;
        for(int i=0;i<arr.length-1;){
            int step=1;
            while(i+step<=arr.length-1 && arr[i]==arr[i+step]){
                step++;
            }
            int lo=i;
            int hi=i+step-1;
            while (lo-1>=0 && hi+1<=arr.length-1 && arr[lo-1]==arr[hi+1]){
                lo--;
                hi++;
            }
            if (hi-lo+1>maxlength){
                maxlength=hi-lo+1;
                finalleft=lo;
                finalright=hi;
            }
            i+=step;
        }
        
        String result=s.substring(finalleft, finalright+1);        
        return result;
    }  
}
