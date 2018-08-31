package strings;
/*
Given a list of non negative integers, arrange them such that they form the largest number.
For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
Note: The result may be very large, so you need to return a string instead of an integer.
*/

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber_179 {
    
    public String largestNumber(int[] nums) {
        if (nums==null || nums.length<1) return "";
        
        String[] s=new String[nums.length];
        for (int i=0;i<s.length;++i) {
            s[i]=String.valueOf(nums[i]);
        }
        
        Comparator<String> c=new Comparator<String>() {      // how to build a comparator
            public int compare(String s1, String s2) {
                String s12=s1+s2;
                String s21=s2+s1;
                return s21.compareTo(s12);          // if s12 > s21, we put s1 in front (s1 is smaller)
            }
        };
        
        Arrays.sort(s,c);
        if(s[0].charAt(0)=='0') return "0";
        StringBuilder sb=new StringBuilder();
        for (String i:s) {
            sb.append(i);            
        }
        return sb.toString();        
    }

}
