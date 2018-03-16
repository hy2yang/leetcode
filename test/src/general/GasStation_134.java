package general;

public class GasStation_134 {
    
    //  B is the first unreachable station for starting at A -> any between AB can not reach B 
    // (if A can reach Anext, gas left>=0, will never harm further trips)
    //  if total balance>=0, there is a solution
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0,tank=0,balance=0;
        for (int i=0;i<gas.length;++i) {
            tank+=gas[i]-cost[i];          // tank: balance after this step;
            balance+=tank;                 // update balance when can reach
            if (tank<0) {                  // can not reach next               
                start=i+1;                 // start from next
                tank=0;                    // reset tank
            }                             
        }
        return balance<0? -1:start;
    }

}
