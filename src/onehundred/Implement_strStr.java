package onehundred;

public class Implement_strStr {

    public static void main(String[] args) {

    }
    
    public int strStr(String haystack, String needle) {
        if (needle.length()==0) return 0;
        if (haystack.length()<needle.length()) return -1;
        int i=0;
        for (i=0;i<=haystack.length()-needle.length();i++) {
            if(haystack.substring(i, i+needle.length()).equals(needle)) return i;                    
        }
        return -1;
    }

}
