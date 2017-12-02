package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*Given an array of integers with possible duplicates, randomly output the index of a given target number. 
You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:
int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

 pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

 pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);

 *
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

public class RandomPickIndex_398 {
    
    HashMap<Integer, ArrayList<Integer>> map;
    
    public RandomPickIndex_398(int[] nums) {
        map= new HashMap<Integer, ArrayList<Integer>>();
        for (int i=0;i<nums.length;++i) {
            if (!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<Integer>());
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        ArrayList<Integer> t= map.get(target);
        int i=(int) (Math.random()*(t.size()));
        return t.get(i);
    }
    
    class Solution {

        int[] nums;
        Random rnd;

        public Solution(int[] nums) {
            this.nums = nums;
            this.rnd = new Random();
        }
        
        public int pick(int target) {
            int result = -1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    if (rnd.nextInt(++count) == 0) result = i;
                }
            }
            return result;
        }
    }
    
    class mySolution {

        int[] nums;

        public mySolution(int[] nums) {
            this.nums = nums;
        }
        
        public int pick(int target) {
            int result = -1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    ++count;
                    if (Math.random()*count<1) result=i;
                }
            }
            return result;
        }
    }

}
