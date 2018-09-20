package graph;

import java.util.HashMap;
import java.util.Map;

/*
Equations are given in the format A / B = k, where A and B are variables represented as strings,
and k is a real number (floating point number).
Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].

The input is always valid.
You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */


public class EvaluateDivision_399 {

    private Map<String, String> parent;  // key:node, value:parent
    private Map<String , Double> r;  // ratio to parent

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (queries==null || queries.length<1) return new double[]{};

        parent = new HashMap<>();  // key:node, value:parent
        r = new HashMap<>();  // ratio to parent

        for (int i=0; i<equations.length; ++i){
            union(equations[i], values[i]);
        }

        double[] res= new double[queries.length];
        for (int i=0;i<queries.length;++i){
            res[i] = eval(queries[i]);
        }

        return res;
    }

    private void union(String[] eq, double val){
        if ( !parent.containsKey(eq[0]) && !parent.containsKey(eq[1])){
            parent.put(eq[1],eq[1]);
            r.put(eq[1],1.0);
        }

        if (parent.containsKey(eq[1])){
            parent.put(eq[0],eq[1]);
            r.put(eq[0],val);
        } else {
            parent.put(eq[1], eq[0]);
            r.put(eq[1], 1.0/val);
        }
    }

    private double eval(String[] q){
        String a=q[0], b=q[1];
        if (!parent.containsKey(a) || !parent.containsKey(b)) return -1.0;

        double ra=1, rb=1;
        while(!parent.get(a).equals(a)){
            ra *= r.get(a);
            a = parent.get(a);
        }

        while(!parent.get(b).equals(b)){
            rb *= r.get(b);
            b = parent.get(b);
        }

        return a.equals(b)? ra/rb:-1.0;
    }
}
