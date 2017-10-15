import java.util.*;

public class Permutations {
    
    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res=new ArrayList<>();
        if(nums.length<1) return res;        
        List<Integer> copy = new ArrayList<Integer>();  
        copy.add(nums[0]);
        res.add(copy);
        for (int i=1;i<nums.length;i++) {
            ArrayList<List<Integer>> next=new ArrayList<>();
            for (List<Integer> x:res) {
                for (int j=0;j<=x.size();j++) {
                    List<Integer> toadd = new ArrayList<Integer>(x);
                    toadd.add(j, nums[i]);
                    next.add(toadd);
                }                
            }
            res=next;
        }
        return res;
    }  
    
    public static void main(String args[]) {
        //int[] a= {1,2,3};
        //List<List<Integer>> x=permute(a);
    }
}
