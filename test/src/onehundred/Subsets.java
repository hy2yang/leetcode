package onehundred;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] a={};
        System.out.println(subsets(a).size());
    }
    
    public static List<List<Integer>> subsets(int[] a) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        ArrayList<Integer> wip=new ArrayList<Integer>();
        helper(res, wip, a, 0);        
        return res;
    }
    
    static void helper(ArrayList<List<Integer>> res, ArrayList<Integer> wip, int[] a, int pos){
       res.add(new ArrayList<Integer>(wip));
       if (pos==a.length) return;
       for (int i=pos;i<a.length;i++){
           wip.add(a[i]);
           helper(res,wip,a,i+1);
           wip.remove(wip.size()-1);
       }
    }

    
    // can be seen as generating a binary sequence of input length
    // 1/0 represents char at this pos in/out of result set 
    
    // advanced: using bit manipulation 
    // m elements, 2^m subsets , binary representation of int from 0 to (2^m)-1 
    // shows are the subsets
    
/*    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        int totalNumber = 1 << S.length;
        List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
        for (int i=0; i<totalNumber; i++) {
            List<Integer> set = new LinkedList<Integer>();
            for (int j=0; j<S.length; j++) {
                if ((i & (1<<j)) != 0) {
                    set.add(S[j]);
                }
            }
            collection.add(set);
        }
        return collection;
    }
*/    
}
