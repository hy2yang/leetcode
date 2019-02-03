package dp;
/*
In a country popular for train travel, you have planned some train travelling one year in advance. 
The days of the year that you will travel is given as an array days.  
Each day is an integer from 1 to 365.

Train tickets are sold in 3 different ways:
a 1-day pass is sold for costs[0] dollars;
a 7-day pass is sold for costs[1] dollars;
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.  
For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

Return the minimum number of dollars you need to travel every day in the given list of days.

Example 1:
Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11

Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total you spent $11 and covered all the days of your travel.

Example 2:
Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17

Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total you spent $17 and covered all the days of your travel.
 

Note:
1 <= days.length <= 365
1 <= days[i] <= 365
days is in strictly increasing order.
costs.length == 3
1 <= costs[i] <= 1000
*/

import java.util.Set;
import java.util.HashSet;

class MinimumCostForTickets_938 {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> travel = new HashSet<>();
        
        for (int i: days){
            travel.add(i);
        }
        
        int[] dp = new int[366];
        
        int day, week, month;
        for (int p=365;p>0;--p){
            if (!travel.contains(p)) {
                dp[p]= p+1<366? dp[p+1]:0;
                continue;
            }
            
            day = p+1<366? dp[p+1]+costs[0]:costs[0];
            week = p+7<366? dp[p+7]+costs[1]:costs[1];
            month = p+30<366? dp[p+30]+costs[2]:costs[2];
            
            dp[p] = month<week? month:week;
            if (day<dp[p]) dp[p]=day;
        }
        
        return dp[1];
    }
}