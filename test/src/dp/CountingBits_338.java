package dp;

import java.util.ArrayList;
import java.util.List;

/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num 
calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
*/
public class CountingBits_338 {
    
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i=1;i<res.length;++i) { // is actually dp
            res[i]= res[i>>1]+(i&1);     // i&1 is last bit, i>>1 is the other part (without last bit)
        }
        return res;
    }
    
    public int[] countBits2(int num) {
        List<Integer> temp=new ArrayList<>();
        temp.add(0);
        int len=1;
        while (len<num+1) {
            int size=temp.size();
            for (int i=0;i<size;++i) {
                temp.add(temp.get(i)+1);
            }
            len*=2;
        }
        if (temp.size()>num+1) temp=temp.subList(0, num+1);
        return temp.stream().mapToInt(i->i).toArray();
    }

}
