package arrays;

/*
In a row of trees, the i-th tree produces fruit with type tree[i].

You start at any tree of your choice, then repeatedly perform the following steps:
Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.

Note that you do not have any choice after the initial choice of starting tree:
you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

You have two baskets, and each basket can carry any quantity but one type of fruit.

What is the max amount of fruit you can collect with this procedure?

Example 1:
Input: [1,2,1]
Output: 3
Explanation: We can collect [1,2,1].

Example 2:
Input: [0,1,2,2]
Output: 3
Explanation: We can collect [1,2,2].
If we started at the first tree, we would only collect [0, 1].

Example 3:
Input: [1,2,3,2,2]
Output: 4
Explanation: We can collect [2,3,2,2].
If we started at the first tree, we would only collect [1, 2].

Example 4:
Input: [3,3,3,1,2,1,1,2,3,3,4]
Output: 5
Explanation: We can collect [1,2,1,1,2].
If we started at the first tree or the eighth tree, we would only collect 4 fruits.


Note:
1 <= tree.length <= 40000
0 <= tree[i] < tree.length
 */

public class FruitIntoBaskets_904 {
    // specific for two baskets, for generic solution, see NonLeetcode.LongestSubstringwithAtMostKDistinctCharacters
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length<1) return 0;
        int typeA=-1, typeB=-1;
        int lo=0, hi=0, res=0;


        while (hi<tree.length){
            while (hi<tree.length){
                if (typeA>=0 && typeB>=0 && tree[hi]!=typeA && tree[hi]!=typeB) break;
                if (typeA<0) typeA=tree[hi];
                else if (tree[hi]!=typeA && typeB<0) typeB=tree[hi];
                ++hi;
            }
            if (hi-lo>res) res=hi-lo;
            lo=hi-1;
            typeA=tree[lo];
            typeB=-1;
            while(lo>0 && tree[lo]==typeA){
                --lo;
            }
            ++lo;
        }

        return res;
    }
}
