package general;
/*
There are N workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].

Now we want to hire exactly K workers to form a paid group.
When hiring a group of K workers, we must pay them according to the following rules:

Every worker in the paid group should be paid in the ratio of
their quality compared to other workers in the paid group.
Every worker in the paid group must be paid at least their minimum wage expectation.

Return the least amount of money needed to form a paid group satisfying the above conditions.

Example 1:
Input: quality = [10,20,5], wage = [70,50,30], K = 2
Output: 105.00000
Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.

Example 2:
Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
Output: 30.66667
Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately.

Note:
1 <= K <= N <= 10000, where N = quality.length = wage.length
1 <= quality[i] <= 10000
1 <= wage[i] <= 10000
Answers within 10^-5 of the correct answer will be considered correct.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCosttoHireKWorkers_857 {

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Integer[] workers = new Integer[quality.length];
        for (int i=0;i<workers.length;++i) workers[i]=i;

        Arrays.sort(workers, Comparator.comparingDouble(a -> (double) wage[a] / (double) quality[a]));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->quality[b]-quality[a]);

        double res = Double.MAX_VALUE, ratio=0;
        int unit=0;
        for (int i: workers){
            pq.add(i);
            unit += quality[i];
            if (pq.size()>K) {
                unit -= quality[pq.remove()];
            }
            if (pq.size()==K){
                ratio = (double)wage[i]/(double)quality[i];
                if (unit*ratio<res) res = unit*ratio;
            }
        }
        return res;
    }

//    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {   // no lambda version
//        Integer[] workers = new Integer[quality.length];
//        for (int i=0;i<workers.length;++i) workers[i]=i;
//
//        Arrays.sort(workers, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                return Double.compare((double) wage[a] / quality[a], (double) wage[b] / quality[b]);
//            }
//        });
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                return quality[b] - quality[a];
//            }
//        });
//
//        double res = Double.MAX_VALUE, ratio=0;
//        int unit=0;
//        for (int i: workers){
//            pq.add(i);
//            unit += quality[i];
//            if (pq.size()>K) {
//                unit -= quality[pq.remove()];
//            }
//            if (pq.size()==K){
//                ratio = (double)wage[i]/(double)quality[i];
//                if (unit*ratio<res) res = unit*ratio;
//            }
//        }
//        return res;
//    }


}
