package general;

import java.util.HashMap;
import java.util.Map;

/*
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) 
such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 
and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:

Input:
[[0,0],[1,0],[2,0]]
Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
*/
public class NumberofBoomerangs_447 {
    
    public int numberOfBoomerangs(int[][] points) {
        int res=0;
        Map<Integer, Integer> d2map= new HashMap<>();
        for (int i=0;i<points.length;++i){
            for (int j=0;j<points.length;++j){
                // if(i==j) continue; // seems not necessary wether same point appear once or more in points 
                int d2=(points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
                int pre=d2map.getOrDefault(d2,0);
                res+=2*pre;
                d2map.put(d2,pre+1);
            }
            d2map.clear();
        }
        return res;
    }

}
