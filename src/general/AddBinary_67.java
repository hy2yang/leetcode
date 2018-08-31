package general;
/*
Given two binary strings, return their sum (also a binary string). 
For example,
a = "11"
b = "1"
Return "100". 
*/
public class AddBinary_67 {

    public String addBinary(String a, String b) {
        char[] x=a.toCharArray(), y=b.toCharArray();
        int i=x.length-1,j=y.length-1;
        int carry=0, temp=0;
        StringBuilder sb=new StringBuilder();
        
        while (i>=0 && j>=0){
            temp=x[i--]+y[j--]+carry-'0'-'0';
            carry=temp/2;            
            sb.append(temp%2);
        }
        
        while (i>=0){
            temp=x[i--]+carry-'0';
            carry=temp/2;            
            sb.append(temp%2);
        }
        
        while (j>=0){
            temp=y[j--]+carry-'0';
            carry=temp/2;            
            sb.append(temp%2);
        }
        
        if (carry>0) sb.append(1);
        
        sb.reverse();
        return sb.toString();
    }
}
