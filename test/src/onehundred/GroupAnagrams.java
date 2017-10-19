package onehundred;
import java.util.*;

public class GroupAnagrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> res= new ArrayList<List<String>>();
        if (strs.length<1) return res;
        HashMap<String, List<String>> map=new HashMap<>();
        for (String s:strs) {
            char[] temp=s.toCharArray();
            Arrays.sort(temp);
            String keyofs=new String(temp);
            if (!map.containsKey(keyofs)) {
                ArrayList<String> cur=new ArrayList<String>();
                cur.add(s);
                map.put(keyofs, cur);
            }
            else map.get(keyofs).add(s);
        }
        res=new ArrayList<List<String>>(map.values());
        return res;        
    }
}
