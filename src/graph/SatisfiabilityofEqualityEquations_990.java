package graph;

import java.util.ArrayList;
import java.util.List;

/*
Given an array equations of strings that represent relationships between variables,
each string equations[i] has length 4 and takes one of two different forms:
 "a==b" or "a!=b".  Here, a and b are lowercase letters (not necessarily different)
 that represent one-letter variable names.

Return true if and only if it is possible to assign integers to variable names
so as to satisfy all the given equations.


Example 1:
Input: ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied,
but not the second.  There is no way to assign the variables to satisfy both equations.

Example 2:
Input: ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.

Example 3:
Input: ["a==b","b==c","a==c"]
Output: true

Example 4:
Input: ["a==b","b!=c","c==a"]
Output: false

Example 5:
Input: ["c==c","b==d","x!=z"]
Output: true

Note:
1 <= equations.length <= 500
equations[i].length == 4
equations[i][0] and equations[i][3] are lowercase letters
equations[i][1] is either '=' or '!'
equations[i][2] is '='
 */
public class SatisfiabilityofEqualityEquations_990 {

    public boolean equationsPossible(String[] equations) {

        UF uf = new UF();
        List<String> dis = new ArrayList<>();

        for (String i : equations){
            char[] temp = i.toCharArray();
            if (temp[1]=='!'){
                dis.add(i);
            } else {
                uf.union(temp[0],temp[3]);
            }
        }

        for (String i:dis){
            char[] temp = i.toCharArray();
            if (temp[0]==temp[3] || uf.find(temp[0])==uf.find(temp[3])) return false;
        }

        return true;
    }

    class UF{
        int[] parent = new int[26];

        public UF(){
            for (int i=0;i<parent.length;++i){
                parent[i] = i;
            }
        }

        public void union(char a, char b){
            parent[find(b)] = find(a);
        }

        public int find(char a){
            int x = a-'a';
            while (x!=parent[x]){
                parent[x] = parent[parent[x]]; // path halving
                x = parent[x];
            }
            return x;
        }
    }

}
