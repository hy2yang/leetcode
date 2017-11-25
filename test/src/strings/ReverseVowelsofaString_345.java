package strings;

public class ReverseVowelsofaString_345 {
    
    public String reverseString(String s) {
        if (s.isEmpty() || s.equals(null)) return "";
        String vowel="aeiouAEIOU";
        char[] res=s.toCharArray();
        char temp;
        int lo=0,hi=res.length-1;
        while(lo<hi) {
            while (lo<hi && vowel.indexOf(res[lo])==-1) ++lo;  // use indexOf
            while (lo<hi && vowel.indexOf(res[hi])==-1) --hi;
            temp=res[lo];
            res[lo++]=res[hi];
            res[hi--]=temp;
        }
        return new String(res);
    }

}
