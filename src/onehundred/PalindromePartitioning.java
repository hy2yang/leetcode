package onehundred;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {

    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        if (s.length()<1) return res;
        ArrayList<String> wip =new ArrayList<>();
        helper(s,res,wip);
        return res;
    }
    
    static void helper(String s, List<List<String>> res, ArrayList<String> wip) {
        if (s.length()<1) {
            res.add(new ArrayList<String>(wip));
            return;
        }
        for (int i=1;i<=s.length();++i) {
            if (validate(s.substring(0, i))) {
                wip.add(s.substring(0, i));
                helper(s.substring(i),res,wip);
                wip.remove(wip.size()-1);
            }
        }        
    }
    
    static boolean validate(String s) {
        if (s.length()<2) return true;
        for (int i=0;i<s.length()/2;++i) {
            if (s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
}


