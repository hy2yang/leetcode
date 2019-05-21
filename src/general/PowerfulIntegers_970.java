package general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given two positive integers x and y, an integer is powerful if
it is equal to x^i + y^j for some integers i >= 0 and j >= 0.
Return a list of all powerful integers that have value less than or equal to bound.
You may return the answer in any order.  In your answer, each value should occur at most once.

Example 1:
Input: x = 2, y = 3, bound = 10
Output: [2,3,4,5,7,9,10]
Explanation:
2 = 2^0 + 3^0
3 = 2^1 + 3^0
4 = 2^0 + 3^1
5 = 2^1 + 3^1
7 = 2^2 + 3^1
9 = 2^3 + 3^0
10 = 2^0 + 3^2

Example 2:
Input: x = 3, y = 5, bound = 15
Output: [2,4,6,8,10,14]

Note:
    1 <= x <= 100
    1 <= y <= 100
    0 <= bound <= 10^6
 */
public class PowerfulIntegers_970 {

    public  List<Integer> powerfulIntegers(int x, int y, int bound) {
        if (x>y){
            int t = x;
            x=y;
            y=t;
        }  // make sure y is not less than x, so ys can be shorter

        int xsum = 1;
        int ysum = 1;
        Set<Integer> temp = new HashSet<>();
        List<Integer> ys = new ArrayList<>();  // valid ys, more space for faster
        while (ysum<bound){
            ys.add(ysum);
            ysum*=y;
            if (y==1) break;
        }

        while(xsum<bound){
            for (Integer j:ys){
                if (xsum+j>bound) break;
                temp.add(xsum+j);
            }
            if (x==1) break;
            xsum*=x;
        }

        return new ArrayList<>(temp);

    }

    public List<Integer> powerfulIntegersBrute(int x, int y, int bound) {
        Set<Integer> temp = new HashSet<>();

        for (int xsum = 1;xsum<bound;xsum*=x){
            for (int ysum = 1;xsum+ysum<=bound;ysum*=y){
                temp.add(xsum+ysum);
                if (y==1) break;

            }
            if (x==1) break;
        }

        return new ArrayList<>(temp);
    }

}
