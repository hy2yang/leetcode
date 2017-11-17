package general;

public class GasStation_134 {
    
    //  B is the first unreachable station for starting at A -> any between AB can not reach B 
    // (if A can reach Anext, gas left>=0, will never harm further trips)
    //  if total balance>=0, there is a solution
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0,tank=0,balance=0;
        for (int i=0;i<gas.length;++i) {
            tank+=gas[i]-cost[i];          // tank: balance of this step;
            if (tank<0) {                  // can not reach
                balance+=tank;             // update balance
                start=i+1;                 // start from next
                tank=0;                    // reset tank
                continue;
            }
            balance+=tank;                 // update balance when can reach, too.
        }
        return balance<0? -1:start;
    }

}
