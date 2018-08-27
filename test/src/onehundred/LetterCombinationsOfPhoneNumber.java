package onehundred;
import java.util.*;

public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        List<String> result=letterCombinations("22");
        for (String s: result) {
            System.out.print(s+" ");
        }

    }
    
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> result=new ArrayList<>();        
        if (digits.length()==0)return result;        
        int len=digits.length();
        for (int i=0;i<len;i++) {
            addaletter(result, digits.charAt(i));
        }
        return result;        
    }
    
    static void addaletter(List<String> a, char digit) {       
        String[] x= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int toadd=(int)digit-48;
        int t=a.size();
        if (t==0) {
            for (int j=0; j<x[toadd].length();j++) {
                a.add(""+x[toadd].charAt(j));
            }
        }
        else {
            for (int i=0;i<t;i++) {
                for (int j=0; j<x[toadd].length();j++) {
                    a.add(a.get(0)+x[toadd].charAt(j));
                }
                a.remove(0);
            } 
        }        
    }

}
