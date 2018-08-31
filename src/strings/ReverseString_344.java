package strings;

/*
Write a function that takes a string as input and returns the string reversed.
Example:
Given s = "hello", return "olleh".
*/

public class ReverseString_344 { 
    
    public String reverseString(String s) {
        if (s.isEmpty() || s.equals(null)) return "";
        char[] res=s.toCharArray();
        char temp;
        int lo=0,hi=res.length-1;
        while(lo<hi) {
            temp=res[lo];
            res[lo++]=res[hi];
            res[hi--]=temp;
        }
        return new String(res);
    }
    
    public String reverseString2(String s) {
        if (s.isEmpty() || s.equals(null)) return "";
        StringBuilder sb=new StringBuilder();
        for (int i=s.length()-1;i>=0;--i) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}
