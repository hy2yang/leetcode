package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

/*There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:
2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, 
and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. 
If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
*/
public class CourseSchedule_207 {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {   //BFS graph search
        ArrayList<Integer>[] neighbors =new ArrayList[numCourses];      // neighbors[i] is a list of nodes i can reach direclty
        int[] prenum=new int[numCourses];                               // prenum[i] is the number of prerequisites of course i
        int count=0;
        
        for (int i=0;i<numCourses;++i) {
            neighbors[i]=new ArrayList<Integer>();
        }
        
        for (int i=0;i<prerequisites.length;++i) {             
            neighbors[prerequisites[i][1]].add(prerequisites[i][0]);
            ++prenum[prerequisites[i][0]];
        }
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for (int i=0;i<prenum.length;++i) {
            if (prenum[i]==0) {
                q.add(i);
                ++count;
            }
        }
        
        int cur,next;
        while (!q.isEmpty()) {
            cur=q.poll();
            for (int i=0;i<neighbors[cur].size();++i) {
                next=neighbors[cur].get(i);
                --prenum[next];
                if (prenum[next]==0) {
                    q.add(next);
                    ++count;
                }
            }
        }        
        return count==numCourses;        
    }   
    

}
