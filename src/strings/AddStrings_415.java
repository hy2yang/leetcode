package strings;
/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
public class AddStrings_415 {

    public String addStrings(String num1, String num2) {
        char[] n1=num1.toCharArray(), n2=num2.toCharArray();
        int i=n1.length-1;
        int j=n2.length-1;
        StringBuilder res=new StringBuilder(); 
        
        int carry=0, cur;
        while (i>=0 && j>=0) {
            cur=n1[i--]-'0'+n2[j--]-'0'+carry;
            carry= (cur>9)? 1:0;
            res.append(cur%10);
        }
        while (i>=0) {
            cur=n1[i--]-'0'+carry;
            carry= (cur>9)? 1:0;
            res.append(cur%10);
        }
        while (j>=0) {
            cur=n2[j--]-'0'+carry;
            carry= (cur>9)? 1:0;
            res.append(cur%10);
        }
        if (carry>0) res.append('1');
        res.reverse();
        return res.toString();
    }
    
}
