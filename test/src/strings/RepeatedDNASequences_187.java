package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Write a function to find all the 10-letter-long sequences (substrings) 
//that occur more than once in a DNA molecule.

public class RepeatedDNASequences_187 {
    
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> once= new HashSet<>();
        HashSet<String> res= new HashSet<>();
        for (int i=0;i<=s.length()-10;++i) {
            String temp=s.substring(i, i+10);
            if (once.contains(temp)) res.add(temp);
            else once.add(temp);
        }
        return new ArrayList<String>(res);
    }

}
