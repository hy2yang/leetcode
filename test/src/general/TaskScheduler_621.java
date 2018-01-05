package general;

import java.util.Arrays;

/*
Given a char array representing tasks CPU need to do. 
It contains capital letters A to Z where different letters represent different tasks.
Tasks could be done without original order. Each task could be done in one interval. 
For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, 
there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
Note:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
*/
public class TaskScheduler_621 {
    
    public int leastInterval(char[] tasks, int n) {
        if (tasks==null || tasks.length<1) return 0;
        if (n==0) return tasks.length;
        
        int[] f=new int[26];        // frequency map
        for (char c: tasks) {
            ++f[c-'A'];
        }
        int lowfreq=25;
        Arrays.sort(f);             // only frquency matters, not actual task
        while (lowfreq>=0 && f[lowfreq]==f[25]) --lowfreq;  // if f[i]==f[25], i is one of the most frequent tasks
        
        return Math.max(tasks.length, (f[25]-1)*(n+1)+25-lowfreq);
        
        // if lowfreq task fills all or more idles, result would be tasks.length;
        // else, ABCDABC AB  AB, f[25]-1 is number of full cycles, n+1 is full cycle length (n plus one most frequent in lead),
        // 25-lowfreq is number of most frequent tasks, aka length of the last, partial cycle 
    }

}
