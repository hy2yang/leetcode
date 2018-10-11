package general;

import java.util.HashMap;
import java.util.Map;

/*
You are given an integer array sorted in ascending order (may contain duplicates),
you need to split them into several subsequences,
where each subsequences consist of at least 3 consecutive integers. Return whether you can make such a split.

Example 1:
Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences :
1, 2, 3
3, 4, 5

Example 2:
Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences :
1, 2, 3, 4, 5
3, 4, 5

Example 3:
Input: [1,2,3,4,4,5]
Output: False

Note:
The length of the input is in range of [1, 10000]
 */
public class SplitArrayintoConsecutiveSubsequences_659 {

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> open = new HashMap<>();
        Map<Integer, Integer> seq = new HashMap<>();

        for (int i: nums){
            open.put(i, open.getOrDefault(i,0)+1);
        }

        for (int i: nums){
            int count = open.getOrDefault(i,0);
            if (count>0){

                open.put(i, count-1);

                if (seq.getOrDefault(i-1,0)>0){
                    seq.put(i-1, seq.getOrDefault(i-1,0)-1);
                    seq.put(i, seq.getOrDefault(i,0)+1);
                }
                else if (open.getOrDefault(i+1,0)>0 && open.getOrDefault(i+2,0)>0){
                    open.put(i+1, open.getOrDefault(i+1,0)-1);
                    open.put(i+2, open.getOrDefault(i+2,0)-1);
                    seq.put(i+2, seq.getOrDefault(i+2,0)+1);
                }
                else return false;
            }
        }
        return true;
    }

    // given that input is sorted, there's solution of better space complexity (and faster)
    public boolean isPossible_fast(int[] nums) {
        int len1=0, len2=0, len3=0;  // number of sequences end with pre, with length 1, 2, >=3
        int cur, count, pre=-1;  // current num, count of current num, last num
        int n1, n2, n3;              // new values for len1, len2, len3

        int i=0;
        while (i<nums.length){
            cur = nums[i];
            count=0;
            while (i<nums.length && nums[i]==cur){
                ++i;
                ++count;
            }

            if (cur!=pre+1){  // not consecutive
                if (len1!=0 || len2!=0) return false; // unfinished sequences left
                else {         // start here with 1 len1, 0 len2 and len3
                    n1 = count;
                    n2 = 0;
                    n3 = 0;
                }
            }
            else {  // update the shortest possible seq
                if (count < len1+len2) return false;  // can't append all seqs which need this num
                n1 = Math.max(0, count-len1-len2-len3); // append everywhere possible
                n2 = len1;  // len1 becomes len2 after appending this num
                n3 = len2 + Math.min(len3, count-len1-len2);
                // part1: len2 becomes len3,
                // part2: count-len1-len2 numbers of cur left to append in len3, at most all len3 (exceeding ones is len1)
            }

            len1=n1;len2=n2;len3=n3;
            pre = cur;
        }
        return len1==0&&len2==0;
    }


}
