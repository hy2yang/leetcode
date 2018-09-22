package search_sort;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*
Strings A and B are K-similar (for some non-negative integer K)
if we can swap the positions of two letters in A exactly K times so that the resulting string equals B.

Given two anagrams A and B, return the smallest K for which A and B are K-similar.

Example 1:

Input: A = "ab", B = "ba"
Output: 1

Example 2:
Input: A = "abc", B = "bca"
Output: 2

Example 3:
Input: A = "abac", B = "baca"
Output: 2

Example 4:
Input: A = "aabc", B = "abca"
Output: 2

Note:
1 <= A.length == B.length <= 20
A and B contain only lowercase letters from the set {'a', 'b', 'c', 'd', 'e', 'f'}
 */
public class KSimilarStrings_854 {

    public int kSimilarity(String A, String B) {  // bfs guarantees min swaps
        if (A.equals(B)) return 0;

        Deque<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        q.offer(A);

        char[] cur, target = B.toCharArray();
        int lo, hi, step=0;
        String temp;
        while (!q.isEmpty()){
            ++step;
            for (int n = q.size(); n>0;--n){
                cur = q.poll().toCharArray();
                lo=0;
                while (lo<target.length && cur[lo]==target[lo]) ++lo;
                for (hi=lo+1;hi<target.length;++hi){       // iterate all possible swaps for fixed lo
                    if (cur[hi]!=target[hi] && cur[hi]==target[lo]){   // only swap when result matches lo
                        temp = swap(cur, lo, hi);
                        if (temp.equals(B)) return step;
                        if (visited.add(temp)) q.offer(temp);
                    }
                }
            }
        }
        return step;
    }

    private String swap(char[] arr, int lo, int hi){
        char[] res = arr.clone();
        char temp = res[lo];
        res[lo] = res[hi];
        res[hi] = temp;
        return new String(res);
    }
}
