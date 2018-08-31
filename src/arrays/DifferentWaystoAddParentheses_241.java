package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*Given a string of numbers and operators, return all possible results 
from computing all the different possible ways to group numbers and operators. 
The valid operators are +, - and *.

Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]

Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/
public class DifferentWaystoAddParentheses_241 {
    
    public List<Integer> diffWaysToCompute(String input) {
        return dfs( input, new HashMap<String, ArrayList<Integer>>());
    }
    
    private ArrayList<Integer> dfs (String in, HashMap<String, ArrayList<Integer>> map){
        if (map.containsKey(in)) return map.get(in);
        ArrayList<Integer> res=new ArrayList<>();        
        if (in.length()<1) return res;
        if (in.indexOf('+')*in.indexOf('-')*in.indexOf('*')==-1) {
            res.add(Integer.parseInt(in));
            map.put(in, res);
            return res;
        }
        ArrayList<Integer> left, right;
        char[] n=in.toCharArray();
        for (int i=0;i<n.length;++i) {
            if (n[i]<'0' || n[i]>'9') {
                left=dfs(in.substring(0, i), map);
                right=dfs(in.substring(i+1),map);  // skip the operator at i;
                for (Integer a:left) {
                    for (Integer b: right) {
                        if (n[i]=='+') res.add(a+b);
                        else if (n[i]=='-') res.add(a-b);
                        else if (n[i]=='*') res.add(a*b);
                    }
                }
            }            
        }
        map.put(in, res);
        return res;
    }

}
