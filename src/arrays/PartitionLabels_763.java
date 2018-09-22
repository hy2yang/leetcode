package arrays;


/*
A string S of lowercase letters is given. We want to partition this string into as many parts as possible
so that each letter appears in at most one part
return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

Note:
S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.
 */
import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();

        char[] cs = S.toCharArray();
        int[] first = new int[26];
        int[] last = new int[26];

        for (int i=0;i<cs.length;++i){
            if (i < first[cs[i]-'a'] ) first[cs[i]-'a']=i;
            int j = cs.length-1-i;
            if (j > last[cs[j]-'a']) last[cs[j]-'a']=j;
        }

        int lo, hi, end;
        for (lo=0,end=0; lo<cs.length;){
            end = last[cs[lo]-'a'];
            hi = lo;
            while (hi<end){
                if ( last[cs[hi]-'a']>end ) end=last[cs[hi]-'a'];
                ++hi;
            }
            res.add(hi-lo+1);
            lo = hi+1;
        }
        return res;
    }
}
