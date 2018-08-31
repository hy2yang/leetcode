package onehundred;

public class MultiplyStrings {
    
    public String multiply(String num1, String num2) {
        if (num1.length()<1 || num2.length()<1) return "0";
        StringBuilder res=new StringBuilder();
        
        int a=num1.length();
        int b=num2.length();
        int[] digits=new int[a+b];
        for (int i=a-1;i>-1;i--) {
            for (int j=b-1;j>-1;j--) {
                int sum=(num1.charAt(i)-48)*(num2.charAt(j)-48)+digits[i+j+1];
                digits[i+j+1]=sum%10;
                digits[i+j]+=sum/10;
                        
            }
        }
        
        for (int i=0;i<a+b;i++) {
            if(i!=a+b-1 && res.length()==0 && digits[i]==0) continue;
            res.append(digits[i]);
        }       
        
        return res.toString();
    }
}
