package general;
/*
In a list of songs, the i-th song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.

Example 1:
Input: [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60

Example 2:
Input: [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.

Note:
    1 <= time.length <= 60000
    1 <= time[i] <= 500
 */
public class PairsofSongsWithTotalDurationsDivisibleby60_1013 {

    public int numPairsDivisibleBy60(int[] time) {
        int[] r = new int[61]; //0-59

        for (int i : time) {
            ++r[i % 60];
        }

        int res = 0;
        if (r[0]>0) res+=r[0]*(r[0]-1)/2;
        if (r[30]>0) res+=r[30]*(r[30]-1)/2;
        for (int i=1;i<30;++i){
            res+= r[i]*r[60-i];
        }

        return res;
    }

}
