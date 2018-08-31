package strings;

public class LongestPalindromicSubstring_5 {
    
    public String longestPalindrome(String s) {
        if (s.length()<2) return s;
        char[] arr=s.toCharArray();
        int maxlen=0;
        int left=0;
        int right=arr.length-1;
        int lo,hi,next;
        for(int i=0;i<arr.length-1;){
            if (i+1<maxlen/2 || arr.length-i<maxlen/2){
                ++i;
                continue;
            }
            lo=i;hi=i;
            while (hi+1<arr.length && arr[lo]==arr[hi+1]) ++hi;  
            next=hi+1;
            while (lo-1>=0 && hi+1<=arr.length-1 && arr[lo-1]==arr[hi+1]){
                lo--;
                hi++;
            }
            if (hi-lo+1>maxlen){
                maxlen=hi-lo+1;
                left=lo;
                right=hi;
            }
            i=next;
        }        
        return s.substring(left, right+1);
    } 

}
