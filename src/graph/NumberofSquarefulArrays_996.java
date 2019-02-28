package graph;

import java.util.Arrays;

/*
Given an array A of non-negative integers, the array is squareful
if for every pair of adjacent elements, their sum is a perfect square.

Return the number of permutations of A that are squareful.
Two permutations A1 and A2 differ if and only if
there is some index i such that A1[i] != A2[i].

Example 1:
Input: [1,17,8]
Output: 2
Explanation:
[1,8,17] and [17,8,1] are the valid permutations.

Example 2:
Input: [2,2,2]
Output: 1

Note:
1 <= A.length <= 12
0 <= A[i] <= 1e9
 */
public class NumberofSquarefulArrays_996 {

    public int numSquarefulPerms(int[] A) {

        Arrays.sort(A);
        boolean[][] graph = new boolean[A.length][A.length];

        for (int i=0;i<A.length;++i){
            for (int j = i+1;j<A.length;++j){
                double rt = Math.sqrt(A[i]+A[j]);
                if (rt-Math.floor(rt)==0){
                    graph[i][j]=true;
                    graph[j][i]=true;
                }
            }
        }

        int[] res = {0};

        bfs(graph, A, 0, new boolean[A.length], -1, res);

        return res[0];
    }


    private void bfs(boolean[][] graph, int[] A, int len, boolean[] visited, int from, int[] res){

        if (len==A.length){
            ++res[0];
        }
        else {
            for (int i = 0; i<A.length;i++){
                if (visited[i] || (i>0 && A[i]==A[i-1] && !visited[i-1])) continue; // remove duplicate
                if (from<0 || graph[from][i]){ // search if from start or can go to A[i]
                    visited[i] = true;
                    bfs(graph, A, len+1, visited, i, res);
                    visited[i] = false;
                }
            }
        }
    }
}
