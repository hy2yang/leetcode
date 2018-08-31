package arrays;
/*
Suppose you have a random list of people standing in a queue. 
Each person is described by a pair of integers (h, k), where h is the height of the person,
and k is the number of people in front of this person who have a height greater than or equal to h. 
Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionbyHeight_406 {
    
    public int[][] reconstructQueue(int[][] people) {
        if (people==null || people.length<1 || people[0].length<1) return new int[0][0];
        
        Arrays.sort(people, new Comparator<int[]>() {        // sort from tallest to shortest,
            public int compare(int[] o1, int[] o2) {         // when same height, smaller k in front 
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                else return o2[0]-o1[0];
            }            
        });
        
        ArrayList<int[]> res=new ArrayList<>();
        
        for (int[] p:people) {        // insert from tall to short
            res.add(p[1], p);         // k: same h or taller in front, since inserted tall ones before, k is the right position
        }
        
        return res.toArray(new int[people.length][people[0].length]);
        
    }
    
    
}
