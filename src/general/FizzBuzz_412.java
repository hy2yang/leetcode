package general;
/*
Write a program that outputs the string representation of numbers from 1 to n.
But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. 
For numbers which are multiples of both three and five output “FizzBuzz”.
*/

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz_412 {
    
    public List<String> fizzBuzz(int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n<1) return res;
        for (int i=1;i<=n;++i) {
            if (i%15==0) res.add("FizzBuzz");
            else if(i%5==0) res.add("Buzz");
            else if(i%3==0) res.add("Fizz");
            else res.add(i+"");
        }
        return res;
    }
    
    public List<String> fizzBuzz2(int n) {         // faster without "%"
        List<String> res = new ArrayList<String>(n);
        for(int i=1,fizz=1,buzz=1;i<=n ;i++){
            if(fizz==3 && buzz==5){
                res.add("FizzBuzz");
                fizz=0;
                buzz=0;
            }            
            else if(buzz==5){
                res.add("Buzz");
                buzz=0;
            }
            else if(fizz==3){
                res.add("Fizz");
                fizz=0;
            }
            else{
                res.add(String.valueOf(i));
            }
            ++fizz;
            ++buzz;
        } 
        return res;
    }

}
